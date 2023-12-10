public class App {
    public static void main(String[] args) {
        BinaryTreeOrderedList<Integer> orderedList = new BinaryTreeOrderedList<>();

        // Adiciona elementos à lista ordenada
        orderedList.add(5);
        orderedList.add(3);
        orderedList.add(7);
        orderedList.add(2);
        orderedList.add(4);
        orderedList.add(6);
        orderedList.add(8);

        // Exibe a lista ordenada
        System.out.println("Ordered List:");


        // Testa outros métodos, se necessário
        // ...

        // Testa a remoção de um elemento específico
        int elementToRemove = 3;
        System.out.println("\nRemoving element " + elementToRemove);
        orderedList.remove(elementToRemove);


        // Testa a obtenção do primeiro e último elemento
        System.out.println("\nFirst element: " + orderedList.first());
        System.out.println("Last element: " + orderedList.last());
    }
}
