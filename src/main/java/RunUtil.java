package main.java.com.wu;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author wuc
 * @date 2019/12/9 9:23
 */
public class RunUtil {
    public static String methodName;
    static public Object run(Object... args){
        try {
            StackTraceElement stack = new Throwable().getStackTrace()[1];
            System.out.println(stack.getClassName());
            Class<?> problemClass = Class.forName(stack.getClassName());
            Constructor<?> constructor = problemClass.getConstructor();
            Object o1 = constructor.newInstance();
            String innerClassName = problemClass.getName() + "$Solution";
            Class<?> solutionClass = Class.forName(innerClassName);
            Constructor<?> declaredConstructor = solutionClass.getDeclaredConstructors()[0];
            declaredConstructor.setAccessible(true);
            Object o2 = declaredConstructor.newInstance(o1);
            Method method= null;

            Method[] methods = solutionClass.getMethods();
            if(methodName!=null){
                method = Arrays.stream(methods).filter(a -> a.getName().equals(
                        methodName
                )).findFirst().get();
            }
            else{
                method = methods[0];
            }
            method.setAccessible(true);
            Object o = method.invoke(o2, args);
            System.out.println(o);
            return o;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static Object toArray(String input){
        return toArray(input,null);
    }
    private static Object toArray(String input,int[] dimensions){
        input = input.replaceAll("\\s+", "");
        char[] chars = input.toCharArray();
        int level = 0;
        for (char aChar : chars) {
            if(aChar=='['){
                level++;
            }
            else if(aChar==']'){
                break;
            }
        }
        if(dimensions==null){
            dimensions = new int[level];
        }
        Object arrayObject = null;
        String substring = input.substring(1, input.length() - 1);
        List<String> components =new ArrayList<>();
        if (level == 1) {
            components = Arrays.asList(substring.split(","));
        } else {
//            components = Arrays.asList(substring.split(",(?=\\[)"));
            Stack<Integer> s = new Stack<>();
            for(int i=0;i<substring.length();i++){
                if('['==(substring.charAt(i))){
                    s.push(i);
                }
                else if(']'==(substring.charAt(i))){
                    Integer pop = s.pop();
                    if(s.empty())
                        components.add(substring.substring(pop,i+1));
                }
            }
        }
        for (int i = 0; i < components.size(); i++) {
            Object o;
            Class<?> contentType;
            String component = components.get(i);
            if(level==1) {
                try {
                    o = Integer.parseInt(component);
                    contentType=int.class;
                } catch (Exception e) {
                    try {
                        o = Double.parseDouble(component);
                        contentType=double.class;
                    } catch (Exception e1) {
                        o = String.valueOf(component);
                        contentType=String.class;
                    }
                }
            }
            else{
                o = toArray(component,dimensions);
                contentType=o.getClass().getComponentType();
            }
            if(arrayObject==null){
                int[] currDimensions = new int[level];
                dimensions[dimensions.length-level]=components.size();
                for(int j=0;j<level;j++){
                    currDimensions[j]=dimensions[dimensions.length-level+j];
                }

                arrayObject = Array.newInstance(contentType,currDimensions);
            }
            Array.set(arrayObject,i,o);
        }
        return arrayObject;
    }


}

