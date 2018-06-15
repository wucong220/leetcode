package contest;

public class P848ShiftingLetters {
	public static void main(String[] args) {
		System.out.println(shift('z',3));
		System.out.println(shiftingLetters("abc", new int[]{3,5,9}));
	}
	
	static public char shift(char input,int s){
		
		return (char)((input-'a'+s)%26+'a');
	}
    static public String shiftingLetters(String S, int[] shifts) {
    	for(int i=shifts.length-2;i>=0;i--){
    			shifts[i]=(shifts[i+1]%26+shifts[i])%26;
    	}
    	char[] ch = S.toCharArray();
    	for(int i=0;i<shifts.length;i++){
    		ch[i]=shift(ch[i],shifts[i]);
    	}
    	return String.valueOf(ch);
    }
}
