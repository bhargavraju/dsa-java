/*
 Given an unsorted integer array, find the first missing positive integer.

Example:

Given [1,2,0] return 3,
[3,4,-1,1] return 2,
[-8, -7, -6] returns 1

Your algorithm should run in O(n) time and use constant space.
 */

package arrays;

import java.util.ArrayList;

public class FirstMissingInteger {
	
	// Array Solution
	
    public int firstMissingPositive(int[] A) {
        int n = A.length;
        boolean oneExists = false;
        for(int i = 0; i < n; i++){
            if(A[i] == 1) oneExists = true;
            else if(A[i] < 1 || A[i] > n) A[i] = 1;
        }
        
        if(!oneExists) return 1;
        
        for(int i = 0; i < n; i++){
            int idx = Math.abs(A[i]) - 1;
            if(A[idx] > 0) A[idx] = -1*A[idx];
        }
        
        for(int i = 0; i < n; i++){
            if(A[i] > 0) return i+1;
        }
        return n+1;
    }
    
    // ArrayList Solution
    
    public int firstMissingPositive(ArrayList<Integer> A) {
        int n = A.size();
        boolean oneExists = false;
        for(int i = 0; i < n; i++){
            if(A.get(i) == 1) oneExists = true;
            else if(A.get(i) < 1 || A.get(i) > n) A.set(i, 1);
        }
        
        if(!oneExists) return 1;
        
        for(int i = 0; i < n; i++){
            int idx = Math.abs(A.get(i)) - 1;
            if(A.get(idx) > 0) A.set(idx, -1*A.get(idx)); 
        }
        
        for(int i = 0; i < n; i++){
            if(A.get(i) > 0) return i+1;
        }
        
        return n+1;
    }

}
