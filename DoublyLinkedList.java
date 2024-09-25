public class DoublyLinkedList {

    private Node header;
    private Node trailer;
    private int count;

    private class Node {
        public Integer item;
        public Node previous;
        public Node next;

        public Node(Integer element) {
            this.item = element;
            this.previous = null;
            this.next = null;
        }

        public Node(Integer element, Node previous, Node next) {
            this.item = element;
            this.previous = previous;
            this.next = next;
        }
    }
    public DoublyLinkedList()
    {
        header = new Node(null);
        trailer = new Node(null);
        header.next = trailer;
        trailer.previous = header;
        count = 0;
    }
    
    
    public void add(int element) {
        Node newNode = new Node(element);

            newNode.previous = trailer.previous;
            newNode.next = trailer;
            newNode.previous.next = newNode;
            trailer.previous = newNode;
            count++;
    }

    
    public void add(int index, int element) {
        if(index < 0 || index > count){
            return ;
        }

        Node newNode = new Node(element);
        Node current = header;

        for(int i=0;i<index;i++){
            current = current.next;
        }
        current.next.previous = newNode;
        newNode.next = current.next;
        newNode.previous = current;
        current.next = newNode;
        count++;
    }

    
    public void addFirst(int e) {
        Node newNode = new Node(e);

        newNode.next = header.next;
        header.next.previous = newNode;
        header.next = newNode;
        newNode.previous = header;
        count++;
    }

    
    public int get(int index) {
        if(index < 0 || index > count){
            throw new IndexOutOfBoundsException("Erro: index inválido");
        }
        Node current = header.next;

        for(int i=0;i<index-1;i++){
            current = current.next;
        }
        return current.item;
    }

    
    public int getFirst() {
        Node current = header.next;
        return current.item;
    }

    
    public int getLast() {
        Node current = trailer.previous;
        return current.item;
    }

    
    public int set(int index, int element) {
        if(index < 0 || index > count-1){
            return -1;
        }

        Node current = header.next;
        for(int i=0;i<index;i++){
            current = current.next;
        }
        int temp = current.item;
        current.item = element;
        return temp;
    }

    
    public boolean remove(int element) {
        Node current = header.next;
        boolean removed = false;

        for(int i=0;i<count;i++){
            if(current.item == element){
                current.previous.next = current.next;
                current.next.previous = current.previous;
                count--;
                removed = true;

            }
            if(removed){
                return true;
            }
            current.previous = current;
            current = current.next;
        }
        return false;
    }

    
    public int removeByIndex(int index) {
        if (index < 0 || index >= count) {
            return -1;
        }

        Node current = header.next;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.previous.next = current.next;
        current.next.previous = current.previous;

        count--;
        return current.item;
    }


    
    public int removeFirst() {
        if(count < 1){
            throw new IndexOutOfBoundsException("Lista está vazia!");
        }
        Node current = header.next;

        header.next = current.next;
        current.next.previous = header;
        count--;
        return current.item;
    }

    
    public int removeLast() {
        if(count < 1){
            throw new IndexOutOfBoundsException("Lista está vazia!");
        }
        Node current = trailer.previous;

        current.previous.next = trailer;
        trailer.previous = current.previous;
        count--;
        return current.item;
    }

    
    public boolean isEmpty() {
        if(header.next == trailer && trailer.previous == header){
            return true;
        }
        return false;
    }

    
    public boolean contains(int element) {
        Node current = header.next;
        boolean contain = false;

        while(current != null){
            if(current.item == element){
                contain = true;
            }
            if(contain){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    
    public int indexOf(int element) {
        Node current = header.next;

        for(int i=0;i<count-1;i++){
            if(current.item == element){
                return i;
            }
            current = current.next;
        }
        return -1;
    }

    
    public int size() {
        return count;
    }

    
    public void clear() {
        header.next = trailer;
        trailer.previous = header;
        count = 0;
    }

    
    public String toString(){
        StringBuilder sb = new StringBuilder("[ ");
        Node current = header.next;

        while(current != trailer){
            sb.append(current.item).append(" ");
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

    
    public void reverse(){
        Node current = header.next;
        Node aux;

        for(int i=0;i<count;i++){
            aux = current.previous;
            current.previous = current.next;
            current.next = aux;

            current = current.previous;
        }

        aux = trailer.previous;
        trailer.previous = header.next;
        trailer.previous.next = trailer;
        header.next = aux;
        header.next.previous = header;
    }

    @Override
    public void bubbleSort(){
        Node current = header.next;

        for(int i=0;i<count;i++){
            boolean trocou = false;

            for(int j=0;j < count-1;j++){
                System.out.println(current.item);
                System.out.println(current.next.item);
                if(current.item > current.next.item){
                    Node next = current.next;
                    Node prev = current.previous;
                    Node nextNext = current.next.next;

                    current.previous.next = next;
                    current.next.previous = prev;
                    current.next.next = current;
                    if(nextNext != null) {
                        current.next = nextNext;
                    }
                    current.previous = next;
                    current.next.previous = current;

                    trocou = true;
                }
                System.out.println(trocou);
                current = current.next;
                //System.out.println(j);
                //System.out.println(count);
            }
            //System.out.println("o"+i);
            //System.out.println(count);
        }
    }

}
 {
    
}
