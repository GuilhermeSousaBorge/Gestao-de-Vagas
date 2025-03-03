package br.com.guilherme.gestao_vagas.controllers;

import br.com.guilherme.gestao_vagas.exeption.UserFoundException;
import br.com.guilherme.gestao_vagas.models.CandidateEntity;
import br.com.guilherme.gestao_vagas.repositories.CandidateRepository;
import br.com.guilherme.gestao_vagas.services.CandidateService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/candidate")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @PostMapping
    public ResponseEntity<Object> createCandidate(@Valid @RequestBody CandidateEntity request){

        try{
            var response = this.candidateService.createCandidate(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
