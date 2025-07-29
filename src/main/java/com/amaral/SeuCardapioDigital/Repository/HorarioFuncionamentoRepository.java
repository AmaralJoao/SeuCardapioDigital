package com.amaral.SeuCardapioDigital.Repository;

import com.amaral.SeuCardapioDigital.Model.HorarioFuncionamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;

public interface HorarioFuncionamentoRepository extends JpaRepository<HorarioFuncionamentoModel,Long> {

    List<HorarioFuncionamentoModel> findByEstabelecimentoId(Long estabelecimentoId);

    @Query("""
        SELECT CASE WHEN COUNT(h) > 0 THEN true ELSE false END
        FROM HorarioFuncionamentoModel h
        WHERE h.estabelecimento.id = :estabelecimentoId
          AND h.diaDaSemana = :diaAtual
          AND :horaAtual BETWEEN h.horarioAbertura AND h.horarioFechamento
    """)
    boolean isEstabelecimentoAberto(@Param("estabelecimentoId") Long estabelecimentoId,
                                    @Param("diaAtual") DayOfWeek diaAtual,
                                    @Param("horaAtual") LocalTime horaAtual);
}
