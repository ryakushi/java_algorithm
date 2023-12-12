import java.util.Scanner;

public class Main {

  static int[] dy = { 0, 1, 0, -1, 0 };
  static int[] dx = { 0, 0, 1, 0, -1 };

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int h = sc.nextInt();
    int w = sc.nextInt();

    sc.nextLine(); //改行

    char map[][] = new char[h][w]; // map配列の作成
    for (int i = 0; i < map.length; i++) {
      map[i] = sc.next().toCharArray();
    }
    int[][] grid = readGrid(map, h, w); // 0/1の処理

    int Q = sc.nextInt();
    for (int k = 0; k < Q; k++) {
      int queryType = sc.nextInt();
      if (queryType == 0) {
        int p = sc.nextInt(); // 特定の行
        int q = sc.nextInt(); // 特定の列

        pushQuery(grid, p, q);
      } else if (queryType == 1) {
        int result = getQuery(grid);
        System.out.println(result);
      }
    }
  }

  //盤面内かをチェックするメソッド
  private static boolean isValidPosition(int[][] grid, int moveX, int moveY) {
    return (
      0 <= moveY && moveY < grid.length && 0 <= moveX && moveX < grid[0].length
    );
  }

  // push クエリ　マス (p,q) および、その上下左右に隣接するマス (盤外を除く) の白色と黒色を反転
  private static void pushQuery(int[][] grid, int p, int q) {
    for (int d = 0; d < 5; d++) {
      int moveX = q + dx[d];
      int moveY = p + dy[d];
      if (isValidPosition(grid, moveX, moveY)) {
        if (grid[moveY][moveX] == 1) {
          grid[moveY][moveX] = 0;
        } else if (grid[moveY][moveX] == 0) {
          grid[moveY][moveX] = 1;
        }
      }
    }
  }

  // getNum クエリ　盤面全体の黒色の個数
  private static int getQuery(int[][] grid) {
    int ans = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        ans += grid[i][j];
      }
    }
    return ans;
  }

  // 0/1に置き換える処理
  private static int[][] readGrid(char[][] map, int h, int w) {
    int[][] grid = new int[h][w];
    for (int i = 0; i < map.length; i++) {
      for (int j = 0; j < map[0].length; j++) {
        if (map[i][j] == '#') {
          grid[i][j] = 1;
        } else if (map[i][j] == '.') {
          grid[i][j] = 0;
        }
      }
    }
    return grid;
  }
}
