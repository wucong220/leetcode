package leetCode;

public class P91DecodeWays {
	//Time limit exceed.
	static public int numDecodings1(String s) {
		if (s.length() == 0)
			return 0;
		return numDecodings1(s, 666);
	}

	static public int numDecodings1(String s, int f) {
		if (s.length() == 0 || (s.length() == 1&&s.charAt(0)!='0'))
			return 1;

		int ret = 0;
		int i = 0;
		if (s.charAt(i) == '0') {
			ret = 0;
		}else if (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) < '7')) {
			ret = numDecodings1(s.substring(i + 2), f) + numDecodings1(s.substring(i + 1), f);
		} else {
			ret = numDecodings1(s.substring(i + 1), f);
		}
		return ret;
	}
	
	//又一次证明了递归动态规划，不如自底向上的动态规划
	static public int numDecodings(String s) {
		if (s.length() == 0)
			return 0;
		int[] ret = new int[s.length()+1];
		ret[s.length()]=1;
		
		for (int i = s.length()-1; i >= 0; i--) {
			if(s.charAt(i)=='0'){
				ret[i]=0;
			}
			else if(i<s.length()-1&&(s.charAt(i)=='1'||(s.charAt(i)=='2'&&s.charAt(i+1)<'7'))){
				ret[i] = ret[i+1]+ret[i+2];
			}
			else{
				ret[i] =ret[i+1];
			}
		}
		
		
		
		return ret[0];
	}
	
	public static void main(String[] args) {
		System.out.println(numDecodings("1"));
	}
}
