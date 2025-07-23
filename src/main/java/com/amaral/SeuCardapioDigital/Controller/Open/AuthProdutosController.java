package com.amaral.SeuCardapioDigital.Controller.Open;

import com.amaral.SeuCardapioDigital.Dto.Request.ProdutoRequestDto;
import com.amaral.SeuCardapioDigital.Dto.Response.ProdutoResponseDto;
import com.amaral.SeuCardapioDigital.Service.ProdutoService;
import com.amaral.SeuCardapioDigital.Utils.AuthUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:5500") // ou especifique a origem com "http://localhost:5500"
@RestController
@RequestMapping("/open/api/produto")
public class AuthProdutosController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/listartodos/{id}")
    public ResponseEntity<List<ProdutoResponseDto>> listarProdutos(/*@PageableDefault(size = 10, sort = "nomeDoProduto", direction = Sort.Direction.ASC) Pageable pageable*/) {

        Long idEstabelecimento = AuthUtils.getIdEstabelecimento();

        List<ProdutoResponseDto> produtos = produtoService.listarProdutosPorEstabelecimento(idEstabelecimento/*, pageable*/);
        return ResponseEntity.ok(produtos);
    }
}
