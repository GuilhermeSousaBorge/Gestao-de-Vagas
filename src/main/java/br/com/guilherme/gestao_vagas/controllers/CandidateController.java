package br.com.guilherme.gestao_vagas.controllers;

import br.com.guilherme.gestao_vagas.models.CandidateEntity;
import br.com.guilherme.gestao_vagas.repositories.CandidateRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/candidate")
public class CandidateController {

    @Autowired
    private CandidateRepository candidateRepository;

    @PostMapping
    public CandidateEntity createCandidate(@Valid @RequestBody CandidateEntity request){
        return this.candidateRepository.save(request);
    }
}
