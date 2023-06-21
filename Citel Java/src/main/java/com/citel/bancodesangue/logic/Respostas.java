package com.citel.bancodesangue.logic;

import com.citel.bancodesangue.entity.BancoDeSangue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class Respostas {

    @Autowired
    private Estados estados;

    public Map<String, Integer> candidatosPorEstado(List<BancoDeSangue> candidatos){
        Map<String, Integer> quantidadeEstados = estados.getQuantidadePorEstados();

        for (BancoDeSangue c : candidatos){
            quantidadeEstados.put(c.getEstado(), quantidadeEstados.get(c.getEstado()) +1);
            System.out.println(quantidadeEstados.get(c.getEstado()));
        }

        return quantidadeEstados;

    }


}
