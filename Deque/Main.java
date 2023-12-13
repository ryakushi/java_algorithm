import java.util.Scanner;

public class Main {

  static Node nil; //ダミーノード

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      init(); // 連結リストの初期化

      int Q = sc.nextInt(); //クエリの数
      for (int i = 0; i < Q; i++) {
        int queryType = sc.nextInt();
        if (queryType == 0) {
          String text = sc.next();
          Node v = new Node(text); // ノードを作成する
          pushHead(v);
        } else if (queryType == 1) {
          String text = sc.next();
          Node v = new Node(text); // ノードを作成する
          pushTail(v);
        } else if (queryType == 2) {
          System.out.println(popHead());
        } else if (queryType == 3) {
          System.out.println(popTail());
        }
      }
    }
  }

  // 双方向連結リストの初期化
  private static void init() {
    nil = new Node("");
    nil.next = nil; // 初期状態では nil の次が nil を指すように
    nil.prev = nil; // 初期状態では nil の前が nil を指すように
  }

  // 双方向連結リストへ先頭への要素の挿入
  private static void pushHead(Node v) {
    v.next = nil.next; // v の次を、元の先頭要素に
    v.prev = nil; // v の前を nil に
    nil.next = v; // nil の次を v に書き換える
    v.next.prev = v; // 元の先頭要素の前を v にする
  }

  // 双方向連結リストへ末尾への要素の挿入
  private static void pushTail(Node v) {
    v.next = nil; //vの次のポインタをnilに
    v.prev = nil.prev; //vの前の要素を元の末尾の要素に
    nil.prev = v; //nilの前をvに紐づけ
    v.prev.next = v; //元の末尾ノードの次をvに紐づける
  }

  // 双方向連結リストの先頭にある文字列を返し、その要素を削除する
  private static String popHead() {
    Node head = nil.next; //先頭のノードを取得
    if (head == nil) {
      return "Error";
    } else {
      String ret = head.data;
      nil.next = head.next; //nilの次を headの次に紐づける
      nil.next.prev = nil; // 新たな先頭の前を nil に
      head = null;
      return ret;
    }
  }

  // 双方向連結リストの末尾にある文字列を返し、その要素を削除する
  private static String popTail() {
    Node tail = nil.prev; // 末尾のノードを取得する
    if (tail == nil) {
      return "Error";
    } else {
      String ret = tail.data; // 末尾の文字列を返す
      nil.prev = tail.prev; // nil の前を、tail の前に
      nil.prev.next = nil; // 新たな末尾の次を nil に
      tail = null; //メモリを開放する
      return ret;
    }
  }
}
