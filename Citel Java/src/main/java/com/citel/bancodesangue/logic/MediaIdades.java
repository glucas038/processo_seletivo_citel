package com.citel.bancodesangue.logic;

import com.citel.bancodesangue.entity.BancoDeSangue;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Component
public class MediaIdades {
    private Map<String, Float> mediaIdade;
    private Map<String, Float> somaIdades;
    private Map<String, Integer> quantidadesPorTipo;
    private List<String> tiposSanguineos;

    public MediaIdades(List<String> tiposSanguineos) {
        this.tiposSanguineos = new ArrayList<>(Arrays.asList("A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"));
        this.mediaIdade = new HashMap<>();
        this.somaIdades = new HashMap<>();
        this.quantidadesPorTipo = new HashMap<>();
    }

    public Map<String, Float> calcularMedia(List<BancoDeSangue> candidatos) {
        DecimalFormatSymbols simbolo = new DecimalFormatSymbols(Locale.getDefault());
        simbolo.setDecimalSeparator('.');
        DecimalFormat decimalFormat = new DecimalFormat("#.##", simbolo);

        inicializarMap();

        for (BancoDeSangue candidato : candidatos) {
            somaIdades.put(candidato.getTipo_sanguineo(), somaIdades.get(candidato.getTipo_sanguineo()) +
                    calcularIdade(candidato.getData_nasc()));
            quantidadesPorTipo.put(candidato.getTipo_sanguineo(),
                    quantidadesPorTipo.get(candidato.getTipo_sanguineo()) + 1);
        }

        for (Map.Entry<String, Float> entry : somaIdades.entrySet()) {
            float media = Float.parseFloat(decimalFormat.format(
                    somaIdades.get(entry.getKey()) / quantidadesPorTipo.get(entry.getKey())));
            mediaIdade.put(entry.getKey(), media);
        }

        return new HashMap<>(mediaIdade);
    }

    private void inicializarMap() {
        for (String tipoSanguineo : tiposSanguineos) {
            mediaIdade.put(tipoSanguineo, 0f);
            quantidadesPorTipo.put(tipoSanguineo, 0);
            somaIdades.put(tipoSanguineo, 0f);
        }
    }

    private int calcularIdade(String dataString) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(dataString, format);

        LocalDate dataNascimento = LocalDate.of(localDate.getYear(), localDate.getMonth(), localDate.getDayOfMonth());
        int ano = dataNascimento.getYear();
        int mes = dataNascimento.getMonthValue();
        int dia = dataNascimento.getDayOfMonth();

        return (int) ChronoUnit.YEARS.between(LocalDate.of(ano, mes, dia), LocalDate.now());
    }
}
