package string;

import java.util.ArrayList;
import java.util.Arrays;

public class StringPermutation {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> ret = new ArrayList<String>();
        if(str.length()==0)return ret;
        char[] ch = str.toCharArray();
        Arrays.sort(ch);
        ret.add(String.valueOf(ch));
        while((ch = getNext(ch))!=null){
        	ret.add(String.valueOf(ch));
        }
        
        return ret;
    }

	private char[] getNext(char[] ch) {
		// TODO Auto-generated method stub
		for(int i=ch.length-1;i>=1;i--){
			if(ch[i]>ch[i-1]){
				//我们要找出比ch[i]大的最小数
				int l = i;
				int r = ch.length;
				//[l,r)区间内比ch[i]大的最小元素
				while(l<r){
					int mid = l+(r-l)/2;
					if(ch[i-1]>=ch[mid]){
						//[l,mid)
						r = mid;
					}
					else {
						l=mid+1;
					}
				}
				int temp=l-1;
				ch[i-1] = (char) (ch[temp]^ch[i-1]);
				ch[temp] = (char) (ch[temp]^ch[i-1]);
				ch[i-1] = (char) (ch[temp]^ch[i-1]);
				Arrays.sort(ch,i,ch.length);
				return ch;
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		System.out.println(new StringPermutation().Permutation("123456789"));
	}
}
