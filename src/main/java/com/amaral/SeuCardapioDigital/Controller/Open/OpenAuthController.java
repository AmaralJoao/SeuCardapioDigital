package com.amaral.SeuCardapioDigital.Controller.Open;

import com.amaral.SeuCardapioDigital.Dto.Request.LoginRequestDto;
import com.amaral.SeuCardapioDigital.Dto.Response.LoginResponseDto;
import com.amaral.SeuCardapioDigital.Service.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/open/api/")
public class OpenAuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> logar(@RequestBody LoginRequestDto loginRequestDto, HttpServletRequest request){
        String token = authService.autenticar(loginRequestDto.getNomeDoEstabelecimento(), loginRequestDto.getSenha(),
                request.getRemoteAddr(),
                request.getHeader("User-Agent"));
        return ResponseEntity.ok(new LoginResponseDto(token));
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(@RequestHeader("Authorization") String authHeader) {
        if (authHeader != null && authHeader.startsWith("Session ")) {
            String token = authHeader.substring(8);
            authService.logout(token);
        }
        return ResponseEntity.noContent().build();
    }
}
