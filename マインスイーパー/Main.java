import java.util.Scanner;

/**
 * マインスイーパー
 */
public class Main {

  //上下左右の確認する配列
  private static int[] dx = { 1, 0, -1, 0 };
  private static int[] dy = { 0, 1, 0, -1 };

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      //ボードの二次元配列
      char[][] bord = {
        { '.', '#', '#', '.', '#' },
        { '#', '#', '.', '.', '.' },
        { '.', '.', '#', '.', '.' },
        { '.', '.', '.', '.', '#' },
      };
      // マス (i, j) が黒であれば 1 を、白であれば 0 を代入する 2 次元配列
      int[][] grid = new int[bord.length][bord[0].length];
      for (int i = 0; i < bord.length; i++) {
        for (int j = 0; j < bord[0].length; j++) {
          if (bord[i][j] == '#') {
            grid[i][j] = 1;
          } else {
            grid[i][j] = 0;
          }
        }
      }
      // クエリの数
      int queries = 3;
      for (int i = 0; i < queries; i++) {
        int x = sc.nextInt(); // xの座標
        int y = sc.nextInt(); // yの座標
        int ans = 0; //爆弾の数

        // マス (x, y) の上下左右に隣接する 4 マスを調べる
        for (int d = 0; d < 4; ++d) {
          int moveX = x + dx[d];
          int moveY = y + dy[d];
          // マス (nx, ny) が盤面内にあるならば、board[nx][ny] を答えに加える
          if (
            0 <= moveX &&
            moveX < grid[0].length &&
            0 <= moveY &&
            moveY < grid.length
          ) {
            ans += grid[moveX][moveY];
          }
        }

        System.out.println(ans);
      }
    }
  }
}
