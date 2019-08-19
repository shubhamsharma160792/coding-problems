package com.java.linklist;

import com.java.linklist.InsertIntoLinkList.Node;

public class MergeTwoSortedLists {

    private Node doTaskRecursive(Node a, Node b) {
        if (a == null)
            return b;
        if (b == null)
            return a;
        if (a.data <= b.data) {
            a.next = doTaskRecursive(a.next, b);
            return a;
        }
        else {
            b.next = doTaskRecursive(a, b.next);
            return b;
        }
    }

    private Node doTaskUsingDummyNode(Node A, Node B) {
        Node currentA = A;
        Node currentB = B;
        Node fakeHead = new Node(0);
        Node head = fakeHead;
        while (currentA != null && currentB != null) {
            if (currentA.data <= currentB.data) {
                head.next = currentA;
                currentA = currentA.next;
            }
            else {
                head.next = currentB;
                currentB = currentB.next;
            }
            head = head.next;
        }
        if (currentA != null) {
            head.next = currentA;
        }
        if (currentB != null) {
            head.next = currentB;
        }
        return fakeHead.next;
    }

    private void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        MergeTwoSortedLists obj = new MergeTwoSortedLists();
        Node node1 = new Node(1);
        node1.next = new Node(2);
        node1.next.next = new Node(3);
        node1.next.next.next = new Node(4);
        node1.next.next.next.next = new Node(5);

        Node node2 = new Node(4);
        node2.next = new Node(5);
        node2.next.next = new Node(6);
        node2.next.next.next = new Node(7);
        node2.next.next.next.next = new Node(8);
        Node head = obj.doTaskRecursive(node1, node2);
        obj.printList(head);
        Node head2 = obj.doTaskUsingDummyNode(node1, node2);
        System.out.println();
        obj.printList(head2);

    }

}
