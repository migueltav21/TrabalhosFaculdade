package pp_fp06.pizza_restaurant;

import pp_fp06.pizza_restaurant.enums.Enums.*;

public class PizzaDemo {

    public static void main(String[] args) {
        //Criação da ementa
        Ementa ementa1 = new Ementa();
        ementa1.setAtivo(true);
        ementa1.setDescricao("Pizaria do zé");
        ementa1.setDesignacao("Só pizza da boa");
        ementa1.setCodigo(111111);
        ementa1.setDataInicio("21-3-2023");
        ementa1.setNumPizzas(2);

        //Criaçaõ das pizzas
        Pizza pizza1 = new Pizza();
        Pizza pizza2 = new Pizza();
        pizza1.setCodgo(232332);
        pizza1.setNome("Pizza peperoni");
        pizza1.setDescricao("Pizza de calabresa tdtfyguk");
        pizza1.setPreco(10.6f);
        pizza1.setTamanho(Tamanho.FAMILIAR);
        pizza1.setNumIngredientes(3);

        pizza2.setCodgo(1212);
        pizza2.setNome("Pizza queijo e fiambre");
        pizza2.setDescricao("lyrtrdtghjk");
        pizza2.setPreco(8.8f);
        pizza2.setTamanho(Tamanho.PEQUENA);
        pizza2.setNumIngredientes(4);

        Pizza[] pizzas = {pizza1, pizza2};

        ementa1.setConjuntoPizzas(pizzas);

        //criação de ingredientes
        Ingrediente i1 = new Ingrediente();
        Ingrediente i2 = new Ingrediente();
        Ingrediente i3 = new Ingrediente();
        Ingrediente i4 = new Ingrediente();
        Ingrediente i5 = new Ingrediente();

        i5.setCalorias(10);
        i5.setCodigo(10101);
        i5.setName("ananas");
        i5.setOrigem(Origem.ANIMAL);

        i1.setCodigo(100);
        i2.setCodigo(200);
        i3.setCodigo(300);
        i4.setCodigo(400);
        i1.setName("Fiambre");
        i2.setName("Queijo");
        i3.setName("molho toamte");
        i4.setName("Peperoni");
        i1.setOrigem(Origem.ANIMAL);
        i2.setOrigem(Origem.MINERAL);
        i3.setOrigem(Origem.VEGETAL);
        i4.setOrigem(Origem.ANIMAL);
        i1.setCalorias(1000);
        i2.setCalorias(500);
        i3.setCalorias(200);
        i4.setCalorias(666);

        //criação de conjuntos de ingredientes
        Ingrediente[] a1 = {i1, i2, i3 };
        Ingrediente[] a2 = {i1, i2, i3, i4};
        
//As calorias dão 0 pq as pizzas estão sem ingredientes
        pizza1.totalCal();
        pizza2.totalCal();

        // Ingredientes adicionados às pizzas
        pizza1.setColecaoIng(a1);
        pizza2.setColecaoIng(a2);
        
        
        ementa1.printEmenta();
        
        //Adicionar só um ingrediente às pizzas
        pizza1.adicionarIng(i5);
        pizza2.adicionarIng(i5);
        ementa1.printEmenta();

        //Obter informação de um ingrediente atravéz do código
        pizza1.getInformacaoIngrediente(200);
        pizza2.getInformacaoIngrediente(300);
        pizza1.getInformacaoIngrediente(1212122);
        
        //Obter o total de calorias de uma pizza
        pizza1.totalCal();
        pizza2.totalCal();
        
        //Remover ingredientes de uma pizza
        pizza1.removerIng(i1);
        pizza2.removerIng(i2);
        pizza2.removerIng(i4);
        
        ementa1.printEmenta();
    }

}
