import Entidade.Carro;
import List.ArrayOrderesList;
import Pesquisas.SortingandSearching;

public class Main {
    public static void main(String[] args) {
        ArrayOrderesList<Carro> arrayOrderesList = new ArrayOrderesList<Carro>();

        Carro carro1 = new Carro("preto1", 3);
        Carro carro2 = new Carro("preto2", 2);
        Carro carro3 = new Carro("pret4", 5);
        Carro carro4 = new Carro("pret5", 6);

        arrayOrderesList.add(carro3);
        arrayOrderesList.add(carro2);
        arrayOrderesList.add(carro4);
        arrayOrderesList.add(carro1);

        Carro[] carros = new Carro[arrayOrderesList.size()];
        System.arraycopy(arrayOrderesList.getList(), 0, carros, 0, arrayOrderesList.getSize() - 1);

        System.out.println(SortingandSearching.linearSearch(carros, 0, carros.length - 1, carro2));

    }
}