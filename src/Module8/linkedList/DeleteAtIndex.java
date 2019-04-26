package linkedList;

import java.util.Scanner;

public class DeleteAtIndex {
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
        int index = s.nextInt();
        if (n >= index ) {
            deleteNodeAtGivenIndex(index);
        }
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
    // Solution
    /*static void deleteNodeAtGivenIndex(int index) {
        if (head == null)
            return;
        else {
            Node temp = head;
            int i = 1;
            while (temp.next != null && i++ < index - 1)
                temp = temp.next;
            if (i == index && temp.next != null)
                temp.next = temp.next.next;
        }
    }*/


    // Method to delete the node at the given index of the LinkedList
    static void deleteNodeAtGivenIndex(int index) {
        // Write your code here
        if (head == null || index == 0)
            return;

        Node temp1 = head;
        if ( index == 1 ){
            // delete head
            head = temp1.next;
            temp1 = head;
            return;
        }
        Node temp2 = temp1.next;
        if(temp2 == null){
            head = null;
            return;
        }
        int nodeNumber = 1;
        while(temp2.next !=null && nodeNumber < index -1 ){
            nodeNumber++;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        temp1.next = temp2.next;
        temp2 = null;
    }
}
