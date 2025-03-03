package br.com.guilherme.gestao_vagas.controllers;

import br.com.guilherme.gestao_vagas.dto.AuthCompanyDTO;
import br.com.guilherme.gestao_vagas.security.AuthCompany;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.AuthenticationException;

@RestController
@RequestMapping("/api/auth")
public class AuthCompanyController {

    @Autowired
    private AuthCompany authCompany;

    @PostMapping("/company")
    public ResponseEntity<Object> create(@RequestBody AuthCompanyDTO authCompanyDTO) throws AuthenticationException {
        try {
            var response = this.authCompany.generateCompanyAuthToken(authCompanyDTO);
            return ResponseEntity.ok().body(response);
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }
}
