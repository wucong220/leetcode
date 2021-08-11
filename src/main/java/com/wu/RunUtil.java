package com.wu;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class RunUtil {
    static String methodName = null;
    static Class[] params = null;

    static public Object run(Object... args) {
        try {
            StackTraceElement stack = new Throwable().getStackTrace()[1];
            System.out.println(stack.getClassName());
            Class<?> problemClass = Class.forName(stack.getClassName());
            Constructor<?> constructor = problemClass.getConstructor();
            Object o1 = constructor.newInstance();
            String innerClassName = problemClass.getName() + "$Solution";
            Class<?> solutionClass = Class.forName(innerClassName);
            Object o2 = solutionClass.getDeclaredConstructors()[0].newInstance(o1);
            Method[] methods = solutionClass.getMethods();

            for (int i = 0; i < methods.length; i++) {
                Method method = methods[i];
                Class<?>[] parameterTypes = method.getParameterTypes();
                if(args.length!=method.getParameterCount())continue;
                int j = 0;
                for (; j < parameterTypes.length; j++) {
                    Class<?> parameterType = parameterTypes[j];
                    Class<?> aClass = args[j].getClass();
                    if (aClass != parameterType) {
                        break;
                    }
                }
//                if(j<parameterTypes.length)continue;

                if (methodName != null)
                    method = Arrays.stream(solutionClass.getMethods()).filter(a->a.getName().contains(methodName)).findFirst().get();
                Object o = method.invoke(o2, args);
                if(o instanceof Array){
                    System.out.println(Arrays.deepToString((Object[]) o));
                }
                else System.out.println(o);
                return o;
            }
            System.out.println("没有找到方法");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    static Class<?> rootContentType;
    public static Object toArray(String input) {
        input = input.replaceAll("\\s+", "");
        char[] chars = input.toCharArray();
        int level = 0;
        for (char aChar : chars) {
            if (aChar == '[') {
                level++;
            } else if (aChar == ']') {
                break;
            }
        }


        String substring = input.substring(1, input.length() - 1);
        List<String> components = new ArrayList<>();
        if (level == 1) {
            if(substring.length()>0) components = Arrays.asList(substring.split(","));
        } else {
//            components = Arrays.asList(substring.split(",(?=\\[)"));
            Stack<Integer> s = new Stack<>();
            for (int i = 0; i < substring.length(); i++) {
                if ('[' == (substring.charAt(i))) {
                    s.push(i);
                } else if (']' == (substring.charAt(i))) {
                    Integer pop = s.pop();
                    if (s.empty())
                        components.add(substring.substring(pop, i + 1));
                }
            }
        }
        Object arrayObject = null;
        Class<?> contentType = rootContentType;
        for (int i = 0; i < components.size(); i++) {
            Object o;
            String component = components.get(i);
            if (level == 1) {
                try {
                    o = Integer.parseInt(component);
                    contentType = int.class;
                } catch (Exception e) {
                    try {
                        o = Double.parseDouble(component);
                        contentType = double.class;
                    } catch (Exception e1) {
                        o = String.valueOf(component);
                        contentType = String.class;
                    }
                }
                rootContentType = contentType;
            } else {
                o = toArray(component);
                contentType = o.getClass();
            }
            break;
        }

        arrayObject = Array.newInstance(contentType, components.size());
        for(int i=0;i<components.size();i++){
            Object o;
            String component = components.get(i);
            if (level == 1) {
                try {
                    o = Integer.parseInt(component);
                } catch (Exception e) {
                    try {
                        o = Double.parseDouble(component);
                    } catch (Exception e1) {
                        o = String.valueOf(component);
                        String temp = (String) o;
                        if(temp.startsWith("\"")&&temp.endsWith("\"")){
                            o = temp.substring(1,temp.length()-1);
                        }
                    }
                }
            } else {
                o = toArray(component);
            }
            Array.set(arrayObject, i, o);
        }
        return arrayObject;
    }

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, NoSuchFieldException, ClassNotFoundException {
//        RunUtil.run(RunUtil.class);
        Object o = RunUtil.toArray("[\n" +
                "  [a,b,c,d],\n" +
                "  [h,g,f,e],\n" +
                "  [i,j,k,l]\n" +
                "]");
        System.out.println(Arrays.deepToString((Object[]) o));

        int[][][] a = new int[3][3][3];
        a[0] = new int[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        System.out.println(Arrays.deepToString(a));
        //        int[][] a = new int[][]{{1,2},{3}};
//        System.out.println(a.getClass().getComponentType());
//        System.out.println(Arrays.deepToString((Object[]) o));
    }
}
