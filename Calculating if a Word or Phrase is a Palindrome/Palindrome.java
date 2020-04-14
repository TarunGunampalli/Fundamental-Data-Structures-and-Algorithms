import java.util.Scanner;

public class Palindrome{
    
    
    public static void main(String [] args)
    {
       LinkedStack stack = new LinkedStack();
       LinkedQueue queue = new LinkedQueue();
       Scanner scan = new Scanner(System.in);
       
       System.out.print("Enter a word: ");
       String input = scan.nextLine();
       
       char[] letters = input.toCharArray();
       boolean palindrome = true;
       for (char letter : letters) {
           stack.push(letter);
           queue.enqueue(letter);
       }
       
       for (int i = 0; i < letters.length; i++) {
           if (stack.pop() != queue.dequeue()) {
               palindrome = false;
           }
       }
       if (palindrome) {
           System.out.println(input + " is a palindrome.");
       }
       else {
           System.out.println(input + " is not a palindrome.");
       }
    }
}
