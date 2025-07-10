package com.amaral.SeuCardapioDigital.Repository;

import com.amaral.SeuCardapioDigital.Model.SessaoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SessaoRepository extends JpaRepository<SessaoModel, String> {
    Optional<SessaoModel> findByTokenAndAtivaTrue(String token);
}
