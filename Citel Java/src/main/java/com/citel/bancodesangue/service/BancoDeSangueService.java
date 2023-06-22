package com.citel.bancodesangue.service;

import com.citel.bancodesangue.entity.BancoDeSangue;
import com.citel.bancodesangue.logic.Respostas;
import com.citel.bancodesangue.repository.BancoDeSangueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class BancoDeSangueService {

    @Autowired
    private BancoDeSangueRepository bancoDeSangueRepository;

    @Autowired
    private Respostas respostas;

    public Optional<List<BancoDeSangue>> retornarTodosClientes() {
        return Optional.of(bancoDeSangueRepository.findAll());
    }

    public List<BancoDeSangue> criarVariosDoadores(List<BancoDeSangue> doadores) {
        return bancoDeSangueRepository.saveAll(doadores);
    }

    public BancoDeSangue criarDoador(BancoDeSangue doador) {
        return bancoDeSangueRepository.save(doador);
    }

    public Map<String, Integer> candidatoPorEstado(){
        return respostas.candidatosPorEstado(retornarTodosClientes().get());
    }

    public Map<String, Float> imcMedio(){
        return respostas.imcMedio(retornarTodosClientes().get());
    }

    public Map<String, Float> percentualObesoPorSexo(){
        return respostas.percentualObesidadePorSexo(retornarTodosClientes().get());
    }

    public Map<String, Float> mediaIdadePorTipoSanguineo(){
        return respostas.mediaIdadePorTipoSanguineo(retornarTodosClientes().get());
    }

    public Map<String, Integer> quantidadeDoadoresPorTipoSanguineo(){
        return respostas.quantidadeDoadoresPorTipoSanguineo(retornarTodosClientes().get());
    }

}
