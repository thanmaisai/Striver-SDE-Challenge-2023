public class Solution
{
    public static Node removeKthNode(Node head, int K)
    {
        // Write your code here.  
        Node start = new Node();
         // assign start before the first node
        start.next = head;

        Node slow = start;
        Node fast = start;
        // iterate the fast till the given key(n) 
        for(int i=0;i<K;i++){
            fast = fast.next;
        }

       // now until fast is null iterate both fast and slow by one step
        while(fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }

        slow.next=slow.next.next; // now shift the node by 1
        return start.next; //return start.next to get the head in the base case
    }
}
