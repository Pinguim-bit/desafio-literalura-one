package br.com.alura.literalura.services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GetFromUrl {
    public static String url(String u){
        //foi preciso usar o followRedirects porque o gutendex estava dando status 301 (redirecionamento)
        HttpClient client = HttpClient.newBuilder()
                .followRedirects(HttpClient.Redirect.NORMAL)
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(u))
                .header("Accept", "application/json")
                .GET()
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            //System.out.println(response.statusCode());
            return response.body();
        }
        catch (IOException |  InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
