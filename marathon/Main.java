// import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    // Scanner sc = new Scanner(System.in);
    int N = 5;
    int[] A = { 2, 3, 4, 0, 1 };
    // nex, bak の情報を初期化する
    int[] next = new int[N];

    int[] back = new int[N];
    // リストの初期化
    for (int i = 0; i < N; i++) {
      next[i] = -1;
      back[i] = -1;
    }
    // 前後の関係性の設定
    for (int i = 0; i < N; i++) {
      if (i != 0) {
        next[A[i]] = A[i - 1];
      }
      if (i != N - 1) {
        back[A[i]] = A[i + 1];
      }
    }

    int Q = 6; //クエリの数

    int[][] queries = {
      { 0, 4 },
      { 1, 2 },
      { 1, 0 },
      { 0, 4 },
      { 0, 3 },
      { 0, 0 },
    };
    for (int i = 0; i < Q; i++) {
      int[] queryType = queries[i];

      if (queryType[0] == 0) {
        //overtakeクエリ
        int v = queryType[1];
        // 前方に人がいない or すでに棄権した人なら、Error を出力する
        if (next[v] == -1) {
          System.out.println("Error");
        } else {
          int nextV = next[v];
          System.out.println(nextV);
          // 位置関係の更新
          // 解説中の 1. と 2.
          if (next[nextV] != -1) {
            back[next[nextV]] = v;
          }
          if (back[v] != -1) {
            next[back[v]] = nextV;
          }
          next[v] = next[nextV];
          back[nextV] = back[v];
          // 解説中の 3.
          back[v] = nextV;
          next[nextV] = v;
        }
      } else if (queryType[0] == 1) {
        // dropout クエリ
        int v = queryType[1];
        //vの削除
        if (next[v] != -1) {
          back[next[v]] = back[v];
        }

        if (back[v] != -1) {
          next[back[v]] = next[v];
        }
        next[v] = -1;
        back[v] = -1;
      }
    }
  }
}
