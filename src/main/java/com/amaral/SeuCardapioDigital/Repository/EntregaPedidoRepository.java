package com.amaral.SeuCardapioDigital.Repository;

import java.util.Optional;

import com.amaral.SeuCardapioDigital.Model.EntregaPedidoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntregaPedidoRepository extends JpaRepository<EntregaPedidoModel, Long> {

    Optional<EntregaPedidoModel> findByPedidoId(Long pedidoId);

}
