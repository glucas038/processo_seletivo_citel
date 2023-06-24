package com.citel.bancodesangue.logic;

import com.citel.bancodesangue.entity.BancoDeSangue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class Respostas {

    @Autowired
    private Estados estados;

    @Autowired
    private ImcMedio imcMedio;

    @Autowired
    private MediaIdades mediaIdades;

    @Autowired
    private QuantidadeDoadores quantidadeDoadores;
    public Map<String, Integer> candidatosPorEstado(List<BancoDeSangue> candidatos){
        Map<String, Integer> quantidadeEstados = estados.getQuantidadePorEstados();

        for (BancoDeSangue c : candidatos){
            quantidadeEstados.put(c.getEstado(), quantidadeEstados.get(c.getEstado()) +1);
            //System.out.println(quantidadeEstados.get(c.getEstado()));
        }

        return quantidadeEstados;
    }

    public Map<String, Float> imcMedio(List<BancoDeSangue> candidatos){
        System.out.println(imcMedio.mediaDeImc(candidatos));
        return imcMedio.mediaDeImc(candidatos);
    }

    public Map<String, Float> percentualObesidadePorSexo(List<BancoDeSangue> candidatos){
        imcMedio(candidatos);
        Map<String, Float> percentuais = new HashMap<>(Map.of(
                "Masculino", imcMedio.getPercentualHomem(),
                "Feminino", imcMedio.getPercentualMulher()
        ));
        return percentuais;
    }

    public Map<String, Float> mediaIdadePorTipoSanguineo(List<BancoDeSangue> candidatos){
        return mediaIdades.calcularMedia(candidatos);
    }

    public Map<String, Integer> quantidadeDoadoresPorTipoSanguineo(List<BancoDeSangue> candidatos){
        return quantidadeDoadores.quantidadeDePossiveisDoadoresPorReceptor(candidatos);
    }

}
