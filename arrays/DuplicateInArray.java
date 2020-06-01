/*
Given a read only array of n + 1 integers between 1 and n, find one number that repeats in linear time using
less than O(n) space and traversing the stream sequentially O(1) times.

Sample Input:
[3 4 1 4 1]
Sample Output:
1

If there are multiple possible answers ( like in the sample case above ), output any one.
If there is no duplicate, output -1
 */

package arrays;

import java.util.List;

public class DuplicateInArray {
	
	// Array solution
	
    public int repeatedNumber(final int[] A) {
        int n = A.length-1;
        if(n <= 0) return -1;
        
        int slow = A[0], fast = A[A[0]];
        
        while(slow != fast){
            slow = A[slow];
            fast = A[A[fast]];
        }
        
        slow = 0;
        while(slow != fast){
            slow = A[slow];
            fast = A[fast];
        }
        
        return slow;
    }
    
    // List solution
    
    public int repeatedNumber(final List<Integer> A) {
        int n = A.size()-1;
        if(n <= 0) return -1;
        
        int slow = A.get(0), fast = A.get(A.get(0));
        
        while(slow != fast){
            slow = A.get(slow);
            fast = A.get(A.get(fast));
        }
        
        slow = 0;
        while(slow != fast){
            slow = A.get(slow);
            fast = A.get(fast);
        }
        
        return slow;
    }

}
