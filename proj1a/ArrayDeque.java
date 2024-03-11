public class ArrayDeque<T> {
//annotation
    private T[] arr;
    private int size;
    private int front;
    private int last;
    private int froSen;
    private int laSen;
    private T[] newArr;

    public ArrayDeque() {
        arr = (T[]) new Object[8];
        size = 0;
        front = 0;
        last = 7;
        froSen = 3;
        laSen = 4;
    }

    public void addFirst(T item) {
        if(front == froSen){
            bordenArr();
        }
        arr[front] = item;
        front++;
        size++;
    }

    private void bordenArr(){
        T[] newArr = (T[]) new Object[arr.length * 2];
        changeArr();
    }
    private void shrink(){
        T[] newArr = (T[]) new Object[arr.length / 2];
        changeArr();
    }
    private void changeArr(){
        if (front >= 0) System.arraycopy(arr, 0, newArr, 0, front);
        int index = newArr.length - 1;
        for (int i = arr.length - 1; i > last; i--) {
            newArr[index] = arr[i];
            index--;
        }
        last = index;
        laSen = newArr.length / 2;
        froSen = laSen - 1;
        arr = newArr;
    }
    public void addLast(T item) {
        if(last == laSen){
            bordenArr();
        }
        arr[last] = item;
        last--;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for (int i = 0; i < front; i++) {
            System.out.print(arr[i] + " ");
        }
        for (int i = last + 1; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public T removeFirst() {
        if(isEmpty()){
            return null;
        }
        if(arr.length * 0.25 > size && arr.length >= 16){
            shrink();
        }
        T val = arr[0];
        for (int i = 1; i < front; i++) {
            arr[i - 1] = arr[i];
        }
        front--;
        size--;
        return arr[0];
    }

    public T removeLast() {
        if(isEmpty()){
            return null;
        }
        if(arr.length * 0.25 > size && arr.length >= 16){
            shrink();
        }
        T val = arr[arr.length - 1];
        for (int i = last; i < arr.length - 1; i++) {
            arr[i + 1] = arr[i];
        }
        last++;
        size--;
        return val;
    }

    public T get(int index) {
        if(index < 0 || index >= arr.length){
            return null;
        }
        if(index >= front && index <= last){
            return null;
        }
        return arr[index];
    }

}
