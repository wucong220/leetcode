package com.wu;

import java.util.*;

/**
 * @author wuc006
 * @date 2021/6/28 14:48
 */
public class CN1912 {
    class MovieRentingSystem {
        //[shopi, moviei, pricei]
        Map<Integer,Map<Integer,Integer>> shopList =new HashMap<>();
        Map<Integer,Map<Integer,Integer>> shopRentList =new HashMap<>();
        TreeSet<Integer> rentedList;
        Map<Integer,TreeSet<Integer>> noRentList = new HashMap<>();
        int[][] entries;

        public MovieRentingSystem(int n, int[][] entries) {
            rentedList = new TreeSet<>(Comparator.comparingInt(a -> entries[(int)a][2]).thenComparingInt(a->entries[(int)a][0]).thenComparingInt(a->entries[(int)a][1]));
            this.entries = entries;
            for (int i = 0; i < entries.length; i++) {
                int[] entry = entries[i];
                shopList.putIfAbsent(entry[0],new HashMap<>());
                shopRentList.putIfAbsent(entry[0],new HashMap<>());
                shopList.get(entry[0]).put(entry[1],i);
                noRentList.putIfAbsent(entry[1],new TreeSet<>(Comparator.comparingInt(a -> entries[(int)a][2]).thenComparingInt(a->entries[(int)a][0])));
                noRentList.get(entry[1]).add(i);
            }
            System.out.println(noRentList);
        }

        public List<Integer> search(int movie) {
            TreeSet<Integer> integers = noRentList.get(movie);
            Iterator<Integer> it = integers.iterator();
            List<Integer> list = new ArrayList<>();
            int i=5;
            while((i--)>0&&it.hasNext()){
                Integer next = it.next();
                list.add(entries[next][0]);
            }
            return list;
        }

        public void rent(int shop, int movie) {
            Map<Integer, Integer> map = shopList.get(shop);
            Integer remove = map.remove(movie);
            shopRentList.putIfAbsent(shop,new HashMap<>());
            Map<Integer, Integer> integerIntegerMap = shopRentList.get(shop);
            integerIntegerMap.put(movie,remove);

            TreeSet<Integer> integers = noRentList.get(movie);
            integers.remove(remove);
            rentedList.add(remove);
        }

        public void drop(int shop, int movie) {
            Map<Integer, Integer> integerIntegerMap = shopRentList.get(shop);
            Integer remove = integerIntegerMap.remove(movie);
            Map<Integer, Integer> map = shopList.get(shop);
            map.put(movie,remove);

            TreeSet<Integer> integers = noRentList.get(movie);
            integers.add(remove);
            rentedList.remove(remove);
        }

        public List<List<Integer>> report() {
            Iterator<Integer> iterator = rentedList.iterator();
            int i=5;
            List<List<Integer>> ret = new ArrayList<>();
            while((i--)>0&&iterator.hasNext()){
                Integer next = iterator.next();
                ret.add(Arrays.asList(entries[next][0],entries[next][1]));
            }
            return ret;
        }
    }

/**
 * Your MovieRentingSystem object will be instantiated and called as such:
 * MovieRentingSystem obj = new MovieRentingSystem(n, entries);
 * List<Integer> param_1 = obj.search(movie);
 * obj.rent(shop,movie);
 * obj.drop(shop,movie);
 * List<List<Integer>> param_4 = obj.report();
 */

public static void main(String[] args) {
    TreeSet<Integer> a = new TreeSet<>();
    a.addAll(Arrays.asList(1,3,2,4));
    System.out.println(a);
}
}
