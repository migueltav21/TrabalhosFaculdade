package Entidade;

public class Carro implements Comparable<Carro>{

    private static int id = 0;
    private Integer carId;
    private String matricula;
    private int numeroPortas;

    public Carro(String matricula, int numeroPortas) {
        this.matricula = matricula;
        this.numeroPortas = numeroPortas;
        this.carId = id++;
    }

    public Integer getCarId() {
        return carId;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getNumeroPortas() {
        return numeroPortas;
    }

    public void setNumeroPortas(int numeroPortas) {
        this.numeroPortas = numeroPortas;
    }

    @Override
    public int compareTo(Carro o) {
        return carId.compareTo(o.getCarId());
    }
}
