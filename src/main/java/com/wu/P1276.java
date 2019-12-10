package main.java.com.wu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wuc006
 * @date 2019/12/10 13:48
 */
public class P1276 {
    class Solution {
        public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
            int total_jumbo=0;
            int total_small=0;
            //total_jumbo*4+total_small*2=tomatoSlices
            //total_jumbo+total_small=cheeseSlices
            //total_jumbo>=0
            //total_small>=0
            float t = (float)tomatoSlices;
            float c = (float)cheeseSlices;
            float j = t/2-c;
            float s = 2*c-t/2;
            if(j==(int)j
                    &&s==(int)s
                    &&j>=0&&s>=0){
                return Arrays.asList((int)j,(int)s);
            }
            else{
                return new ArrayList<>();
            }

        }
    }

    public static void main(String[] args) {
        RunUtil.run(17,4);
    }
}
