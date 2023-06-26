package com.citel.bancodesangue.dtos;

import com.citel.bancodesangue.entity.BancoDeSangue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BancoDeSangueResponseDTOCompleto {

    private String nome;
    private String cpf;
    private String rg;
    private String data_nasc;
    private String sexo;
    private String mae;
    private String pai;
    private String email;
    private String cep;
    private String endereco;
    private int numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String telefone_fixo;
    private String celular;
    private float altura;
    private float peso;
    private String tipo_sanguineo;

    public static BancoDeSangueResponseDTOCompleto converterParaDTO(BancoDeSangue candidato) {
        return new BancoDeSangueResponseDTOCompleto(
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
        );
    }
}
