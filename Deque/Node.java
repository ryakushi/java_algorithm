public class Node {

  Node next; //次がどのノードを指す
  Node prev; //前がどのノードを指す
  String data; //データの取得

  //コンストラクタ
  Node(String data) {
    this.next = null; //最初の次の要素は空の状態
    this.next = null; //最初の前の要素は空の状態
    this.data = data;
  }
}
