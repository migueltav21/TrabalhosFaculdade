/**
 *
 * @author Rui Tavares
 */
public abstract class Stack<T> implements StackADT<T> {

    /**
     * constant to represent the default capacity of the array
     */
    private final int DEFAULT_CAPACITY = 30;
    /**
     * int that represents both the number of elements and the next available
     * position in the array
     */
    private int top;
    /**
     * array of generic elements to represent the stack
     */
    private T[] stack;

    /**
     * Creates an empty stack using the default capacity.
     */
    public Stack() {
        top = 0;
        stack = (T[]) (new Object[DEFAULT_CAPACITY]);
    }

    /**
     * Creates an empty stack using the specified capacity.
     *
     * @param initialCapacity represents the specified capacity
     */
    public Stack(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Initial capacity must be greater than 0");
        }
        stack = (T[]) new Object[initialCapacity];
        top = 0;

    }

    /**
     * Adds the specified element to the top of this stack, expanding the
     * capacity of the stack array if necessary.
     *
     * @param element generic element to be pushed onto stack
     */
    @Override
    public void push(T element) {
        if (top == stack.length) {
            expandCapacity();
        }
        stack[top] = element;
        top++;
    }

    private void expandCapacity() {
        T[] newStack = (T[]) (new Object[stack.length + 10]);
        for (int i = 0; i < stack.length; i++) {
            newStack[i] = stack[i];
        }
        stack = newStack;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            System.out.println("A lista esta vazia");
            return null;
        }
        top--;
        T result = stack[top];
        stack[top] = null;
        return result;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            System.out.println("A lista esta vazia");
            return null;
        }
        return stack[top - 1];
    }

    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    @Override
    public int size() {
        return top;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ArrayStack{capacidade=").append(stack.length).append(", stack=[");

        for (int i = top - 1; i >= 0; i--) {
            sb.append(stack[i]);
            if (i > 0) {
                sb.append(", ");
            }
        }

        sb.append("]}");

        return sb.toString();
    }

    protected int getTop() {
        return top;
    }

    public T[] getStack() {
        return stack;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public void setStack(T[] stack) {
        this.stack = stack;
    }

}
