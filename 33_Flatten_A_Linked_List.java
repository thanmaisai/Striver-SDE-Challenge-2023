
public class Solution {
    public static Node flattenLinkedList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node left = head;
        Node right = head.next;
        head.next = null;
        right = flattenLinkedList(right);

        return merge(left, right);
    }

    public static Node merge(Node left, Node right) {
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

        Node dummy = new Node();
        Node tail = dummy;

        while (left != null && right != null) {
            if (left.data < right.data) {
                tail.child = left;
                left = left.child;
            } else {
                tail.child = right;
                right = right.child;
            }
            tail = tail.child;
        }

        if (left != null) {
            tail.child = left;
        }
        if (right != null) {
            tail.child = right;
        }

        return dummy.child;
    }
}
