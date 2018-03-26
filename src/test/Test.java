package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import DataStructure.ListNode;

public class Test {
	public static void main(String[] args) {
		System.out.println(6/5);
		boolean[] fuck = new boolean[10];
		System.out.println(Arrays.toString(fuck));
		System.out.println("测试两个整形类是否相等：不相等");
		Integer a1 = 221;
		Integer a2 = 221;
		System.out.println(a1==a2);
		
		System.out.println("测试字符串加减操作结果");
		System.out.println('9'-'0');
		System.out.println((char)('0'+1));
		
		System.out.println(String.valueOf('0'+1));
		System.out.println(String.valueOf((char)('0'+1)));
		System.out.println(0x66);
		
		System.out.println("测试subString");
		String s = "fuck";
		String b = s.substring(4);
		System.out.println(b.length());
		
		System.out.println("测试ArrayList头部插入");
		List<Integer> fuck1 = new ArrayList<>();
		fuck1.add(0,5);
		
		System.out.println("测试set");
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
		
		System.out.println("测试字符串比较");
		System.out.println("15".compareTo("1"));
		
		ArrayList<ListNode> as = new ArrayList<>();
		as.add(new ListNode(100));
		
		System.out.println(as);
		
		ListNode next = as.iterator().next();
		next.val=99;
		System.out.println(as);
		
		ArrayList<Integer> ai  = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
		System.out.println(ai);
		Collections.sort(ai,new Comparator<Integer>(){

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1-o2;
			}
			
		});
		System.out.println(ai);
	}
}
