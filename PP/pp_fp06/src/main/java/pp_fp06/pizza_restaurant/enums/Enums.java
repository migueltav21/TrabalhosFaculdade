package pp_fp06.pizza_restaurant.enums;

public class Enums {

    public enum Tamanho {
        PEQUENA, MEDIA, FAMILIAR
    }

    public enum Origem {
        ANIMAL, VEGETAL, MINERAL
    }

    public static String tamanhoPizza(Tamanho tamanho) {
        switch (tamanho) {
            case PEQUENA:
                return "Pizza de tamanho pequena";
            case MEDIA:
                return "Pizza de tamanho médio";
            default:
                return "Pizza de tamanho grande";
        }
    }

    public static String OrigemIngrediente(Origem origem) {
        switch (origem) {
            case ANIMAL:
                return "Ingrediente de origem animal";
            case VEGETAL:
                return "Ingrediente de origem vegetal";
            default:
                return "Ingrediente de origem mineral";
        }
    }

}
