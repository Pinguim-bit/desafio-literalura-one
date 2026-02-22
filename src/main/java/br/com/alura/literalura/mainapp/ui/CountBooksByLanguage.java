package br.com.alura.literalura.mainapp.ui;

import br.com.alura.literalura.models.Livro;
import br.com.alura.literalura.repository.LivroRepository;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class CountBooksByLanguage {
    private final LivroRepository livroRepository;
    private final Scanner scanner = new Scanner(System.in);

    public CountBooksByLanguage(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public void run(String idioma) {
        System.out.println("--------------Consulta via Banco de Dados--------------");
        Long dados  = livroRepository.countByIdiomasContaining(idioma);

        if(dados == 0L){
            System.out.println("Nenhum livro encontrado!");
            System.out.print("Pressione ENTER para voltar:");
            scanner.nextLine();
        }
        else {

            System.out.printf("Foram encontrados %d Livros no idioma(ou sigla) '%s'\n", dados,
                    Objects.equals(idioma, "en") ? "Inglẽs" : (Objects.equals(idioma, "pt") ? "Português" : idioma)
            );

            System.out.print("Pressione ENTER para voltar:");
            scanner.nextLine();
        }
    }
}
