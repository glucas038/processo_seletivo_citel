package com.citel.bancodesangue.logic;

import com.citel.bancodesangue.entity.BancoDeSangue;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class Estados {
    private final List<String> estados = Arrays.asList(
            "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO",
            "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI",
            "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"
    );

    public Map<String, Integer> contarQuantidadeCandidatosPorEstados(List<BancoDeSangue> candidatos) {
        Map<String, Integer> quantidadePorEstados = new HashMap<>();
        inicializarQuantidadePorEstados(quantidadePorEstados);

        for (BancoDeSangue candidato : candidatos) {
            String estado = candidato.getEstado();
            quantidadePorEstados.put(estado, quantidadePorEstados.getOrDefault(estado, 0) + 1);
        }

        return quantidadePorEstados;
    }

    private void inicializarQuantidadePorEstados(Map<String, Integer> quantidadePorEstados) {
        for (String estado : estados) {
            quantidadePorEstados.put(estado, 0);
        }
    }
}
