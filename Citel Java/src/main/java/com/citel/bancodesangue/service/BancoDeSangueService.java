package com.citel.bancodesangue.service;

import com.citel.bancodesangue.entity.BancoDeSangue;
import com.citel.bancodesangue.logic.Respostas;
import com.citel.bancodesangue.repository.BancoDeSangueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

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
}
