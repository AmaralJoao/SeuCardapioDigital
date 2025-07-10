package com.amaral.SeuCardapioDigital.Repository;

import com.amaral.SeuCardapioDigital.Model.ProdutoModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {
    @Query("SELECT p FROM ProdutoModel p WHERE p.estabelecimento.id = :cdEstabelecimento")
    List<ProdutoModel> findByCdEstabelecimento(@Param("cdEstabelecimento") long cdEstabelecimento);
    //Page<ProdutoModel> findByCdEstabelecimento(@Param("cdEstabelecimento") long cdEstabelecimento, Pageable pageable);

}
