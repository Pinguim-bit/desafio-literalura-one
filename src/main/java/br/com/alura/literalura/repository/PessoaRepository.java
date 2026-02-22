package br.com.alura.literalura.repository;

import br.com.alura.literalura.models.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    @Query("""
            SELECT p from Pessoa p
            WHERE (p.anoNascimento IS NULL OR p.anoNascimento <= :ano)
            AND (p.anoMorte IS NULL OR p.anoMorte >= :ano)
            """)
    List<Pessoa> finAllByYear(int ano);
}
