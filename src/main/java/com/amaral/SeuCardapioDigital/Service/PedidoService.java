package com.amaral.SeuCardapioDigital.Service;

import com.amaral.SeuCardapioDigital.Dto.Request.PedidoRequestDto;
import com.amaral.SeuCardapioDigital.Dto.Response.PedidoResponseDto;
import com.amaral.SeuCardapioDigital.Mapper.PedidoMapper;
import com.amaral.SeuCardapioDigital.Model.ItemPedidoModel;
import com.amaral.SeuCardapioDigital.Model.PedidoModel;
import com.amaral.SeuCardapioDigital.Model.ProdutoModel;
import com.amaral.SeuCardapioDigital.Repository.HorarioFuncionamentoRepository;
import com.amaral.SeuCardapioDigital.Repository.PedidoRepository;
import com.amaral.SeuCardapioDigital.Repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    private PedidoRepository pedidoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private PedidoMapper pedidoMapper;
    @Autowired
    private HorarioFuncionamentoRepository horarioFuncionamentoRepository;


    public PedidoResponseDto criarPedido(PedidoRequestDto pedidoDto) {
        PedidoModel pedido = pedidoMapper.requestToModel(pedidoDto);

        BigDecimal total = BigDecimal.ZERO;

        for (ItemPedidoModel item : pedido.getItemDoPedido()) {
            ProdutoModel produto = produtoRepository.findById(item.getProduto().getId())
                    .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado: ID " + item.getProduto().getId()));

            item.setProduto(produto); // associa o produto corretamente
            item.setPrecoUnitario(produto.getPreco()); // garante o preço atual
            item.setPedido(pedido); // vincula o item ao pedido


            BigDecimal subtotal = produto.getPreco().multiply(BigDecimal.valueOf(item.getQuantidade()));
            total = total.add(subtotal);
        }

        pedido.setCodigoDoPedido(geradorIdentificadroDoPedido(pedido.getEstabelecimento().getId()));
        pedido.setDataHoraDoPedido(LocalDateTime.now());
        pedido.setStatus(1);
        pedido.setValorTotalDoPedido(total);

        PedidoModel salvarPedido = pedidoRepository.save(pedido);
        return pedidoMapper.toDto(salvarPedido);
    }

    public PedidoResponseDto editarPedido(Long id, PedidoRequestDto pedidoAtualizadoDto) {
        PedidoModel pedidoAtualizado = pedidoMapper.requestToModel(pedidoAtualizadoDto);

        PedidoModel pedidoExistente = pedidoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Pedido não encontrado: ID " + id));

        // Limpa os itens antigos
        pedidoExistente.getItemDoPedido().clear();

        BigDecimal total = BigDecimal.ZERO;

        for (ItemPedidoModel item : pedidoAtualizado.getItemDoPedido()) {
            ProdutoModel produto = produtoRepository.findById(item.getProduto().getId())
                    .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado: ID " + item.getProduto().getId()));

            item.setProduto(produto);
            item.setPrecoUnitario(produto.getPreco());
            item.setPedido(pedidoExistente);

            BigDecimal subtotal = produto.getPreco().multiply(BigDecimal.valueOf(item.getQuantidade()));
            total = total.add(subtotal);

            pedidoExistente.getItemDoPedido().add(item);
        }

        pedidoExistente.setValorTotalDoPedido(total);
        pedidoExistente.setStatus(pedidoAtualizado.getStatus()); // permite atualizar o status, se quiser
        pedidoExistente.setDataHoraDoPedido(LocalDateTime.now()); // atualiza a data

        PedidoModel salvarPedido = pedidoRepository.save(pedidoExistente);
        return pedidoMapper.toDto(salvarPedido);
    }

    public List<PedidoResponseDto> listarTodos(Long cdEstabelecimento) {
        List<PedidoModel> pedidos = pedidoRepository.findByCdEstabelecimento(cdEstabelecimento);
        return pedidos.stream().map(pedidoMapper::toDto).collect(Collectors.toList());
    }

    public boolean isEstabelecimentoAberto(Long estabelecimentoId) {
        LocalTime agora = LocalTime.now();
        DayOfWeek hoje = LocalDate.now().getDayOfWeek();

        return horarioFuncionamentoRepository
                .isEstabelecimentoAberto(estabelecimentoId, hoje, agora);
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

    /*public Optional<PedidoModel> buscarPorId(Long id) {
        return pedidoRepository.findById(id);
    }*/

}
