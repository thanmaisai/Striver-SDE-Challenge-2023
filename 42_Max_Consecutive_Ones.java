// approach1: 
//     Iterate through the nums array, count consecutive ones, and store the lengths in the arr list.
//     Find the maximum value in the arr list and return it as the result.
// Time Complexity: O(N) since the solution involves only a single pass.
// Space Complexity: O(N) because extra arraylist is used.

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        ArrayList<Integer> arr = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                arr.add(count);
                count = 0;
            }
        }
        arr.add(count);
        return Collections.max(arr);
    }
}

// approach2: optimised
// same a above explained but used an maxCount to store the max count everytime insted of adding them into an array and then getting the max of the arrlist
// Time Complexity: O(N) since the solution involves only a single pass.
// Space Complexity: O(1) because no extra space is used.
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount=0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                count = 0;
            }
        maxCount = Math.max(maxCount,count);
        }
        return maxCount;
    }
}
