package com.citel.bancodesangue.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CandidatoNaoEncontrado  extends Exception{

    public CandidatoNaoEncontrado(){
        super("Candidato não encontrado");
    }
}
