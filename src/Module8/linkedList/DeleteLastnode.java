package linkedList;

import java.util.Scanner;

public class DeleteLastnode {

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
        deleteLastNode();
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    // Method to delete the first node of the LinkedList
    static void deleteLastNode() {
        // Write your code here
        if (head == null)
            return;

        Node temp1 = head;
        Node temp2 = temp1.next;
        if(temp2 == null){
            head = null;
            return;
        }
        while(temp2.next !=null){
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        temp1.next = null;
        temp2 = null;
    }

}
