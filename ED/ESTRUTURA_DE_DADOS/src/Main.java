import java.util.Iterator;

import Trees.*;

public class Main {
    public static void main(String[] args) {
        // Crie uma instância da sua árvore binária de busca
        ArrayBinarySearchTree<Integer> binarySearchTree = new ArrayBinarySearchTree<>();

        // Adicione alguns elementos
        binarySearchTree.addElement(50);
        binarySearchTree.addElement(30);
        binarySearchTree.addElement(70);
        binarySearchTree.addElement(20);
        binarySearchTree.addElement(40);
        binarySearchTree.addElement(60);
        binarySearchTree.addElement(80);

        // Imprima a árvore em ordem
        Iterator<Integer> inOrderIterator = binarySearchTree.iteratorInOrder();

        // Use um loop para percorrer os elementos
        System.out.println("In-order traversal:");
        while (inOrderIterator.hasNext()) {
            Integer element = inOrderIterator.next();
            System.out.println(element);
        }

        System.out.println("Pre-order traversal:");
        binarySearchTree.iteratorPreOrder().forEachRemaining(System.out::println);

        System.out.println("Post-order traversal:");
        binarySearchTree.iteratorPostOrder().forEachRemaining(System.out::println);

        System.out.println("Level-order traversal:");
        binarySearchTree.iteratorLevelOrder().forEachRemaining(System.out::println);


        // Teste os métodos findMin e findMax
        System.out.println("Min: " + binarySearchTree.findMin());
        System.out.println("Max: " + binarySearchTree.findMax());

        // Teste os métodos removeMin e removeMax
        System.out.println("Removing min: " + binarySearchTree.removeMin());
        System.out.println("Removing max: " + binarySearchTree.removeMax());

        // Imprima a árvore após remoções
        System.out.println("In-order traversal after removals:");
        binarySearchTree.iteratorInOrder().forEachRemaining(System.out::println);

        // Teste o método removeAllOccurrences
        binarySearchTree.addElement(30); // Adiciona um elemento repetido
        binarySearchTree.addElement(30); // Adiciona outro elemento repetido
        System.out.println("Before removal of all occurrences:");
        binarySearchTree.iteratorInOrder().forEachRemaining(System.out::println);

        binarySearchTree.removeAllOccurrences(30);
        System.out.println("After removal of all occurrences:");
        binarySearchTree.iteratorInOrder().forEachRemaining(System.out::println);
    }
}
