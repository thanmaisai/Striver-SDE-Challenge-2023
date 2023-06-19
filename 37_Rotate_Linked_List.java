// approach: 
// if node is null of has only one element in the list or rotate by k = 0 then retrurn head as it is null 
// count the elemnts in the list 
// do k%count - for cases where k is grater than count.
// now if the k=0 then there is no rotation thus return head
// loop till count-k and increment the currnode 
// then make the currnode.next = null as it will the end of the rotated list 
// create a newNode which will be the new head and act as the first part of the rotated list 
// assign the currnode to the newNode 
// loop till the end of the list until the new node is null 
// then finally assign the currNode's (the node points to the newNode/ the second half to be added first) last node to the existing head 
// finally return the newNode head - as it will be pointing to the head of the new rotated list

// Time Complexity : O(length of list) + O(length of list – (length of list%k))
// Space Complexity : O(1)

public class Solution {
    public static Node rotate(Node head, int k) {
        // Write your code here.
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        int count = 1;
        Node currNode = head;

        // Find the length of the linked list
        while (currNode.next != null) {
            currNode = currNode.next;
            count++;
        }

        k = k % count;

        if (k == 0) {
            return head;
        }

        currNode = head;

        // Traverse to the (count - k)th node
        for (int i = 1; i < count - k; i++) {
            currNode = currNode.next;
        }

        // The next node after the current node will be the new head of the rotated list
        Node newHead = currNode.next;

        // Set the next of the current node to null
        currNode.next = null;

        // Traverse to the end of the rotated list
        currNode = newHead;
        while (currNode.next != null) {
            currNode = currNode.next;
        }

        // Connect the end of the rotated list to the original head
        currNode.next = head;

        return newHead;
    }
}


// striver code - more simplified to read 
    if(head == null||head.next == null||k == 0) return head;
    //calculating length
    Node temp = head;
    int length = 1;
    while(temp.next != null) {
        ++length;
        temp = temp.next;
    }
    //link last node to first node
    temp.next = head;
    k = k%length; //when k is more than length of list
    int end = length-k; //to get end of the list
    while(end--!=0) temp = temp.next;
    //breaking last node link and pointing to NULL
    head = temp.next;
    temp.next = null;
        
    return head; 
