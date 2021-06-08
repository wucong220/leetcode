package com.wu;

import java.util.List;

/**
 * @author wuc006
 * @date 2021/2/28 13:37
 */
public class CN5689 {
    class Solution {
        public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
            int count = 0;
            for(int i =0;i<items.size();i++){
                switch (ruleKey){
                    case "type":count+=items.get(i).get(0).equals(ruleValue)?1:0;break;
                    case "color":count+=items.get(i).get(1).equals(ruleValue)?1:0;break;
                    case "name":count+=items.get(i).get(2).equals(ruleValue)?1:0;break;
                }
            }
            return count;
        }
    }
}
