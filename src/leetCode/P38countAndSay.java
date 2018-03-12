package leetCode;

public class P38countAndSay {

	static public String countAndSay(int n) {
		String start = "1";
		StringBuilder ret = new StringBuilder();
		String s = start;
		n--;
		while (n-- > 0) {
			int count = 1;
			

			for (int i = 0; i <= s.length(); i++) {
				char c = 0;
				if (i == s.length())
					c = 'a';
				else
					c = s.charAt(i);
				if (i > 0)
					if (c == s.charAt(i - 1))
						count++;
					else {
						ret = ret.append((char)(count+'0')).append(s.charAt(i - 1));
						count = 1;
					}
			}
			s=ret.toString();
			ret.delete(0, ret.length());
		}

		return s;
	}

	public static void main(String[] args) {
		System.out.println(countAndSay(1));

	}
}
