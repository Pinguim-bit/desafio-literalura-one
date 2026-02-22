package br.com.alura.literalura.mainapp;

import br.com.alura.literalura.mainapp.ui.UserInterface;
import br.com.alura.literalura.repository.LivroRepository;

public class MainApp {
    private final LivroRepository livroRepository;

    public MainApp(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public void app() {
        UserInterface menu = new UserInterface(livroRepository);
        menu.menu();
    }
}
