package Graded;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Arrays;

class Node
{
    int value;
    Node leftchild, rightchild;
    Node(int item)
    {
        value = item;
        leftchild = rightchild = null;
    }
}

class BinaryTree
{
    Node root;
    static int preIndex = 0;
    static int index=0;
    Node constructTree(int in[], int pre[], int inStrt, int inEnd)
    {
        if (inStrt > inEnd)
            return null;
        Node tNode = new Node(pre[preIndex++]);
        if (inStrt == inEnd)
            return tNode;
        int inIndex = search(in, inStrt, inEnd, tNode.value);
        tNode.leftchild = constructTree(in, pre, inStrt, inIndex - 1);
        tNode.rightchild = constructTree(in, pre, inIndex + 1, inEnd);
        return tNode;
    }

    int search(int arr[], int strt, int end, int value)
    {
        int i;
        for (i = strt; i <= end; i++)
        {
            if (arr[i] == value)
                return i;
        }
        return i;
    }

    int sumBinaryTree(Node node)
    {
        // Write the logic to recursively create Binary Tree consisting of sum of all its children
        // Base cases
        if (node == null)
            return 0;
        if (node.leftchild == null && node.rightchild == null)
            return node.value;

        // Update left and right subtrees
        int leftsum = sumBinaryTree(node.leftchild);
        int rightsum = sumBinaryTree(node.rightchild);

        // Add sum of left and right to current node
        node.value = node.value +  leftsum + rightsum;

        // Return sum of values under root
        return node.value;
    }

    void printPostorder(Node node)
    {
        if (node == null)
            return;

        // first recur on left subtree
        printPostorder(node.leftchild);

        // then recur on right subtree
        printPostorder(node.rightchild);

        // now deal with the node
        System.out.print(node.value + " ");
    }

    void inOrder(Node node,int inSumTree[]) {
        if (node == null)
            return;

        /* first recur on left child */
        inOrder(node.leftchild, inSumTree);

        /* then print the data of node */
        inSumTree[index] = node.value;
        index++;
        //System.out.print(node.value + " ");

        /* now recur on right child */
        inOrder(node.rightchild,inSumTree);
    }

    Node ArrayToBST(int arr[], int start, int end) {

        /* Base Case */
        if (start > end) {
            return null;
        }

        /* Get the middle element and make it root */
        int mid = (start + end) / 2;
        Node node = new Node(arr[mid]);

        /* Recursively construct the left subtree and make it
         left child of root */
        node.leftchild = ArrayToBST(arr, start, mid - 1);

        /* Recursively construct the right subtree and make it
         right child of root */
        node.rightchild = ArrayToBST(arr, mid + 1, end);

        return node;
    }
}
class Source{

    // driver program to test above functions
    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int in[] = new int[len];
        int pre[] = new int[len];
        for(int i=0;i<len;i++){
            in[i] = scanner.nextInt();
        }
        for(int i=0;i<len;i++){
            pre[i] = scanner.nextInt();
        }
        BinaryTree tree = new BinaryTree();
        Node root = tree.constructTree(in, pre, 0, len - 1);
        tree.sumBinaryTree(root);
        int inSumTree[] = new int[len];
        tree.inOrder(root, inSumTree);
        Arrays.sort(inSumTree);
        Node bstRoot = tree.ArrayToBST(inSumTree, 0, len-1);
        tree.printPostorder(bstRoot);

    }
}
