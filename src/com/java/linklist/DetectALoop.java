package com.java.linklist;

public class DetectALoop {

    static class Node {
        private int  data;
        private Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private boolean isLoopExists(Node head) {
        if (head == null)
            return false;
        Node slowPtr = head;
        Node fastPtr = head;
        while (slowPtr != null && fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            if (slowPtr == fastPtr)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        DetectALoop obj = new DetectALoop();
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = head.next.next.next;
        System.out.printf("Loop exists %b", obj.isLoopExists(head));
    }

}
