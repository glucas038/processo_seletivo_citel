package com.citel.bancodesangue.logic;

import com.citel.bancodesangue.entity.BancoDeSangue;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ImcMedio {

    private Map<String, Float> imcMedio;
    private Map<String, Integer> quantidadePorIdade;
    private Map<String, Float> quantidadeImcPorIdade;
    private float quantidadeMulher;
    private float quantidadeMulherObesa;
    private float percentualMulher;
    private float quantidadeHomem;
    private float quantidadeHomemObeso;
    private float percentualHomem;



    public ImcMedio(Map<String, Integer> imcMedio) {
        this.imcMedio = new HashMap<>();
        this.quantidadePorIdade = new HashMap<>();
        this.quantidadeImcPorIdade = new HashMap<>();
    }

    public Map<String, Float> mediaDeImc(List<BancoDeSangue> candidatos) {
        iniciarMapsEVariaveis();
        conferirIdades(candidatos);

        imcMedio.put("ate10", quantidadeImcPorIdade.get("ate10")/quantidadePorIdade.get("ate10"));
        imcMedio.put("ate20", quantidadeImcPorIdade.get("ate20")/quantidadePorIdade.get("ate20"));
        imcMedio.put("ate30", quantidadeImcPorIdade.get("ate30")/quantidadePorIdade.get("ate30"));
        imcMedio.put("ate40", quantidadeImcPorIdade.get("ate40")/quantidadePorIdade.get("ate40"));
        imcMedio.put("ate50", quantidadeImcPorIdade.get("ate50")/quantidadePorIdade.get("ate50"));
        imcMedio.put("ate60", quantidadeImcPorIdade.get("ate60")/quantidadePorIdade.get("ate60"));
        imcMedio.put("ate70", quantidadeImcPorIdade.get("ate70")/quantidadePorIdade.get("ate70"));
        imcMedio.put("ate80", quantidadeImcPorIdade.get("ate80")/quantidadePorIdade.get("ate80"));
        imcMedio.put("ate90", quantidadeImcPorIdade.get("ate90")/quantidadePorIdade.get("ate90"));
        imcMedio.put("ate100", quantidadeImcPorIdade.get("ate100")/quantidadePorIdade.get("ate100"));

        percentualHomem = (quantidadeHomemObeso/quantidadeHomem) * 100;
        percentualMulher = (quantidadeMulherObesa/quantidadeMulher) * 100;
        System.out.println(quantidadeHomemObeso);

        return imcMedio;
    }

    public float getPercentualMulher() {
        return percentualMulher;
    }

    public float getPercentualHomem() {
        return percentualHomem;
    }

    private void iniciarMapsEVariaveis() {
        String[] faixasEtarias = {"ate10", "ate20", "ate30", "ate40", "ate50",
                "ate60", "ate70", "ate80", "ate90", "ate100"};
        for (String faixaEtaria : faixasEtarias) {
            imcMedio.put(faixaEtaria, 0f);
            quantidadePorIdade.put(faixaEtaria, 0);
            quantidadeImcPorIdade.put(faixaEtaria, 0f);
        }

        this.quantidadeMulher = 0;
        this.quantidadeMulherObesa = 0;
        this.quantidadeHomem = 0;
        this.quantidadeHomemObeso = 0;
    }

    private void conferirIdades(List<BancoDeSangue> candidatos){
        for (BancoDeSangue c: candidatos){
            int idade = calculaIdade(c.getData_nasc());
            float imc = calculaImc(c);

            obesidadePercentualSexo(c, imc);

            if (idade <= 10) {
                quantidadePorIdade.put("ate10", quantidadePorIdade.get("ate10") + 1);
                quantidadeImcPorIdade.put("ate10", quantidadeImcPorIdade.get("ate10") + imc);
            } else if (idade <= 20) {
                quantidadePorIdade.put("ate20", quantidadePorIdade.get("ate20") + 1);
                quantidadeImcPorIdade.put("ate20", quantidadeImcPorIdade.get("ate20") + imc);
            } else if (idade <= 30) {
                quantidadePorIdade.put("ate30", quantidadePorIdade.get("ate30") + 1);
                quantidadeImcPorIdade.put("ate30", quantidadeImcPorIdade.get("ate30") + imc);
            } else if (idade <= 40) {
                quantidadePorIdade.put("ate40", quantidadePorIdade.get("ate40") + 1);
                quantidadeImcPorIdade.put("ate40", quantidadeImcPorIdade.get("ate40") + imc);
            } else if (idade <= 50) {
                quantidadePorIdade.put("ate50", quantidadePorIdade.get("ate50") + 1);
                quantidadeImcPorIdade.put("ate50", quantidadeImcPorIdade.get("ate50") + imc);
            } else if (idade <= 60) {
                quantidadePorIdade.put("ate60", quantidadePorIdade.get("ate60") + 1);
                quantidadeImcPorIdade.put("ate60", quantidadeImcPorIdade.get("ate60") + imc);
            } else if (idade <= 70) {
                quantidadePorIdade.put("ate70", quantidadePorIdade.get("ate70") + 1);
                quantidadeImcPorIdade.put("ate70", quantidadeImcPorIdade.get("ate70") + imc);
            } else if (idade <= 80) {
                quantidadePorIdade.put("ate80", quantidadePorIdade.get("ate80") + 1);
                quantidadeImcPorIdade.put("ate80", quantidadeImcPorIdade.get("ate80") + imc);
            } else if (idade <= 90) {
                quantidadePorIdade.put("ate90", quantidadePorIdade.get("ate90") + 1);
                quantidadeImcPorIdade.put("ate90", quantidadeImcPorIdade.get("ate90") + imc);
            } else {
                quantidadePorIdade.put("ate100", quantidadePorIdade.get("ate100") + 1);
                quantidadeImcPorIdade.put("ate100", quantidadeImcPorIdade.get("ate100") + imc);
            }

        }

    }

    private int calculaIdade(String dataString){

        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(dataString, format);

        LocalDate dataNasc = LocalDate.of(localDate.getYear(), localDate.getMonth(), localDate.getDayOfMonth());
        int ano = dataNasc.getYear();
        int mes = dataNasc.getMonth().getValue();
        int dia = dataNasc.getDayOfMonth();

        return (int) ChronoUnit.YEARS.between(LocalDate.of(ano,mes,dia), LocalDate.now());

    }

    private float calculaImc(BancoDeSangue candidato){
        float imc = candidato.getPeso()/(candidato.getAltura() * candidato.getAltura());
        return imc;
    }

    private void obesidadePercentualSexo(BancoDeSangue candidato, float imc){
        if (candidato.getSexo().equals("Feminino")){
            quantidadeMulher++;
            if (imc > 30){
                quantidadeMulherObesa++;
            }
        } else {
            quantidadeHomem++;
            if (imc > 30){
                quantidadeHomemObeso++;
            }
        }
    }


}
