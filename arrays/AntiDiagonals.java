/*
Give a N*N square matrix, return an array of its anti-diagonals. Look at the example for more details.

Example:
		
Input:
1 2 3
4 5 6
7 8 9

Return the following:
[ 
  [1],
  [2, 4],
  [3, 5, 7],
  [6, 8],
  [9]
]


Input: 
1 2
3 4

Return the following:
[
  [1],
  [2, 3],
  [4]
] 
 */

package arrays;

import java.util.ArrayList;

public class AntiDiagonals {
	
	// Array Solution
	
    public int[][] diagonal(int[][] A) {
        int n = A.length;
        int[][] result = new int[2*n-1][];
        for(int layer = 0; layer < 2*n-1; layer++){
            int j = Math.min(layer, n-1);
            int i = layer-j;
            int layerLength = Math.min(layer+1, 2*n-layer-1);
            result[layer] = new int[layerLength];
            for(int k = 0; k < layerLength; k++){
                result[layer][k] = A[i][j];
                i++;
                j--;
            }
        }
        return result;
    }
    
    // ArrayList solution
    
    public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int n = A.size();
        for(int layer = 0; layer < 2*n-1; layer++){
            ArrayList<Integer> curr = new ArrayList<Integer>();
            int j = Math.min(layer, n-1);
            int i = layer-j;
            while( i >= 0 && i < n && j >= 0 && j < n){
                curr.add(A.get(i).get(j));
                i++;
                j--;
            }
            result.add(curr);
        }
        return result;
    }

}
