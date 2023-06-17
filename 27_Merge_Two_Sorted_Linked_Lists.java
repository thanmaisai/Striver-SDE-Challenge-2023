public class Solution {
    public static LinkedListNode<Integer> sortTwoLists(LinkedListNode<Integer> list1, LinkedListNode<Integer> list2) {
      // creating a new LL 
        LinkedListNode tempNode = new LinkedListNode(0);
      // pointing currNode to the head of the node
        LinkedListNode currentNode = tempNode;
        
        while (list1 != null && list2 != null) { // iterate through list and add the smallest element to the newlist
            if (list1.data < list2.data) { // if list1 < list2 then add list1 to the newlist (called currentNode) and increment list1
                currentNode.next = list1;
                list1 = list1.next;
            } else {
                currentNode.next = list2; // if list1 > list2 then add list2 to the newlist (called currentNode) and increment list2 
                list2 = list2.next;
            }
            currentNode = currentNode.next; //increment newlist node
        }
        
        if (list1 != null) { // if list1 has extra elemnts then just add them to currentNode
            currentNode.next = list1;
        }
        
        if (list2 != null) { // if list2 has extra elemnts then just add them to currentNode
            currentNode.next = list2;
        }
        
      // we r returning tempnode.next because the tempnode points to the first elemnt which is null/0 thus we return tempNode.next 
        return tempNode.next;
    }
}
