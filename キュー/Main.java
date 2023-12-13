import java.util.Scanner;

/**
 * キュー操作の演習
 */

public class Main {

  static Node nil; // 番兵を表すノード（ダミーノード）

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    init(); //連結リストの初期化

    int Q = sc.nextInt(); // クエリ数

    for (int i = 0; i < Q; i++) {
      int type = sc.nextInt(); // クエリの種類
      if (type == 0) {
        String S = sc.next(); // 挿入する文字列
        Node v = new Node(S);
        pushHead(v); // 先頭に要素を挿入
      } else {
        System.out.println(popTail());
      }
    }
    sc.close();
  }

  // 連結リストの初期化
  private static void init() {
    nil = new Node("");
    nil.next = nil; // 初期状態では nil の次が nil を指すように
    nil.prev = nil; // 初期状態では nil の前が nil を指すように
  }

  // 先頭に要素を挿入するメソッド
  private static void pushHead(Node v) {
    v.next = nil.next; // v の次を、元の先頭要素に
    v.prev = nil; // v の前を nil に
    nil.next = v; // nil の次を v に書き換える
    v.next.prev = v; // 元の先頭要素の前を v にする
  }

  private static String popTail() {
    Node tail = nil.prev; // 末尾のノードを取得する
    if (tail == nil) {
      return "Error"; // 双方向連結リストが空なら、Error を返す
    } else {
      String ret = tail.value; // 末尾の文字列を返す
      nil.prev = tail.prev; // nil の前を、tail の前に
      nil.prev.next = nil; // 新たな末尾の次を nil に
      tail = null; // メモリを開放する
      return ret;
    }
  }
}
