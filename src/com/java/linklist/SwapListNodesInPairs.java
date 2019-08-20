package com.java.linklist;

public class SwapListNodesInPairs {

    private Node doTask(Node head) {
        if (head == null || head.next == null)
            return head;
        Node current = head;
        Node prev = null;
        while (current != null && current.next != null) {
            Node temp = current.next;
            current.next = temp.next;
            temp.next = current;
            if (prev == null)
                head = temp;
            else
                prev.next = temp;
            prev = current;
            current = current.next;
        }
        return head;
    }

    private void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + "->");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        SwapListNodesInPairs obj = new SwapListNodesInPairs();
        head = obj.doTask(head);
        obj.printList(head);
    }

}
