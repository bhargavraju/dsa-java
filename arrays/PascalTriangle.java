/*
Given numRows, generate the first numRows of Pascal’s triangle.
Pascal’s triangle : To generate A[C] in row R, sum up A’[C] and A’[C-1] from previous row R - 1.

Example:

Given numRows = 5,

Return

[
     [1],
     [1,1],
     [1,2,1],
     [1,3,3,1],
     [1,4,6,4,1]
]
 */

package arrays;

import java.util.ArrayList;

public class PascalTriangle {
	
    // Array solution
	
	public int[][] solve(int A) {
        int[][] result = new int[A][];
        for(int i = 0; i < A; i++){
            int currLen = i+1;
            result[i] = new int[currLen];
            result[i][0] = 1;
            if(i > 0){
                for(int j = 0; j < i-1; j++){
                    result[i][j+1] = result[i-1][j] + result[i-1][j+1];
                }
                result[i][i] = 1;
            }
        }
        return result;
    }
	
	// ArrayList solution
	
    public ArrayList<ArrayList<Integer>> solveList(int A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < A; i++){
            ArrayList<Integer> current = new ArrayList<Integer>();
            current.add(1);
            if(i > 0){
                ArrayList<Integer> prev = result.get(i-1);
                for(int j = 0; j < prev.size()-1; j++){
                    current.add(prev.get(j) + prev.get(j+1));
                }
                current.add(1);
            }
            result.add(current);
        }
        return result;
    }

}
