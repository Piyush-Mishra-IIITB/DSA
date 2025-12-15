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
    // deletion
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
    // deletion-we did not need to delete manually 
    // the garbage collector takes away we need to change the position of head only
   public static Node deleteHead(Node head) {
    if (head == null) {
        return null;
    }
    return head.next;
}
public static Node deleteTail(Node head){
    if(head==null || head.next==null){
        return null;
    }
    Node temp=head;
    while(temp.next.next !=null){
        temp=temp.next;
    }
    temp.next=null;
    return head;
}
public static Node deletePosition(Node head,int k){
    if(head==null){
        return null;
    }
    if(k==1){
        return head.next;
    }
    int counter=0;
    Node prev=null;
    Node temp=head;
    while(temp!=null){
        counter++;
        if(counter==k-1){
            temp.next=temp.next.next;
            break;
        }
        prev=temp;
        temp=temp.next;
    }
    return head;
}
// insertion
public static Node first(Node head,int val){
    Node h=new Node(val);
    if(head==null){
        return h;
    }
    h.next=head;
    return h;
}
public static Node last(Node head,int val){
    Node h=new Node(val);
    if(head==null){
        return h;
    }
    Node temp=head;
    while(temp.next!=null){
        temp=temp.next;
    }
    temp.next=h;
    h.next=null;
    retrun head;
}
public static Node kthPosition(Node head,int val,int k){
     Node h=new Node(val);
     
     if(k==1){
        h.next=head;
        return h;
     }
     int count=0;
     Node temp=head;
     while(temp!=null){
        count++;
        if(count==k-1){
           h.next=temp.next;
            temp.next=h;
            break;
        }
        temp=temp.next;
     }
     return head;
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
