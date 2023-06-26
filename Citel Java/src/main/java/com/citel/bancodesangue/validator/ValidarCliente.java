package com.citel.bancodesangue.validator;

import com.citel.bancodesangue.entity.BancoDeSangue;
import com.citel.bancodesangue.exception.DadosIncorretos;
import com.citel.bancodesangue.exception.DadosRepetidos;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

@Component
public class ValidarCliente {

    private final List<String> tiposSanguineos = Arrays.asList("A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-");

    private final List<String> listaEstados = Arrays.asList(
            "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO",
            "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI",
            "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"
    );

    public boolean validarEstado(String estado) {
        return listaEstados.contains(estado);
    }

    public boolean validarSangue(String sangue) {
        return tiposSanguineos.contains(sangue);
    }

    public List<BancoDeSangue> validarDadosCandidatos(List<BancoDeSangue> novosCandidatos,
                                                      List<BancoDeSangue> candidatosRegistrados) throws DadosIncorretos, DadosRepetidos {
        for (BancoDeSangue candidato : novosCandidatos) {
            if (existeCandidatoComCPF(candidato, candidatosRegistrados) || existeCandidatoComCPF(candidato, novosCandidatos)) {
                throw new DadosRepetidos();
            }

            if (!validarSexo(candidato) || !validarEstado(candidato) || !validarDataNascimento(candidato) || !validarSangue(candidato)) {

                throw new DadosIncorretos();
            }
        }
        return novosCandidatos;
    }

    private boolean existeCandidatoComCPF(BancoDeSangue candidato, List<BancoDeSangue> candidatos) {
        return candidatos.stream()
                .filter(existente -> !candidato.equals(existente))
                .anyMatch(existente -> candidato.getCpf().equals(existente.getCpf()));
    }

    private boolean validarSexo(BancoDeSangue candidato) {
        String sexo = candidato.getSexo();
        return (sexo.equals("Masculino") || sexo.equals("Feminino"));
    }

    private boolean validarEstado(BancoDeSangue candidato) {
        String estado = candidato.getEstado().toUpperCase();
        return validarEstado(estado);
    }

    private boolean validarDataNascimento(BancoDeSangue candidato) {
        String dataNascString = candidato.getData_nasc();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataNasc = LocalDate.parse(dataNascString, formatter);
        return dataNasc.isBefore(LocalDate.now());
    }

    private boolean validarSangue(BancoDeSangue candidato) {
        String tipoSanguineo = candidato.getTipo_sanguineo().toUpperCase();
        return validarSangue(tipoSanguineo);
    }
}
