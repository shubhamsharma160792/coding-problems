package com.java.linklist;


public class LinkListReversal {
    
    private Node reverseListIterative(Node head) {
        try {
            if (head == null)
                return head;
            Node prev = null;
            Node current = head;
            Node next = null;
            while (current != null) {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }
            head = prev;
            return head;
        }
        catch (Exception e) {
            return head;
        }
    }

    private void printList(Node head) {
        if (head == null)
            return;
        Node tempNode = head;
        while (tempNode != null) {
            System.out.print(tempNode.data + "->");
            tempNode = tempNode.next;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        LinkListReversal obj = new LinkListReversal();
        head = obj.reverseListIterative(head);
        obj.printList(head);
    }

}
