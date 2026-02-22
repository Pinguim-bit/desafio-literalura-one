package br.com.alura.literalura.mainapp;

import br.com.alura.literalura.mainapp.ui.UserInterface;
import br.com.alura.literalura.repository.LivroRepository;
import br.com.alura.literalura.repository.PessoaRepository;

public class MainApp {
    private final LivroRepository livroRepository;
    private final PessoaRepository pessoaRepository;

    public MainApp(LivroRepository livroRepository, PessoaRepository pessoaRepository) {
        this.livroRepository = livroRepository;
        this.pessoaRepository = pessoaRepository;
    }

    public void app() {
        UserInterface menu = new UserInterface(livroRepository, pessoaRepository);
        menu.menu();
    }
}
