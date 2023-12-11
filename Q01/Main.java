import java.util.Scanner;
import java.util.Stack;

/**
 * Main
 *
 * スタック練習
 */
public class Main {

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int contactTypes = sc.nextInt();
      Stack<Integer> contactStack = new Stack<>();
      for (int i = 0; i < contactTypes; i++) {
        contactStack.push(sc.nextInt());
      }

      int queries = sc.nextInt();
      for (int i = 0; i < queries; i++) {
        int queryType = sc.nextInt();

        if (queryType == 0) {
          //push クエリ
          int degree = sc.nextInt();

          contactStack.push(degree);
        } else {
          // Pop クエリ
          if (!contactStack.isEmpty()) {
            System.out.println(contactStack.pop());
          } else {
            System.out.println("error");
          }
        }
      }
    }
  }
}
