/*
Given an array of integers, A of length N, find out the maximum sum sub-array of non negative numbers from A.
The sub-array should be contiguous i.e., a sub-array created by choosing the second and fourth element and skipping the third element is invalid.

Maximum sub-array is defined in terms of the sum of the elements in the sub-array.
Find and return the required sub array.

NOTE:

    1. If there is a tie, then compare with segment's length and return segment which has maximum length.
    2. If there is still a tie, then return the segment with minimum starting index.

Input Format:
The first and the only argument of input contains an integer array A, of length N.

Output Format:
Return an array of integers, that is a sub array of A that satisfies the given conditions.

Constraints:
1 <= N <= 1e5
1 <= A[i] <= 1e5

Examples:

Input 1:
    A = [1, 2, 5, -7, 2, 3]
Output 1:
    [1, 2, 5]
Explanation 1:
    The two sub-arrays are [1, 2, 5] [2, 3].
    The answer is [1, 2, 5] as its sum is larger than [2, 3].

Input 2:
    A = [10, -1, 2, 3, -4, 100]    
Output 2:
    [100]
Explanation 2:
    The three sub-arrays are [10], [2, 3], [100].
    The answer is [100] as its sum is larger than the other two.

 */

package arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxNonNegativeSubArray {
	
	// Array solution
	
    public int[] maxset(int[] A) {
        int n = A.length;
        int l = -1, r = -1;
        long maxSum = 0, currSum = 0;
        int currLeft = 0;
        for(int i = 0; i < n; i++){
            if(A[i] < 0){
                currSum = 0;
                currLeft = i+1;
                continue;
            }
            currSum += A[i];
            if((currSum > maxSum) || (currSum == maxSum && i-currLeft > r-l)){
                l = currLeft;
                r = i;
                maxSum = currSum;
            }
        }
        if(l == -1){
            return new int[]{};
        }else{
            return Arrays.copyOfRange(A, l, r+1);
        }
    }
    
    // ArrayList solution
    
    public ArrayList<Integer> maxset(ArrayList<Integer> A) {
        long currSum = 0, maxSum = 0;
        ArrayList<Integer> result = new ArrayList<Integer>();
        ArrayList<Integer> current = new ArrayList<Integer>();
        for(Integer i: A){
            if(i < 0){
                currSum = 0;
                current = new ArrayList<Integer>();
            }else{
                currSum += i;
                current.add(i);
            }
            if(currSum > maxSum || currSum == maxSum && current.size() > result.size()){
                result = current;
                maxSum = currSum;
            }
        }
        return result;
    }

}
