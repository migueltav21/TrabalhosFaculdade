public class Array<T> {
    private T[] array;
    private int rear;
    private int size;

    public Array(int tamanho) {
        array = (T[]) new Object[tamanho];
        rear = 0;
        size = 0;
    }

    private void expandCapacity() {
        T[] newArray = (T[]) new Object[size * 2];

        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }

        array = newArray;
    }

    public void add(T elemento) {
        if (size == array.length) {
            expandCapacity();
        }

        // Adiciona o novo elemento ao final do array
        array[rear] = elemento;

        // Atualiza os índices
        rear++;
        size++;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < size; i++) {
            result.append(array[i]);
            if (i < size - 1) {
                result.append("\n");
            }
        }
        return result.toString();
    }

    public T[] getArray() {
        return array;
    }

    public void setArray(T[] array) {
        this.array = array;
    }

    public int getRear() {
        return rear;
    }

    public void setRear(int rear) {
        this.rear = rear;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
