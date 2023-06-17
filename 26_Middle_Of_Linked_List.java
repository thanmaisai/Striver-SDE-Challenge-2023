
// first approach 
//here we are using 2 loops- one for n and the another for n/2
//thus now based on this the time complexity is = O(n)+O(n/2)
//thus the better approach to follow is to use the fast and slow tortoise approach 
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode currNode = head;
        int size=0;
        while(currNode !=null){
            currNode=currNode.next;
            size++;
        }
        // my size is the length of LL and half of that to get the middle node
        int half_size = size/2;
        //my currNode has reached the end when i was counting the array so now i will again assign the currNode head to start from first again 
        currNode = head;
        for(int i=0;i<half_size;i++){
              currNode=currNode.next;
        }
        return currNode;

    }
}


// Second Approach 
//here we are just looping n/2 thus the time complexity here is O(n/2)
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode node_jump_by1 = head;
        ListNode node_jump_by2 = head;
        // here the node_jump_by2 != null is for checking even length LL
        // here the node_jump_by2.next != null is for checking odd length LL
        while( node_jump_by2 != null && node_jump_by2.next != null){
             node_jump_by1 = node_jump_by1.next;
             node_jump_by2 = node_jump_by2.next.next;
        }
        return node_jump_by1;
    }
}
