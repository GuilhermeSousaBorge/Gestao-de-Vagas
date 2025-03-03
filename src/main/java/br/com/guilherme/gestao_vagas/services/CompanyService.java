package br.com.guilherme.gestao_vagas.services;

import br.com.guilherme.gestao_vagas.exeption.CompanyFoundException;
import br.com.guilherme.gestao_vagas.models.CompanyEntity;
import br.com.guilherme.gestao_vagas.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public CompanyEntity createCompany(CompanyEntity company){
        this.companyRepository.findByUsernameOrEmail(company.getUsername(), company.getEmail())
                .ifPresent(c -> {
                    throw new CompanyFoundException();
                });

        var encryptedPass = passwordEncoder.encode(company.getPassword());
        company.setPassword(encryptedPass);
        return this.companyRepository.save(company);
    }
}
