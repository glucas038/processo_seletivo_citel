package com.citel.bancodesangue.logic;

import com.citel.bancodesangue.entity.BancoDeSangue;
import org.springframework.stereotype.Component;

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
        this.tiposSanguineos = new ArrayList<>(Arrays.asList("A+", "A-", "B+", "B-",
                "AB+", "AB-", "O+", "O-"));
        this.mediaIdade = new HashMap<String, Float>();
        this.somaIdades= new HashMap<String, Float>();
        this.quantidadesPorTipo = new HashMap<String, Integer>();
    }

    public Map<String, Float> calcularMedia(List<BancoDeSangue> candidatos){
        inicializarMap();

        for (BancoDeSangue c: candidatos){
            somaIdades.put(c.getTipo_sanguineo(), somaIdades.get(c.getTipo_sanguineo()) +
                    calculaIdade(c.getData_nasc()));
            quantidadesPorTipo.put(c.getTipo_sanguineo(), quantidadesPorTipo.get(c.getTipo_sanguineo()) + 1);

            System.out.println(c.getNome() + " + " + calculaIdade(c.getData_nasc()));
        }

        for (Map.Entry<String, Float> entry: somaIdades.entrySet()){
            mediaIdade.put(entry.getKey(), somaIdades.get(entry.getKey())/quantidadesPorTipo.get(entry.getKey()));
        }

        return mediaIdade;

    }

    private void inicializarMap(){
        for (String s: tiposSanguineos){
            mediaIdade.put(s, 0f);
            quantidadesPorTipo.put(s, 0);
            somaIdades.put(s, 0f);
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
}
