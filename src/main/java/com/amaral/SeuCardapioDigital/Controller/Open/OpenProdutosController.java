package com.amaral.SeuCardapioDigital.Controller.Open;

import com.amaral.SeuCardapioDigital.Dto.Response.ProdutoResponseDto;
import com.amaral.SeuCardapioDigital.Service.ProdutoService;
import com.amaral.SeuCardapioDigital.Utils.AuthUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5500") // ou especifique a origem com "http://localhost:5500"
@RestController
@RequestMapping("/open/api/produto")
public class OpenProdutosController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/listartodos/{id}")
    public ResponseEntity<List<ProdutoResponseDto>> listarProdutos(/*@PageableDefault(size = 10, sort = "nomeDoProduto", direction = Sort.Direction.ASC) Pageable pageable*/) {

        Long idEstabelecimento = AuthUtils.getIdEstabelecimento();

        List<ProdutoResponseDto> produtos = produtoService.listarProdutosPorEstabelecimento(idEstabelecimento/*, pageable*/);
        return ResponseEntity.ok(produtos);
    }
}
