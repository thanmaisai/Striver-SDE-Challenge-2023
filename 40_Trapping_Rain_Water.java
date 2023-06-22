// Approach:
//     Initialize two pointers, left and right, pointing to the first and last elements of the height array, respectively.
//     Initialize two variables, leftMax and rightMax, to keep track of the maximum height encountered from the left and right sides, initially set to 0.
//     Initialize a variable, result, to keep track of the total amount of water trapped, initially set to 0.
//     Use a while loop to iterate until the left pointer is less than or equal to the right pointer.
//     Check if the height at the left pointer is less than or equal to the height at the right pointer.
//         If true, update leftMax to the maximum of leftMax and the height at left.
//             * If the height at left is less than leftMax, it means there is a potential to trap water. Add the difference between leftMax and the height at left to result.
//             * Increment the left pointer.
//         If false, update rightMax to the maximum of rightMax and the height at right.
//             * If the height at right is less than rightMax, it means there is a potential to trap water. Add the difference between rightMax and the height at right to result.
//             * Decrement the right pointer.
//     Return the final value of result, which represents the total amount of water trapped.
// Time Complexity: O(N) because we are using 2 pointer approach.
// Space Complexity: O(1) because we are not using anything extra.

class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length-1;
        int leftMax=0;
        int rightMax = 0;
        int result = 0;
        while(left<=right){
            if(height[left]<=height[right]){
                if(height[left]>=leftMax){
                    leftMax=height[left];
                }else{
                    result=result+(leftMax-height[left]);
                }
                left++;
            }else{
                if(height[right]>=rightMax){
                    rightMax = height[right];
                }else{
                    result=result+(rightMax-height[right]);
                }
                right--;
            }
        }
        return result;
    }
}
