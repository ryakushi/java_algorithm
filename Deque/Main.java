import java.util.Scanner;

public class Main {

  static Node nil; //�_�~�[�m�[�h

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      init(); // �A�����X�g�̏�����

      int Q = sc.nextInt(); //�N�G���̐�
      for (int i = 0; i < Q; i++) {
        int queryType = sc.nextInt();
        if (queryType == 0) {
          String text = sc.next();
          Node v = new Node(text); // �m�[�h���쐬����
          pushHead(v);
        } else if (queryType == 1) {
          String text = sc.next();
          Node v = new Node(text); // �m�[�h���쐬����
          pushTail(v);
        } else if (queryType == 2) {
          System.out.println(popHead());
        } else if (queryType == 3) {
          System.out.println(popTail());
        }
      }
    }
  }

  // �o�����A�����X�g�̏�����
  private static void init() {
    nil = new Node("");
    nil.next = nil; // ������Ԃł� nil �̎��� nil ���w���悤��
    nil.prev = nil; // ������Ԃł� nil �̑O�� nil ���w���悤��
  }

  // �o�����A�����X�g�֐擪�ւ̗v�f�̑}��
  private static void pushHead(Node v) {
    v.next = nil.next; // v �̎����A���̐擪�v�f��
    v.prev = nil; // v �̑O�� nil ��
    nil.next = v; // nil �̎��� v �ɏ���������
    v.next.prev = v; // ���̐擪�v�f�̑O�� v �ɂ���
  }

  // �o�����A�����X�g�֖����ւ̗v�f�̑}��
  private static void pushTail(Node v) {
    v.next = nil; //v�̎��̃|�C���^��nil��
    v.prev = nil.prev; //v�̑O�̗v�f�����̖����̗v�f��
    nil.prev = v; //nil�̑O��v�ɕR�Â�
    v.prev.next = v; //���̖����m�[�h�̎���v�ɕR�Â���
  }

  // �o�����A�����X�g�̐擪�ɂ��镶�����Ԃ��A���̗v�f���폜����
  private static String popHead() {
    Node head = nil.next; //�擪�̃m�[�h���擾
    if (head == nil) {
      return "Error";
    } else {
      String ret = head.data;
      nil.next = head.next; //nil�̎��� head�̎��ɕR�Â���
      nil.next.prev = nil; // �V���Ȑ擪�̑O�� nil ��
      head = null;
      return ret;
    }
  }

  // �o�����A�����X�g�̖����ɂ��镶�����Ԃ��A���̗v�f���폜����
  private static String popTail() {
    Node tail = nil.prev; // �����̃m�[�h���擾����
    if (tail == nil) {
      return "Error";
    } else {
      String ret = tail.data; // �����̕������Ԃ�
      nil.prev = tail.prev; // nil �̑O���Atail �̑O��
      nil.prev.next = nil; // �V���Ȗ����̎��� nil ��
      tail = null; //���������J������
      return ret;
    }
  }
}
