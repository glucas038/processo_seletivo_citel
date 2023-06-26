package com.citel.bancodesangue.controller;

import com.citel.bancodesangue.dtos.BancoDeSangueRequest;
import com.citel.bancodesangue.dtos.BancoDeSangueResponseDTO;
import com.citel.bancodesangue.dtos.BancoDeSangueResponseDTOCompleto;
import com.citel.bancodesangue.entity.BancoDeSangue;
import com.citel.bancodesangue.exception.CandidatoNaoEncontrado;
import com.citel.bancodesangue.exception.DadosIncorretos;
import com.citel.bancodesangue.exception.DadosRepetidos;
import com.citel.bancodesangue.service.BancoDeSangueService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@Validated
@RequestMapping("/api/v1/banco-de-sangue")
public class BancoDeSangueController {

    @Autowired
    private BancoDeSangueService bancoDeSangueService;

    @GetMapping("{cpf}")
    public ResponseEntity<BancoDeSangueResponseDTOCompleto> retornarTodosOsDados(@PathVariable String cpf) {
        try {
            return bancoDeSangueService.retornarTodosDados(cpf).map(bancoDeSangue ->
                    ResponseEntity.ok(BancoDeSangueResponseDTOCompleto.converterParaDTO(bancoDeSangue)))
                    .orElseGet(() -> ResponseEntity.notFound().build());
        } catch (CandidatoNaoEncontrado e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping
    public ResponseEntity<List<BancoDeSangueResponseDTO>> retornarTodosClientes() {
        List<BancoDeSangue> candidatos = bancoDeSangueService.retornarTodosClientes().orElse(List.of());
        List<BancoDeSangueResponseDTO> dtos = BancoDeSangueResponseDTO.convertListToDTO(candidatos);
        return ResponseEntity.ok(dtos);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<List<BancoDeSangueResponseDTO>> criarVariosDoadores(
            @RequestBody @Valid List<BancoDeSangueRequest> doadores)
            throws DadosRepetidos, DadosIncorretos {

        List<BancoDeSangue> listaDoadores = BancoDeSangueRequest.converterListaParaEntidade(doadores);
        return ResponseEntity.status(HttpStatus.CREATED).
                body(BancoDeSangueResponseDTO.convertListToDTO(bancoDeSangueService.criarVariosDoadores(listaDoadores)));
    }

    @GetMapping("/pergunta-1")
    public ResponseEntity<Map<String, Integer>> candidatosPorEstado() {
        return ResponseEntity.ok(bancoDeSangueService.candidatoPorEstado());
    }

    @GetMapping("/pergunta-2")
    public ResponseEntity<Map<String, Float>> imcMedio() {
        return ResponseEntity.ok(bancoDeSangueService.imcMedio());
    }

    @GetMapping("/pergunta-3")
    public ResponseEntity<Map<String, Float>> percentualObesidadePorSexo() {
        return ResponseEntity.ok(bancoDeSangueService.percentualObesoPorSexo());
    }

    @GetMapping("/pergunta-4")
    public ResponseEntity<Map<String, Float>> mediaIdadePorTipoSanguineo() {
        return ResponseEntity.ok(bancoDeSangueService.mediaIdadePorTipoSanguineo());
    }

    @GetMapping("/pergunta-5")
    public ResponseEntity<Map<String, Integer>> quantidadeDoadoresPorTipoSanguineo() {
        return ResponseEntity.ok(bancoDeSangueService.quantidadeDoadoresPorTipoSanguineo());
    }
}
