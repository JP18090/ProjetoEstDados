package Projeto;
// Vitor Costa Lemos - RA: 10438932
// José Pedro Bitetti Tkatchuk - RA: 10427372

import java.io.*;
import java.util.*;

public class Programa {
    private static Pais[] paises = new Pais[100];
    private static int count = 0;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;
        String arquivo = "Netflix.txt"; 

        do {
            System.out.println("\nMenu Principal:");
            System.out.println("1. Carregar dados do arquivo");
            System.out.println("2. Exibir todos os registros em ordem alfabética de país");
            System.out.println("3. Exibir todos os registros em ordem decrescente de qtde. títulos");
            System.out.println("4. Consultar país por sigla");
            System.out.println("5. Estatísticas");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            if (opcao != 1 && (paises == null || count == 0)) {
                System.out.println("O arquivo ainda não foi carregado. Escolha a opção 1 primeiro.");
                continue;
            }
            
            switch (opcao) {
                case 1:
                    // Codado por JP
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
                    // Codado por Vitor
                    System.out.print("Digite a sigla do país: ");
                    String sigla = scanner.nextLine();
                    consultarPorSigla(sigla);
                    break;
                case 5:
                    // Codado por JP
                    exibirEstatisticas();
                    //Valor médio das tarifas 
                    //Valor medio de shows e filmes por pais 
                    //Quantidade total de títulos
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

    public static void exibirEmOrdemAlfabetica() {
        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - 1 - i; j++) {
                if (paises[j].pais.compareTo(paises[j + 1].pais) > 0) {
                    Pais temp = paises[j];
                    paises[j] = paises[j + 1];
                    paises[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < count; i++) {
            System.out.println(paises[i]);
        }
    }
    
    public static void exibirPorQtdeTitulos() {
        // Bubble Sort para ordenar o array 'paises' por qtdeTitulos (decrescente)
        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - 1 - i; j++) {
                if (paises[j].qtdeTitulos < paises[j + 1].qtdeTitulos) {
                    // Troca os elementos
                    Pais temp = paises[j];
                    paises[j] = paises[j + 1];
                    paises[j + 1] = temp;
                }
            }
        }
    
    
        System.out.println("Países ordenados por quantidade de títulos (ordem decrescente):");
        for (int i = 0; i < count; i++) {
            System.out.println(paises[i]);
        }
    }
    
    

    public static void consultarPorSigla(String sigla) {
        // Percorre todos os elementos do array de países, até o total carregado (count)
        for (int i = 0; i < count; i++) {
    
            // Verifica se a sigla do país na posição i é igual à sigla passada como argumento
            // equalsIgnoreCase ignora se está em maiúscula ou minúscula (por exemplo, "br" == "BR")
            if (paises[i].sigla.equalsIgnoreCase(sigla)) {
    
                // Se encontrar a sigla, imprime os dados do país (usa o método toString da classe Pais)
                System.out.println(paises[i]);
    
                // Sai do método após encontrar o país (não precisa continuar procurando)
                return;
            }
        }
    
        // Se o laço terminar sem encontrar nenhuma correspondência, mostra mensagem de erro
        System.out.println("País não encontrado.");
    }
    

    public static void exibirEstatisticas() {
        double somaTarifas = 0;
        int totalTitulos = 0;
        int totalShows = 0;
        int totalFilmes = 0;

        for (int i = 0; i < count; i++) {
            somaTarifas += (paises[i].tarifaBasica + paises[i].tarifaStandard + paises[i].tarifaPremium) / 3;
            totalTitulos += paises[i].qtdeTitulos;
            totalShows += paises[i].qtdeShows;
            totalFilmes += paises[i].qtdeFilmes;
        }

        double mediaTarifas = Math.round((somaTarifas / count) * 100.0) / 100.0;
        double mediaShows = Math.round(((double) totalShows / count) * 100.0) / 100.0;
        double mediaFilmes = Math.round(((double) totalFilmes / count) * 100.0) / 100.0;

        System.out.println("Estatísticas:");
        System.out.println("Valor médio das tarifas: " + mediaTarifas);
        System.out.println("Média de shows por país: " + mediaShows);
        System.out.println("Média de filmes por país: " + mediaFilmes);
        System.out.println("Quantidade total de títulos: " + totalTitulos);
    }
}
