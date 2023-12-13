class Node {

  Node next; // 次がどのノードを指すか
  Node prev; // 前がどのノードを指すか
  String value; // ノードに付随している値

  Node(String value) {
    this.next = null;
    this.prev = null;
    this.value = value;
  }
}
