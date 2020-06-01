/*
Given an integer array, find if an integer p exists in the array such that the number of integers greater than p in the array equals to p
If such an integer is found return 1 else return -1.
 */


package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class NobleInteger {
	
	// Array solution
	
    public int solve(int[] A) {
        Arrays.sort(A);
        int n = A.length;
        for(int i = 0; i < n-1; i++){
            if(A[i] == A[i+1]) continue;
            if(A[i] == n-1-i) return 1;
        }
        if(A[n-1] == 0) return 1;
        return -1;
    }
    
    // ArrayList solution
    
    public int solve(ArrayList<Integer> A) {
        Collections.sort(A);
        int n = A.size();
        for(int i = 0; i < n-1; i++){
            if(A.get(i) == A.get(i+1)) continue;
            if(A.get(i) == n-i-1) return 1;
        }
        if(A.get(n-1) == 0) return 1;
        return -1;
    }

}
