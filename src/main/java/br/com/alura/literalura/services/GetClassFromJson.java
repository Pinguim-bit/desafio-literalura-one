package br.com.alura.literalura.services;

import tools.jackson.core.JacksonException;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

public class GetClassFromJson {
    final ObjectMapper mapper = new ObjectMapper();

    public <T> T data(String json, Class<T> classe){
        try {
            JsonNode rootNode = mapper.readTree(json);
            JsonNode dataNode = rootNode.path("results").get(0);
            String results = String.valueOf(dataNode);
            //System.out.println(results);
            return mapper.readValue(results, classe);
        }  catch (JacksonException e) {
            throw new RuntimeException(e);
        }
    }
}
