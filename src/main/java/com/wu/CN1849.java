package com.wu;

public class CN1849 {
    class Solution {
        String origin;
        public boolean splitString(String s){
            origin=s;
            return splitString(s,-1);
        }

        public boolean splitString(String s,long num) {
            if(s.length()==0){
                return true;
            }
            boolean flag=false;
            int prefix = -1;
            boolean ret = false;
            for(int i=0;i<s.length();i++){
                if (flag || s.charAt(i) != '0') {
                    flag = true;
                    if(prefix==-1)prefix=i;
                    String substring = s.substring(prefix, i + 1);
                    if(i==s.length()-1&&s.equals(origin))continue;
                    try{
                        long curr = Long.parseLong(substring);
                        if(curr == num-1||num==-1) {
                            ret = ret || splitString(s.substring(i + 1), curr);
                        }
                    }catch(Exception e){
                        break;
                    }
                }
            }
            if(!flag && num==1)return true;
            return ret;
        }
    }
    
    public static void main(String[] args) {
        RunUtil.run(
                "99999999999999999998");
    }
}
