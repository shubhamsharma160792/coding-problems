package com.java.linklist;

public class LinkListIntersection {

    private int getNodesCount(Node node) {
        int count = 0;
        while (node != null) {
            node = node.next;
            count++;
        }
        return count;
    }

    private Node doTask(Node a, Node b) {
        int countA = getNodesCount(a);
        int countB = getNodesCount(b);
        Node currentA = a;
        Node currentB = b;
        int diff = Math.abs(countA - countB);
        int counter = 0;
        if (countA > countB) {
            while (counter < diff) {
                currentA = currentA.next;
                counter++;
            }
        }
        else if (countA < countB) {
            while (counter < diff) {
                currentB = currentB.next;
                counter++;
            }
        }

        while (currentA != null && currentB != null) {
            if (currentA.equals(currentB))
                return currentA;
            currentA = currentA.next;
            currentB = currentB.next;
        }
        return null;
    }

    public static void main(String[] args) {
        LinkListIntersection obj = new LinkListIntersection();
        Node a = new Node(1);
        a.next = new Node(2);
        a.next.next = new Node(3);
        a.next.next.next = new Node(4);
        Node b = a.next.next;
        System.out.println(obj.doTask(a, b).data);
    }

}
