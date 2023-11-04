public class Queue<T> implements QueueADT<T> {
    Stack<T> stackInput;
    Stack<T> stackOutput;
    int size;

    public Queue() {
        stackInput = new Stack<>();
        stackOutput = new Stack<>();
        size = 0;
    }

    @Override
    public void enqueue(T element) {
        stackInput.push(element);
        size++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("A queue está vazia.");
        }
        if (stackOutput.isEmpty()) {
            while (!stackInput.isEmpty()) {
                stackOutput.push(stackInput.pop());
            }
        }

        return stackOutput.pop();
    }

    @Override
    public T first() {
        if (isEmpty()) {
            throw new IllegalStateException("A queue está vazia.");
        }

        if (stackOutput.isEmpty()) {
            while (!stackInput.isEmpty()) {
                stackOutput.push(stackInput.pop());
            }
        }

        return stackOutput.peek();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        if (stackOutput.isEmpty()) {
            while (!stackInput.isEmpty()) {
                stackOutput.push(stackInput.pop());
            }
        }
        System.out.println("Queue:");
        return stackInput.toString() + " " + stackOutput.toString();
    }

}
