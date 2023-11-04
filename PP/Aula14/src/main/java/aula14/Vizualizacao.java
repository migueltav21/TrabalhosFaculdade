package aula14;


public class Vizualizacao {
    private Video video;
    private Gafanhoto pessoa;

    public Vizualizacao(Gafanhoto pessoa, Video video) {
        this.video = video;
        this.pessoa = pessoa;
        this.pessoa.setTotalAssistido(this.pessoa.getTotalAssistido() + 1);
        this.video.setViews(this.video.getViews() + 1);
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public Gafanhoto getPessoa() {
        return pessoa;
    }

    public void setPessoa(Gafanhoto pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public String toString() {
        return "Vizualizacao{" + "video=" + video + ", pessoa=" + pessoa + '}';
    }
    
     public void avaliar(){
         this.video.setAvaliacao(5);
     }
    
     public void avaliar(int nota){
         this.video.setAvaliacao(nota);
     }
     
     public void avaliar(float prc){
         this.video.setAvaliacao(prc / 10);
         
     }
    
}
