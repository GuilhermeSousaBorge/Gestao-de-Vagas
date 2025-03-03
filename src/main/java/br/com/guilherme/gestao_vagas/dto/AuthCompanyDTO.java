package br.com.guilherme.gestao_vagas.dto;

import lombok.Builder;

@Builder
public record AuthCompanyDTO(String username, String password) {
}
