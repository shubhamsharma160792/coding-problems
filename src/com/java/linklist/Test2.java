package com.java.linklist;


public class Test2 {

    private static class Node {

        int  data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }

    }

    public void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + (temp.next != null ? "->" : ""));
            temp = temp.next;
        }
        System.out.println();
    }

    Node KAltReverseBlock2(Node node, int k) {
        Node current = node;
        Node next = null, prev = null;
        int count = 0;
        if (current == null) {
            return current;
        }

        while (count < k - 1 && current != null) {
            current = current.next;
            count++;
        }

        if (current == null) {
            return node;
        }

        Node firstBlockEnd = current;
        Node secondBlackEnd = null;
        if (current != null) {
            current = current.next;
            secondBlackEnd = current;
        }

        prev = null;
        count = 0;
        while (current != null && count < k) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        if (firstBlockEnd != null) {
            firstBlockEnd.next = prev;
        }

        if (secondBlackEnd != null) {
            secondBlackEnd.next = KAltReverseBlock2(next, k);
        }
        return node;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.next = new Node(8);
        head.next.next.next.next.next.next.next.next = new Node(9);
        head.next.next.next.next.next.next.next.next.next = new Node(10);
        head.next.next.next.next.next.next.next.next.next.next = new Node(11);
        head.next.next.next.next.next.next.next.next.next.next.next = new Node(12);
        head.next.next.next.next.next.next.next.next.next.next.next.next = new Node(13);
        Test2 obj = new Test2();
        obj.printList(head);
        head = obj.KAltReverseBlock2(head, 3);
        obj.printList(head);
    }

}

