package com.wu;

/**
 * @author wuc006
 * @date 2021/6/17 14:53
 */
public class CN1898 {
    public int maximumRemovals(String s, String p, int[] removable) {
        int r = removable.length+1;
        int l = 0;
        while(l<r){
            int m = l + (r - l)/2;
            if(isSubstring(s,p,removable,m)){
                l = m+1;
            }
            else{
                r = m;
            }
        }
        return l-1;
    }

    private boolean isSubstring(String s, String p, int[] removable, int m) {
        char[] ch = s.toCharArray();
        for(int i=0;i<m;i++){
            ch[removable[i]]='#';
        }
        for(int i=0,j=0;i<ch.length;i++){
            if(j<p.length()&&ch[i] == p.charAt(j)){
                j++;
            }
            if(j==p.length())return true;
        }
        return false;
    }
}
