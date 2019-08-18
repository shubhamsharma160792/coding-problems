package com.java.linklist;

public class FindAndRemoveLoop {

    static class Node {
        private int  data;
        private Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private void doTask(Node head) {
        if (head == null)
            return;
        Node slowPtr = head;
        Node fastPtr = head;
        boolean found = false;
        while (slowPtr != null && fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            if (slowPtr == fastPtr) {
                found = true;
                break;
            }
        }
        if (found) {
            slowPtr = head;
            while (slowPtr.next != fastPtr.next) {
                slowPtr = slowPtr.next;
                fastPtr = fastPtr.next;
            }
            fastPtr.next = null;
        }
    }

    private void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + "->");
            current = current.next;
        }
    }

    public static void main(String[] args) {
        FindAndRemoveLoop obj = new FindAndRemoveLoop();
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = head.next.next;
        obj.doTask(head);
        obj.printList(head);
    }

}
