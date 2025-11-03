# Conversor de Moedas (Java Console)
Este projeto é um conversor de moedas desenvolvido em Java, com interface de console, que obtém as taxas de câmbio em tempo real através da API ExchangeRate-API. O objetivo é proporcionar uma experiência prática na construção de aplicações que consomem serviços externos (APIs) e manipulam dados JSON.

# 🌟 Funcionalidades
Interação em console: Menu textual para fácil navegação e interação com o usuário.

Taxas dinâmicas: Utilização da ExchangeRate-API para obter taxas de câmbio precisas e atualizadas.

Conversões múltiplas: Oferece no mínimo 6 opções de conversão pré-definidas (BRL ↔ USD, BRL ↔ EUR, BRL ↔ ARS).

Tratamento de erros: Lógica básica para lidar com entradas inválidas do usuário e falhas na consulta à API.

![Demonstração do Sorteio](2025-08-20-20-35-41.gif)


# 🛠️ Tecnologias Utilizadas
Linguagem: Java (JDK 11+)

Gerenciador de dependências: Maven

Requisições HTTP: java.net.http.HttpClient (Cliente HTTP nativo do Java)

Manipulação de JSON: Gson (Biblioteca para serialização/desserialização de JSON)

API de câmbio: ExchangeRate-API
