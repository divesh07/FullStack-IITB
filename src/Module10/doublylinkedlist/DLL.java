package doublylinkedlist;

// Add a node after a given node:
// Reference : https://www.geeksforgeeks.org/doubly-linked-list/
public class DLL {
    static Node head = null;
    static class Node{
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    // Adding a node at the front of the list
    public static Node push(int new_data, Node head){
        Node new_node = new Node(new_data);
        new_node.next = head;
        new_node.prev = null;

        if (head != null) {
            head.prev = new_node;
        }
        head = new_node;
        return head;
    }
    // add node after a given node
    public static Node insertAfter(int new_data, Node head, int after_data){
        Node new_node = new Node(new_data);
        if ( head == null) {
            head = new_node;
            return head;
        }

        Node prev_Node = head;
        while(prev_Node.next != null && prev_Node.data != after_data ){
            prev_Node = prev_Node.next;
        }
        new_node.next = prev_Node.next;
        prev_Node.next = new_node;
        new_node.prev = prev_Node;

        return head;
    }

    // add node before a given node
    public static Node insertBefore(int new_data, Node head, int before_data){
        Node new_node = new Node(new_data);
        if ( head == null){
            return new_node;
        }

        Node before_Node = head;

        while(before_Node.next != null && before_Node.data != before_data ){
            before_Node = before_Node.next;
        }
        if ( before_Node.prev == null){
            head = new_node;
        }
        new_node.prev = before_Node.prev;
        new_node.next = before_Node;
        before_Node.prev = new_node;

        return head;
    }

    // Add a node at the end:
    public static Node addLast(Node head, int lastNode_data, int new_data){

        Node new_node = new Node(new_data);
        new_node.next = null;
        if ( head == null){
            head = new_node;
            return head;
        }

        Node lastNode = head;
        while(lastNode.next !=null){
            lastNode = lastNode.next;
        }
        new_node.prev = lastNode;
        lastNode.next = new_node;

        return head;

    }


    // print all nodes
    public static void printNodes(Node head){
        if ( head == null){
            System.out.println("no nodes found");
            return;
        }
        Node node = head;
        while(node !=null){
            System.out.println(node.data);
            node = node.next;
        }
    }

    public static void main(String[] args) {
        Node node = new Node(2);
        Node head = node;
        head = push(1, head);
        head = push(3, head);
        head= insertAfter(4,head,3);
        head = addLast(head,2,5);
        head = insertBefore(6,head,3);
        printNodes(head);
    }
}
