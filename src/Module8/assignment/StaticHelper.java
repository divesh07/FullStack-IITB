package assignment;

import java.util.Scanner;


 class StaticHelper {

    static Node head = null;

    static class Node {
        int data;
        Node next;

        Node(int n) {
            data = n;
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        if (n > 0) {
            head = new Node(s.nextInt());
        }
    }
}

