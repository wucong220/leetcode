package leetCode;

import java.util.Arrays;

public class P66PlusOne {
    static public int[] plusOne(int[] digits) {
        int length = digits.length;
        int jw =1;
        for(int i = length-1;i>=0;i--){
        int original = digits[i];
        digits[i] =(jw+digits[i])%10;
        jw = (jw+original)/10;
        }
        if(jw>0){
        	
        
        
        int[] ret = new int[length+1];
        System.arraycopy(digits, 0, ret, 1, length);
        ret[0]=jw;
        return ret;
        }
        return digits;
    }
    
    public static void main(String[] args) {
		System.out.println(Arrays.toString(plusOne(new int[]{9})));
	}
}
