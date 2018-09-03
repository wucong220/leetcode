package leetCode300;

public class P316 {
    static public String removeDuplicateLetters(String s) {
    	int[] count = new int[26];
    	char[] ch = s.toCharArray();
    	for(int i=0;i<s.length();i++){
    		count[ch[i]-'a']++;
    	}
    	int[] temp = new int[26];
    	int min=0;
    	for(int i=0;i<s.length();i++){
    		temp[ch[i]-'a']++;
    		min = ch[i]<ch[min]?i:min;
    		if(temp[ch[i]-'a']==count[ch[i]-'a']){
    			return ch[min]+removeDuplicateLetters(s.substring(min+1).replaceAll(ch[min]+"", ""));
    		}
    	}
    	return "";
    }
    
    public static void main(String[] args) {
		System.out.println(removeDuplicateLetters("cbacdcbc"));
	}
}
