

// import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    int N = 12;

    // ���� i �̉E�ׁE���ׂɂ��鐔����\���z��
    int[] next = new int[N + 1];
    int[] prev = new int[N + 1];

    // �z��̏�����
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

    int num = 1; // ���ɏ��O���鐔��
    for (int i = 0; i < N - 1; i++) {
      // num �̏��O�ƍX�V
      prev[next[num]] = prev[num];
      next[prev[num]] = next[num];
      num = next[next[num]];
    }
    // �ŏI�I�Ɏc������������
    System.out.println(num);
  }
}
