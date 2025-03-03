package br.com.guilherme.gestao_vagas.controllers;

import br.com.guilherme.gestao_vagas.models.CandidateEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/candidate")
public class CandidateController {

    @PostMapping
    public CandidateEntity createCandidate(@RequestBody CandidateEntity request){
        return request;
    }
}
