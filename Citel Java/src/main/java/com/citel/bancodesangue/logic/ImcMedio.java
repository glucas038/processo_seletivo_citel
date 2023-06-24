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

        imcMedio.put("01 - 10", quantidadeImcPorIdade.get("01 - 10")/quantidadePorIdade.get("01 - 10"));
        imcMedio.put("11 - 20", quantidadeImcPorIdade.get("11 - 20")/quantidadePorIdade.get("11 - 20"));
        imcMedio.put("21 - 30", quantidadeImcPorIdade.get("21 - 30")/quantidadePorIdade.get("21 - 30"));
        imcMedio.put("31 - 40", quantidadeImcPorIdade.get("31 - 40")/quantidadePorIdade.get("31 - 40"));
        imcMedio.put("41 - 50", quantidadeImcPorIdade.get("41 - 50")/quantidadePorIdade.get("41 - 50"));
        imcMedio.put("51 - 60", quantidadeImcPorIdade.get("51 - 60")/quantidadePorIdade.get("51 - 60"));
        imcMedio.put("61 - 70", quantidadeImcPorIdade.get("61 - 70")/quantidadePorIdade.get("61 - 70"));
        imcMedio.put("71 - 80", quantidadeImcPorIdade.get("71 - 80")/quantidadePorIdade.get("71 - 80"));
        imcMedio.put("81 - 90", quantidadeImcPorIdade.get("81 - 90")/quantidadePorIdade.get("81 - 90"));
        imcMedio.put("91 - 100", quantidadeImcPorIdade.get("91 - 100")/quantidadePorIdade.get("91 - 100"));

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
        String[] faixasEtarias = {"01 - 10", "11 - 20", "21 - 30", "31 - 40", "41 - 50",
                "51 - 60", "61 - 70", "71 - 80", "81 - 90", "91 - 100"};
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
        String[] faixasEtarias = {"01 - 10", "11 - 20", "21 - 30", "31 - 40", "41 - 50",
                "51 - 60", "61 - 70", "71 - 80", "81 - 90", "91 - 100"};

        for (BancoDeSangue c: candidatos){
            int idade = calculaIdade(c.getData_nasc());
            float imc = calculaImc(c);

            obesidadePercentualSexo(c, imc);

            if (idade <= 10) {
                quantidadePorIdade.put(faixasEtarias[0], quantidadePorIdade.get(faixasEtarias[0]) + 1);
                quantidadeImcPorIdade.put(faixasEtarias[0], quantidadeImcPorIdade.get(faixasEtarias[0]) + imc);
            } else if (idade <= 20) {
                quantidadePorIdade.put(faixasEtarias[1], quantidadePorIdade.get(faixasEtarias[1]) + 1);
                quantidadeImcPorIdade.put(faixasEtarias[1], quantidadeImcPorIdade.get(faixasEtarias[1]) + imc);
            } else if (idade <= 30) {
                quantidadePorIdade.put(faixasEtarias[2], quantidadePorIdade.get(faixasEtarias[2]) + 1);
                quantidadeImcPorIdade.put(faixasEtarias[2], quantidadeImcPorIdade.get(faixasEtarias[2]) + imc);
            } else if (idade <= 40) {
                quantidadePorIdade.put(faixasEtarias[3], quantidadePorIdade.get(faixasEtarias[3]) + 1);
                quantidadeImcPorIdade.put(faixasEtarias[3], quantidadeImcPorIdade.get(faixasEtarias[3]) + imc);
            } else if (idade <= 50) {
                quantidadePorIdade.put(faixasEtarias[4], quantidadePorIdade.get(faixasEtarias[4]) + 1);
                quantidadeImcPorIdade.put(faixasEtarias[4], quantidadeImcPorIdade.get(faixasEtarias[4]) + imc);
            } else if (idade <= 60) {
                quantidadePorIdade.put(faixasEtarias[5], quantidadePorIdade.get(faixasEtarias[5]) + 1);
                quantidadeImcPorIdade.put(faixasEtarias[5], quantidadeImcPorIdade.get(faixasEtarias[5]) + imc);
            } else if (idade <= 70) {
                quantidadePorIdade.put(faixasEtarias[6], quantidadePorIdade.get(faixasEtarias[6]) + 1);
                quantidadeImcPorIdade.put(faixasEtarias[6], quantidadeImcPorIdade.get(faixasEtarias[6]) + imc);
            } else if (idade <= 80) {
                quantidadePorIdade.put(faixasEtarias[7], quantidadePorIdade.get(faixasEtarias[7]) + 1);
                quantidadeImcPorIdade.put(faixasEtarias[7], quantidadeImcPorIdade.get(faixasEtarias[7]) + imc);
            } else if (idade <= 90) {
                quantidadePorIdade.put(faixasEtarias[8], quantidadePorIdade.get(faixasEtarias[8]) + 1);
                quantidadeImcPorIdade.put(faixasEtarias[8], quantidadeImcPorIdade.get(faixasEtarias[8]) + imc);
            } else {
                quantidadePorIdade.put(faixasEtarias[9], quantidadePorIdade.get(faixasEtarias[9]) + 1);
                quantidadeImcPorIdade.put(faixasEtarias[9], quantidadeImcPorIdade.get(faixasEtarias[9]) + imc);
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
