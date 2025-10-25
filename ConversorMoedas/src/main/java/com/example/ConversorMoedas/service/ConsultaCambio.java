package com.example.ConversorMoedas.service;

import com.example.ConversorMoedas.model.Conversao;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Properties;

public class ConsultaCambio {

    private static final String API_KEY = carregarChave();
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/";

    private static String carregarChave() {
        try (InputStream input = ConsultaCambio.class.getClassLoader().getResourceAsStream("application.properties")) {

            if (input == null) {
                System.out.println("ERRO FATAL: Arquivo 'application.properties' não encontrado na pasta 'resources'.");
                System.out.println("Certifique-se de que o arquivo existe e contém 'exchangerate.api.key=SUA_CHAVE'.");
                return null;
            }

            Properties prop = new Properties();
            prop.load(input);
            return prop.getProperty("exchangerate.api.key");

        } catch (IOException ex) {
            System.out.println("Erro ao ler o arquivo de propriedades: " + ex.getMessage());
            return null;
        }
    }


    public Conversao buscarTaxa(String moedaBase, String moedaAlvo) {
        if (API_KEY == null || API_KEY.isEmpty()) {
            System.out.println("ERRO: A chave da API não foi carregada. Verifique o arquivo de propriedades.");
            return null;
        }

        String endereco = BASE_URL + moedaBase + "/" + moedaAlvo;
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endereco))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();

            Gson gson = new Gson();
            return gson.fromJson(json, Conversao.class);

        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao consultar a API: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }


    }



