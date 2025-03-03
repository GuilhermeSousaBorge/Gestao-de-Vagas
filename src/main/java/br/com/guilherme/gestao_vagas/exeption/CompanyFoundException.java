package br.com.guilherme.gestao_vagas.exeption;

public class CompanyFoundException extends RuntimeException{
    public CompanyFoundException() {
        super("Empresa já cadastrada");
    }
}
