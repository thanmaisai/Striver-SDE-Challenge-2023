//Time Complexity: O(N)
//Space Complexity: O(1)
//approach: use the concept of merging the LL and recurssion
// iterate from left to right recurssively and then after reaching null merge the current nodes bottom(child) list with the previous nodes bottom(child)
// list, now as the whole process merges the bottom list of ech node with the heads bottom list thus return the head.


public class Solution {
    //merging two linked list
    static Node MergeTwoLinkedList(Node a,Node b){
        Node temp = new Node(0);
        Node result = temp;
        while(a!=null && b!=null){
         if(a.data<b.data){
             temp.child=a;
             temp=temp.child;
             a=a.child;
         }else{
             temp.child=b;
             temp=temp.child;
             b=b.child;
         }
        }
        if(a!=null){
            temp.child=a;
        }else{
            temp.child=b;
        }
        return result.child;
    }

    public static Node flattenLinkedList(Node head) {
        //Write your code here
        // when reached the last node of the next list return the node
        if(head == null || head.next == null){
            return head;
        }
      
        // recurssive go to last node of the nextList
        // recur for list on right 
        head.next = flattenLinkedList(head.next);
      
        // now merge 
        // merge the last list and last one but list
        head = MergeTwoLinkedList(head,head.next); // merge the with buttom list of 2 lists

         // return the root 
         // it will be in turn merged with its left 
        return head; 
    }
}
