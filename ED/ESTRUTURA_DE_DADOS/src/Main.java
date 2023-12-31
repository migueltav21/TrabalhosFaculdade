import java.util.Iterator;

import Exceptions.EmptyCollectionException;
import Heaps.ArrayHeap;
import Heaps.PriorityQueue;
import Trees.*;
import TreesAVL.LinkedBinarySearchTreeAVL;

public class Main {
    public static void main(String[] args) {
        // Crie uma instância da sua árvore binária de busca
        ArrayBinarySearchTree<Integer> binarySearchTree = new ArrayBinarySearchTree<>();
        LinkedBinarySearchTreeAVL<Integer> tree = new LinkedBinarySearchTreeAVL<>();

        // Adicione alguns elementos
        binarySearchTree.addElement(50);
        binarySearchTree.addElement(30);
        binarySearchTree.addElement(70);
        binarySearchTree.addElement(20);
        binarySearchTree.addElement(40);
        binarySearchTree.addElement(60);
        binarySearchTree.addElement(80);

        tree.addElement(20);
        tree.addElement(30);
        tree.addElement(40);
        tree.addElement(50);
        tree.addElement(60);
        tree.addElement(70);
        tree.addElement(80);

        // Imprima a árvore em ordem
        Iterator<Integer> inOrderIterator = binarySearchTree.iteratorInOrder();
        Iterator<Integer> iterator1 = tree.iteratorInOrder();

        // Use um loop para percorrer os elementos
        System.out.println("In-order traversal:");
        while (inOrderIterator.hasNext()) {
            Integer element = inOrderIterator.next();
            System.out.println(element);
        }

        System.out.println("In-order traversal:");
        while (iterator1.hasNext()) {
            Integer element = iterator1.next();
            System.out.println(element);
        }

        System.out.println("Pre-order traversal:");
        binarySearchTree.iteratorPreOrder().forEachRemaining(System.out::println);

        System.out.println("Pre-order traversal:");
        tree.iteratorPreOrder().forEachRemaining(System.out::println);

        System.out.println("Post-order traversal:");
        binarySearchTree.iteratorPostOrder().forEachRemaining(System.out::println);

        System.out.println("Post-order traversal:");
        tree.iteratorPostOrder().forEachRemaining(System.out::println);

        System.out.println("Level-order traversal:");
        binarySearchTree.iteratorLevelOrder().forEachRemaining(System.out::println);

        System.out.println("Level-order traversal:");
        tree.iteratorLevelOrder().forEachRemaining(System.out::println);

        System.out.println("Pre-order traversal:");
        tree.iteratorPreOrder().forEachRemaining(System.out::println);

        tree.removeElement(50);
        System.out.println("Pre-order traversal:");
        tree.iteratorPreOrder().forEachRemaining(System.out::println);

        // Teste os métodos findMin e findMax
        System.out.println("Min: " + tree.findMin());
        System.out.println("Max: " + tree.findMax());

        // Teste os métodos removeMin e removeMax
        System.out.println("Removing min: " + tree.removeMin());
        System.out.println("Removing max: " + tree.removeMax());

        // Imprima a árvore após remoções
        System.out.println("In-order traversal after removals:");
        tree.iteratorInOrder().forEachRemaining(System.out::println);

        // Teste o método removeAllOccurrences
        tree.addElement(30); // Adiciona um elemento repetido
        tree.addElement(30); // Adiciona outro elemento repetido
        System.out.println("In-order traversal after removals:");
        tree.iteratorInOrder().forEachRemaining(System.out::println);

        tree.removeAllOccurrences(30);
        System.out.println("After removal of all occurrences:");
        tree.iteratorInOrder().forEachRemaining(System.out::println);

        ArrayHeap<Integer> heap = new ArrayHeap<>();

        // Adiciona elementos à heap
        heap.addElement(5);
        heap.addElement(3);
        heap.addElement(8);
        heap.addElement(1);

        // Encontrar o menor elemento
        System.out.println("Min Element: " + heap.findMin());

        // Remove o menor elemento
        try {
            System.out.println("Removed Min Element: " + heap.removeMin());
        } catch (EmptyCollectionException e) {
            System.out.println("Heap is empty.");
        }

        // Cria uma PriorityQueue de Inteiros
        PriorityQueue<Integer> intPriorityQueue = new PriorityQueue<>();

        // Adiciona elementos à PriorityQueue
        intPriorityQueue.addElement(10, 2);
        intPriorityQueue.addElement(5, 1);
        intPriorityQueue.addElement(20, 3);

        // Remove e imprime os elementos da PriorityQueue
        while (!intPriorityQueue.isEmpty()) {
            System.out.println("Next Element: " + intPriorityQueue.removeNext());
        }

        // Cria uma PriorityQueue de Strings
        PriorityQueue<String> stringPriorityQueue = new PriorityQueue<>();

        // Adiciona elementos à PriorityQueue
        stringPriorityQueue.addElement("Apple", 3);
        stringPriorityQueue.addElement("Banana", 1);
        stringPriorityQueue.addElement("Orange", 2);

        // Remove e imprime os elementos da PriorityQueue
        while (!stringPriorityQueue.isEmpty()) {
            System.out.println("Next Element: " + stringPriorityQueue.removeNext());
        }
    }

}
