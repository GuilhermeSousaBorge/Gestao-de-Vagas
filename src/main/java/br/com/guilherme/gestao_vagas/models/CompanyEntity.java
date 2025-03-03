package br.com.guilherme.gestao_vagas.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "company")
@Data
public class CompanyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    @Email(message = "Insira um email valido!")
    private String email;

    @Length(min = 6, max = 100, message = "O campo [senha] deve conter 6 a 8 caracteres")
    private String password;

    @Pattern(regexp = "\\S+", message = "[username] invalido")
    private String username;

    private String webSite;

    private String description;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
