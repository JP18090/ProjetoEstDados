public class Pilha extends vetor {

    int topo;
    public Pilha (int capacity){
    // Cria uma fila com uma capacidade inicial
        super(capacity);
        topo = -1;
    }
    public int size(){
    // Devolve o número de elementos da fila
        return size;
    }
    public void pop (String n) throws Exception{
    // Enfileira, caso a fila não esteja cheia, o elemento n
        topo--;   
        remove(topo);
    }
    public void push(String n) throws Exception{
    // Desenfileira, caso a fila não esteja vazia, o primeiro elemento
        topo++;  
        add(topo,n);
        
    }
    public String top() throws Exception{
    // Devolve, sem desenfileirar, o primeiro elemento da fila
        return get(topo);
    }

}