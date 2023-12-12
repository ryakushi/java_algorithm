package stack;

import java.util.Scanner;

public class Main {

  static Node nil; //�_�~�[�m�[�h

  //-------------------------------------------------------
  private static void init() {
    nil = new Node(""); //�_�~�[�m�[�h
    nil.next = nil; // ������Ԃł� nil �� nil ���w���悤��
  }

  //-------------------------------------------------------
  // �A�����X�g�̐擪�ɂ��镶�����Ԃ��A���̗v�f���폜����
  private static String popHead() {
    Node head = nil.next;
    if (head == nil) {
      return "Error";
    } else {
      String ret = head.data; // �擪�̕������Ԃ�
      nil.next = head.next; // �擪�� head �̎��ɏ���������
      head = null;
      return ret;
    }
  }

  //-------------------------------------------------------
  // �A�����X�g�֐擪�ւ̗v�f�̑}��
  private static void pushHand(Node v) {
    v.next = nil.next; //# v �̎����A���݂̐擪��
    nil.next = v; //# �擪�� v �ɏ���������
  }

  //-------------------------------------------------------
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    init(); //�A�����X�g�̏�����

    int Q = sc.nextInt();
    for (int i = 0; i < Q; i++) {
      int queryType = sc.nextInt();
      if (queryType == 0) {
        String color = sc.next();
        Node v = new Node(color);
        pushHand(v);
      } else if (queryType == 1) {
        System.out.println(popHead());
      }
    }
  }
}
