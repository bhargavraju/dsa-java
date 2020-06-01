/*
There are certain problems which are asked in the interview to also check how you take care of overflows in your problem.
This is one of those problems.
Please take extra care to make sure that you are type-casting your ints to long properly and at all places. Try to verify if your solution works if number of elements is as large as 105

Food for thought :
Even though it might not be required in this problem, in some cases, you might be required to order the operations cleverly so that the numbers do not overflow.
For example, if you need to calculate n! / k! where n! is factorial(n), one approach is to calculate factorial(n), factorial(k) and then divide them.
Another approach is to only multiple numbers from k + 1 ... n to calculate the result.
Obviously approach 1 is more susceptible to overflows.


You are given a read only array of n integers from 1 to n.
Each integer appears exactly once except A which appears twice and B which is missing.
Return A and B.

Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
Note that in your output A should precede B. 

Input:[3 1 2 5 3] 
Output:[3, 4]
A = 3, B = 4
*/

package arrays;

import java.util.ArrayList;
import java.util.List;

public class RepeatAndMissingNum {
	
	// Array Solution
	
    public int[] repeatedNumber(final int[] A) {
        long sumNum = 0, sumSquares = 0;
        for(int i = 0; i < A.length; i++){
            sumNum += A[i] - (i+1);
            sumSquares += A[i]*(long)A[i] - (i+1)*(long)(i+1);
        }
        long aMinusB = sumNum, aPlusB = sumSquares/sumNum;
        int[] result = new int[2];
        result[0] = (int)(aPlusB + aMinusB)/2;
        result[1] = (int)(aPlusB - aMinusB)/2;
        return result;
    }
    
    // ArrayList Solution
    
    public ArrayList<Integer> repeatedNumber(final List<Integer> A) {
        long sumNum = 0, sumSquares = 0;
        for(int i = 0; i < A.size(); i++){
            sumNum += A.get(i) - (i+1);
            sumSquares += A.get(i)*(long)A.get(i) - (i+1)*(long)(i+1);
        }
        long AminusB = sumNum, AplusB = sumSquares/sumNum;
        ArrayList<Integer> result =  new ArrayList<Integer>();
        result.add((int)(AminusB+AplusB)/2);
        result.add((int)(AplusB-AminusB)/2);
        return result;
    }

}
