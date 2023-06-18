public class Solution {
    public static int findIntersection(Node firstHead, Node secondHead) {
        //Write your code here
        while(secondHead!=null){
            Node temp = firstHead;
            while(temp != null){
                if(secondHead == temp){ 
                // here we are not using .val/.data because we are comparing the nodes insted of directly comparing the data inside the node. thus if these node have same memory address then they are intersected
                    return secondHead.data;
                }
                temp = temp.next;
            }
                secondHead=secondHead.next;
        }
        return 0;
    }
}
