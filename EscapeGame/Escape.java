import java.util.Scanner;

public class Escape {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int mathNum = 6; // �}�X�̐�
    int stMath = 2; //�ŏ��̃}�X�̈ʒu
    String text = ".<.><."; //������̓���
    // �E�ƍ��̃}�X��ێ�����z��
    int[] right = new int[mathNum];
    int[] left = new int[mathNum];
    // �z��̏�����
    for (int i = 0; i < mathNum; i++) {
      right[i] = -1;
      left[i] = -1;
    }
    // �}�X�̐ڑ��֌W��ݒ�
    for (int i = 0; i < mathNum; i++) {
      if (i != 0) {
        left[i] = i - 1;
      }
      if (i != mathNum - 1) {
        right[i] = i + 1;
      }
    }

    int direct = 1; // �ړ��̕���
    int now = stMath; // ���݂̃}�X
    long ans = 0; // ����

    while (true) {
      // �}�X v �̏����폜
      right[left[now]] = right[now];
      left[right[now]] = left[now];
      // �ړ��̕��������肷��
      if (text.charAt(now) == '>') {
        direct = 1;
      }
      if (text.charAt(now) == '<') {
        direct = -1;
      }

      int nextDirect;
      // ���̃}�X�����肵�A�������v�Z
      if (direct == 1) {
        nextDirect = right[now];
      } else {
        nextDirect = left[now];
      }

      ans += Math.abs(now - nextDirect); // ��Βl������ċ����𑫂�
      now = nextDirect; // ���݂̃}�X���X�V

      // �I������
      if (now == 0 || now == mathNum - 1) {
        break;
      }
    }
    System.out.println(ans); // �������o��
  }
}
