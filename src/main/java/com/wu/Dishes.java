package com.wu;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;


import java.awt.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;


public class Dishes {

    private String id;

    private String name;

    /**
     * 测试TreeSet默认比较器及传入比较器
     */
    public static void testTreeSet() throws NoSuchAlgorithmException {
        // TreeSet不传比较器，则默认按照自然顺序排序
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(3);
        treeSet.add(1);
        treeSet.add(4);
        System.out.println(treeSet);
        // [1, 3, 4]
        System.out.println(System.currentTimeMillis());
        System.out.println(System.currentTimeMillis());
        System.out.println(System.currentTimeMillis());
        System.out.println(System.currentTimeMillis());
        System.out.println(System.currentTimeMillis());
        System.out.println(System.nanoTime());
        System.out.println(System.nanoTime());
        System.out.println(System.nanoTime());
        System.out.println(System.nanoTime());
        System.out.println(System.nanoTime());
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        System.out.println();
        TreeMap<Integer,Integer> treeMap = new TreeMap<>();
        treeMap.put(1,2);
        treeMap.put(3,4);
        treeMap.put(5,6);
        Integer lowerKey = treeMap.lowerKey(2);
        Integer higherKey = treeMap.higherKey(2);
        System.out.println(lowerKey+","+higherKey);
        Integer floorKey = treeMap.floorKey(2);
        Integer ceilingKey = treeMap.ceilingKey(2);
        System.out.println(floorKey+","+ceilingKey);
    }

    static public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        while(l<=r){
            int m = l + (r - l)/2;
            if(nums[m]==target){
                return m;
            }
            else
            if(nums[l]<=nums[m]){
                if(target>=nums[l]&&target<nums[m]){
                    r = m-1;
                }
                else{
                    l = m +1;
                }
            }
            else{
                if(target>nums[m]&&target<=nums[r]){
                    l = m+1;
                }
                else{
                    r = m-1;
                }
            }
        }
        return -1;
    }

    public static TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder,0,preorder.length-1);
    }

    public static TreeNode bstFromPreorder(int[] preorder, int l, int r){
        if(l>r){
            return null;
        }
        TreeNode root = new TreeNode(preorder[l]);
        int i=l;
        for(;i<=r;i++){
            if(preorder[i]>root.val){
                root.left = bstFromPreorder(preorder,l+1,i-1);
                root.right = bstFromPreorder(preorder,i,r);
                break;
            }
        }
        if(i>r){
            root.left = bstFromPreorder(preorder,l+1,r);
        }
        return root;
    }


    public static void main(String[] args) throws NoSuchAlgorithmException {
        int[] nums = new int[]{4,5,6,7,0,1,2};
        search(nums,0);
        System.out.println((int)'A');
        nums = new int[]{8,5,1,7,10,12};
        bstFromPreorder(nums);
        testTreeSet();
    }
}

