package DFS.p8;

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

    //Method to find the largest element in the tree
    public int findMax(Node node){

        if(node == null){
            return -1;
        }

        int max = node.data;

        int x = findMax(node.left);

        int y = findMax(node.right);

        if(x>y){

            if(x>max){
                max = x;
            }
        }
        else{

            if(y>max){
                max = y;
            }
        }

        return max;
    }
}

class PrintMax{
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
        System.out.println(tree.findMax(tree.root));
    }
}
