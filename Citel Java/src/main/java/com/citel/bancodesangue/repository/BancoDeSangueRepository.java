package com.citel.bancodesangue.repository;

import com.citel.bancodesangue.entity.BancoDeSangue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BancoDeSangueRepository extends JpaRepository<BancoDeSangue, Long> {

}
