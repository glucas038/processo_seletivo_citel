package com.citel.bancodesangue.logic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class Estados {
    private List<String> estados;
    private Map<String, Integer> quantidadePorEstados;

    public Estados() {
        this.estados = new ArrayList<>(Arrays.asList("AC","AL","AP","AM", "BA", "CE", "DF", "ES", "GO",
                "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI",
                "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"));

        this.quantidadePorEstados = new HashMap<String, Integer>();

    }

    public Map<String, Integer> getQuantidadePorEstados() {
        inicializarQuantidadePorEstados();
        return quantidadePorEstados;
    }

    public void inicializarQuantidadePorEstados(){
        for (String e: estados){
            quantidadePorEstados.put(e,0);
        }
    }

    public boolean EstadoValido(String estado){
        return estados.contains(estado);
    }



}
