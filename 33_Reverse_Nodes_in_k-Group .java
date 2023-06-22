
public class Solution {
	public static Node getListAfterReverseOperation(Node head, int n, int b[]) {
       // Write your code here.
      head = reverse(head,0,b);
      return head;
  }
  static Node reverse(Node head,int i,int[] b) {
      if (i>=b.length)
          return head;
      Node curr=head,prev=null,next=null;
      int counter = 0;
      int k = b[i];
      if (k==0) {
          head = reverse(head, i+1, b);
          return head;
      }  
      while (curr!=null && counter<k) {
         next = curr.next;
         curr.next = prev;
         prev = curr;
         curr = next;
         counter++;
     }
     if (next!=null) {
         head.next = reverse(next, i+1, b);
     }
     return prev;
  }

}
