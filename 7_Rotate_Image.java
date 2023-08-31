//TC: O(N*N)
//SC: O(1) // cuz inplace as specified in question
class Solution {
    public void rotate(int[][] matrix) {
       int len = matrix.length;
       //transpose
       for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
       // reverse rows
       for(int i=0;i<len;i++){
           for(int j=0;j<len/2;j++){
               int temp = matrix[i][j];
               matrix[i][j] = matrix[i][len-1-j];
               matrix[i][len-1-j] = temp;
           }
       }
    }
}
