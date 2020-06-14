/*
Implement the next permutation, which rearranges numbers into the numerically next greater permutation of numbers for a given array A of size N.
If such arrangement is not possible, it must be rearranged as the lowest possible order i.e., sorted in an ascending order.

Input Format:
The first and the only argument of input has an array of integers, A.

Output Format:
Return an array of integers, representing the next permutation of the given array.

Constraints:
1 <= N <= 5e5
1 <= A[i] <= 1e9

Examples:

Input 1:
    A = [1, 2, 3]

Output 1:
    [1, 3, 2]

Input 2:
    A = [3, 2, 1]

Output 2:
    [1, 2, 3]

Input 3:
    A = [1, 1, 5]

Output 3:
    [1, 5, 1]

Input 4:
    A = [20, 50, 113]

Output 4:
    [20, 113, 50]
 */

package arrays;

import java.util.ArrayList;

public class NextPermutation {
	
	// Array Solution
	
    public int[] nextPermutation(int[] A) {
        int n = A.length;
        if(n < 2) return A;
        if(n == 2) {
            swap(A, 0, 1);
            return A;
        }
        
        int dec = n-2;
        while(dec >= 0 && A[dec] >= A[dec+1]) dec--;
        
        reverse(A, dec+1, n-1);
        
        if(dec == -1) return A;
        
        int nextNum = dec + 1;
        while(nextNum < n && A[nextNum] <= A[dec]) nextNum++;
        
        swap(A, dec, nextNum);
        
        return A;
        
    }
    
    public void reverse(int[] a, int left, int right) {
        while(left < right) {
            swap(a, left, right);
            left++;
            right--;
        }
    }
    
    public void swap(int[] a, int i1, int i2) {
        int temp = a[i1];
        a[i1] = a[i2];
        a[i2] = temp;
    }
	
	// ArrayList solution
	
    public ArrayList<Integer> nextPermutation(ArrayList<Integer> a) {
        if(a == null || a.size()<2) return a;
 
        int p = 0;            
        for(int i = a.size()-2; i >= 0; i--){
            if(a.get(i) < a.get(i+1)){
                p = i;
                break;
            }    
        }
     
        int q = 0;
        for(int i = a.size()-1; i > p; i--){
            if(a.get(i) > a.get(p)){
                q = i;
                break;
            }    
        }
     
        if(p == 0 && q == 0){
            reverse(a, 0, a.size()-1);
            return a;
        }
     
        int temp = a.get(p);
        a.set(p,a.get(q));
        a.set(q,temp);
     
        reverse(a, p+1, a.size()-1);
        
        return a;
    }
 
    public void reverse(ArrayList<Integer> a, int left, int right){
        while(left < right){
            int temp = a.get(left);
            a.set(left,a.get(right));
            a.set(right,temp);
            left++;
            right--;
        }
    }

}
