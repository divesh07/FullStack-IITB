package DFS.pck4;

import java.util.*;

// Find the number of paths such that sum of all
// the nodes present in the path is equal to n. ﻿

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
    static int count = 0;
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

    //Method to find Nodes in tree
    public void findNode(Node node, int sum , int n){
        //Write your code here
        if ( node == null){
            return;
        }

        sum = sum + node.data;
        if ( sum == n  && node.left == null && node.right == null){
            count++;
            return;
        }

        findNode(node.left,sum,n);
        findNode(node.right, sum, n);
    }

    //Method to print number of paths
    public void printCount(Node node, int sum, int n){
        findNode(node,sum,n);
        System.out.print(count);
    }
}

public class Source{
    public static void main(String[] x){
        Tree tree = new Tree();
        List<Integer> l = new LinkedList<>();
        int size;
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();
        int[] elements = new int[size];
        for(int i = 0; i < size; i++){
            elements[i] = sc.nextInt();
        }
        tree.root = tree.insertNode(elements,tree.root,0);
        int number = sc.nextInt();
        tree.printCount(tree.root,0,number);
    }
}

