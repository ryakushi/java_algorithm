/**
 * �܂܂�����
 *
 */
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
    }
    int N = 1996;

    // 1����N�܂ł̐��������X�g���쐬
    LinkedList<Integer> contacts = new LinkedList<>();
    for (int i = 0; i < N; i++) {
      contacts.add(i + 1);
    }

    // ���X�g��1�ɂȂ�܂ő�����J��Ԃ�
    while (contacts.size() > 1) {
      contacts.poll(); // �擪�̗v�f���폜
      int temp = contacts.poll(); // ���̐擪�̗v�f���擾���ĕϐ��Ɋi�[
      contacts.add(temp); // �擾�����v�f�𖖔��ɒǉ�
    }
    System.out.println(contacts.poll()); // �Ō�Ɏc�����v�f���o��
  }
}
