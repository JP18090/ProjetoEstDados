// Vitor Costa Lemos - RA: 10438932
// José Pedro Bitetti Tkatchuk - RA: 10427372


public class Pais {
        String sigla;
        String pais;
        int qtdeTitulos;
        int qtdeShows;
        int qtdeFilmes;
        double tarifaBasica;
        double tarifaStandard;
        double tarifaPremium;
    
        public Pais(String sigla, String pais, int qtdeTitulos, int qtdeShows, int qtdeFilmes,
                    double tarifaBasica, double tarifaStandard, double tarifaPremium) {
            this.sigla = sigla;
            this.pais = pais;
            this.qtdeTitulos = qtdeTitulos;
            this.qtdeShows = qtdeShows;
            this.qtdeFilmes = qtdeFilmes;
            this.tarifaBasica = tarifaBasica;
            this.tarifaStandard = tarifaStandard;
            this.tarifaPremium = tarifaPremium;
        }
    
        @Override
        public String toString() {
            return "Sigla: " + sigla + ", País: " + pais + ", Qtde Títulos: " + qtdeTitulos +
                   ", Qtde Shows: " + qtdeShows + ", Qtde Filmes: " + qtdeFilmes +
                   ", Tarifa Básica: " + tarifaBasica + ", Tarifa Standard: " + tarifaStandard +
                   ", Tarifa Premium: " + tarifaPremium;
        }
    }
