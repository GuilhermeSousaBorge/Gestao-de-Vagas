package br.com.guilherme.gestao_vagas.repositories;

import br.com.guilherme.gestao_vagas.models.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CompanyRepository extends JpaRepository<CompanyEntity, UUID> {

    Optional<CompanyEntity> findByUserNameOrEmail(String username, String email);
}
