package br.com.alura.literalura.mainapp.ui;

import br.com.alura.literalura.repository.LivroRepository;
import br.com.alura.literalura.services.GetClassFromJson;

import java.util.Scanner;

public class UserInterface {
    private static final GetClassFromJson converter = new GetClassFromJson();
    private final LivroRepository livroRepository;

    public UserInterface(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        while (opcao != 0) {

            System.out.println("\n==============================");
            System.out.println("     CATÁLOGO DE LIVROS");
            System.out.println("==============================");
            System.out.println("1 - Buscar livro por título");
            System.out.println("2 - Listar todos os livros");
            System.out.println("3 - Listar livros por idioma");
            System.out.println("4 - Listar autores");//
            System.out.println("5 - Listar autores vivos em determinado ano");//
            System.out.println("6 - Exibir a quantidade de livros em um determinado idioma");//
            System.out.println("0 - Sair");//
            System.out.print("Escolha uma opção: ");

            while (true) {
                if (scanner.hasNextInt()) {
                    opcao = scanner.nextInt();
                    scanner.nextLine(); // consumir quebra de linha
                    break;
                } else {
                    System.out.print("Opção inválida! Tente Novamente: ");
                    scanner.nextLine(); // limpar entrada inválida
                }
            }

            switch (opcao) {
                case 1:
                    SearchOptionMenu menu = new SearchOptionMenu(livroRepository);
                    while(true) {
                        boolean loop = menu.search();
                        if(!loop) break;
                    }
                    break;

                case 2:
                    ListAllBooksFromDB consultarLivros = new ListAllBooksFromDB(livroRepository);
                    consultarLivros.listAll();
                    break;

                case 3:
                    System.out.println("Digite a sigla do idioma(ex: en, pt ...): ");
                    String  sigla = scanner.nextLine();

                    FindForLanguage buscarIdioma = new FindForLanguage(livroRepository);
                    buscarIdioma.buscar(sigla);
                    break;

                case 0:
                    System.out.println("Encerrando o programa...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }
}
