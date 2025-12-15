package LinkedList;

public class Basic {

    // Node template
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;

    // Traverse Linked List
    public static void traverse(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Length of Linked List
    public static int length(Node head) {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    // Search in Linked List
    public static boolean search(Node head, int val) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == val) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public static void main(String[] args) {
        // Example usage
        head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);

        traverse(head);
        System.out.println("Length: " + length(head));
        System.out.println("Search 20: " + search(head, 20));
        System.out.println("Search 40: " + search(head, 40));
    }
}
