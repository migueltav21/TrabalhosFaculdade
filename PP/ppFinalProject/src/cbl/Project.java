package cbl;
import cbl.participants.*;

public class Project {
    private String name;
    private Facilitator[] facilitadores;
    private Partner[] parceiros;
    private Student[] estudantes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public Facilitator[] getFacilitadores() {
        return facilitadores;
    }

    public void setFacilitadores(Facilitator[] facilitadores) {
        this.facilitadores = facilitadores;
    }

    public Partner[] getParceiros() {
        return parceiros;
    }

    public void setParceiros(Partner[] parceiros) {
        this.parceiros = parceiros;
    }

    public Student[] getEstudantes() {
        return estudantes;
    }

    public void setEstudantes(Student[] estudantes) {
        this.estudantes = estudantes;
    }
    
}
