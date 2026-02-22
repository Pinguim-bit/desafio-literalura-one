package br.com.alura.literalura.mainapp.ui;

import br.com.alura.literalura.mainapp.links.GutendexApi;
import br.com.alura.literalura.models.DTOs.LivroDto;
import br.com.alura.literalura.models.DTOs.PessoaDto;
import br.com.alura.literalura.models.Livro;
import br.com.alura.literalura.models.Pessoa;
import br.com.alura.literalura.repository.LivroRepository;
import br.com.alura.literalura.services.GetClassFromJson;
import br.com.alura.literalura.services.GetFromUrl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SearchOptionMenu {
    private static final Scanner scanner = new Scanner(System.in);
    private static final GetClassFromJson converter = new GetClassFromJson();
    private final LivroRepository livroRepository;

    public SearchOptionMenu(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public boolean search() {
        System.out.println("--------------Consulta via API ( Digite /S para voltar)--------------");
        System.out.print("Digite o nome do livro que deseja Buscar: ");
        String busca = scanner.nextLine();

        if(busca.equalsIgnoreCase("/S")) return false;

        System.out.println("Buscando...");
        String json = GetFromUrl.url(GutendexApi.buscaTitulo(busca));
        LivroDto livroApi = converter.data(json, LivroDto.class);

        //verifica se veio algo
        if(livroApi == null) {
            System.out.println("Nenhum livro encontrado");
            return true;
            //true para rodar o loop denovo em quem chama
        }

        //DTOs
        Livro livro = new Livro();
        Pessoa pessoa = new Pessoa();
        PessoaDto pessoaApi = livroApi.autores().get(0);

        livro.setId(livroApi.id());
        livro.setTitulo(livroApi.titulo());

        pessoa.setNome(pessoaApi.nome());
        pessoa.setAnoNascimento(pessoaApi.anoNascimento());
        pessoa.setAnoMorte(pessoaApi.anoMorte());

        List<Pessoa> autores = livroApi.autores().stream()
                .map(dto -> {
                    Pessoa p = new Pessoa();
                    p.setNome(dto.nome());
                    p.setAnoNascimento(dto.anoNascimento());
                    p.setAnoMorte(dto.anoMorte());
                    return p;
                })
                .collect(Collectors.toCollection(ArrayList::new));

        autores.add(pessoa);

        livro.setAutores(autores);
        livro.setResumo(livroApi.resumo());

        List<String> idiomas = new ArrayList<>(livroApi.idiomas());

        livro.setIdiomas(idiomas);
        livro.setContadorDownload(livroApi.contadorDownload());


        //salva a consulta no banco de dados
        livroRepository.save(livro);

        System.out.println("\n==============================");
        System.out.println("Livro: " + livro.getTitulo());
        System.out.println("Autor(a): \n" + livro.getAutores());
        System.out.println(
                (livro.getIdiomas().size() > 1)
                        ?
                        "Idiomas: \n" + livro.getIdiomas()
                        :
                        "Idioma: \n" + livro.getIdiomas()
        );
        System.out.println("Número de Downloads: " + livro.getContadorDownload());

        //Para sair ou permanecer no loop=================================================
        System.out.println("""
                                1) Pesquisar outro livro
                                2) Voltar
                                """);

        int opcaoSubmenu = 1;
        while(true) {
            if (!scanner.hasNextInt()) {
                System.out.print("Opção Inválida, Tente novamente!: ");
                scanner.nextLine(); //limpa o buffer
                continue; //pula para o topo do while
            }

            opcaoSubmenu = scanner.nextInt();
            scanner.nextLine();

            if(opcaoSubmenu == 1 || opcaoSubmenu == 2) break;
            //caso nem um nem outro
            System.out.print("Opção Inválida, Tente novamente!: ");
        }

        //retornar falso para quebrar o loop de quem está chamando
        if(opcaoSubmenu == 2) return false;

        //return true para continuar o loop de quem chamar em loop
        return true;
    }
}
