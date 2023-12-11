import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int N = scanner.nextInt();
    int X = scanner.nextInt();
    scanner.nextLine(); // 改行読み取り

    char[][] S = new char[N][N];
    for (int i = 0; i < N; i++) {
      String line = scanner.nextLine();
      for (int j = 0; j < N; j++) {
        S[i][j] = line.charAt(j);
      }
    }

    // マス目を0/1に変換するメソッド
    int[][] now = new int[N][N];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (S[i][j] == '.') {
          now[i][j] = 0;
        } else if (S[i][j] == '#') {
          now[i][j] = 1;
        }
      }
    }

    // 世代のシミュレーションを行う処理
    for (int k = 0; k < X; k++) {
      int[][] next = new int[N][N];
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          int sumIJ = getSum(now, i, j, N);
          next[i][j] = nextState(now[i][j], sumIJ);
        }
      }
      now = next;
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (now[i][j] == 0) {
          System.out.print('.');
        } else if (now[i][j] == 1) {
          System.out.print('#');
        }
      }
      System.out.println();
    }
  }

  // 指定したマス周囲の生存数を取得するメソッド
  private static int getSum(int[][] now, int i, int j, int N) {
    int sumIJ = 0;
    for (int ni = i - 1; ni <= i + 1; ni++) {
      for (int nj = j - 1; nj <= j + 1; nj++) {
        if (ni == i && nj == j) continue; //自分自身の場合はカウントしない
        if (ni >= 0 && ni < N && nj >= 0 && nj < N) {
          sumIJ += now[ni][nj];
        }
      }
    }
    return sumIJ;
  }

  // 次の状態を求めるメソッド
  private static int nextState(int nowIJ, int sumIJ) {
    int ret = nowIJ; // 最初に現在の状態で初期化

    // もしセルが死んでいて周囲にちょうど3つの生存セルがある場合、次の世代で生存する
    if (nowIJ == 0 && sumIJ == 3) {
      ret = 1; // 生存する
    }

    // もしセルが生存している場合
    if (nowIJ == 1) {
      // 周囲の生存セルが1つ以下または4つ以上の場合、次の世代で死滅する
      if (sumIJ <= 1 || sumIJ >= 4) {
        ret = 0; // 死滅する
      } else {
        ret = 1; // 生存する
      }
    }
    return ret; // 決定されたセルの状態を返す
  }
}
