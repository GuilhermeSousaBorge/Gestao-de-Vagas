package br.com.guilherme.gestao_vagas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExceptionDto {

    private String message;
    private String field;
}
