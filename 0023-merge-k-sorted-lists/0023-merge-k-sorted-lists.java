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
    public ListNode mergeKLists(ListNode[] lists) {
        //1.Create a PriorityQueue with a comparator for node values.
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a,b) -> a.val - b.val);

        //2.Add the first node of each non-empty list to the heap.
        for(ListNode node : lists){
            if(node!=null){
                heap.add(node);
            }
        }
        
        //3. While the heap isn’t empty: Poll the smallest node.
                                    // Add it to your merged list.
                                    // If it has a next node, add that to the heap.
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while(!heap.isEmpty()){
            ListNode node = heap.poll();
            tail.next = node; // attaches the next smallest node to your merged list.
            tail = node; //moves tail pointer forward, always points to the last node in your merged list.
            if(tail.next != null){
                heap.add(node.next);
            }
        }
        return dummy.next;
    }
}