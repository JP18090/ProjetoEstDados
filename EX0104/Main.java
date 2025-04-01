
public class Main {
    public static void main(String[] args){
        Fila f1 = new Fila(5);
        f1.enqueue("Sandra");
        f1.enqueue("Sergio");
        f1.enqueue("Maria");
        f1.enqueue("Jorge");
        System.out.println("Quantidade de pessoas na fila: " + f1.size());
        System.out.println("Primeira pessoa da Fila: " + f1.front());
        System.out.println("Invetendo a Fila..");

        Pilha p1 = new Pilha(5);

        while (f1.size()!=0) {
            p1.push(f1.front());
            f1.dequeue();
        }
        while (p1.size()!=0) {
            f1.enqueue(p1.top());
            p1.pop();
        }
        
    }
}