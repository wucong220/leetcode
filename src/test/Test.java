package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
		
		Set<Character> sa = new HashSet<>();
		Set<Character> sb = new HashSet<>();
		sa.add('a');
		sa.add('b');
		sb.add('b');
		sb.add('a');
		Set<Set<Character>> ssc = new HashSet<>();
		ssc.add(sa);
		
		System.out.println(ssc.contains(sb));
		System.out.println(ssc);
		System.out.println(sa.equals(sb));
		
	}
}
