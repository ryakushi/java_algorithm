import java.util.Scanner;

public class Escape {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int mathNum = 6; // マスの数
    int stMath = 2; //最初のマスの位置
    String text = ".<.><."; //文字列の入力
    // 右と左のマスを保持する配列
    int[] right = new int[mathNum];
    int[] left = new int[mathNum];
    // 配列の初期化
    for (int i = 0; i < mathNum; i++) {
      right[i] = -1;
      left[i] = -1;
    }
    // マスの接続関係を設定
    for (int i = 0; i < mathNum; i++) {
      if (i != 0) {
        left[i] = i - 1;
      }
      if (i != mathNum - 1) {
        right[i] = i + 1;
      }
    }

    int direct = 1; // 移動の方向
    int now = stMath; // 現在のマス
    long ans = 0; // 答え

    while (true) {
      // マス v の情報を削除
      right[left[now]] = right[now];
      left[right[now]] = left[now];
      // 移動の方向を決定する
      if (text.charAt(now) == '>') {
        direct = 1;
      }
      if (text.charAt(now) == '<') {
        direct = -1;
      }

      int nextDirect;
      // 次のマスを決定し、距離を計算
      if (direct == 1) {
        nextDirect = right[now];
      } else {
        nextDirect = left[now];
      }

      ans += Math.abs(now - nextDirect); // 絶対値を取って距離を足す
      now = nextDirect; // 現在のマスを更新

      // 終了条件
      if (now == 0 || now == mathNum - 1) {
        break;
      }
    }
    System.out.println(ans); // 答えを出力
  }
}
