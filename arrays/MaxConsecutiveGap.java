/*
Given an unsorted array, find the maximum difference between the successive elements in its sorted form.
Try to solve it in linear time/space.

Example :

Input : [1, 10, 5]
Output : 5 
Return 0 if the array contains less than 2 elements.

You may assume that all the elements in the array are non-negative integers and fit in the 32-bit signed integer range.
You may also assume that the difference will not overflow.
 */

package arrays;

import java.util.Arrays;
import java.util.List;

public class MaxConsecutiveGap {
	
	// Array Solution
	
    public int maximumGap(final int[] A) {
        int n = A.length;
        
        if(n <= 1) return 0;
        
        int minVal = A[0], maxVal = A[0];
        for(int i: A){
            minVal = Math.min(minVal, i);
            maxVal = Math.max(maxVal, i);
        }
        
        int diff = maxVal-minVal;
        
        if(diff < 2) return diff;
        
        float gap = diff/(float)(n-1);
        
        int[] minValues = new int[n];
        Arrays.fill(minValues, maxVal+1);
        int[] maxValues = new int[n];
        Arrays.fill(maxValues, minVal-1);
        
        for(int i : A){
            int idx = (int)((i-minVal)/gap);
            minValues[idx] = Math.min(minValues[idx], i);
            maxValues[idx] = Math.max(maxValues[idx], i);
        }
        
        int max_gap = Math.max(1, (int)gap);
        int prev = maxValues[0];
        for(int i = 1; i < n; i++){
            if(minValues[i] != maxVal+1){
                max_gap = Math.max(max_gap, minValues[i]-prev);
                prev = maxValues[i];
            }
        }
        
        return max_gap;
        
    }
    
    // ArrayList solution
    
    public int maximumGap(final List<Integer> A) {
        int n = A.size();
        if(n < 2) return 0;
        
        int minVal = A.get(0), maxVal = A.get(0);
        for(int i = 0; i < n; i++){
            minVal = Math.min(minVal, A.get(i));
            maxVal = Math.max(maxVal, A.get(i));
        }
        int diff = maxVal-minVal;
        
        if(diff < 2) return diff;
        
        float gap = diff/(float)(n-1);
        
        int[] minValues = new int[n];
        Arrays.fill(minValues, maxVal+1);
        int[] maxValues = new int[n];
        Arrays.fill(maxValues, minVal-1);
        
        for(int i = 0; i < n; i++){
            int idx = (int)((A.get(i)-minVal)/gap);
            minValues[idx] = Math.min(minValues[idx], A.get(i));
            maxValues[idx] = Math.max(maxValues[idx], A.get(i));
        }
        
        int max_gap = Math.max(1, (int)gap);
        int prev = maxValues[0];
        for(int i = 0; i < n; i++){
            if(minValues[i] != maxVal+1){
                max_gap = Math.max(minValues[i]-prev, max_gap);
                prev = maxValues[i];
            }
        }
        
        return max_gap;
    }

}
