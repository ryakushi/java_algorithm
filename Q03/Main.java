import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 *好きな色
 */
public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int stuNum = sc.nextInt(); //生徒の人数を表す整数値 N
    String colorText = sc.next(); //色を表す文字列
    sc.nextLine();

    //// 生徒ごとの好きな色を保持するHashMap
    HashMap<Integer, HashSet<String>> studentColors = new HashMap<>();

    // 生徒の情報を入力
    for (int i = 0; i < stuNum; i++) {
      int M = sc.nextInt(); // 生徒 i の好きな色の数 M を取得
      HashSet<String> colors = new HashSet<>(); // 生徒 i の好きな色を保持するHashSet

      for (int j = 0; j < M; j++) {
        String color = sc.next(); // 生徒 i の好きな色を取得
        colors.add(color); // 色をHashSetに追加
      }
      studentColors.put(i, colors); // 生徒 i の好きな色をHashMapに追加
    }
    // 答えを求める
    int ans = 0;
    for (int i = 0; i < stuNum; i++) {
      HashSet<String> colors = studentColors.get(i); // 生徒 i の好きな色を取得
      if (colors.contains(colorText)) { // 生徒 i が色 colorTextを好きかチェック
        ans++; // 色colorText を好きな生徒がいた場合、答えに加算
      }
    }
    System.out.println(ans);
  }
}
