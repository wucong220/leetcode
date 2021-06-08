package leetCode;

import java.util.Arrays;

public class P58LengthOfLastWord {
    static public int lengthOfLastWord(String s) {
        String[] ss = s.split(" ");
        System.out.println(Arrays.toString(ss));
        return ss[ss.length-1].length();
    	
    }
    public static void main(String[] args) {
		String input = "   ";
		System.out.println(lengthOfLastWord(input));
	}
}
