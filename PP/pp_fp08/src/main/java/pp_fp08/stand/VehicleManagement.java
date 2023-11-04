package pp_fp08.stand;

import java.util.*;


public class VehicleManagement {

    private ArrayList<Veiculo> stand = new ArrayList<>();

    
    
    public ArrayList<Veiculo> getStand() {
        return stand;
    }

    public void setStand(ArrayList<Veiculo> stand) {
        this.stand = stand;
    }

    public void adicionarVeiculo(Veiculo veiculo) {
        int num, aux = 0;
        num = this.stand.size();
        for (Veiculo v : this.stand) {
            if (veiculo.getNumChassis() == ((Veiculo) v).getNumChassis()) {
                System.out.println("Não é possível adicionar esse veículo");
                aux++;
            }
        }
        if (aux == 0) {
            this.stand.add(veiculo);
            ((Veiculo) veiculo).setId(num);
            System.out.println("Automóvel adicionado");
        }
    }

    public void removerVeiculo(Veiculo veiculo) {
        this.stand.remove(veiculo);
    }

    public void listarVeiculos() {
        for (Veiculo veiculo : this.stand) {
            if (veiculo instanceof Automovel) {
                System.out.println(((Automovel) veiculo).toString());
            } else if (veiculo instanceof Motociclo) {
                System.out.println(((Motociclo) veiculo).toString());
            } else if (veiculo instanceof Pesado) {
                System.out.println(((Pesado) veiculo).toString());
            }
        }
    }

    public void verificar(int num) {
        int aux = 0;
        for (Veiculo v : this.stand) {
            if (num == ((Veiculo) v).getId()) {
                aux++;
                System.out.println("O automóvel está presente no stand");
                System.out.println("Carateristicas do veiculo:");
                if (((Veiculo) v) instanceof Automovel) {
                    System.out.println(((Automovel) v).toString());
                } else if (((Veiculo) v) instanceof Motociclo) {
                    System.out.println(((Motociclo) v).toString());
                } else if (((Veiculo) v) instanceof Pesado) {
                    System.out.println(((Pesado) v).toString());
                }
            }
        }
        if (aux == 0) {
            System.out.println("O veiculo não está presente no stand");
        }
    }

    public String quantidadeVeiculos() {
        int total = 0, automoveis = 0, pesados = 0, motociclos = 0;
        total = this.stand.size();
        for (Veiculo v : this.stand) {
            if (((Veiculo) v) instanceof Automovel) {
               automoveis++;
            } else if (((Veiculo) v) instanceof Motociclo) {
                motociclos++;
            } else if (((Veiculo) v) instanceof Pesado) {
             pesados++;
            }
        }
        return "No stand existem " + total + " veiculos\n"
                + automoveis + " automoveis, " + motociclos
                + " motociclos, " + pesados + " pesados\n";
    }

}
