package pt.ipp.estg.pp.aula08;

public class Livro implements Publicação {

    private String titulo;
    private String autor;
    private int totalPaginas;
    private int pagAutual;
    private boolean aberto;
    private Pessoa leitor;

    public Livro(String titulo, String autor, int totalPaginas, Pessoa leitor) {
        this.titulo = titulo;
        this.autor = autor;
        this.totalPaginas = totalPaginas;
        this.leitor = leitor;
        this.aberto = false;
        this.pagAutual = 0;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getTotalPaginas() {
        return totalPaginas;
    }

    public void setTotalPaginas(int totalPaginas) {
        if (totalPaginas > 0) {
            this.totalPaginas = totalPaginas;
        } else {
            this.totalPaginas = 0;
        }
    }

    public int getPagAutal() {
        return pagAutual;
    }

    public void setPagAtual(int pagAtual) {
        this.pagAutual = pagAtual;
    }

    public boolean isAberto() {
        return aberto;
    }

    public void setAberto(boolean aberto) {
        this.aberto = aberto;
    }

    public Pessoa getLeitor() {
        return leitor;
    }

    public void setLeitor(Pessoa leitor) {
        this.leitor = leitor;
    }

    public String detalhes() {
        return "Livro{\n" + "titulo=" + titulo + "\nautor=" + autor + "\ntotalPaginas=" + totalPaginas + "\npagAutual=" + pagAutual + "\naberto=" + aberto + "\nleitor=" + leitor.getNome() + "\n}";
    }

    @Override
    public void abrir() {
        this.setAberto(true);
    }

    @Override
    public void fechar() {
        this.setAberto(false);
    }

    @Override
    public void folhear(int p) {
        if (p > this.getTotalPaginas()) {
            this.setPagAtual(0);
        } else {
            this.setPagAtual(p);
        }
    }

    @Override
    public void avançarPag() {
        this.setPagAtual(this.getPagAutal() + 1);
    }

    @Override
    public void voltarPag() {
        this.setPagAtual(this.getPagAutal() - 1);
    }
}
