package linkedList.gradedTest;

import java.util.Scanner;

public class FindNodefromEnd {
    static Node head;

    static class Node {
        int data;
        Node next;

        Node(int n) {
            data = n;
            next = null;
        }
    }

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        head = null;
        if (n > 0) {
            head = new Node(s.nextInt());
            Node temp = head;
            for (int i = 1; i < n; i++) {
                temp.next = new Node(s.nextInt());
                temp = temp.next;
            }
        }
        int k = s.nextInt();
        kthNodeFromEnd(k);
    }

    // Method to find kth element from the end in the LinkedList
    static void kthNodeFromEnd(int k) {
        // Write your code here
        if ( k <= 0 )
            return;

        int nodeCount = 0;
        Node temp = head;

        //count nodes
        while (temp != null)
        {
            temp = temp.next;
            nodeCount++;
        }

        if ( k > nodeCount) {
            System.out.println("Not Possible");
            return;
        }

        temp = head;

        for (int i = 1; i < nodeCount-k+1; i++)
            temp = temp.next;

        System.out.println(temp.data);

    }

    // Solution
    /*// Method to find kth element from the end in the LinkedList
    static void kthNodeFromEnd(int k) {
        Node temp = head;
        int i = 0;
        for (i = 0; i < k && temp != null; i++)
            temp = temp.next;
        if (temp == null && i != k)
            System.out.println("Not Possible");
        else {
            while (temp != null) {
                temp = temp.next;
                head = head.next;
            }
            System.out.println(head.data);
        }
    }*/
}
