package com.wu;

import java.util.*;

/**
 * @author wuc006
 * @date 2021/1/6 9:17
 */
public class CN399 {
    class Solution {
        public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
            Map<String,Map<String,Double>> routes = new HashMap<>();
            Set<String> variables = new HashSet<>();
            for (int i = 0; i < equations.size(); i++) {
                List<String> equation = equations.get(i);
                routes.putIfAbsent(equation.get(0),new HashMap<>());
                routes.putIfAbsent(equation.get(1),new HashMap<>());
                routes.get(equation.get(0)).put(equation.get(1),values[i]);
                routes.get(equation.get(1)).put(equation.get(0),1/values[i]);
                variables.add(equation.get(0));
                variables.add(equation.get(1));
            }
            for (String i : variables) {
                for (String j : variables) {
                    for (String k : variables) {
                        Double aDouble = routes.get(i).get(k);
                        Double aDouble1 = routes.get(k).get(j);
                        if(aDouble !=null&& aDouble1 !=null){
                            routes.get(i).put(j,aDouble*aDouble1);
                            routes.get(j).put(i,1/aDouble/aDouble1);
                        }
                    }
                }
            }
            double[] ret = new double[queries.size()];
            for (int i = 0; i < queries.size(); i++) {
                List<String> query = queries.get(i);
                if (routes.get(query.get(0))!=null&&routes.get(query.get(0)).get(query.get(1)) != null) {
                    ret[i]=routes.get(query.get(0)).get(query.get(1));
                }
                else{
                    ret[i]=-1;
                }
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        List<List<String>> equations= Arrays.asList(Arrays.asList("a","b"),Arrays.asList("b","c"));
        double[] values = new double[]{2.0,3.0};
        List<List<String>> queries=Arrays.asList(Arrays.asList("a","c"),Arrays.asList("b","a"),Arrays.asList("a","e"),Arrays.asList("a","a"),Arrays.asList("x","x"));
        Object run = RunUtil.run(equations, values, queries);
        System.out.println(Arrays.toString((double[]) run));
    }
}
