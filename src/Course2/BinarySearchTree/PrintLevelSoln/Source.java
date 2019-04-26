package PrintLevelSoln;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.*;

class Source {

    public static class Node {

        int value;
        int level;
        Node leftChild;
        Node rightChild;

        Node(int item, int levelno) {
            value = item;
            level = levelno;
            leftChild = rightChild = null;
        }

    }

    Node root;

    static Node insertRec(Node root, Node node) {

        /* If the tree is empty, return a new node */
        if (root == null) {
            root = new Node(node.value, 1);
            return root;
        }

        /* Otherwise, recur down the tree */
        if (node.value < root.value)
            root.leftChild = insertRec(root.leftChild, node);
        else if (node.value > root.value)
            root.rightChild = insertRec(root.rightChild, node);
        return root;
    }

    static void printPostorder(Node node) {
        if (node == null)
            return;

        // first recur on left subtree
        printPostorder(node.leftChild);

        // then recur on right subtree
        printPostorder(node.rightChild);

        // now deal with the node
        System.out.print(node.value + " ");
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        List<Node> values = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            Node node = new Node(0, 0);
            node.level = sc.nextInt();
            values.add(node);
        }
        for (int i = 0; i < length; i++) {
            Node node = values.get(i);
            node.value = sc.nextInt();
        }
        /*
        This sorts the “values” arraylist by comparing the elements in the way
        specified in compare(Node o1, Node o2) method. By using this compare method
        the arraylist is sorted in level order and the elements in the same level
        are sorted in value order.
        */
        Collections.sort(values, new Comparator<Node>() {
            @Override public int compare(Node o1, Node o2) {
                if (o1.level < o2.level) {
                    return -1;
                } else if (o1.level > o2.level) {
                    return 1;
                } else {
                    if (o1.value < o2.value) {
                        return -1;
                    } else if (o1.value > o2.value) {
                        return 1;
                    }
                    return 0;
                }
            }
        });

        Node root = null;
        for (int i = 0; i < values.size(); i++) {
            root = insertRec(root, values.get(i));
        }
        printPostorder(root);

    }
}
