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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        //1. reach node at position "left"
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode leftPrev = dummy;
        ListNode curr = head;

        for(int i =0; i<left-1; i++){
            leftPrev = curr;
            curr = curr.next;
        }
        

        //2. reverse from left to right
        //now curr = "left" & leftPrev = "node before left"
        ListNode prev = null;
        for(int i =0; i<(right-left)+1; i++){
            ListNode temp = curr.next;
            curr.next = prev ;
            prev = curr;
            curr = temp; 
        }

        //3. update pointers
        leftPrev.next.next = curr; //curr -> node after right
        leftPrev.next = prev; //prev -> right

        return dummy.next;
    }
}