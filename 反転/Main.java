import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
      // ���͂��ꂽ�v�f���ƃ��X�g�̏�����
      int N = scanner.nextInt();
      ArrayList<Integer> numbers = new ArrayList<>();
      for (int i = 0; i < N; i++) {
        numbers.add(scanner.nextInt());
      }

      // �N�G���̐����擾���A�e�N�G�������s
      int Q = scanner.nextInt();
      for (int i = 0; i < Q; i++) {
        int queryType = scanner.nextInt();

        if (queryType == 0) {
          // reverse �N�G��: ���X�g���t���ɂ���
          Collections.reverse(numbers);
        } else if (queryType == 1) {
          // push �N�G��: �v�f�����X�g�̖����ɒǉ�
          int value = scanner.nextInt();
          numbers.add(value);
        } else {
          // pop �N�G��: ���X�g���疖���̗v�f�����o���A�폜
          if (!numbers.isEmpty()) {
            int removed = numbers.remove(numbers.size() - 1);
            System.out.println(removed);
          } else {
            // �������X�g����Ȃ�G���[���o��
            System.out.println("Error");
          }
        }
      }
    }
  }
}
