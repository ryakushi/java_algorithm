import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
      // 入力された要素数とリストの初期化
      int N = scanner.nextInt();
      ArrayList<Integer> numbers = new ArrayList<>();
      for (int i = 0; i < N; i++) {
        numbers.add(scanner.nextInt());
      }

      // クエリの数を取得し、各クエリを実行
      int Q = scanner.nextInt();
      for (int i = 0; i < Q; i++) {
        int queryType = scanner.nextInt();

        if (queryType == 0) {
          // reverse クエリ: リストを逆順にする
          Collections.reverse(numbers);
        } else if (queryType == 1) {
          // push クエリ: 要素をリストの末尾に追加
          int value = scanner.nextInt();
          numbers.add(value);
        } else {
          // pop クエリ: リストから末尾の要素を取り出し、削除
          if (!numbers.isEmpty()) {
            int removed = numbers.remove(numbers.size() - 1);
            System.out.println(removed);
          } else {
            // もしリストが空ならエラーを出力
            System.out.println("Error");
          }
        }
      }
    }
  }
}
