package br.com.alura.literalura.repository;

import br.com.alura.literalura.models.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    @Query("SELECT l FROM Livro l JOIN l.idiomas i WHERE LOWER(i) = LOWER(:idioma)")
    List<Livro> findAllByLanguage(String idioma);
}
