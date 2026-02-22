package br.com.alura.literalura.mainapp.ui;

import br.com.alura.literalura.models.Pessoa;
import br.com.alura.literalura.repository.PessoaRepository;

import java.util.List;
import java.util.Scanner;

public class ListAllAuthors {
    private final PessoaRepository repository;
    private final Scanner scanner = new Scanner(System.in);

    public ListAllAuthors(PessoaRepository repository) {
        this.repository = repository;
    }

    public void listAll(){
        List<Pessoa> autores = repository.findAll();

        if(autores.isEmpty()){
            System.out.println("Nenhum autor do histórico de consultas encontrado!");
            System.out.println("Faça consultas por livros no menu anterior\npara registrar autores desse livro!");
            System.out.println("Pressione enter para voltar...");
            scanner.nextLine();
        }
        else {
            System.out.println("--------------Consulta via Banco de Dados--------------");
            System.out.println("Autores de livros já consultados.\n");
            autores.forEach(a -> System.out.println(
                    "Nome: " + a.getNome() + "(Nascimento: " + a.getAnoNascimento() + "/Morte: " + a.getAnoMorte() + ")"
                    )
            );

            System.out.println("Pressione enter para voltar...");
            scanner.nextLine();
        }
    }
}
