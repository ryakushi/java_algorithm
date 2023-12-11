import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 *�D���ȐF
 */
public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int stuNum = sc.nextInt(); //���k�̐l����\�������l N
    String colorText = sc.next(); //�F��\��������
    sc.nextLine();

    //// ���k���Ƃ̍D���ȐF��ێ�����HashMap
    HashMap<Integer, HashSet<String>> studentColors = new HashMap<>();

    // ���k�̏������
    for (int i = 0; i < stuNum; i++) {
      int M = sc.nextInt(); // ���k i �̍D���ȐF�̐� M ���擾
      HashSet<String> colors = new HashSet<>(); // ���k i �̍D���ȐF��ێ�����HashSet

      for (int j = 0; j < M; j++) {
        String color = sc.next(); // ���k i �̍D���ȐF���擾
        colors.add(color); // �F��HashSet�ɒǉ�
      }
      studentColors.put(i, colors); // ���k i �̍D���ȐF��HashMap�ɒǉ�
    }
    // ���������߂�
    int ans = 0;
    for (int i = 0; i < stuNum; i++) {
      HashSet<String> colors = studentColors.get(i); // ���k i �̍D���ȐF���擾
      if (colors.contains(colorText)) { // ���k i ���F colorText���D�����`�F�b�N
        ans++; // �FcolorText ���D���Ȑ��k�������ꍇ�A�����ɉ��Z
      }
    }
    System.out.println(ans);
  }
}
