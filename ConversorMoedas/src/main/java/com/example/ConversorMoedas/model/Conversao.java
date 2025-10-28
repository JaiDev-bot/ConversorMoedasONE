package com.example.ConversorMoedas.model;

public record Conversao(String result,
                        String base_code,
                        String target_code,
                        double conversion_rate) {

}