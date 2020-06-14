/*
You are given an n x n 2D matrix representing an image. Rotate the image by 90 degrees (clockwise). You need to do this in place.

Example:
If the array is
[
    [1, 2],
    [3, 4]
]
Then the rotated array becomes:

[
    [3, 1],
    [4, 2]
]
 */

package arrays;

import java.util.ArrayList;

public class RotateArray {
	
	// ArrayList solution
	
	public void rotate(ArrayList<ArrayList<Integer>> a) {
	    int n = a.size();
	    for(int l = 0; l < n/2; l++){
	        for(int i = l; i < n-1-l; i++){
	            int temp = a.get(l).get(i);
	            a.get(l).set(i, a.get(n-1-i).get(l));
	            a.get(n-1-i).set(l, a.get(n-1-l).get(n-1-i));
	            a.get(n-1-l).set(n-1-i, a.get(i).get(n-1-l));
	            a.get(i).set(n-1-l, temp);
	        }
	    }
	}

}
