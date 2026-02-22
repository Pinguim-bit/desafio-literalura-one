package br.com.alura.literalura.models.DTOs;

import br.com.alura.literalura.models.Pessoa;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.ManyToOne;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record LivroDto(
        Long id,
        @JsonProperty("title") String titulo,
        @JsonProperty("authors") List<PessoaDto> autores,
        @JsonProperty("summaries") List<String> resumo,
        @JsonProperty("languages") List<String> idiomas,
        @JsonProperty("download_count") Integer contadorDownload
) {
}
