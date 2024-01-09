import java.util.concurrent.Semaphore;

public class Kernel {
    private MEM memory;
    private CPU cpu;
    private boolean isRunning;

    public Kernel(int memorySize) {
        this.memory = new MEM(memorySize);
        this.cpu = new CPU(memory);
        this.isRunning = false;
    }

    public void start() {
        if (!isRunning) {
            memory.start();
            cpu.start();
            isRunning = true;
            System.out.println("Kernel iniciado.");
        } else {
            System.out.println("O kernel já está em execução.");
        }
    }

    public void stop() {
        if (isRunning) {
            memory.interrupt();
            cpu.interrupt();
            try {
                memory.join();
                cpu.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            isRunning = false;
            System.out.println("Kernel encerrado.");
        } else {
            System.out.println("O kernel não está em execução.");
        }
    }

    public Task readMemory() {
        return memory.readMemory();
    }



    public MEM getMemory() {
        return memory;
    }

    public void setMemory(MEM memory) {
        this.memory = memory;
    }

    public CPU getCpu() {
        return cpu;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }
}
