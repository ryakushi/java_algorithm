import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * ��ԂȂ�
 */
public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int Q = sc.nextInt();

    // �u���b�N�Ԃ̘A������ێ����郊�X�g�@
    int[] nex = new int[N];
    int[] bak = new int[N];

    // ���X�g�̏������@(�Ȃ��ꍇ�� -1 �Ƃ���)
    for (int i = 0; i < N; i++) {
      nex[i] = -1;
      bak[i] = -1;
    }
    // �N�G���̏���
    for (int i = 0; i < Q; i++) {
      int queryType = sc.nextInt();

      if (queryType == 0) {
        //connect�N�G��
        int p = sc.nextInt();
        int q = sc.nextInt();
        nex[p] = q;
        bak[q] = p;
      } else if (queryType == 1) {
        // contract �N�G��
        int r = sc.nextInt();
        // r �̑O��ɂ���u���b�N���q���悤�ɂ���
        if (nex[r] != -1) {
          bak[nex[r]] = bak[r];
        }
        if (bak[r] != -1) {
          nex[bak[r]] = nex[r];
        }
        // �u���b�N r �̏����X�V����
        nex[r] = -1;
        bak[r] = -1;
      }
    }
    // �����̓��o
    int ans = 0;
    int now = 0;

    // �ԗ� 0 ���܂߁A�ԗ� 0 �̑O�ɉ������邩
    while (now != -1) {
      ans++;
      now = nex[now];
    }
    // �ԗ� 0 ���܂߁A�ԗ� 0 �̌��ɉ������邩
    now = 0;
    while (now != -1) {
      ans++;
      now = bak[now];
    }
    // �ԗ� 0 �� 2 �񐔂����Ă���̂ŁA��������
    ans--;

    System.out.println(ans);
  }
}
