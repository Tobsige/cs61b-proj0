public class LinkedListDeque<T> {
    private class Node{
        public T item;
        public Node prev;
        public Node next;
        public Node(T i, Node p, Node n){
            prev = p;
            item = i;
            next = n;
        }
    }

    public LinkedListDeque(){
        senLast.prev = senFront;
        senFront.next = senLast;
    }

    private Node senLast = new Node(null, null, null);
    private Node senFront = new Node(null, null, null);
    private int length = 0;

    public void addFirst(T item){
        Node p = senFront;
        p.next = new Node(item, p, p.next);
        length += 1;
    }

    public void addLast(T item){
        Node l = senLast;
        l.prev = new Node(item, l.prev, l);
        length += 1;
    }

    public int size(){
        return length;
    }

    public void printDeque(){
        Node p = senFront;
        while(p.next != senLast){
            System.out.print(p.next.item);
            System.out.print(' ');
            p = p.next;
        }
    }

    public T removeFirst(){
        Node f = senFront;
        if (f.next.item == null){
            return null;
        }
        else{
            T result = f.next.item;
            f.next = f.next.next;
            f.next.prev = f;
            length -= 1;
            return result;
        }
    }

    public T removeLast(){
        Node l = senLast;
        if (l.prev.item == null){
            return null;
        }
        else{
            T result = l.prev.item;
            l.prev = l.prev.prev;
            l.prev.next = l;
            length -= 1;
            return result;
        }
    }

    public T get(int index){
        int time = 0;
        Node p = senFront;
        if (length == 0 || index > (length - 1)){
            return null;
        }
        else {
            while(time != index){
                time += 1;
                p = p.next;
            }
            return p.next.item;
        }
    }

    public boolean isEmpty(){
        if (length == 0){
            return true;
        }
        else{
            return false;
        }
    }

    public T getRecursive(int index){
        Node p = senFront;
        if (index > length - 1){
            return null;
        }
        else if(index == 0){
            return p.next.item;
        }
        else {
            this.removeFirst();
            return this.getRecursive(index - 1);
        }
    }
}
