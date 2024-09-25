

public class LinkedQueue implements QueueTAD{
        private DoublyLinkedList lista;

        public LinkedQueue(){
                lista = new DoublyLinkedList();
        }
        /**
         * Adiciona um elemento no final da fila.
         * @param element
         */
        public void enqueue(int element){
                lista.add(element);
        }
    
        /**
         * Remove o elemento no início da fila e retorna ele.
         * @return O elemento que estava no início da fila.
         */
        public int dequeue(){
                int support = lista.getFirst();
                lista.removeByIndex(0);
                return support;
        }
    
        /**
         * @return O tamanho da fila.
         */
        public int size(){
                return lista.size();
        }
    
        /**
         * @return true se a fila estiver vazia, false caso contrário.
         */
        public boolean isEmpty(){
                return lista.isEmpty();
        }
    
        /**
         * Remove todos elementos da fila.
         */
        public void clear(){
                lista.clear();
        }
    
        /**
         * Retorna o elemento no início da fila, sem removê-lo.
         * @return O primeiro elemento da fila.
         */
        public int head(){
                return lista.getFirst();
        }
}