package br.com.alura.literalura.models;

import br.com.alura.literalura.models.DTOs.PessoaDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name = "livros")
public class Livro {
    @Id
    private Long id;
    private String titulo;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "livro_id")
    private List<Pessoa> autores;

    @ElementCollection(fetch = FetchType.EAGER)
    @Column(columnDefinition = "TEXT")
    private List<String> resumo;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> idiomas;

    private Integer contadorDownload;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Pessoa> getAutores() {
        return autores;
    }

    public void setAutores(List<Pessoa> autores) {
        this.autores = autores;
    }

    public List<String> getResumo() {
        return resumo;
    }

    public void setResumo(List<String> resumo) {
        this.resumo = resumo;
    }

    public List<String> getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(List<String> idiomas) {
        this.idiomas = idiomas;
    }

    public Integer getContadorDownload() {
        return contadorDownload;
    }

    public void setContadorDownload(Integer contadorDownload) {
        this.contadorDownload = contadorDownload;
    }
}
