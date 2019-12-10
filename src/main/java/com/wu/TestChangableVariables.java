package main.java.com.wu;

/**
 * @author wuc006
 * @date 2019/12/9 17:50
 */
public class TestChangableVariables {
    public static void print(Object... args){
        System.out.println(args.length);
    }

    public static void main(String[] args) {
        print(new int[]{1,2,3,4,5});
        print(new int[][]{{1,2},{3,4},{5}});
        print(new int[][][]{{{1},{2}},{{3},{4},{5}}});
    }

}


