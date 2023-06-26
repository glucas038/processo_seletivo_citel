package com.citel.bancodesangue.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class BancoDeSangue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String nome;
    @Column(unique = true, nullable = false, name = "cpf")
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
    //@Email
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

    public BancoDeSangue(String nome, String cpf, String rg, String data_nasc, String sexo, String mae, String pai,
                         String email, String cep, String endereco, int numero, String bairro, String cidade,
                         String estado, String telefone_fixo, String celular, float altura,
                         float peso, String tipo_sanguineo) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.data_nasc = data_nasc;
        this.sexo = sexo;
        this.mae = mae;
        this.pai = pai;
        this.email = email;
        this.cep = cep;
        this.endereco = endereco;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.telefone_fixo = telefone_fixo;
        this.celular = celular;
        this.altura = altura;
        this.peso = peso;
        this.tipo_sanguineo = tipo_sanguineo;
    }
}
