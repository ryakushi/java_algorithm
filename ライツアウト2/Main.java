import java.util.Scanner;

public class Main {

  static int[] dy = { 0, 1, 0, -1, 0 };
  static int[] dx = { 0, 0, 1, 0, -1 };

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int h = sc.nextInt();
    int w = sc.nextInt();

    sc.nextLine(); //���s

    char map[][] = new char[h][w]; // map�z��̍쐬
    for (int i = 0; i < map.length; i++) {
      map[i] = sc.next().toCharArray();
    }
    int[][] grid = readGrid(map, h, w); // 0/1�̏���

    int Q = sc.nextInt();
    for (int k = 0; k < Q; k++) {
      int queryType = sc.nextInt();
      if (queryType == 0) {
        int p = sc.nextInt(); // ����̍s
        int q = sc.nextInt(); // ����̗�

        pushQuery(grid, p, q);
      } else if (queryType == 1) {
        int result = getQuery(grid);
        System.out.println(result);
      }
    }
  }

  //�Ֆʓ������`�F�b�N���郁�\�b�h
  private static boolean isValidPosition(int[][] grid, int moveX, int moveY) {
    return (
      0 <= moveY && moveY < grid.length && 0 <= moveX && moveX < grid[0].length
    );
  }

  // push �N�G���@�}�X (p,q) ����сA���̏㉺���E�ɗאڂ���}�X (�ՊO������) �̔��F�ƍ��F�𔽓]
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

  // getNum �N�G���@�ՖʑS�̂̍��F�̌�
  private static int getQuery(int[][] grid) {
    int ans = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        ans += grid[i][j];
      }
    }
    return ans;
  }

  // 0/1�ɒu�������鏈��
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
