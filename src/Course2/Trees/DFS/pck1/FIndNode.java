package DFS.pck1;

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

    //Method to print all the nodes from a given node to the root node
    public boolean printNode(Node node, int data){

        //Write your code here
        if ( node == null)
            return false;

        if (node.data == data) {
            System.out.print(data + " ");
            return true;
        }

        if (printNode(node.left, data) || printNode(node.right, data)){
            System.out.print(node.data + " ");
            return true;
        }
        return false;
    }
}

class Source{

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

        tree.printNode(tree.root,number);
    }
}
