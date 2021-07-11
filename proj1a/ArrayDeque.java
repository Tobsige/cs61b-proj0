public class ArrayDeque<T> {
    private int length;
    private T[] items;
    private int max = 100;
    private T def;

    public ArrayDeque(){
        items = (T []) new Object[max];
        length = 0;
        def = items[0];
    }

    private void resize(){
        T[] a = (T []) new Object[max + 10];
        System.arraycopy(items, 0, a, 0, length);
        items = a;
        max += 10;
    }

    public void addFirst(T item){
        if (length + 1 > max){
            resize();
        }
        T[] a = (T []) new Object[max];
        a[0] = item;
        System.arraycopy(items, 0, a, 1, length);
        items = a;
        length += 1;
    }

    public void addLast(T item){
        if (length + 1 > max){
            resize();
        }
        items[length] = item;
        length += 1;
    }

    public boolean isEmpty(){
        if (length == 0){
            return true;
        }
        else{
            return false;
        }
    }

    public int size(){
        return length;
    }

    public void printDeque(){
        if (this.isEmpty()){
            return;
        }
        else{
            for(int i = 0; i < length; i++){
                System.out.print(items[i]);
            }
        }
    }

    public T removeFirst(){
        if (isEmpty()){
            return null;
        }
        else{
            T[] a = (T []) new Object[max];
            System.arraycopy(items, 1, a, 0, length - 1);
            T b = items[0];
            items = a;
            length -= 1;
            return b;
        }
    }

    public T removeLast(){
        if (isEmpty()){
            return null;
        }
        else{
            T a = items[length - 1];
            items[length - 1] = def;
            length -= 1;
            return a;
        }
    }

    public T get(int index){
        if (isEmpty() || index >= length){
            return null;
        }
        else{
            return items[index];
        }
    }

}
