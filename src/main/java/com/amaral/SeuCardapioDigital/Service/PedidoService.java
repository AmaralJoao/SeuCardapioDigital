package com.amaral.SeuCardapioDigital.Service;

import com.amaral.SeuCardapioDigital.Dto.Request.EntregaPedidoRequestDto;
import com.amaral.SeuCardapioDigital.Dto.Request.PagamentoRequestDto;
import com.amaral.SeuCardapioDigital.Dto.Request.PedidoRequestDto;
import com.amaral.SeuCardapioDigital.Dto.Response.PedidoResponseDto;
import com.amaral.SeuCardapioDigital.Enum.StatusPedidoEnum;
import com.amaral.SeuCardapioDigital.Mapper.PedidoMapper;
import com.amaral.SeuCardapioDigital.Model.*;
import com.amaral.SeuCardapioDigital.Repository.*;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class PedidoService {

    @Autowired
    private EstabelecimentoRepository estabelecimentoRepository;
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private  ProdutoRepository produtoRepository;
    @Autowired
    private EstabelecimentoService estabelecimentoService;
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private PedidoMapper pedidoMapper;


    @Transactional
    public PedidoResponseDto criarPedido(PedidoRequestDto pedidoDto) {

        EstabelecimentoModel estabelecimento = estabelecimentoRepository.findById(pedidoDto.getIdEstabelecimento())
                .orElseThrow(()-> new EntityNotFoundException("Estabelecimento nao encontrado"));

        /*
        validar se forma de pagamento e acita pelo estabelecimento
        */

        // ajustar o metodo no estabelecimentoService
        if (!estabelecimentoService.estabelecimentoIsAberto(pedidoDto.getIdEstabelecimento())){
            throw new IllegalArgumentException("Estabelecimento fechado");
        }


        // persistindo cliente
        ClienteModel clientePedido = clienteService.salvarCliente(pedidoDto.getCliente());

        PedidoModel novoPedido = pedidoMapper.requestToModel(pedidoDto);

        BigDecimal total = BigDecimal.ZERO;

        for (ItemPedidoModel item : novoPedido.getItemDoPedido()) {
            ProdutoModel produto = produtoRepository.findById(item.getProduto().getId())
                    .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado: ID " + item.getProduto().getId()));

            item.setProduto(produto); // associa o produto corretamente
            item.setPrecoUnitario(produto.getPreco()); // garante o preço atual
            item.setPedido(novoPedido); // vincula o item ao pedido


            BigDecimal subtotal = produto.getPreco().multiply(BigDecimal.valueOf(item.getQuantidade()));
            total = total.add(subtotal);
        }

        novoPedido.setEstabelecimento(estabelecimento);
        novoPedido.setCliente(clientePedido);
        novoPedido.setCodigoDoPedido(geradorIdentificadroDoPedido(novoPedido.getEstabelecimento().getId()));
        novoPedido.setDataHoraDoPedido(LocalDateTime.now());
        novoPedido.setStatus(StatusPedidoEnum.pedidoCriado);
        novoPedido.setValorTotalDoPedido(total);

        /*Mapear pagamento e entrega e depois persistir*/



    }

    public List<PedidoResponseDto> listarTodos(Long cdEstabelecimento) {
        List<PedidoModel> pedidos = pedidoRepository.findByCdEstabelecimento(cdEstabelecimento);
        return pedidos.stream().map(pedidoMapper::toDto).collect(Collectors.toList());
    }


    private Long geradorIdentificadroDoPedido(Long idEstabelecimento){

        final long INICIO_GERADO = 1000;
        Optional<Long> ultimoCodigoDePedido = pedidoRepository.findUltimoPedidoDoEstabelecimento(idEstabelecimento);

        if (ultimoCodigoDePedido.isEmpty()){
            return Long.parseLong(String.format("%d%d", idEstabelecimento, INICIO_GERADO));
        }

        String ultimoCodigoString = ultimoCodigoDePedido.get().toString();
        String idEstabelecimentoStr = idEstabelecimento.toString();

        if (ultimoCodigoString.startsWith(idEstabelecimentoStr)) {

            String parteNumerica = ultimoCodigoString.substring(idEstabelecimentoStr.length());
            int proximoNumero = Integer.parseInt(parteNumerica) + 1;
            return Long.parseLong(String.format("%d%d", idEstabelecimento, proximoNumero));

        } else {

            throw new IllegalArgumentException("Estabelecimento não encontrado para criar o codigo do pedido.");
        }
    }


}
