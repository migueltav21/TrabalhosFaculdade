public class App {
    public static void main(String[] args) throws Exception {
        DoublyLinkedList<Integer> lista = new DoublyLinkedList<>();
        lista.adicionarFim(1);
        lista.adicionarFim(2);
        lista.adicionarFim(3);
        lista.adicionarFim(4);

        System.out.println("Lista impressa do inicio:");
        lista.printListForStart();

        System.out.println("\nLista impressa do fim:");
        lista.printListForEnd();

        System.out.println("Lista reversa:");
        lista.printReversedList();
    }
}
