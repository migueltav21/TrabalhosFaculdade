package pp_fp06.pizza_restaurant;

import pp_fp06.pizza_restaurant.enums.Enums.*;

public class Ingrediente {

    private int codigo;
    private String name;
    private float calorias;
    private Origem origem;

    public Ingrediente() {
        this.calorias = 0;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getCalorias() {
        return calorias;
    }

    public void setCalorias(float calorias) {
        this.calorias = calorias;
    }

    public Origem getOrigem() {
        return origem;
    }

    public void setOrigem(Origem origem) {
        this.origem = origem;
    }
    
    
    

}
