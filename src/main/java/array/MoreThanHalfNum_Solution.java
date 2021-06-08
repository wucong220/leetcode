package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MoreThanHalfNum_Solution {
    public static void main(String[] args) {
		System.out.println(moreThanHalfNum_Solution(new int[]{1,2,3,2,2,2,5,4,2}));
	}
	static public int moreThanHalfNum_Solution(int [] array) {
    	Arrays.sort(array);
    	int count=0;
    	for(int i=0;i<array.length;i++){
    		if(i==0||array[i]!=array[i-1]){
    			count=1;
    		}
    		else if(array[i]==array[i-1]){
    			count++;
    		}
    		
    		if(count>array.length/2){
				return array[i];
			}
    	}
		return 0;
    }
}
