public class Node {

  Node next; //�����ǂ̃m�[�h���w��
  Node prev; //�O���ǂ̃m�[�h���w��
  String data; //�f�[�^�̎擾

  //�R���X�g���N�^
  Node(String data) {
    this.next = null; //�ŏ��̎��̗v�f�͋�̏��
    this.next = null; //�ŏ��̑O�̗v�f�͋�̏��
    this.data = data;
  }
}
