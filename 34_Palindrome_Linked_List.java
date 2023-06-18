//leetcode - 
//approach1: we can copy the elements in the LL to an Array and the performe the general palindrome check 
// Time Complexity: O(N) -  the subsequent 'for loop' compares the values in arr from both ends until the middle. 
// It performs N/2 iterations. Each iteration involves accessing elements in arr by index, which takes O(1) time for ArrayList
// Space Complexity: O(N) - using ArrayList with n elements
class Solution {
    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> arr=new ArrayList<>();
    while(head != null) {
        arr.add(head.val);
        head = head.next;
    }
    for(int i=0;i<arr.size()/2;i++) 
        if(arr.get(i) != arr.get(arr.size()-i-1)) return false;
    return true;
    }
}

//coding ninjas
//approach - get middle by tortoise method(so finally we know the middle element), now reverse the secode half(slow.next) 
// and just compare head(first half) with the reversed half 
// Time Complexity: O(N/2)+O(N/2)+O(N/2)
// Space Complexity: O(1) - No extra data structures are used.
public class Solution {

  // reversing the LL - O(n/2)
	static LinkedListNode reverse(LinkedListNode ptr) {
        LinkedListNode pre = null;
        LinkedListNode nex = null;
        while (ptr != null) {
            nex = ptr.next;
            ptr.next = pre;
            pre = ptr;
            ptr = nex;
        }
        return pre;
    }

    public static boolean isPalindrome(LinkedListNode<Integer> head) {
        if (head == null || head.next == null)
            return true;

        LinkedListNode<Integer> slow = head;
        LinkedListNode<Integer> fast = head;

        // getting middle of the LL - O(n/2)
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        slow.next = reverse(slow.next);
        slow = slow.next;
        LinkedListNode<Integer> dummy = head;

        // checking for palandrome condition - O(n/2)
        while (slow != null) {
            if (!dummy.data.equals(slow.data))
                return false;
            dummy = dummy.next;
            slow = slow.next;
        }
        return true;
    }
}
