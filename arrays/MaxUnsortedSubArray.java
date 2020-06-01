/*
You are given an array (zero indexed) of N non-negative integers, A0, A1, A2, .....An-1.Find the minimum sub array
Al, Al+1, ......Ar o if we sort(in ascending order) that sub array, then the whole array should get sorted.
If A is already sorted, output -1.

Example :

Input 1:
A = [1, 3, 2, 4, 5]
Return: [1, 2]

Input 2:
A = [1, 2, 3, 4, 5]
Return: [-1]

In the above example(Input 1), if we sort the sub array A1, A2, then whole array A should get sorted. 
 */

package arrays;

import java.util.ArrayList;

public class MaxUnsortedSubArray {
	
	// Array solution
	
    public int[] subUnsort(int[] A) {
        int n = A.length;
        if(n <= 1) return new int[] {-1};
        int l = 0, r = n-1;
        while(l < n-1 && A[l] <= A[l+1]){
            l++;
        }
        while(r > 0 && A[r] >= A[r-1]){
            r--;
        }
        if(l > r) return new int[] {-1};
        int minVal = A[l], maxVal = A[l];
        for(int i = l; i <= r; i++){
            minVal = Math.min(minVal, A[i]);
            maxVal = Math.max(maxVal, A[i]);
        }
        for(int i = l-1; i >= 0; i--){
            if(A[i] > minVal){
                l--;
            }else{
                break;
            }
        }
        for(int i = r+1; i < n; i++){
            if(A[i] < maxVal){
                r++;
            }else{
                break;
            }
        }
        return new int[] {l, r};
    }
    
    // ArrayList solution
    
    public ArrayList<Integer> subUnsort(ArrayList<Integer> A) {
        int n = A.size();
        
        ArrayList<Integer> sortedResult = new ArrayList<Integer>();
        sortedResult.add(-1);
        
        if(n <= 1) return sortedResult;
        
        int l = 0, r = n-1;
        while(l < n-1 && A.get(l) <= A.get(l+1)) l++;
        while(r > 0 && A.get(r) >= A.get(r-1)) r--;
        
        if(l > r) return sortedResult;
        
        int minVal = A.get(l), maxVal = A.get(l);
        for(int i = l; i <= r; i++){
            minVal = Math.min(minVal, A.get(i));
            maxVal = Math.max(maxVal, A.get(i));
        }
        
        for(int i = l-1; i >= 0; i--){
            if(A.get(i) > minVal){
                l--;
            }else{
                break;
            }
        }
        for(int i = r+1; i < n; i++){
            if(A.get(i) < maxVal){
                r++;
            }else{
                break;
            }
        }
        
        ArrayList<Integer> out = new ArrayList<Integer>();
        out.add(l);
        out.add(r);
        
        return out;
        
    }

}
