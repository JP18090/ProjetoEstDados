package Projeto;
// Vitor Costa Lemos - RA: 10438932
// José Pedro Bitetti Tkatchuk - RA: 10427372

import java.io.*;
import java.util.*;
import java.util.Scanner;

public class Programa {
    private static Pais[] paises = new Pais[100];
    private static int count = 0;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;
        String arquivo = "Netflix.txt"; 

        do {
            System.out.println("Menu Principal:");
            System.out.println("1. Carregar dados do arquivo");
            System.out.println("2. Exibir todos os registros em ordem alfabética de país");
            System.out.println("3. Exibir todos os registros em ordem decrescente de qtde. títulos");
            System.out.println("4. Consultar país por sigla");
            System.out.println("5. Estatísticas");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    carregarDadosDoArquivo(arquivo);
                    break;
                case 2:
                    // Codado por JP
                    exibirEmOrdemAlfabetica();
                    break;
                case 3:
                    // Codado por Vitor
                    exibirPorQtdeTitulos();
                    break;
                case 4:
                    // Codado por JP
                    System.out.print("Digite a sigla do país: ");
                    String sigla = scanner.nextLine();
                    consultarPorSigla();
                    break;
                case 5:
                    // Codado por Vitor
                    exibirEstatisticas();
                    break;
                case 6:
                    System.out.println("Antes de sair fique com o nosso video sobre o codigo ");
                    System.out.println("Link do video:");
                    System.out.println("URL");
                    System.out.println("\n------Integrantes-------");
                    System.out.println("José Pedro Bitetti Tkatchuk - RA: 10427372");
                    System.out.println("Vitor Costa Lemos - RA: 10438932");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 6);

        scanner.close();
    }

    public static void carregarDadosDoArquivo(String ArqNetflix) {
        try (BufferedReader br = new BufferedReader(new FileReader(ArqNetflix))) {
            String linha;
            while ((linha = br.readLine()) != null && count < paises.length) {
                String[] dados = linha.split(",");
                String sigla = dados[0];
                String pais = dados[1];
                int qtdeTitulos = Integer.parseInt(dados[2]);
                int qtdeShows = Integer.parseInt(dados[3]);
                int qtdeFilmes = Integer.parseInt(dados[4]);
                double tarifaBasica = Double.parseDouble(dados[5]);
                double tarifaStandard = Double.parseDouble(dados[6]);
                double tarifaPremium = Double.parseDouble(dados[7]);

                paises[count++] = new Pais(sigla, pais, qtdeTitulos, qtdeShows, qtdeFilmes, tarifaBasica, tarifaStandard, tarifaPremium);
            }
            System.out.println("Dados carregados com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao carregar o arquivo: " + e.getMessage());
        }
    }

    public static void exibirEmOrdemAlfabetica(){

    }
    public static void exibirPorQtdeTitulos(){

    }
    public static void consultarPorSigla(){

    }
    public static void exibirEstatisticas(){

    }

}
