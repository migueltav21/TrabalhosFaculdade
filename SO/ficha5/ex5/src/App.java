public class App {
    public static void main(String[] args) throws Exception {
        int[] array = createRandomArray(100);
        int numThreads = 5;
        int numDeEspacosPorThread = array.length / numThreads;

        int[] arrayFinal = new int[numThreads];
        MaxValue[] threads = new MaxValue[numThreads];

        // criação das threads
        for (int i = 0; i < numThreads; i++) {
            threads[i] = new MaxValue(array, i * numDeEspacosPorThread, (i + 1) * numDeEspacosPorThread - 1);
            threads[i].start();
        }

        // Aguarda o término de todas as threads
        for (MaxValue thread : threads) {
            thread.join();
        }

        // Coleta os resultados
        for (int i = 0; i < numThreads; i++) {
            arrayFinal[i] = threads[i].getLocalMax();
        }

        MaxValue threadPrincipal = new MaxValue(arrayFinal, 0, numThreads - 1);
        threadPrincipal.start();
        
        System.out.println("Array com os maiores numeros:");
        for (int i = 0; i < 5; i++) {
            System.out.println(arrayFinal[i]);
        }

        for (int i = 0; i < array.length; i++) {
            if (i % 20 == 0) {
                System.out.println("-----------------------");
            }
            System.out.println(array[i]);
        }

        int maiorNumero = threadPrincipal.getLocalMax();
        System.out.println("Maior numero array: " + maiorNumero);
    }

    private static int[] createRandomArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = (int) (Math.random() * 1000); // Valores aleatórios até 1000
        }
        return array;
    }
}
