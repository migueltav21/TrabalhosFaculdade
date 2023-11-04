package ficha1_ex1;

public class Ficha1_ex1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Instanciação dos pares definindo o tipo das variáveis visto que 
        //a classe TwoTypePair é genérica
        TwoTypePair<String, Integer> par = new TwoTypePair<>("Miguel", 20);
        TwoTypePair<Integer, Integer> par2 = new TwoTypePair<>(10, 1000);
        TwoTypePair<Integer, Integer> par3 = new TwoTypePair<>(10, 1000);
        System.out.println(par.toString());
        System.out.println(par2.toString());

        // criamos uma varivel resposta coparando duas instancias
        boolean resposta = par.equals(par2);
        if (resposta == true) {
            System.out.println("O par 1 definido por " + par.toString()
                    + " e o par 2 definido por " + par2.toString() + " sao iguais");
        } else {
            System.out.println("O par 1 definido por " + par.toString()
                    + " e o par 2 definido por " + par2.toString() + " nao sao iguais");
        }

        String um = par.getFirst();
        System.out.println(um);
        int dois = par.getSecond();
        System.out.println(dois);

        //mudamos o valor das variáveis para ver o que acontece
        par.setFirst("Joao");
        par.setSecond(99);
        System.out.println(par.toString());
    }

}
