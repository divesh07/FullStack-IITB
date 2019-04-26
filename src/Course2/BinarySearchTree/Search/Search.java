package Search;
import java.util.Scanner;

class Node {
    int value;
    Node leftchild, rightchild;
    Node(int item) {
        value = item;
        leftchild = rightchild = null;
    }
}

class BinaryTree {
    Node root;
    int count = 0;
    int giftAmount(Node root, int low, int high) {
        // Write your logic here
        if ( root == null || low == -1 || high == -1)
            return 0;
        if ( low < root.value){
            giftAmount(root.leftchild, low, high);
        }

        /* if root's data lies in range, then prints root's data */
        if (low <= root.value && high >= root.value) {
            count++;
        }

        /* If root->data is smaller than k2, then only we can get o/p keys
         in right subtree */
        if (high > root.value) {
            giftAmount(root.rightchild, low, high);
        }

        return count;
    }
}

public class Search {
    public static void main(String args[]) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(52);
        tree.root.leftchild = new Node(28);
        tree.root.leftchild.leftchild = new Node(14);
        tree.root.leftchild.leftchild.leftchild = new Node(7);
        tree.root.leftchild.leftchild.rightchild = new Node(21);
        tree.root.leftchild.rightchild = new Node(36);
        tree.root.leftchild.rightchild.leftchild = new Node(30);
        tree.root.leftchild.rightchild.rightchild = new Node(42);
        tree.root.rightchild = new Node(76);
        tree.root.rightchild.leftchild = new Node(62);
        tree.root.rightchild.rightchild = new Node(90);
        tree.root.rightchild.rightchild.leftchild = new Node(80);
        tree.root.rightchild.rightchild.rightchild = new Node(100);

        Scanner scanner = new Scanner(System.in);
        int firstNumber = scanner.nextInt();
        int secondNumber = scanner.nextInt();

        int low = firstNumber > secondNumber ? secondNumber : firstNumber;
        int high = firstNumber > secondNumber ? firstNumber : secondNumber;

        System.out.println(tree.giftAmount(tree.root, low, high));
    }
}