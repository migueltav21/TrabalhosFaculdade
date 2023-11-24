public class SortingandSearching {

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

    public static void main(String[] args) throws Exception {
        OrderedList<Carro> Carros = new OrderedList<>();

        Carro carro1 = new Carro("Gol", "Volkswagen", 2022);
        Carro carro2 = new Carro("Civic", "Honda", 2021);
        Carro carro3 = new Carro("Corolla", "Toyota", 2023);
        Carro carro4 = new Carro("Tt", "Audi", 2023);

        Carros.add(carro1);
        Carros.add(carro2);
        Carros.add(carro3);
        Carros.add(carro4);

        // Imprimir o conteúdo da instância de Array
        System.out.println(Carros.toString());
        Carro carroProcurado = new Carro("Civic", "Honda", 2021);
        boolean encontradoLinear = linearSearch(Carros, carroProcurado);
        boolean encontradoBinario = binarySearch(Carros, carroProcurado);
        System.out.println("Pesquisa Linear - Carro encontrado: " + encontradoLinear);
        System.out.println("Pesquisa Binaria - Carro encontrado: " + encontradoBinario);

        OrderedList<Integer> numeros = new OrderedList<>();
        numeros.add(1);
        numeros.add(4);
        numeros.add(2);
        numeros.add(9);
        numeros.add(10);
        System.out.println(numeros.toString());
        boolean encontrado = linearSearch(numeros, 1);
        boolean encontrado2 = binarySearch(numeros, 10);
        boolean encontrado3 = binarySearch(numeros, 11);
        System.out.println("Pesquisa Linear - Numero encontrado: " + encontrado);
        System.out.println("Pesquisa Binaria - Numero encontrado: " + encontrado2);
        System.out.println("Pesquisa Binaria - Numero encontrado: " + encontrado3);
    }
}
