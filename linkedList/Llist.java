class CustomLinkedList {

    static Node head;

    static class Node {
        int data;
        Node next;

        Node() {
            this.data = 0;
            this.next = null;
        }

        Node(int val) {
            this.data = val;
            this.next = null;
        }
    }

    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode; // Corrected assignment
            return;
        }

        Node last = head;
        while (last.next != null) {
            last = last.next;
        }

        last.next = newNode;
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

public class Llist {
    public static void main(String[] args) {
        CustomLinkedList list = new CustomLinkedList();

        list.append(10);
        list.append(20);
        list.append(30);

        list.printList(); // Output: 10 -> 20 -> 30 -> null
    }
}
