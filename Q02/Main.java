import java.util.ArrayList;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      // コンタクトの種類数を取得し、リストに格納
      int contactTypes = sc.nextInt();
      ArrayList<Integer> contacts = new ArrayList<>();
      for (int i = 0; i < contactTypes; i++) {
        contacts.add(sc.nextInt());
      }

      // クエリ数を取得し、クエリごとの操作を実行
      int queries = sc.nextInt();
      for (int i = 0; i < queries; i++) {
        int queryType = sc.nextInt();

        if (queryType == 0) {
          // Insert query: 指定された位置に要素を挿入
          int index = sc.nextInt();
          int value = sc.nextInt();
          contacts.add(index, value);
        } else if (queryType == 1) {
          // Erase query: 指定された位置の要素を削除
          int index = sc.nextInt();
          if (index >= 0 && index < contacts.size()) {
            contacts.remove(index);
          }
        } else {
          // Count query: 指定された値の出現回数を数える
          int valueToCount = sc.nextInt();
          int count = 0;
          for (Integer integer : contacts) {
            if (integer == valueToCount) {
              count++;
            }
          }

          System.out.println(count);
        }
      }
    }
  }
}
