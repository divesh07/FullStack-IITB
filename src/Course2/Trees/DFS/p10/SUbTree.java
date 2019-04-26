package DFS.p10;


import java.util.Scanner;
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

    int preIndex = 0;

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

    /* This funtcion is here just to test buildTree() */
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

    boolean areIdentical(Node root1, Node root2)
    {

        /* base cases */
        if (root1 == null && root2 == null)
            return true;

        if (root1 == null || root2 == null)
            return false;

        /* Check if the data of both roots is same and data of left and right
           subtrees are also same */
        return (root1.value == root2.value
                && areIdentical(root1.leftchild, root2.leftchild)
                && areIdentical(root1.rightchild, root2.rightchild));
    }

    /* This function returns true if S is a subtree of T, otherwise false */
    boolean isSubtree(Node T, Node S)
    {
        // Write the logic to determine if Tree S is subtree of Tree N
        /* base cases */
        if (S == null)
            return true;

        if (T == null)
            return false;

        /* Check the tree with root as current node */
        if (areIdentical(T, S))
            return true;

        /* If the tree with root as current node doesn't match then
           try left and right subtrees one by one */
        return isSubtree(T.leftchild, S)
                || isSubtree(T.rightchild, S);
    }
}
class SUbTree{

    // driver program to test above functions
    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        int len1 = scanner.nextInt();
        int in1[] = new int[len1];
        int pre1[] = new int[len1];
        for(int i=0;i<len1;i++){
            in1[i] = scanner.nextInt();
        }
        for(int i=0;i<len1;i++){
            pre1[i] = scanner.nextInt();
        }
        int len2 = scanner.nextInt();
        int in2[] = new int[len2];
        int pre2[] = new int[len2];
        for(int i=0;i<len2;i++){
            in2[i] = scanner.nextInt();
        }
        for(int i=0;i<len2;i++){
            pre2[i] = scanner.nextInt();
        }
        BinaryTree tree1 = new BinaryTree();
        BinaryTree tree2 = new BinaryTree();
        Node root1 = tree1.constructTree(in1, pre1, 0, len1 - 1);
        Node root2 = tree2.constructTree(in2, pre2, 0, len2 - 1);

        if (tree1.isSubtree(root1, root2))
            System.out.println("Tree 2 is a subtree of Tree 1 ");
        else
            System.out.println("Tree 2 is not a subtree of Tree 1");
    }
}


