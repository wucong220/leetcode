package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		System.out.println(6/5);
		boolean[] fuck = new boolean[10];
		System.out.println(Arrays.toString(fuck));
		
		Integer a1 = 221;
		Integer a2 = 221;
		System.out.println(a1==a2);
		
		System.out.println('9'-'0');
		System.out.println((char)('0'+1));
		
		System.out.println(String.valueOf('0'+1));
		System.out.println(String.valueOf((char)('0'+1)));
		System.out.println(0x66);
		
		String s = "fuck";
		String b = s.substring(4);
		System.out.println(b.length());
		
		List<Integer> fuck1 = new ArrayList<>();
		fuck1.add(0,5);
	}
}
