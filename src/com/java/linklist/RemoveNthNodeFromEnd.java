package com.java.linklist;


public class RemoveNthNodeFromEnd {

    private int listLength(Node node) {
        int len = 0;
        while (node != null) {
            node = node.next;
            len++;
        }
        return len;
    }

    private Node removeNthNodeFromEnd(Node node, int pos) {
        int len = listLength(node);
        if (len <= pos) {
            node = node.next;
            return node;
        }
        Node prev = null;
        Node current = node;
        int posFromBegin = len - pos;
        int counter = 0;
        while (counter < posFromBegin) {
            prev = current;
            current = current.next;
            counter++;
        }
        prev.next = current.next;
        return node;
    }

    private void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        RemoveNthNodeFromEnd obj = new RemoveNthNodeFromEnd();
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        obj.printList(head);
        obj.removeNthNodeFromEnd(head, 1);
        System.out.println();
        obj.printList(head);
    }

}


