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
    public void reorderList(ListNode head) {
        if(head == null || head.next==null) return;

        // 1. Find the middle
        ListNode slow = head, fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. reverse the sec half
        ListNode sec = reverseList(slow.next);
        slow.next = null;

        // 3. Merge two halves
        ListNode first = head;
        while(sec!=null){
            ListNode temp1 = first.next;
            ListNode temp2 = sec.next;
            first.next = sec;
            sec.next = temp1;
            first = temp1;
            sec = temp2;
        }

    }


    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while(curr!=null){
            ListNode temp = curr.next;
            curr.next = prev; 
            prev = curr;  
            curr = temp; 
        }
        return prev;
    }
}