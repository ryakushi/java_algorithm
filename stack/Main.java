package stack;

import java.util.Scanner;

public class Main {

  static Node nil; //ダミーノード

  //-------------------------------------------------------
  private static void init() {
    nil = new Node(""); //ダミーノード
    nil.next = nil; // 初期状態では nil が nil を指すように
  }

  //-------------------------------------------------------
  // 連結リストの先頭にある文字列を返し、その要素を削除する
  private static String popHead() {
    Node head = nil.next;
    if (head == nil) {
      return "Error";
    } else {
      String ret = head.data; // 先頭の文字列を返す
      nil.next = head.next; // 先頭を head の次に書き換える
      head = null;
      return ret;
    }
  }

  //-------------------------------------------------------
  // 連結リストへ先頭への要素の挿入
  private static void pushHand(Node v) {
    v.next = nil.next; //# v の次を、現在の先頭に
    nil.next = v; //# 先頭を v に書き換える
  }

  //-------------------------------------------------------
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    init(); //連結リストの初期化

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
