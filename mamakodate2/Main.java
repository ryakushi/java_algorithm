

// import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    int N = 12;

    // 数字 i の右隣・左隣にある数字を表す配列
    int[] next = new int[N + 1];
    int[] prev = new int[N + 1];

    // 配列の初期化
    for (int i = 1; i <= N; i++) {
      next[i] = i + 1;
      if (i == N) {
        next[i] = 1;
      }
      prev[i] = i - 1;
      if (i == 1) {
        prev[i] = N;
      }
    }

    int num = 1; // 次に除外する数字
    for (int i = 0; i < N - 1; i++) {
      // num の除外と更新
      prev[next[num]] = prev[num];
      next[prev[num]] = next[num];
      num = next[next[num]];
    }
    // 最終的に残った数が答え
    System.out.println(num);
  }
}
