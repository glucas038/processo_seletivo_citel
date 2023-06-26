package com.citel.bancodesangue.logic;

import com.citel.bancodesangue.entity.BancoDeSangue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class Respostas {

    private final Estados estados;
    private final ImcMedio imcMedio;
    private final MediaIdades mediaIdades;
    private final QuantidadeDoadores quantidadeDoadores;

    @Autowired
    public Respostas(Estados estados, ImcMedio imcMedio, MediaIdades mediaIdades, QuantidadeDoadores quantidadeDoadores) {
        this.estados = estados;
        this.imcMedio = imcMedio;
        this.mediaIdades = mediaIdades;
        this.quantidadeDoadores = quantidadeDoadores;
    }

    public Map<String, Integer> candidatosPorEstado(List<BancoDeSangue> candidatos) {
        Map<String, Integer> map = estados.contarQuantidadeCandidatosPorEstados(candidatos);
        Map<String, Integer> sortedMap = new TreeMap<>(map);
        return sortedMap;
    }

    public Map<String, Float> imcMedio(List<BancoDeSangue> candidatos) {
        Map<String, Float> map = imcMedio.calcularMediaImc(candidatos);
        Map<String, Float> sortedMap = new TreeMap<>(map);
        return sortedMap;
    }

    public Map<String, Float> percentualObesidadePorSexo(List<BancoDeSangue> candidatos) {
        imcMedio(candidatos);
        Map<String, Float> percentuais = new HashMap<>(Map.of(
                "Masculino", imcMedio.getPercentualHomens(),
                "Feminino", imcMedio.getPercentualMulheres()
        ));
        return percentuais;
    }

    public Map<String, Float> mediaIdadePorTipoSanguineo(List<BancoDeSangue> candidatos) {
        Map<String, Float> map = mediaIdades.calcularMedia(candidatos);
        Map<String, Float> sortedMap = new TreeMap<>(map);
        return sortedMap;
    }

    public Map<String, Integer> quantidadeDoadoresPorTipoSanguineo(List<BancoDeSangue> candidatos) {
        Map<String, Integer> map = quantidadeDoadores.quantidadeDePossiveisDoadoresPorReceptor(candidatos);
        Map<String, Integer> sortedMap = new TreeMap<>(map);
        return sortedMap;
    }

}
