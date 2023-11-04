package pp_fp07.publicSchool;

public class UnidadeCurricular {
    
    private String nome;
    private String sigla;
    private String nomeCurso;
    private String anoLectivo;
    private String semestre;

    public UnidadeCurricular(String nomeTmp, String siglaTmp, String nomeCursoTmp, String anoLectivoTmp, String semestreTmp) {
        nome = nomeTmp;
        sigla = siglaTmp;
        nomeCurso = nomeCursoTmp;
        anoLectivo = anoLectivoTmp;
        semestre = semestreTmp;
}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public String getAnoLectivo() {
        return anoLectivo;
    }

    public void setAnoLectivo(String anoLectivo) {
        this.anoLectivo = anoLectivo;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    @Override
    public String toString() {
        return "UnidadeCurricular: " + "nome=" + nome + "\n sigla=" + sigla + "\n nomeCurso=" + nomeCurso + "\n anoLectivo=" + anoLectivo + "\n semestre=" + semestre;
    }
    
    
}
