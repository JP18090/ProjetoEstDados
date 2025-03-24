package Projeto;
class Vetor {
    Pais[] A; // Criando uma lista do tipo Pais
    int capacity; // Capacidade do vetor - comprimento máximo
    int size; // Elementos no vetor - quantidade de elementos
    
    public Vetor(int capacity) {
        A = new Pais[capacity];    // Vetor de Pais com capacidade definida
        this.size = 0;
        this.capacity = capacity;
    }
    
    public boolean isEmpty() {
        // Verifica se o Vetor está vazio
        return size == 0;
    }

    public boolean isFull() {
        // Verifica se o Vetor está cheio
        return size == capacity;
    }
            
    public int size() {
        // Retorna a quantidade de elementos no Vetor
        return size;
    }
    
    public Pais get(int i) throws Exception {
        // Retorna o elemento da posição i
        if (i < 0 || i >= size)
            throw new Exception("Posição inválida!!");
        return A[i];
    }
    
    public void set(int i, Pais n) throws Exception {
        // Substitui o conteúdo da posição i por n
        if (i < 0 || i >= size)
            throw new Exception("Posição inválida!!");
        A[i] = n;
    }
    
    public void add(int i, Pais n) throws Exception {
        // Adiciona o elemento n na posição i
        if (isFull()) {
            throw new Exception("A lista está cheia!! Impossível inserir");
        }
        if (i < 0 || i > size) {
            throw new Exception("Posição inválida!!");
        }
        for (int p = size; p > i; p--) {
            A[p] = A[p - 1];
        }
        A[i] = n;
        size++;
    }
    
    public void remove(int i) throws Exception {
        // Remove o elemento da posição i
        if (isEmpty())
            throw new Exception("A lista está vazia!! Impossível remover");
        if (i < 0 || i > size - 1) {
            throw new Exception("Posição inválida!!");
        }
        for (int p = i; p <= size - 2; p++) {
            A[p] = A[p + 1];
        }
        size--;
    }
    
    public int search(String sigla) {
        // Busca a sigla do país na lista - retorna a posição ou -1, se não existir
        for (int i = 0; i < size; i++)
            if (A[i].sigla.equalsIgnoreCase(sigla))   // Comparando a sigla
                return i;
        return -1;  // Retorna -1 se não encontrar a sigla
    }
    
    public void show() {
        // Mostra todo o conteúdo da lista
        for (int i = 0; i < size; i++) {
            System.out.println(A[i]);
        }
        
        System.out.println("\nFim da lista!!");
    }
}
