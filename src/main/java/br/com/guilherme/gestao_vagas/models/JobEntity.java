package br.com.guilherme.gestao_vagas.models;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "job")
@Data
public class JobEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String description;

    private String level;

    private String benefits;

    @Column(name = "company_id")
    private UUID companyId;

    @ManyToOne
    @JoinColumn(name = "company_id", insertable = false, updatable = false)
    private CompanyEntity companyEntity;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
