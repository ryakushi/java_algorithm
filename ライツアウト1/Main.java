import java.util.Scanner;

public class Main {

  //左右の確認をする配列
  static int[] dx = { 0, 0, 1, 0, -1 };
  //上下を確認する配列
  static int[] dy = { 0, 1, 0, -1, 0 };

  /**
   * @param args
   */
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      // 高さと幅の取得
      int H = sc.nextInt();
      int W = sc.nextInt();

      sc.nextLine(); //改行

      // グリッドの作成
      int[][] grid = readGrid(sc, H, W);

      // クエリの数の取得
      int queries = sc.nextInt();
      // クエリの処理
      processQuery(sc, grid, queries);
    }
    
  }

  // グリッドの作成
  private static int[][] readGrid(Scanner sc, int H, int W) {
    int[][] grid = new int[H][W];
    //ドットマスを０に＃マスを１に置き換える
    for (int i = 0; i < H; i++) {
      String bord = sc.next();
      for (int j = 0; j < W; j++) {
        if (bord.charAt(j) == '#') {
          grid[i][j] = 1;
        } else {
          grid[i][j] = 0;
        }
      }
    }
    return grid;
  }

  //// クエリの処理
  private static void processQuery(Scanner sc, int[][] grid, int queries) {
    for (int i = 0; i < queries; i++) {
      int queryType = sc.nextInt();
      int p = sc.nextInt();
      int q = sc.nextInt();

      if (queryType == 0) {
        //クエリの番号0だったらpushメソッドの呼び出し
        pushQuery(grid, p, q);
      } else {
        //クエリの番号1だったらgetメソッドの呼び出し
        int ans = getQuery(grid, p, q);
        System.out.println(ans);
      }
    }
  }

  //   push クエリの処理
  private static void pushQuery(int[][] grid, int p, int q) {
    for (int d = 0; d < 5; ++d) {
      int moveX = q + dx[d];
      int moveY = p + dy[d];

      // 与えられたマスの周囲にあるマスを反転する
      if (isValidPosition(grid, moveX, moveY)) {
        if (grid[moveY][moveX] == 1) {
          grid[moveY][moveX] = 0;
        } else {
          grid[moveY][moveX] = 1;
        }
      }
    }
  }

  //   get クエリの処理
  private static int getQuery(int[][] grid, int p, int q) {
    int ans = 0;
    for (int d = 0; d < 5; ++d) {
      int moveX = q + dx[d];
      int moveY = p + dy[d];
      // 与えられたマスの周囲にある黒いマスの数をカウントする
      if (isValidPosition(grid, moveX, moveY)) {
        ans += grid[moveY][moveX];
      }
    }
    return ans;
  }

  //与えられた座標がグリッド内に存在するかチェック
  private static boolean isValidPosition(int[][] grid, int x, int y) {
    return (x >= 0 && x < grid[0].length && y >= 0 && y < grid.length);
  }
}
