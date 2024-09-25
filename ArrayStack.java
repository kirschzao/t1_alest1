public class ArrayStack implements StackTAD {
    private int[] array;
    private int index;

    public ArrayStack(){
        array = new int[8];
        index = 0;
    }

        /**
         * Adiciona elemento no topo da pilha.
         * @param element
         */
        public void push(int element){
            if(index == array.length){
                int[] support = new int[array.length*2];
                for(int x = 0; x < index; x++ ){
                    support[x]= array[x];
                }
                array = support;
            }
           array[index] = element;
           index++;
        }
    
        /**
         * Remove o elemento do topo da pilha.
         * @return O elemento que se encontrava no topo da pilha.
         */
        public int pop(){
            int element = array[index-1];
            array[index-1] = 0;
            return element;
        }
    
        /**
         * @return O tamanho da pilha.
         */
        public int size(){
            return index;
        }
    
        /**
         * @return true se a pilha estiver vazia, false caso contrário.
         */
        public boolean isEmpty(){
            return index == 0;
        }
    
        /**
         * Remove todos elementos da pilha.
         */
        public void clear(){
            for(int x = 0; x < index; x++ ){
                array[x] = 0;
            }
            index = 0;
        }
    
        /**
         * Retorna o elemento do topo da pilha, sem removê-lo.
         * @return O elemento presente no topo da pilha.
         */
        public int top(){
            return array[index-1];
        }
}
    