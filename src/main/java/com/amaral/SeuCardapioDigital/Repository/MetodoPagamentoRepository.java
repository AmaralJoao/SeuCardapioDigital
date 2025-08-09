package com.amaral.SeuCardapioDigital.Repository;

import java.util.Optional;

import com.amaral.SeuCardapioDigital.Model.MetodoPagamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MetodoPagamentoRepository extends JpaRepository<MetodoPagamentoModel, Long> {

    Optional<MetodoPagamentoModel> findByIdAndAtivoTrue(Long id);

}
