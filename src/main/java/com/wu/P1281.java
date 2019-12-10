package main.java.com.wu;

import javax.management.relation.RoleUnresolved;

/**
 * @author wuc006
 * @date 2019/12/9 9:22
 */
public class P1281 {
    class Solution {
        public int subtractProductAndSum(int n) {
            int sum=0;
            int product=1;
            while(n>0){
                int digit= n%10;
                product*=digit;
                sum+=digit;
                //当n是个位数时结束循环
                n=n/10;
            }
            return product-sum;
        }
    }

    public static void main(String[] args) {
        RunUtil.run(243);
    }
}
