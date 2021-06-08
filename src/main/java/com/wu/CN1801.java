package com.wu;

import java.util.PriorityQueue;

/**
 * @author wuc006
 * @date 2021/3/29 10:13
 */
public class CN1801 {
    class Solution {
        int mod = 1000_000_007;
        public int getNumberOfBacklogOrders(int[][] orders) {
            PriorityQueue<int[]> buy = new PriorityQueue<>((a,b)->b[0]-a[0]);
            PriorityQueue<int[]> sell = new PriorityQueue<>((a,b)->a[0]-b[0]);
            for (int[] order : orders) {
                int price = order[0];
                int amount = order[1];
                int type = order[2];
                if(type == 0){
                    if(sell.isEmpty()){
                        buy.offer(order);
                    }
                    else {
                        while(true) {
                            if(!sell.isEmpty()) {
                                int[] peek = sell.peek();
                                if (price >= peek[0]) {
                                    if (amount >= peek[1]) {
                                        sell.poll();
                                        amount -= peek[1];
                                    } else {
                                        peek[1] -= amount;
                                        break;
                                    }
                                } else {
                                    if(amount>0){
                                        order[1]=amount;
                                        buy.offer(order);
                                    }
                                    break;
                                }
                            }
                            else{
                                if(amount>0){
                                    order[1]=amount;
                                    buy.offer(order);
                                }
                                break;
                            }
                        }
                    }
                }
                else{
                    while(true) {
                        if(!buy.isEmpty()) {
                            int[] peek = buy.peek();
                            if (price <= peek[0]) {
                                if (amount >= peek[1]) {
                                    buy.poll();
                                    amount -= peek[1];
                                } else {
                                    peek[1] -= amount;
                                    break;
                                }
                            } else {
                                if(amount>0){
                                    order[1]=amount;
                                    sell.offer(order);
                                }
                                break;
                            }
                        }
                        else{
                            if(amount>0){
                                order[1]=amount;
                                sell.offer(order);
                            }
                            break;
                        }
                    }
                }
            }
            return (buy.stream().map(a->a[1]).reduce((a,b)->(a+b)%mod).orElse(0)%mod+sell.stream().map(a->a[1]).reduce((a,b)->(a+b)%mod).orElse(0)%mod)%mod;
        }
    }
}
