package com.java.linklist;

public class Expedia {

    static class Node {
        private int  data;
        private Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private Integer lengthOfList(Node head) {
        if (head == null)
            return 0;
        int length = 0;
        Node node = head;
        while (node != null) {
            node = node.next;
            length++;
        }
        return length;
    }

    private boolean loopExists(Node head) {
        if (head == null)
            return false;
        Node slowNode = head;
        Node fastNode = head;
        while (slowNode != null && fastNode != null && fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
            if (slowNode == fastNode)
                return true;
        }
        return false;
    }

    private Node insertAtStart(Node head, int data) {
        Node newNode = new Node(data);
        if (head == null) {
            return newNode;
        }
        newNode.next = head;
        head = newNode;
        return head;
    }

    private Node insertAtEnd(Node head, int data) {
        Node newNode = new Node(data);
        if (head == null)
            return newNode;
        Node temp = head;
        Node current = null;
        while (temp != null) {
            current = temp;
            temp = temp.next;
        }
        current.next = newNode;
        newNode.next = null;
        return head;
    }

    private Node insertAtMiddle(Node head, int data) {
        Node newNode = new Node(data);
        int length = lengthOfList(head);
        Node prev = null;
        Node current = head;
        int i = 0;
        while (i <= length / 2) {
            prev = current;
            current = current.next;
            i++;
        }
        newNode.next = prev.next;
        prev.next = newNode;
        return head;
    }

    private Node addAfterAGivenNode(Node head, int data, int val) {
        Node current = head;
        Node prev = null;
        boolean found = false;
        while (current != null) {
            prev = current;
            current = current.next;
            if (prev.data == val) {
                found = true;
                break;
            }
        }
        if (!found) {
            return head;
        }
        else {
            Node newNode = new Node(data);
            newNode.next = prev.next;
            prev.next = newNode;
        }
        return head;
    }

    private void printList(Node head) {
        Node node = head;
        while (node != null) {
            System.out.print(node.data);
            node = node.next;
        }
        System.out.println();
    }

    private Node reverseList(Node head) {
        if (head == null)
            return head;
        Node current = head;
        Node prev = null;
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

    private Node reverseListInGroup(Node head, int k) {
        if (head == null)
            return head;
        Node current = head;
        Node prev = null;
        Node next = null;
        int counter = 0;
        while (current != null && counter < k) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            counter++;
        }
        if (next != null) {
            head.next = reverseListInGroup(next, k);
        }
        return prev;
    }

    public static void main(String[] args) {
        Expedia obj = new Expedia();
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        System.out.println(obj.lengthOfList(head));
        obj.printList(head);
        head = obj.insertAtStart(head, 0);
        obj.printList(head);
        obj.insertAtEnd(head, 4);
        obj.printList(head);
        head = obj.insertAtMiddle(head, 5);
        obj.printList(head);
        obj.addAfterAGivenNode(head, 6, 4);
        obj.printList(head);
        head = obj.reverseList(head);
        obj.printList(head);
        Node head2 = new Node(1);
        head2.next = new Node(2);
        head2.next.next = new Node(3);
        head2.next.next.next = new Node(4);
        head2.next.next.next.next = new Node(5);
        head2.next.next.next.next.next = new Node(6);
        obj.reverseListInGroup(head2, 3);
        obj.printList(head2);

    }

}
