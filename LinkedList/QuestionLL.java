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
}
