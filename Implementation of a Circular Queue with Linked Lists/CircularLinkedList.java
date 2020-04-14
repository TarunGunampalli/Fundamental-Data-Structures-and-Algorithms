public class CircularLinkedList {

  // in a circle there is no "first", so we change the name
  private Node position;
  
  private int size;

  // a list is always created in an empty state
  protected CircularLinkedList() {
    position = null;
    size = 0;
  }

  // if we need position in classes that extend this one
  protected Node getPosition() {
    return position; 
  }

  // simple and self-explained code. Worth to reuse it
  public boolean isEmpty() {
    return (size == 0); 
  }

  // we insert after position, just because we had
  // to decide where to insert, but no special reason
  public void insert(Object o) {
    Node n = new Node(o, null);
    if (isEmpty()) {
        position = n;
        position.setNext(position);
    }
    else {
        n.setNext(position.getNext());
        position.setNext(n);
        position = n;
    }
    size++;
  }

  public Object extract() {
    // look carefully which value is returned in each case
    //
    // 1 - if the list is empty, return null
    // 2 - if the list has only one value,
    // return the value and state that the list is empty
    // 3 - if the list has more than one value,
    // return the value that is next to 'position' and
    // the Node that contained the returned Object.
    //
    // Look that in the third case, instead of returning the value of
    // position, it is returned the next in the list. Why? Because it was
    // easier to implement, nothing else. (draw it for a better understanding)
    
    Object temp = null;
    
    if (isEmpty()) {
        return temp;
    }
    if (size == 1) {
        temp = position.getInfo();
        position = null;
        size--;
    }
    else {
        temp = position.getNext().getInfo();
        position.setNext(position.getNext().getNext());
        size--;
    }
    return temp;
  }

  public String toString() {
    String toReturn = "";
    for (Object element : toArray()) {
        toReturn += element.toString();
    }
    return toReturn;
  }

  public int size() {
    return size;
  }

  public Object[] toArray() {
    Object[] toReturn = new Object[size];
    int last = 0;
    Node init = position;
    do {
        position = position.getNext();
        toReturn[last++] = position.getInfo();
    } while (position != init);
    return toReturn;
  }

}
