package com.java.linklist;

public class InsertIntoLinkList {

    static class Node {
        public int  data;
        public Node next;

        Node(int d) {
            this.data = d;
            this.next = null;
        }
    }

    private Node insertNodeAtStart(Node head, Integer number) {
        try{
            if (head == null)
                return head;
            Node newNode = new Node(number);
            newNode.next = head;
            head = newNode;
            return head;
        }catch(Exception e){
            return head;
        }
    }

    private Node insertNodeAtEnd(Node head, Integer number) {
        try {
            if (head == null)
                return head;
            Node newNode = new Node(number);
            Node current = head;
            Node prev = null;
            while (current != null) {
                prev = current;
                current = current.next;
            }
            prev.next = newNode;
            newNode.next = null;
            return head;
        }
        catch (Exception e) {
            return head;
        }
    }

    private int findListLength(Node head) {
        try {
            int len = 0;
            Node current = head;
            while (current != null) {
                len++;
                current = current.next;
            }
            return len;
        }
        catch (Exception e) {
            return 0;
        }
    }

    private Node insertInMiddle(Node head, Integer number) {
        try {
            if (head == null)
                return head;
            int listLength = findListLength(head);
            int i = 0;
            Node current = head;
            Node prev = null;
            while (i < listLength / 2) {
                prev = current;
                current = current.next;
                i++;
            }
            Node newNode = new Node(number);
            Node temp = prev.next;
            prev.next = newNode;
            newNode.next = temp;
            return head;
        }
        catch (Exception e) {
            return head;
        }
    }

    private Node addAfterGivenNode(Node head, Integer afterValue, Integer number) {
        try {
            boolean found = false;
            if (head == null)
                return head;
            Node current = head;
            while (current != null) {
                if (current.data == afterValue) {
                    found = true;
                    break;
                }
                current = current.next;
            }
            if (!found)
                return head;
            Node temp = current.next;
            Node newNode = new Node(number);
            current.next = newNode;
            newNode.next = temp;
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
        InsertIntoLinkList obj = new InsertIntoLinkList();
        head = obj.insertNodeAtStart(head, 0);
        head = obj.insertNodeAtEnd(head, 6);
        head = obj.insertInMiddle(head, 100);
        head = obj.addAfterGivenNode(head, 3, 101);
        obj.printList(head);
    }

}
