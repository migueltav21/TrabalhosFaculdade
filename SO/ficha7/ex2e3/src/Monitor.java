public class Monitor {
    public synchronized void acordaTodas(){
        this.notifyAll();
    }

    public synchronized void espera(int i){
        try{
            this.wait(i * 1000);
        }catch(InterruptedException ie){}
    }
}
