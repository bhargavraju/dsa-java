/*
Given an index k, return the kth row of the Pascal's triangle.

Pascal's Triangle : To generate A[C] in row R, sum up A'[C] and A'[C-1] from previous row R - 1.

Example:

Input : k = 3

Return : [1,3,3,1]
 NOTE : k is 0 based. k = 0, corresponds to the row [1].
Note:Could you optimize your algorithm to use only O(k) extra space?
 */


package arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class PascalTriangleKthRow {
	
	// Array solution
	
    public int[] getRow(int A) {
        int[] result = new int[A+1];
        Arrays.fill(result, 1);
        for(int i = 1; i < A; i++){
            result[i] = result[i-1]*(A-i+1)/i;
        }
        return result;
    }
    
    // ArrayList solution
    
    public ArrayList<Integer> getRowList(int A) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(1);
        for(int i = 1; i <= A; i++){
            int prev = result.get(i-1);
            result.add(prev*(A-i+1)/i);
        }
        return result;
    }

}
