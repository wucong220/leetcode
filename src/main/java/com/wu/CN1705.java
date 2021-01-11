package com.wu;

import java.util.PriorityQueue;

/**
 * @author wuc006
 * @date 2020/12/31 14:07
 */
public class CN1705 {
    class Solution {
        public int eatenApples(int[] apples, int[] days) {
            PriorityQueue<Apple> pq = new PriorityQueue<>((a, b) -> a.expireDate - b.expireDate);
            int count=0;
            for(int i=0;;i++){
                if(i<apples.length) {
                    pq.offer(new Apple(i + days[i], apples[i]));
                }else{
                    if(pq.isEmpty())break;
                }

                while (!pq.isEmpty()){
                    Apple peek = pq.peek();
                    if(peek.expireDate>i){
                        peek.count--;
                        count++;
                        if(peek.count==0){
                            pq.poll();
                        }
                        break;
                    }
                    else{
                        pq.poll();
                    }
                }
            }
            return count;
        }

        private class Apple {
            int expireDate;
            int count;

            public Apple(int expireDate,int count) {
                this.expireDate = expireDate;
                this.count = count;
            }
        }
    }

    public static void main(String[] args) {
        RunUtil.run(
                RunUtil.toArray("[9,24,5,12,15,21,13,12,28,0,21,6,0,26,20,0,21,21,7,0,19,25,0,30,32,32,0,0,0,22,0,11,2,27,16,0,15,12,14,33,10,11,0,13,11,0,27,0,0,14,20,11,0,22,10,1,22,6,0,13,31,33,30,27,2,30,18]"),
                RunUtil.toArray("[3,48,2,21,20,13,25,9,20,0,34,6,0,33,38,0,42,24,9,0,20,38,0,30,52,22,0,0,0,27,0,22,2,53,8,0,10,18,1,62,20,15,0,9,13,0,28,0,0,24,2,2,0,9,3,2,1,2,0,15,46,58,37,12,1,28,29]")
        );
    }
}
