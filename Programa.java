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
            scanner.nextLine(); // Limpar buffer de entrada

            switch (opcao) {
                case 1:
                    carregarDadosDoArquivo(arquivo);
                    break;
                case 2:
                    exibirEmOrdemAlfabetica();
                    break;
                case 3:
                    exibirPorQtdeTitulos();
                    break;
                case 4:
                    System.out.print("Digite a sigla do país: ");
                    String sigla = scanner.nextLine();
                    consultarPorSigla();
                    break;
                case 5:
                    exibirEstatisticas();
                    break;
                case 6:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 6);

        scanner.close();
    }

    public static void carregarDadosDoArquivo(String nomeArquivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
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
