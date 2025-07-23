package com.amaral.SeuCardapioDigital.Controller.Open;

import com.amaral.SeuCardapioDigital.Dto.Request.EstabelecimentoRequestDto;
import com.amaral.SeuCardapioDigital.Dto.Response.EstabelecimentoResponseDto;
import com.amaral.SeuCardapioDigital.Service.EstabelecimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/open/api/estabelecimento")
public class OpenEstabelecimentoController {

    @Autowired
    private EstabelecimentoService estabelecimentoService;

    @PostMapping("/criarestabelecimento")
    public ResponseEntity<EstabelecimentoResponseDto> criarEstabelecimento(@RequestBody EstabelecimentoRequestDto estabelecimentoRequestDto){
        return ResponseEntity.ok(estabelecimentoService.criarEstabelecimento(estabelecimentoRequestDto));
    }
}
