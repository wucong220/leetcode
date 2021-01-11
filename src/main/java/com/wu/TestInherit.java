package com.wu;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author wuc006
 * @date 2020/5/29 16:46
 */
public class TestInherit {
    public static void main(String[] args) {
//        Animal c = new Cat(5);
//        System.out.println(c.age);
//        System.out.println(c.getAge());
//        GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment(); //返回本地 GraphicsEnvironment 。
//        String [] forName = e.getAvailableFontFamilyNames(); //返回包含在此所有字体系列名称的数组， GraphicsEnvironment本地化为默认的语言环境，如返回 Locale.getDefault() 。
//        for (int i = 0; i < forName.length; i++) //逐行输出
//            System.out.println(forName[i]);
//
//
//        int[] a = new int[]{5,4,3,2,1};
//        List<Integer> list = new ArrayList<>();
        System.out.println(5&(-5));
    }

}

class Animal{
    int age ;
    Animal(int i){
        age=i;
    }
    int getAge(){
        return this.age;
    }
}

class Cat extends Animal{
    Cat(int i){
        super(i+1);
        this.age=i;
    }
    int getAge(){
        System.out.println(super.getAge());
        return this.age;
    }
}