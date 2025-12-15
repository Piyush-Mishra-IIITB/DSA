package LinkedList;

public class DLL {
    //structure
    public static class Node{
        int data;
        Node next;
        Node prev;
        public Node(int data){
            this.data=data;
            this.next= null;
            this.prev= null;
        }
    }
    // reverse of dll
    //1.st approach-use stack(Lifo property)
    public static Node reverse(Node head){
        if(head==null||head.next==null){
            return head;
        }
        Node last=null;
        Node temp=head;
        while(temp!=null){
            last=temp.prev;
            temp.prev=temp.next;
            temp.next=last;

            temp=temp.prev;
        }
        return last.prev;
    }
}

