// approach: Brute Force
// use a hasset to store unique elements and the put these elemnets into an array and return the sie of the hashset 
// Time complexity: O(n*log(n))+O(n)
// Space Complexity: O(n) 

class Solution {
    public int removeDuplicates(int[] arr) {
        if(nums.length==0) return 0;
        HashSet < Integer > set = new HashSet < > ();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        int k=set.size();
        int j = 0;
        for (int x: set) {
            nums[j++] = x;
        }
        return k;
    }
}

// approach: Two pointers - (optimized)
//     1. Initialize a pointer i to keep track of the unique elements in the array. Start at the first element (index 0).
//     2. Iterate through the array using a pointer j, starting from the second element (index 1).
//     3. Compare the element at index i with the element at index j.
//     4. If they are not equal, it means a new unique element is found. Increment i and update the value at index i to be the element at index j.
//     5. Repeat steps 3-4 for the remaining elements in the array.
//     6. Finally, return i + 1 as the count of unique elements in the modified array.

class Solution {
    public int removeDuplicates(int[] arr) {
        int i = 0;
        for (int j = 1; j < arr.length; j++) {
            if (arr[i] != arr[j]) {
                i++;
                arr[i] = arr[j];
            }
        }
        return i + 1;
    }
}
