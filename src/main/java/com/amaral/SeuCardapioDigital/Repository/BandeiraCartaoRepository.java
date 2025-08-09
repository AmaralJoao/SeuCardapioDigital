package com.amaral.SeuCardapioDigital.Repository;

import java.util.Optional;

import com.amaral.SeuCardapioDigital.Model.BandeiraCartaoModel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BandeiraCartaoRepository extends JpaRepository<BandeiraCartaoModel, Long> {
    
    // Métodos adicionais podem ser incluídos conforme necessidade futura
    Optional<BandeiraCartaoModel> findById(Long id);

}

