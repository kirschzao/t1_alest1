public class ArrayQueue implements QueueTAD {
    private int[] array;
    private int start;
    private int end;
    private int index;

    public ArrayQueue(){
        array = new int[8];
        start = 0;
        end = 0;
        index = 0;
    }

    /**
     * Adiciona um elemento no final da fila.
     * @param element
     */
    public void enqueue(int element) {
        if (index == array.length) {
            int[] temp = new int[array.length * 2];
            for (int i = 0; i < index; i++) {
                temp[i] = array[(start + i) % array.length];
            }
            array = temp;
            start = 0;
            end = index;
        }
        array[end] = element;
        end = (end + 1) % array.length;
        index++;
    }

    /**
     * Remove o elemento no início da fila e retorna ele.
     * @return O elemento que estava no início da fila.
     */
    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Fila cheia");
        }
        int element = array[start];
        start = (start + 1) % array.length;
        index--;
        return element;
    }

    /**
     * @return O tamanho da fila.
     */
    public int size() {
        return this.index;
    }

    /**
     * @return true se a fila estiver vazia, false caso contrário.
     */
    public boolean isEmpty() {
        return index == 0;
    }

    /**
     * Remove todos elementos da fila.
     */
    public void clear() {
        
    }

    /**
     * Retorna o elemento no início da fila, sem removê-lo.
     * @return O primeiro elemento da fila.
     */
    public int head() {
        return array[0];
    }

}
