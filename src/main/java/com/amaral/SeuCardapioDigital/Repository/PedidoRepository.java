package com.amaral.SeuCardapioDigital.Repository;

import com.amaral.SeuCardapioDigital.Model.PedidoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PedidoRepository extends JpaRepository<PedidoModel, Long> {

    @Query("SELECT p.codigoDoPedido FROM PedidoModel p WHERE p.estabelecimento.id = :cdEstabelecimento ORDER BY p.id DESC LIMIT 1")
    Optional<Long> findUltimoPedidoDoEstabelecimento(@Param("cdEstabelecimento") Long cdEstabelecimento);

    @Query("SELECT p FROM PedidoModel p WHERE p.estabelecimento.id = :cdEstabelecimento ORDER BY p.id")
    List<PedidoModel> findByCdEstabelecimento(@Param("cdEstabelecimento") long cdEstabelecimento);

    Optional<PedidoModel> findByCodigoDoPedido(Long codigoDoPedido);

    @Query("SELECT p FROM PedidoModel p "
            + "LEFT JOIN FETCH p.cliente "
            + "LEFT JOIN FETCH p.itemDoPedido "
            + "WHERE p.id = :id")
    Optional<PedidoModel> findByIdComItensECliente(Long id);
}
