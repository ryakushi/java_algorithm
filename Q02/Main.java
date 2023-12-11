import java.util.ArrayList;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      // �R���^�N�g�̎�ސ����擾���A���X�g�Ɋi�[
      int contactTypes = sc.nextInt();
      ArrayList<Integer> contacts = new ArrayList<>();
      for (int i = 0; i < contactTypes; i++) {
        contacts.add(sc.nextInt());
      }

      // �N�G�������擾���A�N�G�����Ƃ̑�������s
      int queries = sc.nextInt();
      for (int i = 0; i < queries; i++) {
        int queryType = sc.nextInt();

        if (queryType == 0) {
          // Insert query: �w�肳�ꂽ�ʒu�ɗv�f��}��
          int index = sc.nextInt();
          int value = sc.nextInt();
          contacts.add(index, value);
        } else if (queryType == 1) {
          // Erase query: �w�肳�ꂽ�ʒu�̗v�f���폜
          int index = sc.nextInt();
          if (index >= 0 && index < contacts.size()) {
            contacts.remove(index);
          }
        } else {
          // Count query: �w�肳�ꂽ�l�̏o���񐔂𐔂���
          int valueToCount = sc.nextInt();
          int count = 0;
          for (Integer integer : contacts) {
            if (integer == valueToCount) {
              count++;
            }
          }

          System.out.println(count);
        }
      }
    }
  }
}
