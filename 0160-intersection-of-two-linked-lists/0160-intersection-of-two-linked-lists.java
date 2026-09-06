public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
      int l1 =0,l2 = 0;
      for(ListNode temp1 = headA;temp1!=null;temp1 = temp1.next) {
        l1++;
      }
       for(ListNode temp2 = headB;temp2!=null;temp2 = temp2.next) {
        l2++;
      }
      ListNode temp1 = headA;
      ListNode temp2 = headB;
      if(l1 > l2){
        for(int i =1;i<= l1 - l2;i++){
            temp1 = temp1.next;
        }
      }
      else for(int i = 1;i <= l2 - l1;i++) temp2 = temp2.next;
      while(temp1 != temp2){
        temp1 = temp1.next;
        temp2 = temp2.next;
      }
     return temp1;
    }
}