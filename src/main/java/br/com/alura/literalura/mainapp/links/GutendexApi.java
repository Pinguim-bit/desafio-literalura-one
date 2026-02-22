package br.com.alura.literalura.mainapp.links;

public class GutendexApi {
    private static final String API = "https://gutendex.com/books?search=";

    public static String buscaTitulo(String titulo){
        return API + titulo
                .trim()
                .toLowerCase()
                .replaceAll(" ", "%20");
    }
}
