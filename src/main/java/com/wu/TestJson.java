package com.wu;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wuc006
 * @date 2019/12/20 15:26
 */
public class TestJson {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<String, String>();
        map.put("staffId","12345678");
        map.put("deptId","12345678");
        map.put("setId","12345678");
        String str = JSON.toJSONString(map);
        System.out.println(str);
    }
}
