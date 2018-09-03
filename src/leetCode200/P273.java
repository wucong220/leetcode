package leetCode200;

public class P273 {
    public String numberToWords(int num) {
    	
    	final String[] ge = {"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"}; 
    	final String[] shi ={"Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    	final String[] ers ={"","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    	final String[] linj = {"","Thousand","Million","Billion"};
    	
    	char[] ch = String.valueOf(num).toCharArray();
    	StringBuilder sb = new StringBuilder();
    	int group = ch.length/3;
    	int offset = ch.length%3;
    	int i=0;
    	if(offset>0){
    		if(offset==2){
    			if(ch[0]=='1'){
    				sb.append(shi[ch[1]-'0']+" ");
    			}
    			else{
    				sb.append(ers[ch[0]-'0']+" ").append(ge[ch[1]-'0']+" ");
    			}
    		}
    		else{
    			sb.append(ge[ch[0]-'0']+" ");
    		}
    		sb.append(linj[group]+" ");
    		group--;
    		i = offset;
    	}
    	else group--;
    	
    	while(group>=0){
    		if(ch[i]!='0')sb.append(ge[ch[i]-'0']+" Hundred ");
			if(ch[i+1]=='1'){
				sb.append(shi[ch[i+2]-'0']+" ");
			}
			else{
				sb.append(ers[ch[i+1]-'0']+" ").append(ge[ch[i+2]-'0']+" ");
			}
			sb.append(linj[group]+" ");
			group--;
			i=i+3;
    	}
    	return 	sb.toString().trim();   
    }
    public static void main(String[] args) {
		String s = new P273().numberToWords(1234567891);
		System.out.println("'"+s+"'");
	}
}
