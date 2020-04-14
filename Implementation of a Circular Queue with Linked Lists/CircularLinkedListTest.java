public class CircularLinkedListTest {

  public static void main(String args[]) {
        CircularLinkedList queue = new CircularLinkedList();
        for (int i = 0; i < 10; i++) {
            queue.insert(i);
        }
        System.out.println(queue.toString());
        for (int i = 0; i < 5; i++) {
            System.out.println(queue.extract());
        }
        System.out.println(queue.toString());
  }
}
