package br.com.alura.literalura.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Livro (
        Number id,
        @JsonProperty("title") String titulo,
        @JsonProperty("authors") List<Pessoa> autores,
        @JsonProperty("summaries") List<String> resumo,
        @JsonProperty("languages") List<String> idiomas,
        @JsonProperty("download_count") Number contadorDownloads
){}
