package br.com.guilherme.gestao_vagas.security;

import br.com.guilherme.gestao_vagas.dto.AuthCompanyDTO;
import br.com.guilherme.gestao_vagas.repositories.CompanyRepository;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;

@Service
public class AuthCompany {

    @Value("${security.token.secret}")
    private String securityToken;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String generateCompanyAuthToken(AuthCompanyDTO authCompanyDTO) throws AuthenticationException {
        var company = this.companyRepository.findByUsername(authCompanyDTO.username()).orElseThrow(() -> new UsernameNotFoundException("Company not found"));

        var passwordMatches = this.passwordEncoder.matches(authCompanyDTO.password(), company.getPassword());

        if(!passwordMatches){
            throw new AuthenticationException();
        }

        Algorithm algorithm = Algorithm.HMAC256(securityToken);
        return JWT.create().withIssuer("matchjobs")
                .withSubject(company.getId().toString()).sign(algorithm);
    }
}
