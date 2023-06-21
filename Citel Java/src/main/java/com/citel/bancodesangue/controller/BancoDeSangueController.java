package com.citel.bancodesangue.controller;

import com.citel.bancodesangue.entity.BancoDeSangue;
import com.citel.bancodesangue.service.BancoDeSangueService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/banco-de-sangue")
public class BancoDeSangueController {

    @Autowired
    private BancoDeSangueService bancoDeSangueService;

    @GetMapping
    public ResponseEntity<Optional<List<BancoDeSangue>>> retornarTodosDoadores(){

        return  ResponseEntity.status(HttpStatus.OK).body(bancoDeSangueService.retornarTodosClientes());

    }

    @PostMapping
    public ResponseEntity<List<BancoDeSangue>> criarVariosDoadores(@RequestBody @Valid List<BancoDeSangue> doadores){
        return ResponseEntity.status(HttpStatus.CREATED).body(bancoDeSangueService.criarVariosDoadores(doadores));
    }

    @GetMapping("/pergunta-1")
    public ResponseEntity<Map<String, Integer>> cadidatosPorEstado(){
        return ResponseEntity.status(HttpStatus.OK).body(bancoDeSangueService.candidatoPorEstado());
    }

}
