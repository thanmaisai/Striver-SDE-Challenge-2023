public class Solution {
    public static LinkedListNode<Integer> reverseLinkedList(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> prev = null;
        LinkedListNode<Integer> current = head;
        LinkedListNode<Integer> next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
}
