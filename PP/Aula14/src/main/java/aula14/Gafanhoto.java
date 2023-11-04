package aula14;

public class Gafanhoto extends Pessoa{
    private String login;
    private int totalAssistido;

    public Gafanhoto(String login, int totalAssistido, String nome, int idade, String sexo, int experiencia) {
        super(nome, idade, sexo, experiencia);
        this.login = login;
        this.totalAssistido = totalAssistido;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getTotalAssistido() {
        return totalAssistido;
    }

    public void setTotalAssistido(int totalAssistido) {
        this.totalAssistido = totalAssistido;
    }

    @Override
    public String toString() {
        return super.toString() + " Gafanhoto{" + "login=" + login + ", totalAssistido=" + totalAssistido + '}';
    }
    
    
}
