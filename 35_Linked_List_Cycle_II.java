// approach1: we can use a hashtable ans store each node occurance in the has table and once a LL is completely iterated and if we find a node which is 
// the start of the cycle the then as that node will be present in the hash table we will just return node.
// if we dont find the node and reach null then there is no cycle and return null;
// Time Complexity: O(N)
// Space Complexity: O(N) - for storing in hash table


// approach2: here we are using the tortoise method where we we use slow fast and entry node assigned to head
// here the fast move by next.next (2 steps) and slow move by next(1 step)
// there will be some point where the slow and fast meet 
// then from there until slow and entry meet keep incrementing both by next(one step) (entry start from head and slow start from the point where slow and fast meet)
// finally when both meet then return entry
// if not met then return null

// Time Complexity: O(N)
// Space Complexity: O(1)

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
