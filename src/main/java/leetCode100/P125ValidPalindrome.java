package leetCode100;

public class P125ValidPalindrome {
	// 判断是否是有效回文，1.只考虑字母不考虑其他字符；2.不考虑字母的大小写。
	// 两个指针往中间靠近
	public static boolean isPalindrome(String s) {
		int head = 0;
		int tail = s.length() - 1;
		while (head < tail) {
			char hc = s.charAt(head);
			char tc = s.charAt(tail);
			while (head < tail && !((hc >= 'a' && hc <= 'z')
					|| (hc >= 'A' && hc <= 'Z')
					|| (hc >= '0' && hc <= '9'))) {
				head++;
				hc = s.charAt(head);
			}
			while (head < tail && !((tc >= 'a' && tc <= 'z')
					|| (tc >= 'A' && tc <= 'Z')
					|| (tc >= '0' && tc <= '9'))) {
				tail--;
				tc = s.charAt(tail);
			}
			if (head < tail)
				if (hc > 57 && tc > 57)
					if (hc == tc || Math.abs(hc - tc) == ('a' - 'A')) {
						head++;
						tail--;
					} else {
						return false;
					}
				else{
					if(hc==tc){
						head++;
						tail--;
					}else{
						return false;
					}
				}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isPalindrome("1b1"));
	}
}
