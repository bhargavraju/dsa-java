/*
You’re given a read only array of n integers. Find out if any integer occurs more than n/3 times in the array in linear time and constant additional space.

If so, return the integer. If not, return -1. If there are multiple solutions, return any one.

Example :
Input : [1 2 3 1 1]
Output : 1

1 occurs 3 times which is more than 5/3 times.  
 */
package arrays;

import java.util.List;

public class OneThirdRepeatNumber {
	
	// ArrayList Solution
	// Check Moore's voting algorithm. Apply it to 1/3rd majority
	
	public int repeatedNumber(final List<Integer> a) {
	    int count1 = 0, count2 = 0;
	    int num1 = Integer.MAX_VALUE, num2 = Integer.MIN_VALUE;
	    for(int i = 0; i < a.size(); i++) {
	        if(a.get(i) == num1) {
	            count1++;
	        } else if(a.get(i) == num2) {
	            count2++;
	        } else if(count1 == 0) {
	            num1 = a.get(i);
	            count1++;
	        } else if(count2 == 0) {
	            num2 = a.get(i);
	            count2++;
	        } else {
	            count1--;
	            count2--;
	        }
	    }
	    count1 = count2 = 0;
	    for(int i = 0; i < a.size(); i++) {
	        if(a.get(i) == num1) {
	            count1++;
	        } else if(a.get(i) == num2) {
	            count2++;
	        }
	    }
	    
	    if(count1 > a.size()/3) return num1;
	    if(count2 > a.size()/3) return num2;
	    
	    return -1;
	}

}
