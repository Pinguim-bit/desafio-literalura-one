package br.com.alura.literalura.mainapp.ui;

import br.com.alura.literalura.mainapp.links.GutendexApi;
import br.com.alura.literalura.models.Livro;
import br.com.alura.literalura.models.Pessoa;
import br.com.alura.literalura.repository.LivroRepository;
import br.com.alura.literalura.services.GetClassFromJson;
import br.com.alura.literalura.services.GetFromUrl;

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
            System.out.println("0 - Sair");
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
                    System.out.println("Opção 2 selecionada.");
                    break;

                case 3:
                    System.out.println("Opção 3 selecionada.");
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
