package leetCode;

import java.util.ArrayList;
import java.util.List;

public class P93RestoreIPAddresses {
	static public List<String> restoreIpAddresses(String s) {

		return restoreIpAddresses(s, 4);
	}

	static public List<String> restoreIpAddresses(String s, int n) {
		List<String> ls = new ArrayList<String>();
		if (s.length() == 0) {
			return ls;
		} else if (n == 1 && s.length() <= 3 && s.length() >= 1) {
			if (s.length() >= 2 && s.charAt(0) == '0') {
			} else {
				int value = Integer.parseInt(s);
				if (value < 256)
					ls.add(s);
			}
		} else if (s.length() <= n * 3 && s.length() >= n) {
			StringBuilder b = new StringBuilder(s.length() + 3);
			// 选1个
			List<String> temp = restoreIpAddresses(s.substring(1), n - 1);
			for (String string : temp) {
				b.append(s.charAt(0)).append(",").append(string);
				ls.add(b.toString());
				b.delete(0, b.length());
			}
			// 选两个
			if (s.charAt(0) != '0') {
				temp = restoreIpAddresses(s.substring(2), n - 1);
				for (String string : temp) {
					b.append(s.substring(0, 2)).append(",").append(string);
					ls.add(b.toString());
					b.delete(0, b.length());
				}

				// 选三个
				if (s.length() > 3 && Integer.parseInt(s.substring(0, 3)) < 256) {
					temp = restoreIpAddresses(s.substring(3), n - 1);
					for (String string : temp) {
						b.append(s.substring(0, 3)).append(",").append(string);
						ls.add(b.toString());
						b.delete(0, b.length());
					}
				}
			}

		}
		return ls;
	}

	public static void main(String[] args) {
		System.out.println(restoreIpAddresses("010010"));
	}
}
