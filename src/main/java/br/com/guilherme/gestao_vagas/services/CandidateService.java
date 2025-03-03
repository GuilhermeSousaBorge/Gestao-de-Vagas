package br.com.guilherme.gestao_vagas.services;

import br.com.guilherme.gestao_vagas.exeption.UserFoundException;
import br.com.guilherme.gestao_vagas.models.CandidateEntity;
import br.com.guilherme.gestao_vagas.repositories.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    public CandidateEntity createCandidate(CandidateEntity candidate){
        this.candidateRepository.findByUsernameOrEmail(candidate.getUsername(), candidate.getEmail())
                .ifPresent((user) -> {
                    throw new UserFoundException();
                });
        return this.candidateRepository.save(candidate);
    }
}
