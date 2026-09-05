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
    public ListNode swapNodes(ListNode head, int k) {
        if(head.next == null) return head;
       ListNode slow = head;
       ListNode fast = head;
       ListNode swap = head;
       for(int i =1;i <k;i++){
        fast = fast.next;
       } 
       slow = fast;
       
       while(fast.next != null){
         swap = swap.next;
         fast = fast.next;
       }
    //    for(int i =1;i < k;i++) swap = swap.next;
       int temp = swap.val;
       swap.val = slow.val;
       slow.val = temp;

       return head;
    }
}