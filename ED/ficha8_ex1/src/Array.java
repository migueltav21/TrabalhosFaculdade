public class Array<T> {
    private T[] array;
    private int rear;
    private int size;

    public Array(int tamanho) {
        array =(T[]) new Object[tamanho];
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
        if (!(elemento instanceof Comparable)) {
            throw new IllegalArgumentException("Element must implement Comparable");
        }

        if (size == array.length) {
            expandCapacity();
        }
        int index = 0;
        while (index < size && ((Comparable<T>) elemento).compareTo(array[index]) > 0) {
            index++;
        }

        // Deslocar os elementos à direita para abrir espaço para o novo elemento
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }

        // Inserir o novo elemento na posição correta
        array[index] = elemento;

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
