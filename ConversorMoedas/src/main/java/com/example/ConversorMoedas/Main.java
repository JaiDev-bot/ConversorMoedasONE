package com.example.ConversorMoedas;

import com.example.ConversorMoedas.model.Conversao;
import com.example.ConversorMoedas.service.ConsultaCambio;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConsultaCambio consulta = new ConsultaCambio();

        int opcao = 0;

        String menu = """
                \n*************************************************
                BEM-VINDO(A) AO CONVERSOR DE MOEDAS!
                
                Escolha uma das opções de conversão:
                1. Dólar (USD) >> Real (BRL)
                2. Real (BRL) >> Dólar (USD)
                3. Euro (EUR) >> Real (BRL)
                4. Real (BRL) >> Euro (EUR)
                5. Peso Argentino (ARS) >> Real (BRL)
                6. Real (BRL) >> Peso Argentino (ARS)
                7. Sair
                *************************************************
                """;


        while (opcao != 7) {
            System.out.println(menu);

            try {
                System.out.print("Digite a opção desejada: ");
                opcao = scanner.nextInt();

                if (opcao == 7) {
                    System.out.println("Obrigado por usar o Conversor de Moedas. Até logo!");
                    break;
                }

                String moedaBase, moedaAlvo;
                switch (opcao) {
                    case 1:
                        moedaBase = "USD";
                        moedaAlvo = "BRL";
                        break;
                    case 2:
                        moedaBase = "BRL";
                        moedaAlvo = "USD";
                        break;
                    case 3:
                        moedaBase = "EUR";
                        moedaAlvo = "BRL";
                        break;
                    case 4:
                        moedaBase = "BRL";
                        moedaAlvo = "EUR";
                        break;
                    case 5:
                        moedaBase = "ARS";
                        moedaAlvo = "BRL";
                        break;
                    case 6:
                        moedaBase = "BRL";
                        moedaAlvo = "ARS";
                        break;
                    default:
                        System.out.println("Opção inválida. Por favor, tente novamente.");
                        continue; // Volta para o início do loop
                }

                System.out.print("Digite o valor a ser convertido: ");
                double valor = scanner.nextDouble();

                Conversao dados = consulta.buscarTaxa(moedaBase, moedaAlvo);

                if (dados != null) {
                    double taxa = dados.conversion_rate();
                    double resultado = valor * taxa;

                    System.out.println("\n--- RESULTADO DA CONVERSÃO ---");
                    System.out.printf("Taxa de Câmbio de 1 %s para %s: %.4f%n", moedaBase, moedaAlvo, taxa);
                    System.out.printf("O valor de %.2f %s corresponde a %.2f %s%n", valor, moedaBase, resultado, moedaAlvo);
                    System.out.println("-----------------------------\n");
                }


            } catch (InputMismatchException e) {
                System.out.println("\nERRO: Entrada inválida. Por favor, digite apenas números para a opção e o valor.");
                scanner.next();
                opcao = 0;
            }
        }


        scanner.close();
    }


    }