package leetCode100;

import java.util.HashMap;
import java.util.Map;

public class P132PalindromePartitioningII_T {
	//Time Limit Exceeded;
/*	static public int minCut(String s) {
		HashMap<String, Integer> cutcounter = new HashMap<>();
		return minCut(s, cutcounter);
	}

	static public int minCut(String s, Map<String, Integer> cutcounter) {
		if (cutcounter.containsKey(s)) {
			return cutcounter.get(s);
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < s.length(); i++) {
			String curr = s.substring(0, i + 1);
			if (isPalindrome(curr)) {
				if (s.substring(i + 1).length() == 0) {
					return 0;
				} else {
					int temp = minCut(s.substring(i + 1));
					min = Math.min(min, temp + 1);
				}
			}
		}
		cutcounter.put(s, min);
		return min;
	}

	static public boolean isPalindrome(String s) {
		char[] cs = s.toCharArray();
		for (int i = 0; i < cs.length / 2; i++) {
			if (!(cs[i] == cs[cs.length - 1 - i])) {
				return false;
			}
		}
		return true;
	}*/
	
	public static int minCut(String s) {
	    char[] c = s.toCharArray();
	    int n = c.length;
	    int[] cut = new int[n]; //储存动态规划结果
	    boolean[][] pal = new boolean[n][n];//储存是否回文；
	    
	    for(int i = 0; i < n; i++) {
	    	//默认的最小值为i的值，每个单个字符为一个切片
	        int min = i;
	        //下面开始计算[0,i]的最小切片值
	        for(int j = 0; j <= i; j++) {
	            if(c[j] == c[i] && (j + 1 > i - 1 || pal[j + 1][i - 1])) {
	                pal[j][i] = true;  
	                min = j == 0 ? 0 : Math.min(min, cut[j - 1] + 1);
	            }
	        }
	        cut[i] = min;
	    }
	    return cut[n - 1];
	}
	
	public static void main(String[] args) {
		System.out.println(minCut("abababababababcabababababa"));
	}
}
