public class LinkedList {

    static Node head;

    static class Node{
        int data;
        Node next;

        Node(){
            this.data = null;
            this.next = null;
        }
        Node(int val){
            this.data = val;
            this.next = null;
        }
    }

    public void append (int data){
        Node newNode = new Node(data);
        if (head == null){
            head == newNode;
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

class Llist {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.append(10);
        list.append(20);
        list.append(30);

        list.printList();
    }
}