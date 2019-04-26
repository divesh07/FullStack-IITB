package DFS.pck2;

import java.util.LinkedList;
import java.util.List;
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

    Tree(){
        root = null;
    }

    Tree(int data){
        root = new Node(data);
    }

    //Method to construct a binary tree from the given array
    public Node insertNode(int[] elements, Node node, int i){

        if(i < elements.length){
            node = new Node(elements[i]);

            node.left = insertNode(elements,node.left,2 * i + 1);

            node.right = insertNode(elements,node.right,2 * i + 2);
        }

        return node;
    }

    //Method to print nodes that are multiple of root node
    public void findNode(Node node){

        //Write your code here
        if (node == null)
            return;

        findNode(node.left);
        if ( check(node.data)) {
            System.out.print(node.data + " ");
        }
        findNode(node.right);


    }

    //Method to check if a value is divisible by root node or not
    public boolean check(int data){
        //Write your code here
        if ( data == 0)
            return false;
        return data%root.data == 0;
    }
}

class PrintInorder{

    public static void main(String[] x){

        Tree tree = new Tree();

        int size;

        Scanner sc = new Scanner(System.in);

        size = sc.nextInt();

        int[] elements = new int[size];


        for(int i = 0; i < size; i++){
            elements[i] = sc.nextInt();
        }

        tree.root = tree.insertNode(elements,tree.root,0);

        tree.findNode(tree.root);
    }
}