//approach1: 
// we create a HashMap to store the original nodes as keys and their corresponding cloned nodes as values.
// We iterate through the original linked list and create a clone of each node. We store the original node as the key and the cloned node as the value in the HashMap.
// After creating all the cloned nodes, we iterate through the original linked list again and set the next and random pointers for each cloned node by looking up the corresponding nodes in the HashMap.
// Finally, we return the cloned head node by retrieving it from the HashMap using the original head node.

// Time Complexity: O(N)+O(N) - Two iterations over the entire list. Once for inserting in the map and other for linking nodes with next and random pointer.
// Space Complexity: O(N) - Use of hashmap for storing entire data.
public class Solution {
	public static LinkedListNode<Integer> cloneRandomList(LinkedListNode<Integer> head) {
		// Write your code here.
		//create a HashMap - store the original nodes as keys and their corresponding cloned nodes as values.
		HashMap<LinkedListNode,LinkedListNode> hashMap = new HashMap<>();
		LinkedListNode currNode = head;

    //create a clone of each node. We store the original node as the key and the cloned node as the value 
		while(currNode!=null){
			LinkedListNode newNode = new LinkedListNode(currNode.data); // store data of original node in newNode 
			hashMap.put(currNode,newNode); // put both the org node and data of that node 
			currNode=currNode.next; 
		}

    //set the next and random pointers for each cloned node
		LinkedListNode temp=head;
		while(temp!=null){
			LinkedListNode node = hashMap.get(temp);
			node.next= (temp.next!=null)?hashMap.get(temp.next):null; 
			node.random= (temp.random!=null)?hashMap.get(temp.random):null; 
			temp=temp.next;
		}
		return hashMap.get(head); // return the cloned head from hashmap

	}
}

// approach2: 
// Step 1: Iterate through the original linked list and create a new cloned node for each original node. Insert the cloned nodes right after their corresponding original nodes.
// Step 2: Iterate through the linked list again and set the random pointers of the cloned nodes. If an original node has a random pointer, set the random pointer of its corresponding cloned node to the next node after the random node.
// Step 3: Separate the original and cloned linked lists. Restore the original linked list by removing the cloned nodes from the list. Also, create a dummy node to keep track of the new head of the cloned linked list.
// Finally, return the cloned linked list by returning the next node of the dummy node.
// Time Complexity: O(N)+O(N)+O(N) - Each step takes O(N) of time complexity.
// Space Complexity: O(1)


public class Solution {
	public static LinkedListNode<Integer> cloneRandomList(LinkedListNode<Integer> head) {
    if (head == null)
        return null;
    
    // Step 1: Create cloned nodes and insert them after the original nodes
    LinkedListNode<Integer> currNode = head;
    while (currNode != null) {
        LinkedListNode<Integer> newNode = new LinkedListNode<>(currNode.data); // create a new node with current node data
        newNode.next = currNode.next; // make current node next to new node next
        currNode.next = newNode; // assign new node to current next 
        currNode = newNode.next; // just iterate through the main node not the new node's 
    }

    // Step 2: Set random pointers for the cloned nodes
    LinkedListNode<Integer> itr = head;
    while (itr != null) { 
        if (itr.random != null) {
            itr.next.random = itr.random.next; // assign the random pointers to the respective deep copies
        }
        itr = itr.next.next; // just iterate through the main node not the new node's 
    }
    
    // Step 3: Separate the original and cloned linked lists
    LinkedListNode<Integer> dummy = new LinkedListNode<>(0);
    LinkedListNode<Integer> temp = dummy; // using temp as we can return dummy.next as head at last 
    itr = head; 
    while (itr != null) {
        temp.next = itr.next; // dummy nodes head is pointing to deep copy of the original list
        itr.next = itr.next.next; // now remove the link btw deep copy and the current node and connect it with next main node
        
      // increment both the node for next node
        temp = temp.next; 
        itr = itr.next;
    }
    
    return dummy.next;
}
}
