package com.amaral.SeuCardapioDigital.Service;

import com.amaral.SeuCardapioDigital.Dto.Request.LoginRequestDto;
import com.amaral.SeuCardapioDigital.Model.SessaoModel;
import com.amaral.SeuCardapioDigital.Repository.EstabelecimentoRepository;
import com.amaral.SeuCardapioDigital.Repository.SessaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class AuthService {

    @Autowired
    private EstabelecimentoRepository estabelecimentoRepository;
    @Autowired
    private SessaoRepository sessaoRepository;

    public String autenticar(String nomeEstabelecimento, String senha, String ip, String userAgent){
        var estabelecimento = estabelecimentoRepository.findByNome(nomeEstabelecimento)
                .orElseThrow(()-> new RuntimeException("Credenciais invalidas"));

        if (!new BCryptPasswordEncoder().matches(senha, estabelecimento.getSenha())){
            throw new RuntimeException("Credenciais incorretas");
        }

        String token = UUID.randomUUID().toString();
        SessaoModel sessao = new SessaoModel();
        sessao.setToken(token);
        sessao.setEstabelecimento(estabelecimento);
        sessao.setCriadaEm(LocalDateTime.now());
        sessao.setExpiraEm(LocalDateTime.now().plusHours(1));
        sessao.setAtiva(true);
        sessao.setIp(ip);
        sessao.setUserAgent(userAgent);

        sessaoRepository.save(sessao);
        return token;
    }

    public void logout(String token) {
        sessaoRepository.findById(token).ifPresent(sessao -> {
            sessao.setAtiva(false);
            sessaoRepository.save(sessao);
        });
    }

}
