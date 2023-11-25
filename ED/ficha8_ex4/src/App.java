public class App {
        public static void main(String[] args) throws Exception {
                // --------------------------------------METODOS DE ORDENACAO---------------------------------------
                UnorderedList<Contact> lista = new UnorderedList<>();
                lista.addToFront(new Contact("Clark", "Kent", "610-555-7384"));
                lista.addToFront(new Contact("Bruce", "Wayne", "215-555-3827"));
                lista.addToFront(new Contact("Peter", "Parker", "733-555-2969"));
                lista.addToFront(new Contact("James", "Howlett", "663-555-3984"));
                lista.addToFront(new Contact("Steven", "Rogers", "464-555-3489"));
                lista.addToFront(new Contact("Carl", "Ayton", "298-213-6789"));
                lista.addToFront(new Contact("Matt", "Murdock", "243-555-2837"));
                lista.addToFront(new Contact("Ronaldo", "Cristiano", "213-866-3267"));

                UnorderedList<Integer> lista2 = new UnorderedList<>();
                lista2.addToFront(4);
                lista2.addToFront(1);
                lista2.addToFront(45);
                lista2.addToFront(25);
                lista2.addToFront(2);
                lista2.addToFront(11);
                lista2.addToFront(9);

                Carro carro1 = new Carro("Gol", "Volkswagen", 2022);
                Carro carro2 = new Carro("Civic", "Honda", 2021);
                Carro carro3 = new Carro("Corolla", "Toyota", 2023);
                Carro carro4 = new Carro("Tt", "Audi", 2023);

                OrderedList<Carro> Carros = new OrderedList<>();
                Carros.add(carro1);
                Carros.add(carro2);
                Carros.add(carro3);
                Carros.add(carro4);

                // ------------------------------------------------------------------------

                System.out.println(lista2.toString());
                SortingandSearching.mergeSort(lista2);
                System.out.println("-----------------------");
                System.out.println(lista2.toString());

                System.out.println(lista.toString());
                SortingandSearching.mergeSort(lista);
                System.out.println("-----------------------");
                System.out.println(lista.toString());

                // --------------------------------------METODOS DE PROCURA---------------------------------------
                System.out.println("-----------METODOS DE PROCURA------------");

                // Imprimir o conteúdo da instância de Array
                System.out.println(Carros.toString());
                Carro carroProcurado = new Carro("Civic", "Honda", 2021);
                boolean encontradoLinear = SortingandSearching.linearSearch(Carros,
                                carroProcurado);
                boolean encontradoBinario = SortingandSearching.binarySearch(Carros,
                                carroProcurado);
                System.out.println("Pesquisa Linear - Carro encontrado: " +
                                encontradoLinear);
                System.out.println("Pesquisa Binaria - Carro encontrado: " +
                                encontradoBinario);

                OrderedList<Integer> numeros = new OrderedList<>();
                numeros.add(1);
                numeros.add(4);
                numeros.add(2);
                numeros.add(9);
                numeros.add(10);
                System.out.println(numeros.toString());
                boolean encontrado = SortingandSearching.linearSearch(numeros, 1);
                boolean encontrado2 = SortingandSearching.binarySearch(numeros, 10);
                boolean encontrado3 = SortingandSearching.binarySearch(numeros, 11);
                System.out.println("Pesquisa Linear - Numero encontrado: " + encontrado);
                System.out.println("Pesquisa Binaria - Numero encontrado: " + encontrado2);
                System.out.println("Pesquisa Binaria - Numero encontrado: " + encontrado3);

        }
}
