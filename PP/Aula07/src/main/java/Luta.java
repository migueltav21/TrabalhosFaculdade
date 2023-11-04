
import java.util.Random;


public class Luta {
   private Lutador desafiado;
   private Lutador desafiante;
   private int rounds;
   private boolean aprovada;

    public Lutador getDesafiado() {
        return desafiado;
    }

    public void setDesafiado(Lutador desafiado) {
        this.desafiado = desafiado;
    }

    public Lutador getDesafiante() {
        return desafiante;
    }

    public void setDesafiante(Lutador desafiante) {
        this.desafiante = desafiante;
    }

    public int getRounds() {
        return rounds;
    }

    public void setRounds(int rounds) {
        this.rounds = rounds;
    }

    public boolean isAprovada() {
        return aprovada;
    }

    public void setAprovada(boolean aprovada) {
        this.aprovada = aprovada;
    }
   
   
   
   
   public void marcarLuta(Lutador l1, Lutador l2){
       if(l1.getCategoria().equals(l2.getCategoria()) && !l1.getNome().equals(l2.getNome())){
           this.setAprovada(true);
           this.setDesafiado(l2);
           this.setDesafiante(l1);
           System.out.println("A luta foi marcada");
       }else{
           this.setAprovada(false);
           this.setDesafiado(null);
           this.setDesafiante(null);
       }
   }
   
   public void lutar(){
       if(this.aprovada == true){
           this.desafiado.apresentar();
           this.getDesafiante().apresentar();
           
           Random aleatorio = new Random();
           int vencedor = aleatorio.nextInt(3);
           switch(vencedor){
               case 0:
                    System.out.println("A luta ficou empatada!");
                    this.getDesafiado().empatarLuta();
                    this.getDesafiante().empatarLuta();
                   break;
               case 1:
                    System.out.println("Vitória do " + this.desafiado.getNome());
                    this.desafiado.ganharLuta();
                    this.desafiante.perderLuta();
                   break;
               case 2:
                       System.out.println("Vitória do " + this.desafiante.getNome());
                    this.desafiado.perderLuta();
                    this.desafiante.ganharLuta();
                   break;
           }
           
       }else{
           System.out.println("A luta não foi aprovada");
       }
   }
    
}
