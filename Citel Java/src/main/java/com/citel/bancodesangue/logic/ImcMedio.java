package com.citel.bancodesangue.logic;

import com.citel.bancodesangue.entity.BancoDeSangue;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;

@Component
public class ImcMedio {

    private Map<String, Integer> imcMedio;
    private Map<String, Integer> quantidadePorIdade;
    public ImcMedio(Map<String, Integer> imcMedio) {
        this.quantidadePorIdade = Map.of(
                "ate10", 0,
                "ate20", 0,
                "ate30", 0,
                "ate40", 0,
                "ate50", 0,
                "ate60", 0,
                "ate70", 0,
                "ate80", 0,
                "ate90", 0,
                "ate100", 0
        );
    }




    private void conferirIdades(List<BancoDeSangue> candidatos){
        for (BancoDeSangue c: candidatos){
            int idade = calculaIdade(c.getData_nasc());

            if (idade <= 10) {
                quantidadePorIdade.put("ate10", quantidadePorIdade.get("ate10") + 1);
            } else if (idade <= 20) {
                quantidadePorIdade.put("ate20", quantidadePorIdade.get("ate20") + 1);
            } else if (idade <= 30) {
                quantidadePorIdade.put("ate30", quantidadePorIdade.get("ate30") + 1);
            } else if (idade <= 40) {
                quantidadePorIdade.put("ate40", quantidadePorIdade.get("ate40") + 1);
            } else if (idade <= 50) {
                quantidadePorIdade.put("ate50", quantidadePorIdade.get("ate50") + 1);
            } else if (idade <= 60) {
                quantidadePorIdade.put("ate60", quantidadePorIdade.get("ate60") + 1);
            } else if (idade <= 70) {
                quantidadePorIdade.put("ate70", quantidadePorIdade.get("ate70") + 1);
            } else if (idade <= 80) {
                quantidadePorIdade.put("ate80", quantidadePorIdade.get("ate80") + 1);
            } else if (idade <= 90) {
                quantidadePorIdade.put("ate90", quantidadePorIdade.get("ate90") + 1);
            } else {
                quantidadePorIdade.put("ate100", quantidadePorIdade.get("ate100") + 1);
            }

        }

    }

    private int calculaIdade(String data){
        LocalDate dataNasc = LocalDate.parse(data);
        int ano = dataNasc.getYear();
        int mes = dataNasc.getMonth().getValue();
        int dia = dataNasc.getDayOfMonth();

        return (int) ChronoUnit.YEARS.between(LocalDate.of(ano,mes,dia), LocalDate.now());

    }
}
