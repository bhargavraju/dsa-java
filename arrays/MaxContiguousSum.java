/*
Find the contiguous sub array within an array, A of length N which has the largest sum.

Input Format:

The first and the only argument contains an integer array, A.
Output Format:

Return an integer representing the maximum possible sum of the contiguous sub array.
Constraints:

1 <= N <= 1e6
-1000 <= A[i] <= 1000
For example:

Input 1:
    A = [1, 2, 3, 4, -10]

Output 1:
    10

Explanation 1:
    The sub array [1, 2, 3, 4] has the maximum possible sum of 10.

Input 2:
    A = [-2, 1, -3, 4, -1, 2, 1, -5, 4]

Output 2:
    6

Explanation 2:
    The sub array [4,-1,2,1] has the maximum possible sum of 6. 
*/


package arrays;

import java.util.List;

public class MaxContiguousSum {
	
	// Array Solution
	
    public int maxSubArray(final int[] A) {
        int maxSum = Integer.MIN_VALUE, currSum = 0;
        for(int i = 0; i < A.length; i++){
            currSum += A[i];
            maxSum = Math.max(maxSum, currSum);
            if(currSum < 0){
                currSum = 0;
            }
        }
        return maxSum;
    }
    
    // ArrayList Solution
    
    public int maxSubArray(final List<Integer> A) {
        int maxSum = Integer.MIN_VALUE, currSum = 0;
        for(int i = 0; i < A.size(); i++){
            currSum += A.get(i);
            maxSum = Math.max(maxSum, currSum);
            if(currSum < 0){
                currSum = 0;
            }
        }
        return maxSum;
    }

}
