package com.amaral.SeuCardapioDigital.Service;

import com.amaral.SeuCardapioDigital.Dto.Request.HorarioDeFuncionamentoResquestDto;
import com.amaral.SeuCardapioDigital.Model.EstabelecimentoModel;
import com.amaral.SeuCardapioDigital.Model.HorarioFuncionamentoModel;
import com.amaral.SeuCardapioDigital.Repository.EstabelecimentoRepository;
import com.amaral.SeuCardapioDigital.Repository.HorarioFuncionamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HorarioFuncionamentoService {

    @Autowired
    private HorarioFuncionamentoRepository repository;
    @Autowired
    private EstabelecimentoRepository estabelecimentoRepository;

    public HorarioFuncionamentoModel criar(HorarioDeFuncionamentoResquestDto dto) {
        EstabelecimentoModel estabelecimento = estabelecimentoRepository.findById(dto.getEstabelecimentoId())
                .orElseThrow(() -> new RuntimeException("Estabelecimento não encontrado"));

        if (dto.getHorarioAbertura().isAfter(dto.getHorarioFechamento())) {
            throw new IllegalArgumentException("Horário de abertura não pode ser após o horário de fechamento.");
        }

        HorarioFuncionamentoModel horario = new HorarioFuncionamentoModel();
        horario.setDiaDaSemana(dto.getDiaDaSemana());
        horario.setHorarioAbertura(dto.getHorarioAbertura());
        horario.setHorarioFechamento(dto.getHorarioFechamento());
        horario.setEstabelecimento(estabelecimento);

        return repository.save(horario);
    }

    public List<HorarioFuncionamentoModel> listarPorEstabelecimento(Long estabelecimentoId) {
        return repository.findByEstabelecimentoId(estabelecimentoId);
    }
}
