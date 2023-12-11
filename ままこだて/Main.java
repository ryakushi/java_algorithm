/**
 * ままこだて
 *
 */
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
    }
    int N = 1996;

    // 1からNまでの数を持つリストを作成
    LinkedList<Integer> contacts = new LinkedList<>();
    for (int i = 0; i < N; i++) {
      contacts.add(i + 1);
    }

    // リストが1つになるまで操作を繰り返す
    while (contacts.size() > 1) {
      contacts.poll(); // 先頭の要素を削除
      int temp = contacts.poll(); // 次の先頭の要素を取得して変数に格納
      contacts.add(temp); // 取得した要素を末尾に追加
    }
    System.out.println(contacts.poll()); // 最後に残った要素を出力
  }
}
