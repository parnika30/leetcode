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
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode left = dummy;
        ListNode right = head;

        // Move right pointer n steps ahead
        while(n>0 && right!=null){
            right = right.next;
            n--;
        }

        // Move both pointers until right reaches the end
        while(right!=null){
            left = left.next;
            right = right.next;
        }

        // Skip the nth node from end
        left.next = left.next.next;
        return dummy.next; //returning the actual head
    }
}

//TC: O(N)