public class Main {
    public static void main(String[] args) {
        Array<Carro> arrayCarros = new Array<>(10);

        Carro carro1 = new Carro("Gol", "Volkswagen", 2022);
        Carro carro2 = new Carro("Civic", "Honda", 2021);
        Carro carro3 = new Carro("Corolla", "Toyota", 2023);
        Carro carro4 = new Carro("Tt", "Audi", 2023);

        arrayCarros.add(carro1);
        arrayCarros.add(carro2);
        arrayCarros.add(carro3);
        arrayCarros.add(carro4);

        // Imprimir o conteúdo da instância de Array
        System.out.println(arrayCarros.toString());
         Carro carroProcurado = new Carro("Civic", "Honda", 2021);

     /*   boolean encontradoLinear = SortingandSearching.linearSearch(arrayCarros.getArray(), 0, arrayCarros.getSize(), carroProcurado);
        System.out.println("Pesquisa Linear - Carro encontrado: " + encontradoLinear);

        Array<Integer> array = new Array<>(10);
        array.add(1);
        array.add(4);
        array.add(2);
        array.add(9);
        array.add(10);
        System.out.println(array.toString());
        boolean encontrado = SortingandSearching.linearSearch(array.getArray(), 0, array.getSize(), 1);
        System.out.println("Pesquisa Linear - Numero encontrado: " + encontrado);
 */

        Carro[] carro = new Carro[3];
        carro[0] = carro1;
        carro[1] = carro2;
        carro[2] = carro3;
        boolean encontrado_ = SortingandSearching.linearSearch(carro, 0, carro.length, carro1);
        System.out.println("Pesquisa Linear - Carro encontrado: " + encontrado_);


        
        Integer[] aaa = new Integer[3];
        aaa[0] = 1;
        aaa[1] = 2;
        aaa[2] = 3;
        boolean encontrad = SortingandSearching.linearSearch(aaa, 0, aaa.length, 1);
        System.out.println("Pesquisa Linear - Numero encontrado: " + encontrad);
    }
}