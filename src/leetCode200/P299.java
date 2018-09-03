package leetCode200;

import java.util.Arrays;

public class P299 {
    public String getHint(String secret, String guess) {
        int bulls=0,cows=0;
        char[] chs = secret.toCharArray();
        char[] chg = guess.toCharArray();
        int[] ctrs = new int[10],ctrg=new int[10];
        for(int i=0;i<secret.length();i++){
        	if(chs[i]==chg[i]){
        		bulls++;
        	}
        	else{
        		ctrs[chs[i]-'0']++;
        		ctrg[chg[i]-'0']++;
        	}
        }
        for(int i=0;i<10;i++){
        	cows+=Math.min(ctrs[i], ctrg[i]);
        }
        return bulls+"A"+cows+"B";
        
    }
}
