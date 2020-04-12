public class PrintStack{

  /** Recursive algorithm to print a Stack */
  private static void print(LinkedStack<Integer> p)
  {
    LinkedStack<Integer> aux = new LinkedStack<Integer>();
    int current = 0;
    while (p.top() != null) {
        System.out.println(p.top());
        aux.push(p.pop());
    }
    while (aux.top() != null) {
        p.push(aux.pop());
    }
  } // print


  public static void main(String [] args)
  {
    LinkedStack<Integer> p = new LinkedStack<Integer>();

    p.push(1);
    p.push(2);
    p.push(3);
    p.push(4);
    p.push(5);

    System.out.println("Stacks elements:");
    print(p);

  } // main

    
}
