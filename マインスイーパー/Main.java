import java.util.Scanner;

/**
 * �}�C���X�C�[�p�[
 */
public class Main {

  //�㉺���E�̊m�F����z��
  private static int[] dx = { 1, 0, -1, 0 };
  private static int[] dy = { 0, 1, 0, -1 };

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      //�{�[�h�̓񎟌��z��
      char[][] bord = {
        { '.', '#', '#', '.', '#' },
        { '#', '#', '.', '.', '.' },
        { '.', '.', '#', '.', '.' },
        { '.', '.', '.', '.', '#' },
      };
      // �}�X (i, j) �����ł���� 1 ���A���ł���� 0 �������� 2 �����z��
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
      // �N�G���̐�
      int queries = 3;
      for (int i = 0; i < queries; i++) {
        int x = sc.nextInt(); // x�̍��W
        int y = sc.nextInt(); // y�̍��W
        int ans = 0; //���e�̐�

        // �}�X (x, y) �̏㉺���E�ɗאڂ��� 4 �}�X�𒲂ׂ�
        for (int d = 0; d < 4; ++d) {
          int moveX = x + dx[d];
          int moveY = y + dy[d];
          // �}�X (nx, ny) ���Ֆʓ��ɂ���Ȃ�΁Aboard[nx][ny] �𓚂��ɉ�����
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
