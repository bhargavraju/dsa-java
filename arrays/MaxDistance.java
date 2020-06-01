/*
Given an array A of integers, find the maximum of j - i subjected to the constraint of A[i] <= A[j].
If there is no solution possible, return -1.

Example :
A : [3 5 4 2]

Output : 2 
for the pair (3, 4)
 
 */

package arrays;

import java.util.List;

public class MaxDistance {
	
	// Array solution
	
    public int maximumGap(final int[] A) {
        int n = A.length;
        if(n <= 1){
            return 0;
        }
        int[] leftMin = new int[n];
        int[] rightMax = new int[n];
        leftMin[0] = A[0];
        rightMax[n-1] = A[n-1];
        for(int idx = 1; idx < n; idx++){
            leftMin[idx] = Math.min(leftMin[idx-1], A[idx]);
        }
        for(int idx = n-2; idx >= 0; idx--){
            rightMax[idx] = Math.max(A[idx], rightMax[idx+1]);
        }
        int i = 0, j = 0, diff = -1;
        while(i < n && j < n){
            if(leftMin[i] <= rightMax[j]){
                diff = Math.max(diff, j-i);
                j++;
            }else{
                i++;
            }
        }
        return diff;
    }
    
    // List solution
    
    public int maximumGap(final List<Integer> A) {
        int n = A.size();
        if(n <= 1) return 0;
        int[] leftMin = new int[n];
        int[] rightMax = new int[n];
        leftMin[0] = A.get(0);
        rightMax[n-1] = A.get(n-1);
        for(int idx = 1; idx < n; idx++){
            leftMin[idx] = Math.min(leftMin[idx-1], A.get(idx));
        }
        for(int idx = n-2; idx >= 0; idx--){
            rightMax[idx] = Math.max(rightMax[idx+1], A.get(idx));
        }
        int i = 0, j = 0, diff = -1;
        while(i < n && j < n){
            if(leftMin[i] <= rightMax[j]){
                diff = Math.max(diff, j-i);
                j++;
            }else{
                i++;
            }
        }
        return diff;
    }

}
