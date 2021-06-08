package com.wu;

import java.util.Map;

/**
 * @author wuc006
 * @date 2021/4/1 9:40
 */
public class CN1006 {
    class Solution {
        public int clumsy(int N) {
            int offset = N % 4;
            int groups = N / 4;
            int answer=0;
            for(int i=groups;i>0;i--){
                int curr =(i*4+offset);
                int i1 = groups==i?1:-1;
                answer+= i1*curr * (curr - 1) / (curr - 2) + curr - 3;;
            }

            answer+=-1*offset*Math.max(1,offset-1)/ Math.max(1,offset-2)+Math.max(0,offset-3);

            return answer;
        }
    }

    public static void main(String[] args) {
        RunUtil.run(10);
    }
}
