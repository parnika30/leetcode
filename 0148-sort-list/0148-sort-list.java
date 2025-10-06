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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode a = head; // first half
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next; 
        }

        ListNode b = slow.next;
        slow.next = null;

        a = sortList(a);
        b = sortList(b);

        ListNode res = mergeLists(a,b);
        return res;
    }

    private ListNode mergeLists(ListNode a, ListNode b){
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        ListNode temp1 = a, temp2 = b; 
        while(temp1!=null && temp2!= null){
            if(temp1.val <= temp2.val){
                temp.next = temp1;
                temp1 = temp1.next;
            }else{
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if(temp1 == null) temp.next = temp2;
        if(temp2 == null) temp.next = temp1;

        return dummy.next;
    }
}

//1. find middle using fast slow
// 2. sort the list using the same sorlist using recursion 
// 3. merge list 