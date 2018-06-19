package leetCode100;

import java.util.ArrayList;
import java.util.List;

public class P166FractiontoRecurringDecimal {
	public static void main(String[] args) {
		System.out.println(fractionToDecimal(-1, -2147483648));
		System.out.println(-1/-2147483648);
	}

	static public String fractionToDecimal(int numerator, int denominator) {
		
		long temp1=numerator,temp2=denominator;
		boolean flag =(temp1*temp2>=0)?false:true;
		if(temp1<0)temp1=-temp1;
		if(temp2<0)temp2=-temp2;
		StringBuffer sb = new StringBuffer();
		List<Long> fucks = new ArrayList<>();
		long a1 = temp1 / temp2;
		long a2 = temp1 % temp2;
		sb.append(a1);
		if (a2 > 0) {
			sb.append('.');
			long fuck = a2;
			int start = sb.length();
			while (fuck > 0) {
				for(int i=start;i<sb.length();i++){
					if(fucks.get(i-start)==fuck){
						sb.insert(i, '(').append(')');
						if(flag) sb.insert(0, '-');
						return sb.toString();
					}
				}
				fucks.add(fuck);
				fuck = fuck * 10;
				sb.append(fuck / temp2);
				fuck = fuck % temp2;
			}
		}
		if(flag) sb.insert(0, '-');
		return sb.toString();
	}

}
