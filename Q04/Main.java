<<<<<<< HEAD
=======

>>>>>>> dev
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int num = sc.nextInt(); //sns���g�p���Ă���l��
    int Q = sc.nextInt(); //�N�G�����J��Ԃ���
    // ���[�U�[ i �̃t�H�����[�̔ԍ��� HashSet �ŊǗ�����z��
    ArrayList<HashSet<Integer>> followers = new ArrayList<>();
    for (int i = 0; i < num; ++i) {
      followers.add(new HashSet<>());
    }
    for (int i = 0; i < Q; i++) {
      int queryType = sc.nextInt();
      if (queryType == 0) {
        //Follow(x,y) �N�G��
        int x = sc.nextInt();
        int y = sc.nextInt();
        followers.get(y).add(x);
      } else if (queryType == 1) {
        //  GetFollowers(z)�N�G��
        int z = sc.nextInt();

        if (followers.get(z).isEmpty()) {
          System.out.println("No");
        } else {
          for (int hashSet : followers.get(z)) {
            System.out.println(hashSet + " ");
          }
        }
      }
    }
  }
}
