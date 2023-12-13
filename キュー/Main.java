import java.util.Scanner;

/**
 * �L���[����̉��K
 */

public class Main {

  static Node nil; // �ԕ���\���m�[�h�i�_�~�[�m�[�h�j

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    init(); //�A�����X�g�̏�����

    int Q = sc.nextInt(); // �N�G����

    for (int i = 0; i < Q; i++) {
      int type = sc.nextInt(); // �N�G���̎��
      if (type == 0) {
        String S = sc.next(); // �}�����镶����
        Node v = new Node(S);
        pushHead(v); // �擪�ɗv�f��}��
      } else {
        System.out.println(popTail());
      }
    }
    sc.close();
  }

  // �A�����X�g�̏�����
  private static void init() {
    nil = new Node("");
    nil.next = nil; // ������Ԃł� nil �̎��� nil ���w���悤��
    nil.prev = nil; // ������Ԃł� nil �̑O�� nil ���w���悤��
  }

  // �擪�ɗv�f��}�����郁�\�b�h
  private static void pushHead(Node v) {
    v.next = nil.next; // v �̎����A���̐擪�v�f��
    v.prev = nil; // v �̑O�� nil ��
    nil.next = v; // nil �̎��� v �ɏ���������
    v.next.prev = v; // ���̐擪�v�f�̑O�� v �ɂ���
  }

  private static String popTail() {
    Node tail = nil.prev; // �����̃m�[�h���擾����
    if (tail == nil) {
      return "Error"; // �o�����A�����X�g����Ȃ�AError ��Ԃ�
    } else {
      String ret = tail.value; // �����̕������Ԃ�
      nil.prev = tail.prev; // nil �̑O���Atail �̑O��
      nil.prev.next = nil; // �V���Ȗ����̎��� nil ��
      tail = null; // ���������J������
      return ret;
    }
  }
}
