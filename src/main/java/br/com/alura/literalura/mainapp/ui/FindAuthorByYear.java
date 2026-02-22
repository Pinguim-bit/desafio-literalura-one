package br.com.alura.literalura.mainapp.ui;

import br.com.alura.literalura.models.Pessoa;
import br.com.alura.literalura.repository.PessoaRepository;

import java.util.List;
import java.util.Scanner;

public class FindAuthorByYear {
    private final PessoaRepository pessoaRepository;
    private final Scanner scanner = new Scanner(System.in);

    public FindAuthorByYear(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public void findByYear() {

        System.out.print("Digite o ano para consulta: ");
        int ano = 0;

        System.out.println("--------------Consulta via Banco de Dados--------------");

        while(true) {
            if(!scanner.hasNextInt()) {
                scanner.nextLine();
                System.out.print("Erro! Digite apenas números!\nTente Novamente: ");
                continue;
            }
            ano = scanner.nextInt();
            scanner.nextLine();
            break;
        }

        List<Pessoa> autores = pessoaRepository.finAllByYear(ano);
        if(autores.isEmpty()) {
            System.out.printf("Nenhum autor encontrado nesse ano indicado(%s)\n", ano);
            System.out.println("Pressione ENTER para voltar:");
            scanner.nextLine();
        }
        else {
            System.out.println("Lista de autores ainda vivos no ano de " + ano + "\n");
            autores.forEach(System.out::println);

            System.out.println("Pressione ENTER para voltar:");
            scanner.nextLine();
        }

    }
}
