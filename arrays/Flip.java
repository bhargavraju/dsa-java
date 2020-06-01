/*
You are given a binary string(i.e. with characters 0 and 1) S consisting of characters S1, S2, ... SN
In a single operation, you can choose two indices L and R such that 1 <= L <= R <= N and
flip the characters SL, SL+1, .... SR. By flipping, we mean change character 0 to 1 and vice-versa.

Your aim is to perform ATMOST one operation such that in final string number of 1s is maximised.
If you don't want to perform any operation, return an empty array. Else, return an array consisting of two elements
denoting L and R. If there are multiple solutions, return the lexicographically smallest pair of L and R.

Notes:
Pair (a, b) is lexicographically smaller than pair (c, d) if a < c or, if a == c and b < d.

For example,
S = 010
Pair of [L, R] | Final string
_______________|_____________
[1 1]          | 110
[1 2]          | 100
[1 3]          | 101
[2 2]          | 000
[2 3]          | 001

We see that two pairs [1, 1] and [1, 3] give same number of 1s in final string. So, we return [1, 1].

Another example,
If S = 111

No operation can give us more than three 1s in final string. So, we return empty array [].
*/

package arrays;

import java.util.ArrayList;

public class Flip {
	
	// Array Solution
	
    public int[] flipArray(String A) {
        int maxCount = 0, currCount = 0, leftIndex=0;
        char[] chars = A.toCharArray();
        int[] ans = new int[2];
        for(int i = 0; i < chars.length; i++){
            if(chars[i]=='0'){
                currCount += 1;
                if(currCount > maxCount){
                    maxCount = currCount;
                    ans[0] = leftIndex;
                    ans[1] = i;
                }
            } else {
                currCount -= 1;
                if(currCount < 0){
                    currCount = 0;
                    leftIndex = i+1;
                }
            }
        }
        if(maxCount == 0){
            return new int[0];
        }else{
            ans[0] += 1;
            ans[1] += 1;
            return ans;
        }
    }
    
    // ArrayList solution
    
    public ArrayList<Integer> flipList(String A) {
        int currSum = 0, maxSum = 0, leftIndex=0, leftAns=0, rightAns=0;
        ArrayList<Integer> result = new ArrayList<Integer>(2);
        char[] chars = A.toCharArray();
        for(int i = 0; i < chars.length; i++){
            if(chars[i] == '0'){
                currSum += 1;
                if(maxSum < currSum){
                    maxSum = currSum;
                    leftAns = leftIndex;
                    rightAns = i;
                }
            }else{
                currSum -= 1;
                if(currSum < 0){
                    currSum = 0;
                    leftIndex = i+1;
                }
            }
        }
        if(maxSum == 0){
            return new ArrayList<Integer>();
        }else{
            result.add(leftAns+1);
            result.add(rightAns+1);
            return result;
        }
    }

}
