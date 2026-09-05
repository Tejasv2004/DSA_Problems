class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null) return null;
    ListNode vSlow = head;
    ListNode slow = head;
    ListNode fast = head;
    for(int i =1;i <= n;i++){
        fast = fast.next;
        if(fast == null){
            head = slow.next;
            return head;
        }
    }
    while(fast != null){
      vSlow = slow;
      slow = slow.next;
      fast = fast.next;  
    }
    vSlow.next = slow.next;
    return head;
    }
}