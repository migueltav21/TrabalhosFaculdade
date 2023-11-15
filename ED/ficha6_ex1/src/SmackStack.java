public class SmackStack<T> extends Stack<T> implements SmackStackADT<T> {

    public SmackStack() {
        super();
    }

    public SmackStack(int n) {
        super(n);
    }

    @Override
    public T smack() {
        T elemento = super.getStack()[0];
        for (int i = 0; i < super.getTop() - 1; i++) {
            super.getStack()[i] = super.getStack()[i + 1];
        }
        super.setTop(super.getTop() - 1);
    return elemento;
    }

}
