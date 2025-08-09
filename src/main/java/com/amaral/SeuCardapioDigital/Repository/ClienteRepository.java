package com.amaral.SeuCardapioDigital.Repository;

import com.amaral.SeuCardapioDigital.Model.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {

    Optional<ClienteModel> findByTelefoneAndDdd(String telefone, int ddd);
}
