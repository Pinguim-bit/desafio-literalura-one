package br.com.alura.literalura.mainapp.ui;

import br.com.alura.literalura.repository.LivroRepository;

import java.util.Scanner;

public class ListAllBooksFromDB {
    private final LivroRepository repository;
    private final Scanner scanner = new Scanner(System.in);

    public ListAllBooksFromDB(LivroRepository repository) {
        this.repository = repository;
    }

    public void listAll() {
        var livro = repository.findAll();

        if(livro.isEmpty()) {
            System.out.println("Nenhu livro encontrado!");
            System.out.println("Pesquise livros na opção 'Buscar livro por título' no menu anterior\npara adicionar livros ao banco de dados.");
            System.out.println("\nPressione Enter para voltar....");
            scanner.nextLine();
        }
        else {

            System.out.println("--------------Consulta via Banco de Dados--------------");
            System.out.println("Listando todos os livros já consultados: ");

            //interface do Livro
            livro.forEach(l -> {
                System.out.println("\n-------------------------------");
                System.out.println("Nome: " + l.getTitulo());
                System.out.println("Sinopse: \n" + "\t" + l.getResumo());
                System.out.println((l.getAutores().size() > 1) ? "Autores: \n" + l.getAutores() : "Autor(a): \n" + l.getAutores());
                System.out.println((l.getIdiomas().size() > 1) ? "Idiomas: \n" + l.getIdiomas() : "Idioma: " + l.getIdiomas());
                System.out.println("Downloads: " + l.getContadorDownload());

            });

            System.out.println("\nPressione Enter para voltar....");
            scanner.nextLine();
        }
    }
}
