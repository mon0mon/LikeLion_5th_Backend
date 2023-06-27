/**
 * @project LikeLion_Backend
 * @author ARA
 * @since 2023-06-20 : AM 9:46
 */

package ds.queue;

public class MyLinkedList {
    Node start = null;

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        System.out.println(linkedList);

        System.out.println(linkedList.remove(0));   //  1
        System.out.println(linkedList.remove(1));   //  3
        System.out.println(linkedList.remove(0));   //  2
    }

    private static class Node {
        private int data;
        private Node link;

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node link) {
            this.data = data;
            this.link = link;
        }
    }

    //  add:  제일 뒤에 data 추가
    public void add(int data) {
        //  1. start == null (LinkedList가 비어있을 때)
        if (start == null) start = new Node(data);
        //  2. 아니라면, link가 null인 노드가 나올때까지
        else {
            Node head = start;
            while (head.link != null) {
                head = head.link;
            }

            //  while이 끝났을 때, head.link == null이다. (마지막 노드이다)
            head.link = new Node(data);
        }
    }

    //  remove : idx번째 데이터를 회수 및 노드 제거
    public int remove(int idx) {
        if (idx == 0) {
            int value = start.data;
            start = start.link;
            return value;
        }
        //  0이 아닐 때
        int i = 0;
        Node prev = start;
        Node head = start;
        while (i < idx) {
            prev = head;
            head = head.link;
            i++;
        }
        prev.link = head.link;

        return head.data;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node head = start;
        while (head != null) {
            sb.append(head.data);
            //  link가 Null이 아니라는 건 뒤에 원소가 더 있다.
            if (head.link != null) {
                sb.append(", ");
            }
            head = head.link;
        }
        sb.append("]");
        return sb.toString();
    }
}