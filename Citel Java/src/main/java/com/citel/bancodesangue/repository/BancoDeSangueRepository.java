package com.citel.bancodesangue.repository;

import com.citel.bancodesangue.entity.BancoDeSangue;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BancoDeSangueRepository extends JpaRepository<BancoDeSangue, Long>,
        JpaSpecificationExecutor<BancoDeSangue> {

    Optional<List<BancoDeSangue>> findByCpf(String cpf);

    Optional<BancoDeSangue> findOneByCpf(String cpf);

    boolean existsByCpf(String cpf);

    //boolean existsByCPF(String cpf);
}
