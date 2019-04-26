package linkedList;

import java.util.Scanner;

public class InsertNodeAtIndex {
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
        int index = s.nextInt();
        if (n<index){
            addAtEnd(k);
        }else {
            addAtGivenIndex(k, index);
        }
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    // Method to add the element at the front of the LinkedList
    static void addAtGivenIndex(int k, int index) {
        // Write your code here
        if ( head == null){
            head = new Node(k);
            head.next = null;
            return;
        }

        Node newNode = new Node(k);
        Node temp = head;
        if ( index == 0){
            head = newNode;
            newNode.next = temp;
            //head.next = temp.next;
            System.out.println(head.next + " " + head.data + " " + temp.data + " " + temp.next);
            return;
        }
        for(int i = 0 ; i < index -1  ; i++){
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Solution provided
    /*// Method to add the element at the given index of the LinkedList
    static void addAtGivenIndex(int k, int index) {
        if (head == null)
            head = new Node(k);
        else {
            Node temp = head;
            int i = 0;
            while (temp.next != null && i++ < index - 1)
                temp = temp.next;
            Node temp2 = new Node(k);
            temp2.next = temp.next;
            temp.next = temp2;
        }
    }
    */
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

