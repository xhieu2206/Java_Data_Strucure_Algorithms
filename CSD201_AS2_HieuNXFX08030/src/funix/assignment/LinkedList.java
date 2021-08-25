package funix.assignment;

import java.util.Objects;

public class LinkedList {
    private Node head;

    public Node getHead() {
        return head;
    }

    public void insertAtHead(Product data) {
        /*
            Để insert ở head của linkedlist, chỉ cần refer nextNode của newNode về head node của linkedlist
         */
        Node newNode = new Node(data);
        newNode.setNextNode(this.head);
        this.head = newNode;
    }

    public void insertAtTail(Product data) {
        /*
            Để insert new node ở tail của linkedlist, chỉ cần tìm phần tử tail bằng cách tìm phần tử có nextNode == null, và set nextNode của phần tử này bằng Node mới.
         */
        Node newNode = new Node(data);
        Node tail = Algorithm.getTail(this);
        if (tail == null) {
            this.head = newNode;
        } else {
            tail.setNextNode(newNode);
        }
    }

    public int length() {
        /*
            Duyệt từ node đầu tiên đến tail đến khi nào tìm thấy node có nextNode là null, đây là phần tử cuối cùng của linkedlist (tail)
         */
        int length = 0;
        Node current = this.head;
        if (current == null) return length;
        while (current != null) {
            length ++;
            current = current.getNextNode();
        }
        return length;
    }

    public void deleteFromHead() {
        /*
            Để xóa phần tử đầu tiên khỏi linkedlist, chỉ cần setNextNode của phần tử head về null, khi đó phần tử thứ 2 sẽ là head, phần tử đầu tiên sẽ không còn có liên kết nào đối với linkedlist nữa và cơ chế garbage collection của Java sẽ "dọn" phần tử nà  y cho chúng ta.
         */
        this.head = this.head.getNextNode();
    }

    public Node findById(String id) {
        /*
            Duyệt từng phần tử trong linkedlist (tương tự với cách duyệt để tính length của linkedlist), tìm phần tử có ID bằng ID cần tìm, trả về ID này. Nếu sau khi duyệt hết các phần tử mà không tìm được node cần tìm, return null sau vòng while
         */
        Node current = this.head;
        while (current != null) {
            if (Objects.equals(current.getData().getId(), id)) {
                return current;
            }
            current = current.getNextNode();
        }
        return null;
    }

    public void deleteById(String id) {
        Node current = this.head;
        Node previousNode = this.head;
        if (Objects.equals(current.getData().getId(), id)) {
            // trong trường hợp node đầu tiên (head) chứa product data tương ứng với data cần xóa
            this.head = this.head.getNextNode();
        } else {
            while (current.getNextNode() != null) {
                previousNode = current;
                current = current.getNextNode();
                if (Objects.equals(current.getData().getId(), id)) {
                    break;
                }
            }
            // gán next node của node previous bằng next node của node bị xóa
            previousNode.setNextNode(current.getNextNode());
            // set next node của node bị xóa bằng null để "loại" node này ra khỏi linkedlist, khi đó node này sẽ không còn liên kết gì với linkedlist nữa.
            current.setNextNode(null);
        }
    }
}
