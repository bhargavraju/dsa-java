/*
 Given an integer A, generate a square matrix filled with elements from 1 to A2 in spiral order.

Input Format:
The first and the only argument contains an integer, A.

Output Format:
Return a 2-d matrix of size A x A satisfying the spiral order.

Constraints:
1 <= A <= 1000

Examples:

Input 1:
    A = 3

Output 1:
    [   [ 1, 2, 3 ],
        [ 8, 9, 4 ],
        [ 7, 6, 5 ]   ]

Input 2:
    4

Output 2:
    [   [1, 2, 3, 4],
        [12, 13, 14, 5],
        [11, 16, 15, 6],
        [10, 9, 8, 7]   ]
 */


package arrays;

public class SpiralMatrix2 {
	
    public int[][] generateMatrix(int A) {
        int[][] result = new int[A][A];
        int l = 0, r = A-1, t = 0, b = A-1;
        int el = 1;
        int dir = 0;
        while(l <= r && t <= b){
            if(dir == 0){
                for(int i = l; i <= r; i++){
                    result[t][i] = el;
                    el++;
                }
                t++;
            }else if(dir == 1){
                for(int i = t; i <= b; i++){
                    result[i][r] = el;
                    el++;
                }
                r--;
            }else if(dir == 2){
                for(int i = r; i >= l; i--){
                    result[b][i] = el;
                    el++;
                }
                b--;
            }else{
                for(int i = b; i >= t; i--){
                    result[i][l] = el;
                    el++;
                }
                l++;
            }
            dir = (dir+1)%4;
        }
        return result;
    }

}
