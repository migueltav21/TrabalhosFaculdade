public class Counter {
    long count = 0;
    public void add(long value){
        this.count += value;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
