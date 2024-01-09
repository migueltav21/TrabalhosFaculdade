public class Task extends Thread {
    private String taskName;
    private String description;
    private int auxiliar;

    public Task(String taskName, String task) {
        this.taskName = taskName;
        this.description = task;
    }

    @Override
    public void run() {
        // Lógica da execução da tarefa
        System.out.println("Executando Task ");
        System.out.println("Nome: " + taskName);
        System.out.println("Descricao: " + description);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAuxiliar() {
        return auxiliar;
    }

    public void setAuxiliar(int auxiliar) {
        this.auxiliar = auxiliar;
    }

}
