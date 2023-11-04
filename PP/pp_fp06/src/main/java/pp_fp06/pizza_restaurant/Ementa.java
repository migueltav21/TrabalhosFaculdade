package pp_fp06.pizza_restaurant;

import static pp_fp06.pizza_restaurant.enums.Enums.*;

public class Ementa {

    private String designacao;
    private String descricao;
    private int codigo;
    private String dataInicio;
    private String dataFim;
    private int numPizzas;
    private Pizza[] conjuntoPizzas;
    private boolean ativo;

    public Ementa() {
        this.setDataFim("Não definida");
        this.conjuntoPizzas = new Pizza[10];
        this.ativo = false;
    }

    public String getDesignacao() {
        return designacao;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public int getNumPizzas() {
        return numPizzas;
    }

    public void setNumPizzas(int numPizzas) {
        this.numPizzas = numPizzas;
    }

    public Pizza getConjuntoPizzas(int i) {
        return this.conjuntoPizzas[i];
    }

    public void setConjuntoPizzas(Pizza[] conjuntoPizzas) {
        this.conjuntoPizzas = conjuntoPizzas;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public void printEmenta() {
        if (this.ativo == false) {
            System.out.println("Ementa não disponivel");
        } else {
            System.out.println("Designação: " + this.getDesignacao());
            System.out.println("Descrição: " + this.getDescricao());
            System.out.println("Codigo de identificação: " + this.codigo);
            System.out.println("Data de inicio: " + this.getDataInicio());
            System.out.println("Data do fim: " + this.getDataFim());
            System.out.println("numero de pizzas disponíveis: " + this.getNumPizzas());
            System.out.println("------------");
            for (int i = 0; i < this.getNumPizzas(); i++) {
                System.out.println("Pizza " + (i + 1));
                System.out.println("Codigo: " + this.getConjuntoPizzas(i).getCodgo());
                System.out.println("Nome da pizza: " + this.getConjuntoPizzas(i).getNome());
                System.out.println("Descrição: " + this.getConjuntoPizzas(i).getDescricao());
                System.out.println("Preço: " + this.getConjuntoPizzas(i).getPreco());
                tamanhoPizza(this.getConjuntoPizzas(i).getTamanho());
                System.out.println("Numero de ingredientes: " + this.getConjuntoPizzas(i).getNumIngredientes());
                System.out.println("---Ingredientes:---");
                for (int j = 0; j < this.getConjuntoPizzas(i).getNumIngredientes(); j++) {
                    System.out.println("Codigo do ingrediente: " + this.getConjuntoPizzas(i).getColecaoIng(j).getCodigo());
                    System.out.println("Nome: " + this.getConjuntoPizzas(i).getColecaoIng(j).getName());
                    OrigemIngrediente(this.getConjuntoPizzas(i).getColecaoIng(j).getOrigem());
                    System.out.println("Calorias: " + this.getConjuntoPizzas(i).getColecaoIng(j).getCalorias());

                }
            }
        }
    }
}
