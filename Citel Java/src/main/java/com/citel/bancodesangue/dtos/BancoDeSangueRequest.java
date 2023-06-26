package com.citel.bancodesangue.dtos;

import com.citel.bancodesangue.entity.BancoDeSangue;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BancoDeSangueRequest {

    @NotEmpty
    private String nome;
    @Column(unique = true, nullable = false)
    @NotEmpty
    @CPF(message = "CPF inválido")
    private String cpf;
    @NotEmpty
    private String rg;
    @NotEmpty
    @JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    private String data_nasc;
    @NotEmpty
    private String sexo;
    @NotEmpty
    private String mae;
    @NotEmpty
    private String pai;
    @NotEmpty
    private String email;
    @NotEmpty
    private String cep;
    @NotEmpty
    private String endereco;
    @NotNull
    private int numero;
    @NotEmpty
    private String bairro;
    @NotEmpty
    private String cidade;
    @NotEmpty
    private String estado;
    @NotEmpty
    private String telefone_fixo;
    @NotEmpty
    private String celular;
    @NotNull
    private float altura;
    @NotNull
    private float peso;
    @NotEmpty
    private String tipo_sanguineo;

    public static List<BancoDeSangue> converterListaParaEntidade(List<BancoDeSangueRequest> candidatosDTO) {
        List<BancoDeSangue> listaCandidatos = new ArrayList<>();
        for (BancoDeSangueRequest candidato : candidatosDTO) {
            listaCandidatos.add(new BancoDeSangue(
                    candidato.getNome(),
                    candidato.getCpf(),
                    candidato.getRg(),
                    candidato.getData_nasc(),
                    candidato.getSexo(),
                    candidato.getMae(),
                    candidato.getPai(),
                    candidato.getEmail(),
                    candidato.getCep(),
                    candidato.getEndereco(),
                    candidato.getNumero(),
                    candidato.getBairro(),
                    candidato.getCidade(),
                    candidato.getEstado(),
                    candidato.getTelefone_fixo(),
                    candidato.getCelular(),
                    candidato.getAltura(),
                    candidato.getPeso(),
                    candidato.getTipo_sanguineo()
            ));
        }
        return listaCandidatos;
    }

    public static BancoDeSangue converterParaEntidade(BancoDeSangueRequest candidatoDTO) {
        return new BancoDeSangue(
                candidatoDTO.getNome(),
                candidatoDTO.getCpf(),
                candidatoDTO.getRg(),
                candidatoDTO.getData_nasc(),
                candidatoDTO.getSexo(),
                candidatoDTO.getMae(),
                candidatoDTO.getPai(),
                candidatoDTO.getEmail(),
                candidatoDTO.getCep(),
                candidatoDTO.getEndereco(),
                candidatoDTO.getNumero(),
                candidatoDTO.getBairro(),
                candidatoDTO.getCidade(),
                candidatoDTO.getEstado(),
                candidatoDTO.getTelefone_fixo(),
                candidatoDTO.getCelular(),
                candidatoDTO.getAltura(),
                candidatoDTO.getPeso(),
                candidatoDTO.getTipo_sanguineo()
        );
    }

}
