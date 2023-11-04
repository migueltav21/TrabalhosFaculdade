package cbl;

public class Edition {

    private String nome;
    private boolean ativo;
    private int[] projects;
    private static Edition[] editions = new Edition[10];
    private static int posArray = 0;

    public Edition(String nome, int[] projects) {
        this.nome = nome;
        this.ativo = false;
        this.projects = projects;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public int[] getProjects() {
        return projects;
    }

    public void setProjects(int[] projects) {
        this.projects = projects;
    }

    public static Edition[] getEditions() {
        return editions;
    }

    public static void setEditions(Edition[] editions) {
        Edition.editions = editions;
    }

    public static void add(Edition edition) {
        try {
            editions[posArray] = edition;
            posArray++;
        } catch (ArrayIndexOutOfBoundsException e) {
            Edition newArray[] = new Edition[editions.length + 10];
            System.arraycopy(editions, 0, newArray, 0, editions.length);
            newArray[posArray] = edition;
            Edition.setEditions(newArray);
        }
    }

    private static int findEditionIndex(Edition edition) {
        for (int i = 0; i < posArray; i++) {
            if (editions[i] == edition) {
                return i;
            }
        }
        return -1;
    }

    public static void remove(Edition edition) {
        try {
            int index = findEditionIndex(edition);
            if (index == -1) {
                System.out.println("A edição que deseja remover não existe.");
            } else {
                Edition[] newArray = new Edition[editions.length];
                System.arraycopy(editions, 0, newArray, 0, index);
                System.arraycopy(editions, index + 1, newArray, index, editions.length - index - 1);
                Edition.setEditions(newArray);
                posArray--;
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao remover a edição: " + e.getMessage());
        }
    }

    public static void printEdicoes() {
        for (int i = 0; i < posArray; i++) {
            System.out.println("Nome: " + editions[i].nome + " - Ativo:" + editions[i].ativo);
        }
    }

    public static Edition procurarEdicao(String nome) {
        for (int i = 0; i < posArray; i++) {
            if (editions[i].getNome().equals(nome)) {
                return editions[i];
            }
        }
        return null;
    }

    public static int encontrarEdicaoAtiva() {
        for (int i = 0; i < posArray; i++) {
            if (editions[i].ativo == true) {
                return i;
            }
        }
        return -1;
    }

    public static void ativar(Edition edition) {
        int index = findEditionIndex(edition);
        if (index == -1) {
            System.out.println("A edição que deseja ativar não existe.");
        } else {
            int num = encontrarEdicaoAtiva();
            if (num != -1) {
                editions[num].ativo = false;
            }
            editions[index].ativo = true;
        }
    }

    @Override
    public String toString() {
        return "Edition{" + "nome=" + nome + ", ativo=" + ativo + ", projects=" + projects + '}';
    }

    public static int numeroDeEdicoesCBL(){
        return posArray;
    } 
}
