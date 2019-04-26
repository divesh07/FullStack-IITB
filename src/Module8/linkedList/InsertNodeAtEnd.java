package linkedList;

import java.util.Scanner;

public class InsertNodeAtEnd {
    static Node head;

    static class Node{
        int data;
        Node next;
        Node(int n){
            data = n;
            next = null;
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        head = null;
        if ( n > 0){
            head = new Node(s.nextInt());
            Node temp = head;
            for ( int i = 1; i < n ; i ++){
                temp.next = new Node(s.nextInt());
                temp = temp.next;
            }
        }
        int k = s.nextInt();
        addAtEnd(k);
        while(head !=null){
            System.out.println(head.data + "");
            head = head.next;
        }
    }

    // Method to add the element at the end of the list
    static void addAtEnd(int k) {
        // Write your code here
        if ( head == null){
            head = new Node(k);
            return;
        }
        Node end = head;
        while(end.next!= null){
            end = end.next;
        }
        Node last = new Node(k);
        end.next = last;
        last.next = null;
    }
}
