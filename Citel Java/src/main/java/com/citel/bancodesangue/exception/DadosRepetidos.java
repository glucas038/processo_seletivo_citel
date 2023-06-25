package com.citel.bancodesangue.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DadosRepetidos extends Exception{

    public DadosRepetidos(){
        super("Só pode cadastrar o mesmo CPF uma vez");
    }

}
