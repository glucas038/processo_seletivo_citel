package com.citel.bancodesangue.logic;

import com.citel.bancodesangue.entity.BancoDeSangue;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Component
public class QuantidadeDoadores {

    private Map<String, Integer> quantidadesPorTipo;
    private Map<String, Integer> quantidadesPossiveisDoadores;

    private List<String> tiposSanguineos;

    public QuantidadeDoadores(List<String> tiposSanguineos) {
        this.tiposSanguineos = new ArrayList<>(Arrays.asList("A+", "A-", "B+", "B-",
                "AB+", "AB-", "O+", "O-"));
        this.quantidadesPorTipo = new HashMap<String, Integer>();
        this.quantidadesPossiveisDoadores = new HashMap<String, Integer>();
    }

    public Map<String, Integer> quantidadeDePossiveisDoadoresPorReceptor(List<BancoDeSangue> candidatos){
        inicializarMap();

        quantidadePorTipoSanguineo(candidatos);

        int AMais = quantidadesPorTipo.get("A+");
        int AMenos = quantidadesPorTipo.get("A-");
        int BMais = quantidadesPorTipo.get("B+");
        int BMenos = quantidadesPorTipo.get("B-");
        int ABMais = quantidadesPorTipo.get("AB+");
        int ABMenos = quantidadesPorTipo.get("AB-");
        int OMais = quantidadesPorTipo.get("O+");
        int OMenos = quantidadesPorTipo.get("O-");

        quantidadesPossiveisDoadores.put("A+", AMais + AMenos + OMais + OMenos);
        quantidadesPossiveisDoadores.put("A-", AMenos + OMenos);
        quantidadesPossiveisDoadores.put("B+", BMais + BMenos + OMais + OMenos);
        quantidadesPossiveisDoadores.put("B-", BMenos + OMenos);
        quantidadesPossiveisDoadores.put("AB+", AMais + BMais + OMais + ABMais + AMenos + BMenos + OMenos + ABMenos);
        quantidadesPossiveisDoadores.put("AB-", AMenos + BMenos + OMenos + ABMenos);
        quantidadesPossiveisDoadores.put("O+", OMais + OMenos);
        quantidadesPossiveisDoadores.put("O-", OMenos);

        return quantidadesPossiveisDoadores;
    }

    private void quantidadePorTipoSanguineo(List<BancoDeSangue> candidatos){

        for (BancoDeSangue c: candidatos){
            int idade = calculaIdade(c.getData_nasc());

            if (idade >= 16 & idade <= 69 & c.getPeso() > 50) {
                quantidadesPorTipo.put(c.getTipo_sanguineo(), quantidadesPorTipo.get(c.getTipo_sanguineo()) + 1);
            }

        }
    }

    private void inicializarMap(){
        for (String s: tiposSanguineos){
            quantidadesPorTipo.put(s, 0);
            quantidadesPossiveisDoadores.put(s, 0);
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
