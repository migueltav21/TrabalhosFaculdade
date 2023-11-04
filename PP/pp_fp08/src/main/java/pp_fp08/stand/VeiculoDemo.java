package pp_fp08.stand;

import pp_fp08.stand.Enums.*;

public class VeiculoDemo {

    public static void main(String[] args) {
        VehicleManagement stand = new VehicleManagement();
        Veiculo v1 = new Veiculo(111, "Mercedes", "a 180", "stembro de 2009", Origem.NACIONAL, 10000, Condicao.USADO, 15000);
        Automovel v2 = new Automovel(5, 222, "Seat", "Ibiza", "janeiro de 2006", Origem.NACIONAL, 50505000.23f, Condicao.USADO, 3500);
        Veiculo v5 = new Automovel(5, 222, "Seat", "Ibiza", "janeiro de 2006", Origem.NACIONAL, 50505000.23f, Condicao.NOVO, 3500);
        Veiculo v3 = new Motociclo(125, 100, 333, "Honda", "125", "fevereiro 2017", Origem.IMPORTADO, 20000, Condicao.NOVO, 8000);
        Veiculo v4 = new Pesado(6, 2000, Tipologia.TRUCK, true, 444, "Volvo", "csasa", "abril 2020", Origem.IMPORTADO, 80000, Condicao.NOVO, 23000);
        Veiculo v10 = new Pesado(6, 2000, Tipologia.TRUCK, false, 444, "Volvo", "csasa", "abril 2020", Origem.IMPORTADO, 80000, Condicao.NOVO, 23000);
        Veiculo v11 = new Pesado(6, 2000, Tipologia.TRUCK, false, 444, "Volvo", "csasa", "abril 2020", Origem.IMPORTADO, 80000, Condicao.USADO, 23000);

        v2.setNumPortas(4);
        
        System.out.println(v1.toString());
        System.out.println(v2.toString());
        System.out.println(v5.toString());
        System.out.println(v3.toString());
        System.out.println(v4.toString());
        System.out.println(v10.toString());
        System.out.println(v11.toString());
        
        System.out.println("---");
        stand.adicionarVeiculo(v2);
        System.out.println("---");
        stand.adicionarVeiculo(v3);
        System.out.println("---");
        stand.adicionarVeiculo(v4);
        System.out.println("---");
        stand.adicionarVeiculo(v5);
        System.out.println("---");
        System.out.println("----------STAND----------");
        stand.listarVeiculos();
        stand.verificar(2);
        stand.verificar(55);
        System.out.print(stand.quantidadeVeiculos());
        
        

    }

}
