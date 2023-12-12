import java.util.Scanner;

/**
 * Main
 */
public class Main {

  static Node nil = new Node(""); // ダミーノード

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    nil.next = nil; //初期化時に自分自身を持たせる。
    int Q = sc.nextInt();

    for (int i = 0; i < Q; i++) {
      int queryType = sc.nextInt();
      String S = sc.next();
      if (queryType == 0) {
        Node v = new Node(S);
        insert(v);
      } else if (queryType == 1) {
        int k = Integer.parseInt(S);
        output(k);
      }
    }
    sc.close();
  }

  private static void output(int k) {
    Node v = nil.next;
    for (int i = 0; i < k && v != nil; i++) {
      System.out.print(v.data + " ");
      v = v.next;
    }
    System.out.println();
  }

  private static void insert(Node v) {
    v.next = nil.next; // vの次を現在の先頭に設定
    nil.next = v; // 先頭をvに更新
  }
}
