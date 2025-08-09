package com.amaral.SeuCardapioDigital.Repository;

import java.util.Optional;

import com.amaral.SeuCardapioDigital.Model.PagamentoPedidoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoPedidoRepository extends JpaRepository<PagamentoPedidoModel, Long> {

    Optional<PagamentoPedidoModel> findByPedidoId(Long pedidoId);

}
