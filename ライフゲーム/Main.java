import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int N = scanner.nextInt();
    int X = scanner.nextInt();
    scanner.nextLine(); // ���s�ǂݎ��

    char[][] S = new char[N][N];
    for (int i = 0; i < N; i++) {
      String line = scanner.nextLine();
      for (int j = 0; j < N; j++) {
        S[i][j] = line.charAt(j);
      }
    }

    // �}�X�ڂ�0/1�ɕϊ����郁�\�b�h
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

    // ����̃V�~�����[�V�������s������
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

  // �w�肵���}�X���͂̐��������擾���郁�\�b�h
  private static int getSum(int[][] now, int i, int j, int N) {
    int sumIJ = 0;
    for (int ni = i - 1; ni <= i + 1; ni++) {
      for (int nj = j - 1; nj <= j + 1; nj++) {
        if (ni == i && nj == j) continue; //�������g�̏ꍇ�̓J�E���g���Ȃ�
        if (ni >= 0 && ni < N && nj >= 0 && nj < N) {
          sumIJ += now[ni][nj];
        }
      }
    }
    return sumIJ;
  }

  // ���̏�Ԃ����߂郁�\�b�h
  private static int nextState(int nowIJ, int sumIJ) {
    int ret = nowIJ; // �ŏ��Ɍ��݂̏�Ԃŏ�����

    // �����Z��������ł��Ď��͂ɂ��傤��3�̐����Z��������ꍇ�A���̐���Ő�������
    if (nowIJ == 0 && sumIJ == 3) {
      ret = 1; // ��������
    }

    // �����Z�����������Ă���ꍇ
    if (nowIJ == 1) {
      // ���͂̐����Z����1�ȉ��܂���4�ȏ�̏ꍇ�A���̐���Ŏ��ł���
      if (sumIJ <= 1 || sumIJ >= 4) {
        ret = 0; // ���ł���
      } else {
        ret = 1; // ��������
      }
    }
    return ret; // ���肳�ꂽ�Z���̏�Ԃ�Ԃ�
  }
}
