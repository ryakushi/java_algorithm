import java.util.Scanner;

/**
 * Main
 */
public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt(); // �m�[�h�� (��Ԑ�)
    int Q = sc.nextInt(); // �N�G����

    Node[] nodes = new Node[N]; // �m�[�h�̔z��
    for (int i = 0; i < N; i++) {
      nodes[i] = new Node(-1); // �m�[�h�̏�����
    }

    for (int i = 0; i < Q; i++) {
      int queryType = sc.nextInt(); //�N�G���̃^�C�v

      if (queryType == 0) {
        //connect �N�G��
        int p = sc.nextInt(); // �m�[�hp
        int q = sc.nextInt(); // �m�[�hq
        nodes[p].next = q; // p�̎���q�ɐݒ�
        nodes[q].prev = p; // q�̑O��p�ɐݒ�
      } else if (queryType == 1) {
        //contract�N�G��
        int r = sc.nextInt(); // �m�[�hr

        // r�̑O��̃m�[�h���擾
        int prev = (int) nodes[r].prev;
        int next = nodes[r].next;

        if (next != -1) {
          nodes[next].prev = prev; // r�̎��̃m�[�h�̑O���Ar�̑O�̃m�[�h�ɐݒ�
        }
        if (prev != -1) {
          nodes[prev].next = next; // r�̑O�̃m�[�h�̎����Ar�̎��̃m�[�h�ɐݒ�
        }
        nodes[r] = new Node(-1); //�m�[�hr���폜
      }
    }
    // �����̓��o
    int ans = 0, now = 0;

    // �ԗ� 0 ���܂߁A�ԗ� 0 �̑O�ɉ������邩
    while (now != -1) {
      ans++;
      now = nodes[now].next;
    }
    // �ԗ� 0 ���܂߁A�ԗ� 0 �̌��ɉ������邩
    now = 0;
    while (now != -1) {
      ans++;
      now = nodes[now].prev;
    }
    // �ԗ� 0 �� 2 �񐔂����Ă���̂ŁA��������
    ans--;

    System.out.println(ans);
  }
}
