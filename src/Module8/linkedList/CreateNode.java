package linkedList;

import java.util.Scanner;

public class CreateNode {
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
        // Lets create nodes
        Scanner s = new Scanner(System.in);
        int n = s.nextInt(); // how many nodes
        head = null;
        if ( n > 0){
            head = new Node(s.nextInt()); // create head node
            Node temp = head ; // both head and temp node are pointing to the first node
            for ( int i = 1; i < n ; i++){ // create remaining nodes
                temp.next = new Node(s.nextInt()); // New node created
                temp = temp.next; // temp points to the latest node
            }
        }
    }
}
