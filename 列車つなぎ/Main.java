import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 列車つなぎ
 */
public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int Q = sc.nextInt();

    // ブロック間の連結情報を保持するリスト　
    int[] nex = new int[N];
    int[] bak = new int[N];

    // リストの初期化　(ない場合は -1 とする)
    for (int i = 0; i < N; i++) {
      nex[i] = -1;
      bak[i] = -1;
    }
    // クエリの処理
    for (int i = 0; i < Q; i++) {
      int queryType = sc.nextInt();

      if (queryType == 0) {
        //connectクエリ
        int p = sc.nextInt();
        int q = sc.nextInt();
        nex[p] = q;
        bak[q] = p;
      } else if (queryType == 1) {
        // contract クエリ
        int r = sc.nextInt();
        // r の前後にあるブロックを繋ぐようにする
        if (nex[r] != -1) {
          bak[nex[r]] = bak[r];
        }
        if (bak[r] != -1) {
          nex[bak[r]] = nex[r];
        }
        // ブロック r の情報を更新する
        nex[r] = -1;
        bak[r] = -1;
      }
    }
    // 答えの導出
    int ans = 0;
    int now = 0;

    // 車両 0 を含め、車両 0 の前に何両あるか
    while (now != -1) {
      ans++;
      now = nex[now];
    }
    // 車両 0 を含め、車両 0 の後ろに何両あるか
    now = 0;
    while (now != -1) {
      ans++;
      now = bak[now];
    }
    // 車両 0 が 2 回数えられているので、調整する
    ans--;

    System.out.println(ans);
  }
}
