package com.amaral.SeuCardapioDigital.Controller;

import com.amaral.SeuCardapioDigital.Dto.Request.ProdutoRequestDto;
import com.amaral.SeuCardapioDigital.Dto.Response.ProdutoResponseDto;
import com.amaral.SeuCardapioDigital.Model.ProdutoModel;
import com.amaral.SeuCardapioDigital.Service.ProdutoService;
import com.amaral.SeuCardapioDigital.Utils.AuthUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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
@RequestMapping("/auth/api/produto")
public class ProdutosController {

    @Autowired
    private ProdutoService produtoService;

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/cadastrar")
    public ResponseEntity<ProdutoResponseDto> cadastrarProduto(@RequestBody ProdutoRequestDto produtoRequestDto){
        return ResponseEntity.ok(produtoService.criarNovoProduto(produtoRequestDto));
    }
    @PreAuthorize("isAuthenticated()")
    @PostMapping("/upload")
    public ResponseEntity<String> uploadImagem(@RequestParam("file") MultipartFile file) throws IOException {
        String nomeArquivo = UUID.randomUUID() + "_" + file.getOriginalFilename();
        Path destino = Paths.get("uploads/imagens/" + nomeArquivo);
        Files.createDirectories(destino.getParent());
        Files.copy(file.getInputStream(), destino, StandardCopyOption.REPLACE_EXISTING);

        // Gere a URL completa acessível pelo React
        String imagemUrl = "http://localhost:8080/uploads/imagens/" + nomeArquivo;
        return ResponseEntity.ok(imagemUrl);
    }

    //@PreAuthorize("isAuthenticated()")
    @GetMapping("/listartodos")
    public ResponseEntity<List<ProdutoResponseDto>> listarProdutos(/*@PageableDefault(size = 10, sort = "nomeDoProduto", direction = Sort.Direction.ASC) Pageable pageable*/) {

        Long idEstabelecimento = AuthUtils.getIdEstabelecimento();

        List<ProdutoResponseDto> produtos = produtoService.listarProdutosPorEstabelecimento(idEstabelecimento/*, pageable*/);
        return ResponseEntity.ok(produtos);
    }
}
