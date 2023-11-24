public class App {
    public static void main(String[] args) throws Exception {
        LinkedList<Integer> lista = new LinkedList<>();
        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.add(4);

        System.out.println("Lista original:");
        lista.printList();

        System.out.println("\nLista impressa recursivamente:");
        lista.printListRecursiva();

        LinkedList<String> lista2 = new LinkedList<>();
        lista2.add("Miguel");
        lista2.add("Joao");
        lista2.add("Pedro");
        lista2.add("Francisco");

        lista2.printListRecursiva();

        lista.replace(2, 4);

        System.out.println("Lista apos substituicao:");
        lista.printList();


        LinkedList<String> lista3 = new LinkedList<>();
        lista3 = lista2.reversedList();
        System.out.println("Lista revertida:");
        lista3.printList();
    }
}
