package br.com.alura.literalura.mainapp.ui;

import br.com.alura.literalura.models.Livro;
import br.com.alura.literalura.repository.LivroRepository;

import java.util.List;
import java.util.Scanner;

public class FindForLanguage {
    private final LivroRepository repository;
    private final Scanner  scanner = new Scanner(System.in);

    public FindForLanguage(LivroRepository repository) {
        this.repository = repository;
    }

    public void buscar(String idioma) {
        List<Livro> livros = repository.findAllByLanguage(idioma);
        if(livros.isEmpty()) {
            System.out.printf("Nenhu livro em '%s' encontrado!",  idioma);
            System.out.println("\nPressione Enter para voltar....");
            scanner.nextLine();
        }
        else {

            System.out.println("--------------Consulta via Banco de Dados--------------");
            System.out.println("Listando todos os livro pelo idioma selecionado: " + idioma + "\n\n");

            //interface do Livro
            livros.forEach(l -> {
                System.out.println("Livro: " + l.getTitulo() + " (" + l.getAutores().get(0).getNome() + ")" + l.getIdiomas());
            });

            System.out.println("\nPressione Enter para voltar....");
            scanner.nextLine();
        }
    }
}
