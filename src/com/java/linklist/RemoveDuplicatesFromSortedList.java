package com.java.linklist;

public class RemoveDuplicatesFromSortedList {

    public Node deleteDuplicates(Node A) {
        Node current = A;
        while (current.next != null) {
            if (current.data == current.next.data) {
                Node nextNext = current.next.next;
                current.next = nextNext;
            }
            else {
                current = current.next;
            }
        }
        return A;
    }

    private void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedList obj = new RemoveDuplicatesFromSortedList();
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(5);
        obj.printList(head);
        head = obj.deleteDuplicates(head);
        System.out.println();
        obj.printList(head);
    }

}
