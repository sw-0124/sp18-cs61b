

public class LinkedListDeque <T>{

   class Node{
        private T item;
        private Node next;
        private Node pre;

        public Node(T item){
            this.item = item;
        }
    }
    private Node dummyHead;
    private Node rear;
    private int size;

    public LinkedListDeque(){
        dummyHead = new Node(null);
        rear = dummyHead;
        size = 0;
    }

    public void addFirst(T item){
        Node node = new Node(item);

        if(size == 0){
            dummyHead.next = node;
            node.pre = dummyHead;
            rear = node;
        }else {
            node.next = dummyHead.next;
            dummyHead.next.pre = node;
            node.pre = dummyHead;
            dummyHead.next = node;
        }

        size++;
    }

    public void addLast(T item){
        Node node = new Node(item);
        node.pre = rear;
        rear.next = node;
        rear = node;
        size++;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        Node p = dummyHead.next;
        while (p != null){
            System.out.print(p.item + " ");
            p = p.next;
        }
    }

    public T removeFirst(){
        if(!isEmpty()){
            Node node = dummyHead.next;
            dummyHead.next = dummyHead.next.next;
            size--;
            return node.item;
        }else {
            return null;
        }
    }

    public T removeLast(){
        if(!isEmpty()){
            Node node = rear;
            rear = rear.pre;
            rear.next = null;
            size--;
            return (T) node.item;
        }else {
            return null;
        }
    }

    public T get(int index){
        if(index >= size() || index < 0){
            return null;
        }else {

            Node p = dummyHead;
            while (index >= 0){
                p = p.next;
                index--;
            }
            return p.item;
        }
    }

    public T getRecursive(int index){
        if (index >= size) {
            return null;
        }
        return getRecursiveHelp(dummyHead.next, index);
    }

    private T getRecursiveHelp(Node start, int index) {
        if (index == 0) {
            return start.item;
        } else {
            return getRecursiveHelp(start.next, index - 1);
        }
    }

}
