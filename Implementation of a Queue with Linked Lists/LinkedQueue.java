public class LinkedQueue<E> implements Queue<E> {
   // Attributes
   private Node<E> head;
   private Node<E> tail;
   private int size;

    public LinkedQueue(){
       head = null;
       tail = null;
       size = 0;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public int size() {
        return size;
    }

    public E front() {
        if (head == null) {
            return null;
        }
        return head.getInfo();
    }

    public void enqueue (E info) {
        Node<E> n = new Node<E>(info, null);
        if (isEmpty()) {
            size = 1;
            head = n;
            tail = n;
        }
        else {
            tail.setNext(n);
            tail = n;
            size++;
        }
    }

    public E dequeue(){
       if (isEmpty()) {
           return null;
       }
       E temp = head.getInfo();
       head = head.getNext();
       size--;
       if (isEmpty()) {
           tail = null;
       }
        return temp;
    }
    
    
    public static void main(String [] args)
    {
        
        LinkedQueue<Integer> q = new LinkedQueue<Integer>();   
        
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        
        System.out.println("Size: " + q.size()); 
        
        Integer e = q.front(); 
        System.out.println("Size: " + q.size()); 
        System.out.println(e); 
        
        e = q.dequeue();
        e = q.dequeue();
        System.out.println("Size: " + q.size()); 
        
        e = q.dequeue();
        e = q.dequeue();
        e = q.dequeue();
        System.out.println("Size: " + q.size() + " isEmpty: " + q.isEmpty()); 
        
        
    }
}
