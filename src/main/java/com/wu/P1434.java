package com.wu;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wuc006
 * @date 2020/5/14 13:47
 */
public class P1434 {
    class Solution {
        public int numberWays(List<List<Integer>> prefs) {
            long hats =0x1FF_FFFF_FFFFL;
            List<Map<Long,Integer>> save = new ArrayList<>();
            for(int i=0;i<prefs.size();i++){
                save.add(new HashMap<>());
            }
            return dfs(prefs,0,hats,save);
        }

        public int dfs(List<List<Integer>> prefs, int i, long hats, List<Map<Long, Integer>> save){
            if(i==prefs.size())return 1;
            if(hats==0)return 0;
            if(save.get(i).containsKey(hats)){
                return save.get(i).get(hats);
            }
            List<Integer> pref = prefs.get(i);
            int ret = 0;
            for(int hat:pref){
                if((hats&(1<<(hat-1)))!=0){
                    hats=hats&(~(1<<(hat-1)));
                    ret += dfs(prefs,i+1,hats, save);
                    hats=hats|(1<<(hat-1));
                }
            }
            save.get(i).put(hats,ret);
            return ret;
        }
    }

    public static void main(String[] args) {
//        BigDecimal bigDecimal = new BigDecimal("1");
//        System.out.println(bigDecimal.toString());
//        RunUtil.run(RunUtil.toArray("[[1,2,3,4],[1,2,3,4],[1,2,3,4],[1,2,3,4]]"));
//
//

        LocalDate birth = LocalDate.of(1994, 2, 20);
        LocalDate now = LocalDate.now();
        Period between = Period.between(birth, now);
        System.out.println(between);
        System.out.println(between.getYears());
        System.out.println(between.getMonths());
        System.out.println(between.getDays());
    }
}
