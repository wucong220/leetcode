package leetCode;

import java.util.ArrayList;
import java.util.List;

public class P22GeneratedParentheses {

	public static List<String> generateParenthesis(int n) {
		PString pstring = new PString(4,4);
		
		return pstring.getPs();
	}

	public static void main(String[] args) {
		System.out.println(generateParenthesis(4));
		
		PString pstring = new PString(4,4);
		
		System.out.println(pstring.getPs());
	}
}

class PString {
	private int i;
	private int j;
	private List<String> ps;

	public PString(int i, int j) {
		this.i = i;
		this.j = j;

		ps = new ArrayList<String>();

		if (i == 0 && j == 0) {
			ps.add("");
		} else {
			if (i - 1 >= j && j >= 0) {
				PString iString = new PString(i - 1, j);
				int size = iString.ps.size();
				for (int k = 0; k < size; k++) {
					this.ps.add(iString.ps.get(k) + "(");
				}
			}
			if (i >= j - 1 && j - 1 >= 0) {
				PString jString = new PString(i, j - 1);
				int size = jString.ps.size();
				for (int k = 0; k < size; k++) {
					this.ps.add(jString.ps.get(k) + ")");
				}
			}
		}
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}

	public List<String> getPs() {
		return ps;
	}

	public void setPs(List<String> ps) {
		this.ps = ps;
	}

}