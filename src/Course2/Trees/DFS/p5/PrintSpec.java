package DFS.p5;

//print all the nodes in the binary tree that are smaller than the given number ‘n’ and are prime numbers.

import java.util.*;
class Node{

    int data;

    Node left,right;

    Node(int data){

        this.data = data;
        left = null;
        right = null;
    }

    public String toString(){
        return data+"";
    }
}

class Tree{

    Node root;

    static boolean flag = false;

    Tree(int data){
        root = new Node(data);
    }

    //Method to print nodes that are prime and are smaller than the key
    public void printNode(Node node, int key){
        //Write your code here
        if ( node == null)
            return;
        if ( check(node.data, key)) {
            flag = true;
            System.out.print(node.data + " ");
        }
        printNode(node.left, key);
        printNode(node.right, key);

    }

    public boolean isPrime(int data) {
        // Check from 2 to n-1
        for (int i = 2; i < data; i++) {
            if (data % i == 0)
                return false;
        }
        return true;
    }

    //This method checks if a number is prime and is less than the key or not
    public boolean check(int data,int key){
        if (data <= 1)
            return false;

        if ( key <= data ) {
            return false;
        }

        return isPrime(data);

    }
    //Method to check if at least one such node exists or not
    public void found(){
        //Write your code here
        if(!flag){
            System.out.println(false);
        }
    }
}

public class PrintSpec{

    public static void main(String[] x){

        Tree tree = new Tree(5);

        tree.root.left = new Node(3);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(2);
        tree.root.right = new Node(10);
        tree.root.right.right = new Node(0);

        Scanner sc = new Scanner(System.in);

        int key = sc.nextInt();
        tree.printNode(tree.root,key);
        tree.found();
    }
}

