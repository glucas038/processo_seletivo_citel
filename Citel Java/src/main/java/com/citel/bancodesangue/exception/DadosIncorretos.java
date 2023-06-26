package com.citel.bancodesangue.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DadosIncorretos extends Exception {

    public DadosIncorretos(){
        super("Sexo, estado, tipo sanguineo ou data de nascimento incorretos");
    }

}
