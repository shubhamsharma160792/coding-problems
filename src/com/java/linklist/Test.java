package com.java.linklist;

public class Test {

    static class Node {
        private int  data;
        private Node next;
        public Node(int data) {
            this.data = data;
        }
    }

    private Node insertNodeAtBegining(Node head, int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return head;
        }
        Node temp = head;
        head = newNode;
        newNode.next = temp;
        return head;
    }

    private Node insertNodeAtEnd(Node head, int data) {
        Node newNode = new Node(data);
        if (head == null)
            return newNode;
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        newNode.next = null;
        return head;
    }

    private int findListLength(Node head) {
        int length = 0;
        Node current = head;
        while (current != null) {
            current = current.next;
            length++;
        }
        return length;
    }

    private Node insertNodeInMiddle(Node head, int data) {
        Node newNode = new Node(data);
        if (head == null)
            return newNode;
        int length = findListLength(head);
        int i = 1;
        Node current = head;
        while (i++ < length / 2)
            current = current.next;
        Node temp = current.next;
        current.next = newNode;
        newNode.next = temp;
        return head;
    }

    private Node insertAfterAGivenNode(Node head, Node afterNode, int data) {
        Node newNode = new Node(data);
        if (head == null)
            return newNode;
        Node current = head;
        boolean found = false;
        while (current != null) {
            if (current == afterNode) {
                found = true;
                break;
            }
            current = current.next;
        }
        if (found) {
            Node temp = current.next;
            current.next = newNode;
            newNode.next = temp;
        }
        return head;
    }

    private void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    private Node deleteGivenNode(Node head, int givenNode) {
        if (head == null)
            return null;
        Node current = head;
        Node prev = null;
        while (current != null) {
            if (current.data == givenNode)
                break;
            prev = current;
            current = current.next;
        }
        prev.next = current.next;
        return head;
    }

    private Node reverseList(Node head) {
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

    private Node reverseListInBlock(Node head, int k){
        if(head == null)
            return head;
        Node prev = null;
        Node current = head;
        Node next = null;
        int counter =0;
        while (counter++ < k && current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        if (next != null) {
            head.next = reverseListInBlock(next, k);
        }
        return prev;
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
        Test obj = new Test();
        head = obj.insertNodeAtBegining(head, 0);
        obj.printList(head);
        head = obj.insertNodeAtEnd(head, 14);
        obj.printList(head);
        head = obj.insertNodeInMiddle(head, 100);
        obj.printList(head);
        head = obj.insertAfterAGivenNode(head, head.next.next.next.next.next.next.next, 111);
        obj.printList(head);
        head = obj.deleteGivenNode(head, 9);
        obj.printList(head);
        head = obj.reverseList(head);
        obj.printList(head);
        head = obj.reverseListInBlock(head, 3);
        obj.printList(head);

        // head = obj.insertNodeAtEnd(head, 14);
        // head = obj.insertNodeAtBegining(head, 0);
        // head = obj.insertAfterGivenNode(head, 20, 7);
        // head = obj.insertInMiddle(head, 40);
        // obj.printList(head);
        // head = obj.reverseLinkList(head);
        // System.out.println();
        // obj.printList(head);
        // head = obj.reverseLinkListInGroups(head, 3);
        // System.out.println();
        // obj.printList(head);

    }
}
