package com.java.linklist;

public class LinkListReverseInGroup {

    private Node reverse(Node head, int k) {
        try {
            if (head == null)
                return head;
            Node current = head;
            Node prev = null;
            Node next = null;
            int counter = 0;
            while (counter < k && current != null) {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
                counter++;
            }
            if (next != null) {
                head.next = reverse(next, k);
            }
            return prev;
        }
        catch (Exception e) {
            return null;
        }
    }

    private void printList(Node node) {
        while (node != null){
            System.out.print(node.data + "->");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        LinkListReverseInGroup obj = new LinkListReverseInGroup();
        head = obj.reverse(head, 3);
        obj.printList(head);
    }
}
