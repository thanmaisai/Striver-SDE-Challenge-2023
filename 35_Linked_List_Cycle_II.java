
public class Solution {
    public static Node firstNode(Node head) {
        // Write your code here.
        if(head==null || head.next==null){
            return null;
        }

        Node slow = head;
        Node fast = head;
        Node entry = head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(slow==fast){
                while(slow!=entry){
                    entry=entry.next;
                    slow=slow.next;
                }
                return entry;
            }
        }
        return null;
    }
}
