package Ll;
class CustomLinkedList {

    Node head;

    class Node {
        int data;
        Node next;

        Node(int val) {
            this.data = val;
            this.next = null;
        }
    }

    public void insertAtFirst(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
        }
        else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void insertAtSpecificPosition(int data, int loc){
        Node newNode = new Node(data);

    if (loc == 0) {
        newNode.next = head;
        head = newNode;
        return;
    }

    Node temp = head;
    int count = 0;

    while (temp != null && count < loc - 1) {
        temp = temp.next;
        count++;
    }

    if (temp == null) {
        System.out.println("Position out of bounds");
        return;
    }

    newNode.next = temp.next;
    temp.next = newNode;
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

    public void display(int [] arr){
        for(int val: arr){
            System.out.print(val+ " ");
        }
    }

    public void arrayToLinkedList(int [] arr){
        for (int i=0; i<arr.length; i++){
            append(arr[i]);
        }
    }

    public static CustomLinkedList sumOfTwoList(CustomLinkedList l1, CustomLinkedList l2){
        
        CustomLinkedList resultList = new CustomLinkedList();

        Node temp1 = l1.head;
        Node temp2 = l2.head;

        int carry = 0;
        
        while(temp1 != null || temp2 != null || carry != 0){
            
            int val1 = (temp1 != null) ? temp1.data : 0;
            int val2 = (temp2 != null) ? temp2.data : 0;

            int sum = val1 + val2+ carry;
            int result = sum%10;
            carry = sum/10;

            resultList.append(result);

            if(temp1 != null) temp1 = temp1.next;
            if(temp2 != null) temp2 = temp2.next;
        }

        return resultList;
    }
    
}

public class Llist {
    public static void main(String[] args) {
        CustomLinkedList list = new CustomLinkedList();

        int [] arr = {1,2,3,4};
        list.arrayToLinkedList(arr);

        list.append(10);
        list.append(20);
        list.append(30);

        list.printList(); // Output: 10 -> 20 -> 30 -> null

        CustomLinkedList list1 = new CustomLinkedList();
        int[] arr1 = {1, 2, 3, 4};
        list1.arrayToLinkedList(arr1);

        CustomLinkedList list2 = new CustomLinkedList();
        int[] arr2 = {5, 6, 7};
        list2.arrayToLinkedList(arr2);

        CustomLinkedList resultList = CustomLinkedList.sumOfTwoList(list1, list2);

        resultList.printList();
    }
}
