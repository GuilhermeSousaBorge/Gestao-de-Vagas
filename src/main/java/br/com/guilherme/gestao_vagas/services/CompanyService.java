package br.com.guilherme.gestao_vagas.services;

import br.com.guilherme.gestao_vagas.exeption.CompanyFoundException;
import br.com.guilherme.gestao_vagas.models.CompanyEntity;
import br.com.guilherme.gestao_vagas.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public CompanyEntity createCompany(CompanyEntity company){
        this.companyRepository.findByUserNameOrEmail(company.getUserName(), company.getEmail())
                .ifPresent(c -> {
                    throw new CompanyFoundException();
                });
        return this.companyRepository.save(company);
    }
}
