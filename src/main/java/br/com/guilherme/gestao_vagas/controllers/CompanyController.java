package br.com.guilherme.gestao_vagas.controllers;

import br.com.guilherme.gestao_vagas.models.CompanyEntity;
import br.com.guilherme.gestao_vagas.services.CompanyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @PostMapping
    public ResponseEntity<Object> createCompany(@Valid @RequestBody CompanyEntity request){
        try{
            var response = this.companyService.createCompany(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
