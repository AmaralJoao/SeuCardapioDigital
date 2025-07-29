package com.amaral.SeuCardapioDigital.Service;

import com.amaral.SeuCardapioDigital.Dto.Request.EstabelecimentoRequestDto;
import com.amaral.SeuCardapioDigital.Dto.Response.EstabelecimentoResponseDto;
import com.amaral.SeuCardapioDigital.Mapper.EstabelecimentoMapper;
import com.amaral.SeuCardapioDigital.Model.EstabelecimentoModel;
import com.amaral.SeuCardapioDigital.Repository.EstabelecimentoRepository;
import com.amaral.SeuCardapioDigital.Repository.HorarioFuncionamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

@Service
public class EstabelecimentoService {

    @Autowired
    private EstabelecimentoRepository estabelecimentoRepository;
    @Autowired
    private EstabelecimentoMapper estabelecimentoMapper;

    public EstabelecimentoResponseDto criarEstabelecimento(EstabelecimentoRequestDto criarEstabelecimentoRequestDto){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        EstabelecimentoModel novoEstebelecimento = estabelecimentoMapper.requestToModel(criarEstabelecimentoRequestDto);

        novoEstebelecimento.setSenha(passwordEncoder.encode(novoEstebelecimento.getSenha()));

        EstabelecimentoModel estabelecimentoCriado = estabelecimentoRepository.save(novoEstebelecimento);

        String urlGerada = gerarUrl(estabelecimentoCriado);
        estabelecimentoCriado.setUrl(urlGerada);

        estabelecimentoCriado = estabelecimentoRepository.save(estabelecimentoCriado);

        return estabelecimentoMapper.toDto(estabelecimentoCriado);
    }


    private String gerarUrl(EstabelecimentoModel estabelecimentoCriado) {

        return String.format(estabelecimentoCriado.getId() + "-" + gerarSlug(estabelecimentoCriado.getNome()));
    }

    private String gerarSlug(String nomeDoEstabelecimento){
        return nomeDoEstabelecimento.toLowerCase()
                .replaceAll("[^a-z0-9\\s]", "")
                .replaceAll("\\s+", "-");

    }
}
