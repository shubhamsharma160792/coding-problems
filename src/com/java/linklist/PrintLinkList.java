package com.java.linklist;

public class PrintLinkList {

    private void printList(Node head) {
        if(head == null)
            return;
        Node tempNode = head;
        while (tempNode != null) {
            System.out.print(tempNode.data + "->");
            tempNode = tempNode.next;
        }
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);
        PrintLinkList obj = new PrintLinkList();
        obj.printList(node);
    }

}
