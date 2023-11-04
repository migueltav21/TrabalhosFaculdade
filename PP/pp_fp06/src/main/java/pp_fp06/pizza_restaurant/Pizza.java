package pp_fp06.pizza_restaurant;

import static pp_fp06.pizza_restaurant.enums.Enums.*;



public class Pizza {

    private int codgo;
    private String nome;
    private String Descricao;
    private float preco;
    private int numIngredientes;
    private Tamanho tamanho;
    private Ingrediente[] colecaoIng;

    public Pizza() {
        colecaoIng = new Ingrediente[5];
    }

    public int getCodgo() {
        return codgo;
    }

    public void setCodgo(int codgo) {
        this.codgo = codgo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getNumIngredientes() {
        return numIngredientes;
    }

    public void setNumIngredientes(int numIngredientes) {
        this.numIngredientes = numIngredientes;
    }

    public Ingrediente getColecaoIng(int i) {
        return this.colecaoIng[i];
    }

    public void setColecaoIng(Ingrediente[] colecaoIng) {
        this.colecaoIng = colecaoIng;
    }

    public Tamanho getTamanho() {
        return tamanho;
    }

    public void setTamanho(Tamanho tamanho) {
        this.tamanho = tamanho;
    }

    public void adicionarIng(Ingrediente ingrediente) {
        if (this.getNumIngredientes() == 5) {
            System.out.println("A pizza não pode ter mais ingredientes\nIngrediente não adicionado");
        } else {
            this.setNumIngredientes(this.getNumIngredientes() + 1);
            Ingrediente novosIng[] = new Ingrediente[this.getNumIngredientes()];
            for( int i= 0; i < this.colecaoIng.length; i++){
                novosIng[i] = this.colecaoIng[i];
            }
            novosIng[novosIng.length - 1] = ingrediente;
            this.setColecaoIng(novosIng);
               System.out.println("Ingrediente adicionado com sucesso");
            
        }
    }
    
    public void removerIng(Ingrediente ing){
        for(int i = 0; i<this.getNumIngredientes(); i++){
            if(ing.getCodigo() == this.getColecaoIng(i).getCodigo()){
                for(int j = i; j < this.getNumIngredientes() - 1; j++){
                    this.colecaoIng[j] = this.colecaoIng[j+1];
                }
                this.colecaoIng[this.getNumIngredientes() - 1] = null;
                this.setNumIngredientes(this.getNumIngredientes() - 1);
                System.out.println("Ingrediente removido com sucesso");
            }
            }
        }

    
    public void getInformacaoIngrediente(int idTemp) {
        int aux = 0;
        for (int i = 0; i < this.getNumIngredientes(); i++) {
            if (this.getColecaoIng(i).getCodigo() == idTemp) {
                System.out.println("----------------------------------------");
                System.out.println("Informaçao do Ingrediente:");
                System.out.println("----------------------------------------");
                System.out.printf("Nome: %s\n", this.getColecaoIng(i).getName());
                System.out.printf("Codigo: %s\n", this.getColecaoIng(i).getCodigo());
                OrigemIngrediente(this.getColecaoIng(i).getOrigem());
                System.out.println("Calorias: " + this.getColecaoIng(i).getCalorias());
                System.out.println("----------------------------------------");
                aux++;
            }
        }
        if (aux == 0){
            System.out.println("Ingrediente não encontrado!");
        }
    }

    void totalCal() {
        int total = 0;
        for (int i = 0; i < this.getNumIngredientes(); i++) {
            if (this.colecaoIng[i] != null) {
                total += this.getColecaoIng(i).getCalorias();
            }
        }
        System.out.println("A " + this.getNome() + " tem " + total + " calorias");
    }
}
