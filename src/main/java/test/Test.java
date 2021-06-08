package test;

import java.util.*;

import DataStructure.ListNode;

public class Test {
	public static void main1(String[] args) {
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
		
//		System.out.println(Character.isAlphabetic('干'));
		System.out.println('A'-'a');
		System.out.println('0'-'P');
		System.out.println((int)'0');
		
		Queue<Integer> i = new LinkedList<>();
		
		i.offer(1);
		i.addAll(ai);
		i.poll();i.poll();
		System.out.println(i);
		
		Queue<List<String>> q = new LinkedList<>();
		List<String> ls = new ArrayList<>();
		ls.add("1");
		ls.add("2");
		q.offer(ls);
		System.out.println(q);
		ls.add("3");
		q.offer(ls);
		System.out.println(q);
		
		byte a = 0;
		System.out.println(a|(1<<1));
		System.out.println(a|(1<<2));
		
		Integer yourmother = 6;
		Integer fuckyou = yourmother;
		fuckyou++;
		System.out.println(yourmother);
		double a213 = (double)3/2;
		System.out.println("a213="+a213);
		System.out.println(Double.MAX_VALUE);
		System.out.println(Long.MAX_VALUE);
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Math.round(1.6));
		System.out.println((double)94911150/94911151);
		System.out.println((double)94911151/94911152);
		System.out.println();

	}

	class Solution {
		Map<Long,Integer> save = new HashMap<>();
		public int maxUncrossedLines(int[] A, int[] B) {
			Map<Integer,List<Integer>> Bindex = new HashMap<>();
			for(int i=0;i<B.length;i++){
				List<Integer> list = Bindex.getOrDefault(B[i],new ArrayList<Integer>());
				list.add(i);
				Bindex.put(B[i],list);
			}

			int ret = maxUncrossedLines(A,B,Bindex,0,A.length-1,0,B.length-1);
			System.out.println(save);
			return ret;
		}

		public int maxUncrossedLines(int[] A,int[] B,  Map<Integer,List<Integer>> Bindex,int aL,int aR,int bL,int bR){
			if(aL>aR||bL>bR)return 0;
			long key = aL|(aR<<10)|(bL<<20)|(bR<<30);
			if(save.containsKey(key)){
				return save.get(key);
			}
			int max = 0;
			int oldB = B.length-1;
			for(int i=aL;i<=aR;i++){
				List<Integer> list = Bindex.get(A[i]);
				if(list!=null){
					int maxj = 0;
					for(int j:list){
						if(j>=bL&&j<=bR&&j<=oldB){
							max = Math.max(max,1+maxUncrossedLines(A,B,Bindex,aL,i-1,bL,j-1)+maxUncrossedLines(A,B,Bindex,i+1,aR,j+1,bR));
							maxj=Math.max(maxj,j);
						}
					}
					oldB=maxj;
				}
			}
			save.put(key,max);
			return max;
		}
	}
	public static void main(String[] args) {
		new Test().new Solution().maxUncrossedLines(new int[]{3,1,1,3,1},new int[]{3,1,1,1,1});
	}
}
