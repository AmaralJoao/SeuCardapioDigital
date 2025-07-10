package com.amaral.SeuCardapioDigital.Service;

import com.amaral.SeuCardapioDigital.Dto.Request.ProdutoRequestDto;
import com.amaral.SeuCardapioDigital.Dto.Response.ProdutoResponseDto;
import com.amaral.SeuCardapioDigital.Mapper.ProdutoMapper;
import com.amaral.SeuCardapioDigital.Model.ProdutoModel;
import com.amaral.SeuCardapioDigital.Repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private ProdutoMapper produtoMapper;

    /*public Page<ProdutoResponseDto> listarProdutosPorEstabelecimento(long idEstabelecimento, Pageable pageable) {
        return produtoRepository.findByCdEstabelecimento(idEstabelecimento, pageable)
                .map(produtoMapper::toDto);
    }*/

     public List<ProdutoResponseDto> listarProdutosPorEstabelecimento(long idEstabelecimento) {
        return produtoRepository.findByCdEstabelecimento(idEstabelecimento).stream()
                .map(produtoMapper::toDto).collect(Collectors.toList());
    }

    public ProdutoResponseDto criarNovoProduto(ProdutoRequestDto produtoRequestDto) {
        ProdutoModel novoProduto = produtoMapper.requestToModel(produtoRequestDto);
        ProdutoModel salvarProduto = produtoRepository.save(novoProduto);

        return produtoMapper.toDto(salvarProduto);
    }
}
