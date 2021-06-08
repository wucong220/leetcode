package CN;

import main.java.com.wu.RunUtil;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CN679 {
    class Solution {

        public boolean judgePoint24(int[] nums){
            for(int i=0;i<nums.length;i++){
                for (int j = 0; j < nums.length; j++) {
                    if(i==j)continue;
                    for (int k = 0; k < nums.length; k++) {
                        if(i==k||j==k)continue;
                        for (int l = 0; l < nums.length; l++) {
                            if(i==l||j==l||k==l)continue;
                            if(judgePoint241(new int[]{nums[i],nums[j],nums[k],nums[l]}))return true;
                        }
                    }
                }
            }
            return false;
        }

        public boolean judgePoint241(int[] nums) {
        /*
           1 (. .) (. .)
           2 . (. .) .
           3 (. . .) .
           4 . (. . .)
        */
            double n1 = nums[0];
            double n2 = nums[1];
            double n3 = nums[2];
            double n4 = nums[3];
            //case1:
            if(Math.abs(n1-8)<=0.01&&Math.abs(n2-4)<=0.01){
                int a = 1;
            }
            if(combine(combine(n1,n2),combine(n3,n4)))return true;
            //case2:
            for(double d:combine(n2,n3)){
                if(contains(combine(n1,d,n4),24.0)){
                    return true;
                };
            }
            //case3:
            for(double d:combine(n1,n2,n3)){
                if(contains(combine(d,n4),24.0))return true;
            }
            //case4:
            for(double d:combine(n2,n3,n4)){
                if(contains(combine(n1,d),24.0))return true;
            }
            return false;
        }

        Set<Double> combine(double a,double b){
            Set<Double> set = new HashSet<>();
            set.add(a+b);
            set.add(a-b);
            set.add(a*b);
            set.add(1.0*a/b);
            return set;
        }

        boolean combine(Set<Double> a,Set<Double> b){
            for(Double d1:a){
                for(Double d2:b){
                    Set<Double> combine = combine(d1, d2);
                    if(contains(combine,24.0)){
                        return true;
                    }
                }
            }
            return false;
        }

        Set<Double> combine(double a, double b, double c){
            Set<Double> ret = new HashSet<>();
            Set<Double> c1 = combine(a,b);
            for(double d:c1){
                ret.addAll(combine(d,c));
            }
            Set<Double> c2 = combine(b,c);
            for(double d:c2){
                ret.addAll(combine(a,d));
            }
            return ret;
        }

        public boolean contains(Set<Double> d,Double t){
            double epsilon = 0.01;
            for(double dd:d){
                if(Math.abs(dd-t)<epsilon)return true;
            }
            return false;
        }
    }



    public static void main(String[] args) {
        RunUtil.methodName= "judgePoint24";
        main.java.com.wu.RunUtil.run(new int[]{1,4,6,1});
//        System.out.println(new HashSet<>(Arrays.asList(24.0)).contains(24.0));
    }
}
