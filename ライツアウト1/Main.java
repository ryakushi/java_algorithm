import java.util.Scanner;

public class Main {

  //���E�̊m�F������z��
  static int[] dx = { 0, 0, 1, 0, -1 };
  //�㉺���m�F����z��
  static int[] dy = { 0, 1, 0, -1, 0 };

  /**
   * @param args
   */
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      // �����ƕ��̎擾
      int H = sc.nextInt();
      int W = sc.nextInt();

      sc.nextLine(); //���s

      // �O���b�h�̍쐬
      int[][] grid = readGrid(sc, H, W);

      // �N�G���̐��̎擾
      int queries = sc.nextInt();
      // �N�G���̏���
      processQuery(sc, grid, queries);
    }
    
  }

  // �O���b�h�̍쐬
  private static int[][] readGrid(Scanner sc, int H, int W) {
    int[][] grid = new int[H][W];
    //�h�b�g�}�X���O�Ɂ��}�X���P�ɒu��������
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

  //// �N�G���̏���
  private static void processQuery(Scanner sc, int[][] grid, int queries) {
    for (int i = 0; i < queries; i++) {
      int queryType = sc.nextInt();
      int p = sc.nextInt();
      int q = sc.nextInt();

      if (queryType == 0) {
        //�N�G���̔ԍ�0��������push���\�b�h�̌Ăяo��
        pushQuery(grid, p, q);
      } else {
        //�N�G���̔ԍ�1��������get���\�b�h�̌Ăяo��
        int ans = getQuery(grid, p, q);
        System.out.println(ans);
      }
    }
  }

  //   push �N�G���̏���
  private static void pushQuery(int[][] grid, int p, int q) {
    for (int d = 0; d < 5; ++d) {
      int moveX = q + dx[d];
      int moveY = p + dy[d];

      // �^����ꂽ�}�X�̎��͂ɂ���}�X�𔽓]����
      if (isValidPosition(grid, moveX, moveY)) {
        if (grid[moveY][moveX] == 1) {
          grid[moveY][moveX] = 0;
        } else {
          grid[moveY][moveX] = 1;
        }
      }
    }
  }

  //   get �N�G���̏���
  private static int getQuery(int[][] grid, int p, int q) {
    int ans = 0;
    for (int d = 0; d < 5; ++d) {
      int moveX = q + dx[d];
      int moveY = p + dy[d];
      // �^����ꂽ�}�X�̎��͂ɂ��鍕���}�X�̐����J�E���g����
      if (isValidPosition(grid, moveX, moveY)) {
        ans += grid[moveY][moveX];
      }
    }
    return ans;
  }

  //�^����ꂽ���W���O���b�h���ɑ��݂��邩�`�F�b�N
  private static boolean isValidPosition(int[][] grid, int x, int y) {
    return (x >= 0 && x < grid[0].length && y >= 0 && y < grid.length);
  }
}
