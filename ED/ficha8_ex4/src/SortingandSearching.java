import java.util.Iterator;

import org.w3c.dom.Node;

public class SortingandSearching {
    /**
     * Sorts the specified array of integers using the selection
     * sort algorithm.
     *
     * @param data the array to be sorted
     */
    public static <T extends Comparable<? super T>> void selectionSort(List<T> list) {
        No<T> min, temp;

        for (No<T> current = list.getFront(); current.getProximo() != null; current = current.getProximo()) {
            min = current;

            for (No<T> scan = current.getProximo(); scan != null; scan = scan.getProximo()) {
                if (scan.getElemento().compareTo(min.getElemento()) < 0) {
                    min = scan;
                }
            }

            // Swap the values
            temp = new No<>(min.getElemento());
            min.setElemento(current.getElemento());
            current.setElemento(temp.getElemento());
        }
    }

    /**
     * Sorts the specified array of objects using an insertion
     * sort algorithm.
     *
     * @param data the array to be sorted
     */
    public static <T extends Comparable<? super T>> void insertionSort(List<T> list) {
        if (list == null || list.isEmpty() || list.size() == 1) {
            return; // Lista vazia ou com apenas um elemento já está ordenada
        }

        No<T> current = list.getFront().getProximo(); // Inicia do segundo elemento
        while (current != null) {
            T key = current.getElemento();
            No<T> position = current;

            // Shift de valores maiores para a direita
            while (position.getAnterior() != null && position.getAnterior().getElemento().compareTo(key) > 0) {
                position.setElemento(position.getAnterior().getElemento());
                position = position.getAnterior();
            }

            // Insere o valor na posição correta
            position.setElemento(key);

            current = current.getProximo();
        }
    }

    /**
     * Sorts the specified array of objects using a bubble sort
     * algorithm.
     *
     * @param data the array to be sorted
     */
    public static <T extends Comparable<? super T>> void bubbleSort(List<T> list) {
        if (list == null || list.isEmpty() || list.size() == 1) {
            return; // Lista vazia ou com apenas um elemento já está ordenada
        }

        No<T> end = list.getRear();
        boolean swapped;

        do {
            swapped = false;
            No<T> current = list.getFront();

            while (current != end) {
                No<T> next = current.getProximo();

                if (next != null && current.getElemento().compareTo(next.getElemento()) > 0) {
                    // Swap the values
                    T temp = current.getElemento();
                    current.setElemento(next.getElemento());
                    next.setElemento(temp);
                    swapped = true;
                }

                current = next;
            }

            // O próximo ciclo não precisa percorrer o último elemento
            end = current.getAnterior();
        } while (swapped);
    }

    /**
     * Sorts the specified array of objects using the quick sort
     * algorithm.
     *
     * @param data the array to be sorted
     * @param min  the integer representation of the minimum value
     * @param max  the integer representation of the maximum value
     */
    public static <T extends Comparable<? super T>> void quickSort(List<T> list) {
        No<T> head = list.getFront();
        No<T> tail = list.getRear();
        _quickSort(list, head, tail);
    }

    private static <T extends Comparable<? super T>> void _quickSort(List<T> list, No<T> head, No<T> tail) {
        if (head != null && tail != null && head != tail && head.getProximo() != tail) {
            No<T> pivot = partition(list, head, tail);
            _quickSort(list, head, pivot.getAnterior());
            _quickSort(list, pivot, tail);
        }
    }

    private static <T extends Comparable<? super T>> No<T> partition(List<T> list, No<T> head, No<T> tail) {
        T pivotValue = tail.getElemento();
        No<T> i = head.getAnterior();

        for (No<T> j = head; j != tail; j = j.getProximo()) {
            if (j.getElemento().compareTo(pivotValue) <= 0) {
                if (i == null) {
                    i = head;
                } else {
                    i = i.getProximo();
                }

                // Swap elements at i and j
                T temp = i.getElemento();
                i.setElemento(j.getElemento());
                j.setElemento(temp);
            }
        }

        if (i == null) {
            i = head;
        } else {
            i = i.getProximo();
        }

        T temp = i.getElemento();
        i.setElemento(tail.getElemento());
        tail.setElemento(temp);

        if (head.getElemento().compareTo(head.getProximo().getElemento()) > 0) {
            // Troca os elementos
            T firstElement = head.getElemento();
            head.setElemento(head.getProximo().getElemento());
            head.getProximo().setElemento(firstElement);
        }

        return i;
    }

    /**
     * Sorts the specified array of objects using the merge sort
     * algorithm.
     *
     * @param data the array to be sorted
     * @param min  the integer representation of the minimum value
     * @param max  the integer representation of the maximum value
     */
    public static <T extends Comparable<? super T>> void mergeSort(List<T> list) {
        No<T> front = list.getFront();
        No<T> rear = list.getRear();
        _mergeSort(list, front, rear);
    }
    
    private static <T extends Comparable<? super T>> void _mergeSort(List<T> list, No<T> front, No<T> rear) {
        if (front != null && rear != null && front != rear) {
            // Encontrar o ponto médio
            No<T> mid = findMidpoint(front, rear);
    
            // Aplicar mergeSort nas duas metades
            _mergeSort(list, front, mid);
            _mergeSort(list, mid.getProximo(), rear);
    
            // Mesclar as duas metades ordenadas
            merge(list, front, mid, rear);
        }
    }
    
    private static <T extends Comparable<? super T>> void merge(List<T> list, No<T> front, No<T> mid, No<T> rear) {
        // Cria listas temporárias para as duas metades
        UnorderedList<T> leftList = new UnorderedList<>();
        UnorderedList<T> rightList = new UnorderedList<>();
    
        // Preenche as listas temporárias
        No<T> current = front;
        while (current != mid.getProximo()) {
            leftList.addToRear(current.getElemento());
            current = current.getProximo();
        }
        while (current != rear.getProximo()) {
            rightList.addToRear(current.getElemento());
            current = current.getProximo();
        }
    
        // Combina as duas listas ordenadas
        No<T> leftCurrent = leftList.getFront();
        No<T> rightCurrent = rightList.getFront();
    
        while (leftCurrent != null && rightCurrent != null) {
            if (leftCurrent.getElemento().compareTo(rightCurrent.getElemento()) <= 0) {
                front.setElemento(leftCurrent.getElemento());
                leftCurrent = leftCurrent.getProximo();
            } else {
                front.setElemento(rightCurrent.getElemento());
                rightCurrent = rightCurrent.getProximo();
            }
            front = front.getProximo();
        }
    
        // Adiciona os elementos restantes, se houver, de ambas as listas
        while (leftCurrent != null) {
            front.setElemento(leftCurrent.getElemento());
            leftCurrent = leftCurrent.getProximo();
            front = front.getProximo();
        }
        while (rightCurrent != null) {
            front.setElemento(rightCurrent.getElemento());
            rightCurrent = rightCurrent.getProximo();
            front = front.getProximo();
        }
    }
    


    // --------------METODOS DE PESQUISA-----------------------

    /**
     * Searches the specified linked list of objects using a
     * linear search algorithm.
     *
     * @param list   the linked list to be searched
     * @param target the element being searched for
     * @return true if the desired element is found
     */
    public static <T extends Comparable<? super T>> boolean linearSearch(OrderedList<T> list, T target) {
        No<T> current = list.getFront();
        boolean found = false;

        while (current != null && !found) {
            if (current.getElemento().compareTo(target) == 0) {
                found = true;
            }
            current = current.getProximo();
        }
        return found;
    }

    public static <T extends Comparable<? super T>> boolean binarySearch(OrderedList<T> list, T target) {
        return binarySearch(list, list.getFront(), list.getRear(), target);
    }

    private static <T extends Comparable<? super T>> boolean binarySearch(OrderedList<T> list, No<T> min, No<T> max,
            T target) {
        boolean found = false;

        while (min != null && max != null && min != max) {
            No<T> midpoint = findMidpoint(min, max);

            int comparison = midpoint.getElemento().compareTo(target);
            if (comparison == 0) {
                found = true;
                break;
            } else if (comparison > 0) {
                max = midpoint.getAnterior();
            } else {
                min = midpoint.getProximo();
            }
        }

        if (min != null && min.getElemento().equals(target)) {
            found = true;
        }

        return found;
    }

    private static <T> No<T> findMidpoint(No<T> start, No<T> end) {
        No<T> slow = start;
        No<T> fast = start;
        while (fast != end && fast.getProximo() != null && fast.getProximo() != end) {
            slow = slow.getProximo();
            fast = fast.getProximo().getProximo();
        }
        return slow;
    }
}
