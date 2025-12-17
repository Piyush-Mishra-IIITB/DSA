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
// finding middle leetcode -876
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
    public ListNode middleNode(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
}
// detect a cycle -leetcode 141
//hashmap approach

public class Solution {
    public boolean hasCycle(ListNode head) {
        HashMap<ListNode,Integer> hm = new HashMap<>();
        ListNode temp=head;
        while(temp!=null){
            if(hm.containsKey(temp)){
                return true;
            }
            hm.put(temp,1);
            temp=temp.next;
        }
        return false;
    }
}
// 2nd approach of detecting a cycle in LL (using slow fast pointer)


public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next !=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }
}
// finding starting point of cycle-leetcode 142
public class Solution {
    public ListNode detectCycle(ListNode head) {

        HashSet<ListNode> set = new HashSet<>();
        ListNode temp = head;

        while (temp != null) {
            if (set.contains(temp)) {
                return temp; 
            }
            set.add(temp);
            temp = temp.next;
        }

        return null; 
    }
}
//deleting middle node usign slow fast pointer


 class Solution {
    public ListNode deleteMiddle(ListNode head) {

        if (head == null || head.next == null) {
            return null;
        }

     ListNode prev=null;
     ListNode slow=head;
     ListNode fast=head:
     while(fast!=null && fast.next!=null){
        fast=fast.next.next;
        prev=slow;
        slow=slow.next;
     }
    slow.next=slow.next.next;
      return head;
    }}
// reverse in group-leetcode 25
class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode temp = head;
        ListNode prevNode = null;

        while (temp != null) {

            ListNode kth = find(temp, k);
            if (kth == null) {
                if (prevNode != null) {
                    prevNode.next = temp;
                }
                break;
            }

            ListNode nextNode = kth.next;
            kth.next = null;

            ListNode newHead = reverse(temp);

            if (temp == head) {
                head = newHead;
            } else {
                prevNode.next = newHead;
            }

            prevNode = temp; 
            temp = nextNode;
        }

        return head;
    }
    public static ListNode find(ListNode temp, int k) {
        while (temp != null && k > 1) {
            temp = temp.next;
            k--;
        }
        return temp;
    }
    public static ListNode reverse(ListNode head) {
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
// rotation by k of linkedlist-leetcode-61

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next ==null){
            return head;
        }
        ListNode tail=head;
        int counter=1;
        while(tail.next !=null){
            counter++;
            tail=tail.next;
        }
        k=k%counter;
        tail.next=head;
        ListNode newTail=find(head,counter-k-1);
        head=newTail.next;
        newTail.next=null;
        return head;
    
    }
    public static ListNode find(ListNode head,int k){
        while(k!=0 && head !=null){
            k--;
            head=head.next;
        }
        return head;
    }}
    // merge 2 linkedlist


 class Solution {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        int c1 = 0, c2 = 0;
        ListNode t1 = list1, t2 = list2;

        while (t1 != null) {
            c1++;
            t1 = t1.next;
        }
        while (t2 != null) {
            c2++;
            t2 = t2.next;
        }

        int[] arr = new int[c1 + c2];
        int idx = 0;

        t1 = list1;
        while (t1 != null) {
            arr[idx++] = t1.val;
            t1 = t1.next;
        }

        t2 = list2;
        while (t2 != null) {
            arr[idx++] = t2.val;
            t2 = t2.next;
        }
        Arrays.sort(arr);

        return arrayToLinkedList(arr);
    }

    public static ListNode arrayToLinkedList(int[] arr) {
        if (arr.length == 0) return null;

        ListNode head = new ListNode(arr[0]);
        ListNode curr = head;

        for (int i = 1; i < arr.length; i++) {
            curr.next = new ListNode(arr[i]);
            curr = curr.next;
        }
        return head;
    }
}
// sort the linkedlis brute force-leetcode 148

 import java.util.*;
class Solution {
    public ListNode sortList(ListNode head) {
        ListNode temp=head;
        int counter=0;
        while(temp!=null){
            counter++;
            temp=temp.next;
        }
        int arr[]=new int [counter];
        int a=0;
        ListNode temp1=head;
        while(temp1!=null){
            arr[a]=temp1.val;
            temp1=temp1.next;
            a++;
        }
        Arrays.sort(arr);
        return arrayToLinkedList(arr);
    }
    public static ListNode arrayToLinkedList(int[] arr) {
        if (arr.length == 0) return null;

        ListNode head = new ListNode(arr[0]);
        ListNode curr = head;

        for (int i = 1; i < arr.length; i++) {
            curr.next = new ListNode(arr[i]);
            curr = curr.next;
        }
        return head;
    }
}
// leetcode 23

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < lists.length; i++) {
            ListNode curr = lists[i];
            while (curr != null) {
                arr.add(curr.val);
                curr = curr.next;
            }
        }
        if (arr.size() == 0) return null;
        Collections.sort(arr);
        return arrToList(arr);
    }

    private ListNode arrToList(ArrayList<Integer> arr) {
        ListNode head = new ListNode(arr.get(0));
        ListNode temp = head;

        for (int i = 1; i < arr.size(); i++) {
            temp.next = new ListNode(arr.get(i));
            temp = temp.next;
        }

        return head;
    }
}
// leetcode -23 without using array
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
    if (lists == null || lists.length == 0) return null;
   ListNode head= (lists[0]);
   for(int i=1;i<lists.length;i++){
    head=merge(head,lists[i]);
   }  
   return head;
    }
    public static ListNode merge(ListNode l1,ListNode l2){
        ListNode dummy= new ListNode(-1);
        ListNode curr=dummy;
        while(l1 !=null && l2 !=null){
        if(l1.val>l2.val){
            curr.next=l2;
            curr=l2;
            l2=l2.next;
        }else{
            curr.next=l1;
            curr=l1;
            l1=l1.next;
        }}
        if(l1!=null){curr.next=l1;}
        else{
            curr.next=l2;
        }
        return dummy.next;
    }

}
// leetcode 138


class Solution {
    public Node copyRandomList(Node head) {
        Node temp=head;
        HashMap <Node,Node> hm =new HashMap<>();
        while(temp!=null){
            Node newNode=new Node(temp.val);
            hm.put(temp,newNode);
            temp=temp.next;
        }
        temp=head;
        while(temp!=null){
            Node currNode=hm.get(temp);
            currNode.next=hm.get(temp.next);
            currNode.random=hm.get(temp.random);
            temp=temp.next;
        }
        return hm.get(head);
    }
}
