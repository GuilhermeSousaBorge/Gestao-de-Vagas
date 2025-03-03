package br.com.guilherme.gestao_vagas.repositories;

import br.com.guilherme.gestao_vagas.models.CandidateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CandidateRepository extends JpaRepository<CandidateEntity, UUID> {
}
