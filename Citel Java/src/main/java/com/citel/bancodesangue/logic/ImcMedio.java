package com.citel.bancodesangue.logic;

import com.citel.bancodesangue.entity.BancoDeSangue;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Component
public class ImcMedio {

    private Map<String, Float> imcMedio;
    private Map<String, Integer> quantidadePorIdade;
    private Map<String, Float> quantidadeImcPorIdade;
    private int quantidadeMulheres;
    private int quantidadeMulheresObesas;
    private float percentualMulheres;
    private int quantidadeHomens;
    private int quantidadeHomensObesos;
    private float percentualHomens;
    private String[] faixasEtarias = {"01 - 10", "11 - 20", "21 - 30", "31 - 40", "41 - 50",
            "51 - 60", "61 - 70", "71 - 80", "81 - 90", "91 - 100"};

    public ImcMedio() {
        imcMedio = new HashMap<>();
        quantidadePorIdade = new HashMap<>();
        quantidadeImcPorIdade = new HashMap<>();
        quantidadeMulheres = 0;
        quantidadeMulheresObesas = 0;
        quantidadeHomens = 0;
        quantidadeHomensObesos = 0;
    }

    public Map<String, Float> calcularMediaImc(List<BancoDeSangue> candidatos) {
        inicializarMapasEVariaveis();
        conferirIdades(candidatos);
        calcularImcMedio();

        return new HashMap<>(imcMedio);
    }

    public float getPercentualMulheres() {
        return percentualMulheres;
    }

    public float getPercentualHomens() {
        return percentualHomens;
    }

    private void inicializarMapasEVariaveis() {

        for (String faixaEtaria : faixasEtarias) {
            imcMedio.put(faixaEtaria, 0f);
            quantidadePorIdade.put(faixaEtaria, 0);
            quantidadeImcPorIdade.put(faixaEtaria, 0f);
        }
    }

    private void conferirIdades(List<BancoDeSangue> candidatos) {

        for (BancoDeSangue candidato : candidatos) {
            int idade = calcularIdade(candidato.getData_nasc());
            float imc = calcularImc(candidato);

            conferirObesidadeEGenero(candidato, imc);

            for (int i = 0; i < faixasEtarias.length; i++) {
                if (idade <= (i + 1) * 10) {
                    String faixaEtaria = faixasEtarias[i];
                    quantidadePorIdade.put(faixaEtaria, quantidadePorIdade.get(faixaEtaria) + 1);
                    quantidadeImcPorIdade.put(faixaEtaria, quantidadeImcPorIdade.get(faixaEtaria) + imc);
                    break;
                }
            }
        }
    }

    private int calcularIdade(String dataString) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataNasc = LocalDate.parse(dataString, format);
        return (int) ChronoUnit.YEARS.between(dataNasc, LocalDate.now());
    }

    private float calcularImc(BancoDeSangue candidato) {
        return candidato.getPeso() / (candidato.getAltura() * candidato.getAltura());
    }

    private void conferirObesidadeEGenero(BancoDeSangue candidato, float imc) {
        if (candidato.getSexo().equals("Feminino")) {
            quantidadeMulheres++;
            if (imc > 30) {
                quantidadeMulheresObesas++;
            }
        } else {
            quantidadeHomens++;
            if (imc > 30) {
                quantidadeHomensObesos++;
            }
        }
    }

    private void calcularImcMedio() {
        DecimalFormatSymbols simbolo = new DecimalFormatSymbols(Locale.getDefault());
        simbolo.setDecimalSeparator('.');

        DecimalFormat decimalFormat = new DecimalFormat("#.##", simbolo);

        for (String faixaEtaria : faixasEtarias) {
            float imcMedioValor = Float.parseFloat(decimalFormat.format(
                    quantidadeImcPorIdade.get(faixaEtaria) / quantidadePorIdade.get(faixaEtaria)));
            imcMedio.put(faixaEtaria, imcMedioValor);
        }

        percentualHomens = Float.parseFloat(decimalFormat.format(
                (quantidadeHomensObesos / (float) quantidadeHomens) * 100));

        percentualMulheres = Float.parseFloat(decimalFormat.format(
                (quantidadeMulheresObesas / (float) quantidadeMulheres) * 100));
    }
}
