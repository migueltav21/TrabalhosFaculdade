public class MaxValue extends Thread{
    private int[] array;
    private int startIndex;
    private int endIndex;
    private int localMax;

    public MaxValue(int[] array, int startIndex, int endIndex) {
        this.array = array;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.localMax = 0;
    }

    public void run() {
        for (int i = startIndex; i <= endIndex; i++) {
            if(array[i] > localMax){
                localMax = array[i];
            }
        }
    }

    public int getLocalMax() {
        return localMax;
    }

}
