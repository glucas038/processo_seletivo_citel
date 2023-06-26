package com.citel.bancodesangue.dtos;

import com.citel.bancodesangue.entity.BancoDeSangue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class BancoDeSangueResponseDTO {

    private String nome;
    private String cpf;
    private String email;

    public static BancoDeSangueResponseDTO convertToDTO(BancoDeSangue candidato){
        return new BancoDeSangueResponseDTO(candidato.getNome(), candidato.getCpf(),candidato.getEmail());
    }

    public static List <BancoDeSangueResponseDTO> convertListToDTO(List<BancoDeSangue> listCandidatos){
        List<BancoDeSangueResponseDTO> listDTO = new ArrayList<>();
        for (BancoDeSangue candidatos: listCandidatos){
            listDTO.add(new BancoDeSangueResponseDTO(candidatos.getNome(), candidatos.getCpf(),candidatos.getEmail()));
        }

        Collections.sort(listDTO, Comparator.comparing(BancoDeSangueResponseDTO::getNome));

        return listDTO;
    }
}
