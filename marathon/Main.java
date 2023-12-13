// import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    // Scanner sc = new Scanner(System.in);
    int N = 5;
    int[] A = { 2, 3, 4, 0, 1 };
    // nex, bak �̏�������������
    int[] next = new int[N];

    int[] back = new int[N];
    // ���X�g�̏�����
    for (int i = 0; i < N; i++) {
      next[i] = -1;
      back[i] = -1;
    }
    // �O��̊֌W���̐ݒ�
    for (int i = 0; i < N; i++) {
      if (i != 0) {
        next[A[i]] = A[i - 1];
      }
      if (i != N - 1) {
        back[A[i]] = A[i + 1];
      }
    }

    int Q = 6; //�N�G���̐�

    int[][] queries = {
      { 0, 4 },
      { 1, 2 },
      { 1, 0 },
      { 0, 4 },
      { 0, 3 },
      { 0, 0 },
    };
    for (int i = 0; i < Q; i++) {
      int[] queryType = queries[i];

      if (queryType[0] == 0) {
        //overtake�N�G��
        int v = queryType[1];
        // �O���ɐl�����Ȃ� or ���łɊ��������l�Ȃ�AError ���o�͂���
        if (next[v] == -1) {
          System.out.println("Error");
        } else {
          int nextV = next[v];
          System.out.println(nextV);
          // �ʒu�֌W�̍X�V
          // ������� 1. �� 2.
          if (next[nextV] != -1) {
            back[next[nextV]] = v;
          }
          if (back[v] != -1) {
            next[back[v]] = nextV;
          }
          next[v] = next[nextV];
          back[nextV] = back[v];
          // ������� 3.
          back[v] = nextV;
          next[nextV] = v;
        }
      } else if (queryType[0] == 1) {
        // dropout �N�G��
        int v = queryType[1];
        //v�̍폜
        if (next[v] != -1) {
          back[next[v]] = back[v];
        }

        if (back[v] != -1) {
          next[back[v]] = next[v];
        }
        next[v] = -1;
        back[v] = -1;
      }
    }
  }
}
