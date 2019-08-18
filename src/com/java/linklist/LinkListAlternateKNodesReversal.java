package com.java.linklist;

public class LinkListAlternateKNodesReversal {
    
    private Node reverseAlternateKNodes(Node head, int k) {
        try {
            return null;
        }
        catch (Exception e) {
            return null;
        }
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
        LinkListAlternateKNodesReversal obj = new LinkListAlternateKNodesReversal();
        head = obj.reverseAlternateKNodes(head, 3);
        obj.printList(head);
    }

    private void printList(Node head) {
        while (head != null) {
            head = head.next;
            System.out.print(head.data);
        }
    }

}
