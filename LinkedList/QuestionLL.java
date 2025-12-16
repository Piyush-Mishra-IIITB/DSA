package LinkedList;

public class QuestionLL {
    //leetcode 2

    class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int carry = 0;
        ListNode dummyNode = new ListNode(-1);
        ListNode current = dummyNode;

        ListNode temp1 = l1;
        ListNode temp2 = l2;

        while (temp1 != null || temp2 != null) {
            int sum = carry;

            if (temp1 != null) {
                sum += temp1.val;
                temp1 = temp1.next;
            }

            if (temp2 != null) {
                sum += temp2.val;
                temp2 = temp2.next;
            }

            current.next = new ListNode(sum % 10);
            current = current.next;

            carry = sum / 10;
        }

        if (carry != 0) {
            current.next = new ListNode(carry);
        }

        return dummyNode.next;
    }
}
// leetcode 328
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode odd=head;
        ListNode even=head.next;
        ListNode evenHead=head.next;
        while(even !=null && even.next !=null){
            odd.next=odd.next.next;
            even.next=even.next.next;

            odd=odd.next;
            even=even.next;
        }
        odd.next=evenHead;
        return head;
    }
    
}
// sort the linkedlist of 0,1,2 in 1 pass
public static Node sort(Node head){
    if(head==null || head.next==null){
        return head;
    }
    Node oned=new Node(-1);
    Node twod=new Node(-1);
    Node zerod=new Node(-1);
    Node one= oned;
    Node two= twod;
    Node zero= zerod;
    Node temp=head;
    while(temp!=null){
        if(temp.data==0){
            zero.next=temp;
            zero=zero.next;
        }
        else if(temp.data==1){
            one.next=temp;
            one=one.next;
        }
        else{
            two.next=temp;
            two=two.next;
        }
        temp=temp.next;
    }
    two.next=null;
    one.next = twod.next;
    zero.next = oned.next != null ? oned.next : twod.next;

    return zerod.next;
}
}
// removal nth node from end

// using slow fast pointer
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null){
            return null;
        }
        if(head.next==null){
            if(n==1){
                return null;
            }
        }
        ListNode temp=head;
        int counter=0;
        while(temp!=null){
            counter++;
            temp=temp.next;
        }
        if(k==counter){
           return  head.next;
            
        }
        ListNode fast=head;
        ListNode slow=head;
        for(int i=0;i<n;i++){
            fast=fast.next;
        }
        while(fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;
        return head;
    }
}
// leetcode-206
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev=null;
        ListNode temp=head;
        while(temp!=null){
            ListNode front=temp.next;
            temp.next=prev;
            prev=temp;
            temp=front;
        }
        return prev;
    }
}
// palindrome of linkedlist
class Solution {
    public boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHalf = reverse(slow.next);
        ListNode firstHalf = head;

        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val) {
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
// plus one to linkedlist -leetcode 369

public static Node addOne(Node head){
    int carry=1;
    Node newHead=reverse(head);
    Node temp=newHead;
    while(temp!=null){
        temp.data=temp.data+carry;
        if(temp.data<10){
            carry=0;
            break;
        }
        temp.data=temp.data%10;
        carry=1;
        temp=temp.next;
    }
    if(carry==1){
        Node car=new Node(1);
        head=reverse(newHead);
        car.next=head;
        return car;
    }
    head=reverse(newHead);
    return head;
}
public static Node reverse(Node head){
    Node p=null;
    Node temp=head;
    while(temp!=null){
        Node forward=temp.next;
        temp.next=p;
        prev=temp;
        temp=forward;
    }
    return prev;
}
// intersection of 2 linkedlist leetcode-160
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp1=headA;
        ListNode temp2=headB;
        int c1=0;
        int c2=0;
        while(temp1 !=null){
            c1++;
            temp1=temp1.next;
        }
        while(temp2!=null){
            c2++;
            temp2=temp2.next;
        }
        if(c1<c2){
            return collisionpt(headB,headA,c2-c1);
        }else{
            return collisionpt(headA,headB,c1-c2);
        }
    }
    public static ListNode collisionpt(ListNode big,ListNode small,int distance){
        while(distance!=0){
            distance--;
            big=big.next;
        }
        while(big!=small){
            big=big.next;
            small=small.next;
        }
        return big;
    }
}