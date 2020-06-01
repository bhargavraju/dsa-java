/*
Given a matrix of m * n elements (m rows, n columns), return all elements of the matrix in spiral order.

Example:
Given the following matrix:
[
    [ 1, 2, 3 ],
    [ 4, 5, 6 ],
    [ 7, 8, 9 ]
]
You should return

[1, 2, 3, 6, 9, 8, 7, 4, 5]
*/


package arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralArray {
	
	//Array Solution
	
    public static int[] spiralOrder(final int[][] A) {
        int m = A.length, n = A[0].length;
        int[] result = new int[m*n];
        int dir = 0;
        int T = 0, L = 0, B = m-1, R = n-1;
        int idx = 0;
        while(T <= B && L <= R){
            if(dir == 0){
                for(int i = L; i <= R; i++){
                    result[idx] = A[T][i];
                    idx++;
                }
                T++;
            } else if(dir == 1){
                for(int i = T; i <= B; i++){
                    result[idx] = A[i][R];
                    idx++;
                }
                R--;
            } else if(dir == 2){
                for(int i = R; i >= L; i--){
                    result[idx] = A[B][i];
                    idx++;
                }
                B--;
            } else {
                for(int i = B; i >= T; i--){
                    result[idx] = A[i][L];
                    idx++;
                }
                L++;
            }
            dir = (dir+1)%4;
        }
        return result;
    }

    
    // ArrayList Solution
    
    public ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> A) {
        int m = A.size();
        int n = A.get(0).size();
        int dir = 0;
        int T = 0, L = 0, B = m-1, R = n-1;
        ArrayList<Integer> result = new ArrayList<Integer>();
        while(L <= R && T <= B){
            if(dir == 0){
                for(int i = L; i <= R; i++){
                    result.add(A.get(T).get(i));
                }
                T++;
            }else if(dir == 1){
                for(int i = T; i <= B; i++){
                    result.add(A.get(i).get(R));
                }
                R--;
            }else if(dir == 2){
                for(int i = R; i >= L; i--){
                    result.add(A.get(B).get(i));
                }
                B--;
            }else{
                for(int i = B; i >= T; i--){
                    result.add(A.get(i).get(L));
                }
                L++;
            }
            dir = (dir+1)%4;
        }
        return result;
    }

}
