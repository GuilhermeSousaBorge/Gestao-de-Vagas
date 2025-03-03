package br.com.guilherme.gestao_vagas.repositories;

import br.com.guilherme.gestao_vagas.models.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JobRepository extends JpaRepository<JobEntity, UUID> {
}
