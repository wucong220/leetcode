package com.wu.bd;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wuc006
 * @date 2021/4/22 16:02
 */
public class BrokeWood {
    public void brokeWood(int[] array){
        List<Integer> list = new ArrayList<>();
        for(int a:array){
            list.add(a);
        }
        for(int i=0;i<list.size()-1;i++){
            if(list.get(i)>list.get(i+1)){
                list.set(i,list.get(i)/2);

            }
        }

    }
}
