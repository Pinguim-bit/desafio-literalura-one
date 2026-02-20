package br.com.alura.literalura.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Pessoa (
        @JsonProperty("name") String nome,
        @JsonProperty("birth_year") Number anoNascimento,
        @JsonProperty("death_year") Number anoMorte
){}
