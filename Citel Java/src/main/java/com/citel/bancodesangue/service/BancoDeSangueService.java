package com.citel.bancodesangue.service;

import com.citel.bancodesangue.dtos.BancoDeSangueResponseDTO;
import com.citel.bancodesangue.entity.BancoDeSangue;
import com.citel.bancodesangue.exception.CandidatoNaoEncontrado;
import com.citel.bancodesangue.exception.DadosIncorretos;
import com.citel.bancodesangue.exception.DadosRepetidos;
import com.citel.bancodesangue.logic.Respostas;
import com.citel.bancodesangue.repository.BancoDeSangueRepository;
import com.citel.bancodesangue.validator.ValidarCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class BancoDeSangueService {

    private final BancoDeSangueRepository bancoDeSangueRepository;
    private final Respostas respostas;
    private final ValidarCliente validarCliente;

    @Autowired
    public BancoDeSangueService(BancoDeSangueRepository bancoDeSangueRepository, Respostas respostas, ValidarCliente validarCliente) {
        this.bancoDeSangueRepository = bancoDeSangueRepository;
        this.respostas = respostas;
        this.validarCliente = validarCliente;
    }

    public Optional<List<BancoDeSangue>> retornarTodosClientes() {
        return Optional.of(bancoDeSangueRepository.findAll());
    }

    public List<BancoDeSangue> criarVariosDoadores(List<BancoDeSangue> candidatos) throws DadosRepetidos, DadosIncorretos {
        List<BancoDeSangue> candidatosRegistrados = bancoDeSangueRepository.findAll();
        List<BancoDeSangue> candidatosValidados = validarCliente.validarDadosCandidatos(candidatos, candidatosRegistrados);

        return bancoDeSangueRepository.saveAll(candidatosValidados);
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

    public Optional<BancoDeSangue> retornarTodosDados(Long id) throws CandidatoNaoEncontrado {

        if (!bancoDeSangueRepository.existsById(id)){
            throw new CandidatoNaoEncontrado();
        }

        return bancoDeSangueRepository.findById(id);
    }
}
