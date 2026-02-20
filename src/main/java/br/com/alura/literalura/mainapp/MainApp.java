package br.com.alura.literalura.mainapp;

import br.com.alura.literalura.models.Livro;
import br.com.alura.literalura.services.GetClassFromJson;
import br.com.alura.literalura.services.GetFromUrl;

public class MainApp {
    public static void app() {
        GetClassFromJson converter = new GetClassFromJson();

        //Área de Testes
        var json = GetFromUrl.url("https://gutendex.com/books?search=romeo%20and%20juliet");

        Livro livro = converter.data(json, Livro.class);
        //System.out.println(json);
        System.out.println("\n\n" + livro + "\n\n");
    }
}
