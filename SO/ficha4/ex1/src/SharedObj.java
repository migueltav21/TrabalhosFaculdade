public class SharedObj {
    private int number;
    private String name;

    public synchronized String getName() {
        return name;
    }

    public synchronized int getNumber() {
        return number;
    }

    public synchronized void setName(String n) {
        name = n;
    }

    public synchronized void setNumber(int x) {
        number = x;
    }
}
