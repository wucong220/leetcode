package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P68TextJustification {
	static public List<String> fullJustify(String[] words, int maxWidth) {
		int left = maxWidth;
		List<String> ret = new ArrayList<>();

		Line line = new Line(maxWidth);
		for (int i = 0; i < words.length; i++) {

			if (left >= words[i].length()) {
				line.words.add(words[i]);
				line.totalLen += words[i].length();
				left = left - words[i].length() - 1;
			} else {
				ret.add(line.countSpace());
				line = new Line(maxWidth);
				left = maxWidth - words[i].length() - 1;
				line.words.add(words[i]);
				line.totalLen += words[i].length();
			}
		}

		StringBuilder sb =new StringBuilder();

		for(int i = 0;i<line.words.size();i++){
			sb.append(line.words.get(i));
			if(i<line.words.size()-1){
			sb.append(' ');
			}
		};
		
		
		int space =  left+1;

		char[] spaces = new char[space];
		Arrays.fill(spaces, ' ');
		sb.append(String.valueOf(spaces));
	
		ret.add(sb.toString());
	
		
		//ret.add(line.countSpace());

		return ret;
	}

	public static void main(String[] args) {
		String[] input = new String[] {"a"};//{ "This", "is", "an", "example", "of", "text", "justification." };
		System.out.println(fullJustify(input, 1));
	}
}

class Line {
	List<String> words;
	int totalLen;
	int maxWidth;

	public Line(int maxWidth) {
		super();
		this.words = new ArrayList<String>();
		this.totalLen = 0;
		this.maxWidth = maxWidth;

	}

	@Override
	public String toString() {
		return words.toString();
	}

	public String countSpace() {

		int space = (this.maxWidth - this.totalLen);
		if(words.size()==1){
			char[] spaces = new char[space];
			Arrays.fill(spaces, ' ');
			return words.get(0)+String.valueOf(spaces);
		}
		int space_intervals = space / (words.size() - 1);
		char[] spaces = new char[space_intervals];
		Arrays.fill(spaces, ' ');
		int offset = space % (words.size() - 1);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < words.size(); i++) {
			sb.append(words.get(i));
			if (i < words.size()-1) {
				sb.append(String.valueOf(spaces));
				if (offset-- > 0) {
					sb.append(' ');
				}
			}
		}
		

		return sb.toString();
	}

}
