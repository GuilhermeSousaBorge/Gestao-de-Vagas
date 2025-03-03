package br.com.guilherme.gestao_vagas.exeption;

public class UserFoundException extends RuntimeException {

    public UserFoundException() {
        super("Usuario já cadastrado");
    }
}
