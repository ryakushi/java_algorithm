class Node {

  Node next; // �����ǂ̃m�[�h���w����
  Node prev; // �O���ǂ̃m�[�h���w����
  String value; // �m�[�h�ɕt�����Ă���l

  Node(String value) {
    this.next = null;
    this.prev = null;
    this.value = value;
  }
}
