// approach 1: - brute force
// use 3 for loope with i=0 and j=i+1 and k=j+1 till arr.length-1 
// in the innermost loop check if sum of elements in i,j,k == 0
// if yes then add them into new array list and then add that new arraylist to result arraylist 
// finally return result list
// Note: this method will list all the possiable arrays which sum will give 0 
// but as per the Q to get get only unique subarrays we can use a set to store them and finally return the set as list - to remove dublicated 
// Time Complexity : O(n^3)   // 3 loops
// Space Complexity : O(3*k)  // k is the no.of triplets
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
         List < List < Integer >> ans = new ArrayList < > ();
          for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    ArrayList < Integer > temp = new ArrayList < > ();
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                    }
                    if (temp.size() != 0)
                        ans.add(temp);
                }
            }
        }
        return ans;
    }
}

// to remove dublicated in the above approach - use a set 

// Time Complexity : O(n^3 * log(m))   // 3 loops + log(m) for putting elements in the set and comparing 
// Space Complexity : O(M)  // M be the elemnts in the set 

// approach2: optimised
//  1.   Sort the input array nums in ascending order.
//  2.   Create an empty list res to store the resulting triplets.
//  3.   Iterate through the array from index 0 to nums.length - 2.
//  4.   Check if the current index i is 0 or if the current number is different from the previous number.
//  5.   Initialize two pointers, lo and hi, with lo starting from i + 1 and hi starting from the end of the array.
//  6.   While lo is less than hi, do the following:
//         * If the sum of nums[i], nums[lo], and nums[hi] is equal to zero, add the triplet to the res list.
//         * Move lo to the next distinct number and move hi to the previous distinct number.
//         * Increment lo and decrement hi.
//         * If the sum is less than zero, increment lo; otherwise, decrement hi.
//  7.   After the loop finishes, return the res list containing all the valid triplets.
// Time Complexity : O(n^2)  
// Space Complexity : O(3*k)  // k is the no.of triplets.

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums); //(1)
        List<List<Integer>> res = new LinkedList<>(); 
        for(int i=0;i<nums.length-2;i++){
            if(i == 0 || (i>0 && nums[i]!=nums[i-1])){
                int lo = i+1,hi=nums.length-1,sum=0-nums[i];
            while(lo<hi){
                if( nums[lo] + nums[hi] == sum ){
                    res.add(Arrays.asList(nums[i],nums[lo],nums[hi]));

                    while(lo<hi && nums[lo]==nums[lo+1]) lo++;
                    while(lo<hi && nums[hi]==nums[hi-1]) hi--;
                    lo++;hi--;
                }
                else if(nums[lo]+nums[hi]<sum) lo++;
                else hi--;
            }
            }
        }
        return res;
    }
}
