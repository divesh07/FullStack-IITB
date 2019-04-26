package PrintLevel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

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

    static int findMinIndex(List<Node> nodes){
        int min = nodes.get(0).level;
        for (Node node: nodes){
            if (node.level < min){
                min = node.level;
            }
        }
        return min;
    }
    Node root;

    static Node insertRec(Node root, List<Node> nodes) {
        // Write the logic to recreate the binary search tree.
        boolean found = false;
        if (nodes.size() <= 0)
            return null;

        // get Min index
        int min = findMinIndex(nodes);

        for (Node node : nodes) {
            if (node.level == min) {
                found = true;
                root = node;
                //nodes.remove(node);
                break;
            }
        }
        if (!found) {
            // since the root element is not found
            return null;
        }

        for (Node node : nodes) {
            if (node.level == min + 1 && node.value > root.value) {
                root.rightChild = node;
                //nodes.remove(node);
            } else if (node.level == min + 1 && node.value < root.value) {
                root.leftChild = node;
                //nodes.remove(node);
            }
        }


        for (Node node : nodes) {
            if (node.level == min + 2 && node.value > root.value) {
                if (node.level == min + 2 & node.value > root.rightChild.value) {
                    root.rightChild.rightChild = node;
                    //nodes.remove(node);
                } else if (node.level == min + 2 && node.value < root.rightChild.value) {
                    root.rightChild.leftChild = node;
                    //nodes.remove(node);
                }
            }else {
                if (node.level == min + 2 && node.value < root.value) {
                    if (node.level == min + 2 && node.value > root.leftChild.value) {
                        root.leftChild.rightChild = node;
                        //nodes.remove(node);
                    } else if (node.level == min + 2 && node.value < root.leftChild.value) {
                        root.leftChild.leftChild = node;
                        //nodes.remove(node);
                    }
                }
            }
        }
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

        Node root = null;
        root = insertRec(root, values);
        printPostorder(root);

    }
}

