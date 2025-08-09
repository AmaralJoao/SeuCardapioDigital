package com.amaral.SeuCardapioDigital.Repository;

import com.amaral.SeuCardapioDigital.Model.EstabelecimentoFormaPagamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstabelecimentoFormaPagamentoRepository extends JpaRepository<EstabelecimentoFormaPagamentoModel, Long> {
}
