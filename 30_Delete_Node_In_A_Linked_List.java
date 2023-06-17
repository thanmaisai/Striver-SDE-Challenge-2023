public class Solution {
	public static void deleteNode(LinkedListNode<Integer> node) {
		// Write your code here.
        node.data = node.next.data; // copy that data of next in the specified node => nothing but override the node with next node data
        node.next= node.next.next; // since its specified that node to be deleted will never be at the last, thus we assing the next.next node to the node.next
        return;
	}
}
