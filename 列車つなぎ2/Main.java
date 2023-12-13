import java.util.Scanner;

/**
 * Main
 */
public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt(); // ノード数 (列車数)
    int Q = sc.nextInt(); // クエリ数

    Node[] nodes = new Node[N]; // ノードの配列
    for (int i = 0; i < N; i++) {
      nodes[i] = new Node(-1); // ノードの初期化
    }

    for (int i = 0; i < Q; i++) {
      int queryType = sc.nextInt(); //クエリのタイプ

      if (queryType == 0) {
        //connect クエリ
        int p = sc.nextInt(); // ノードp
        int q = sc.nextInt(); // ノードq
        nodes[p].next = q; // pの次をqに設定
        nodes[q].prev = p; // qの前をpに設定
      } else if (queryType == 1) {
        //contractクエリ
        int r = sc.nextInt(); // ノードr

        // rの前後のノードを取得
        int prev = (int) nodes[r].prev;
        int next = nodes[r].next;

        if (next != -1) {
          nodes[next].prev = prev; // rの次のノードの前を、rの前のノードに設定
        }
        if (prev != -1) {
          nodes[prev].next = next; // rの前のノードの次を、rの次のノードに設定
        }
        nodes[r] = new Node(-1); //ノードrを削除
      }
    }
    // 答えの導出
    int ans = 0, now = 0;

    // 車両 0 を含め、車両 0 の前に何両あるか
    while (now != -1) {
      ans++;
      now = nodes[now].next;
    }
    // 車両 0 を含め、車両 0 の後ろに何両あるか
    now = 0;
    while (now != -1) {
      ans++;
      now = nodes[now].prev;
    }
    // 車両 0 が 2 回数えられているので、調整する
    ans--;

    System.out.println(ans);
  }
}
