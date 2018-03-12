package leetCode;

public class P43MuiltiplyStrings {
	static public StringBuilder add(String num1,String num2){
		int JinWei = 0;
		int i = num1.length()-1;
		int j = num2.length()-1;
		StringBuilder sb = new StringBuilder();
		
		while(i>=0&&j>=0){
			int sum =  (num1.charAt(i)-'0'+num2.charAt(j)-'0'+JinWei);
			JinWei = sum/10;
			sum = sum%10;
			sb.insert(0,(char)(sum+'0'));
			i--;
			j--;
		}

		while(i>=0){
			int sum =  (num1.charAt(i)-'0'+JinWei);
			JinWei = sum/10;
			sum = sum%10;
			sb.insert(0,(char)(sum+'0'));	
			i--;
		}
		
		while(j>=0){
			int sum =  (num2.charAt(j)-'0'+JinWei);
			JinWei = sum/10;
			sum = sum%10;
			sb.insert(0,(char)(sum+'0'));
			j--;
		}
		
		if(JinWei!=0){
			sb.insert(0, JinWei);
		}
		
		return sb;
	}
	
	static public String multiply_one(String num1,char num2){
		int i = num1.length()-1;
		int JinWei=0;
		StringBuilder sb = new StringBuilder();
		while(i>=0){
			int multi = (num1.charAt(i)-'0')*(num2-'0')+JinWei;
			JinWei = multi /10;
			multi = multi%10;
			sb.insert(0, multi);
			i--;
		}
		if(JinWei!=0){
			sb.insert(0, JinWei);
		}
		return sb.toString();
	}
	
	
	static public String multiply(String num1, String num2) {
    	StringBuilder sb = new StringBuilder();
    		for(int j = 0;j<num2.length();j++){
    			String a1 = multiply_one(num1, num2.charAt(j));
    			sb = add(sb.append('0').toString(),a1);
    			System.out.println(sb);
    		}

    	return sb.toString();
    }
    public static void main(String[] args) {
		String num1 = "12541351234624252345234697241964156106541";
		String num2 = "419641641864163413131063156341634";
//		System.out.println(add(num1,num2));
//		System.out.println(Long.parseLong(num1)+Long.parseLong(num2));
		
		System.out.println(multiply(num1, num2));
		System.out.println(Long.parseLong(num1)*Long.parseLong(num2));
	}
}
