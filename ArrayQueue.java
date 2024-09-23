

public class ArrayQueue implements QueueTAD {
    private int[] array = new int[8];
    private int index = 0;

    public ArrayQueue(){
        
    }

    /**
     * Adiciona um elemento no final da fila.
     * @param element
     */
    public void enqueue(int element){
        
        if(index + 1 < array.length){
            array[index] = element;
            System.out.println("Inserindo " + element + " no index " + index);
            
            index++;
        }else{
            int[] temp = new int[array.length*2];
            temp = array;
            temp[index] = element;
            System.out.println("Recriando temp array " + element + " no index " + index);   


            index++;
            array = temp;
        }
    }

    /**
     * Remove o elemento no início da fila e retorna ele.
     * @return O elemento que estava no início da fila.
     */
    public int dequeue() {
        return 0;
    }

    /**
     * @return O tamanho da fila.
     */
    public int size() {
        return 0;
    }

    /**
     * @return true se a fila estiver vazia, false caso contrário.
     */
    public boolean isEmpty() {
        return false;
    }

    /**
     * Remove todos elementos da fila.
     */
    public void clear() {}

    /**
     * Retorna o elemento no início da fila, sem removê-lo.
     * @return O primeiro elemento da fila.
     */
    public int head() {
        return 1;
    }

}
