import javafx.scene.layout.Priority;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

class Dest {
    public static void hello() {
        System.out.println("hello");
    }
}

public class TextDemo {


    public static void reflectNewInstance() {
        try {
            Class<?> classStudent = Class.forName("Student");
            Student student = (Student)classStudent.newInstance();
            System.out.println("获得学生对象："+student);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
    public static void reflectPrivateConstructor() {
        try {
            Class<?> classStudent = Class.forName("Student");
            Constructor<?> constructor = classStudent.getDeclaredConstructor(String.class,int.class);
            constructor.setAccessible(true);
            Student student = (Student) constructor.newInstance("小明",9);
            System.out.println("获得私有构造哈数且修改姓名和年龄："+student);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public static void reflectPrivateField() {
        try {
            Class<?> classStudent = Class.forName("Student");
            Field field = classStudent.getDeclaredField("name");
            field.setAccessible(true);
            Student student = (Student) classStudent.newInstance();
            field.set(student,"小明");
            String name = (String)field.get(student);
            System.out.println(name);
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public static void reflectPrivateMethod() {
        try {
            Class<?> classStudent = Class.forName("Student");
            Method methodStudent = classStudent.getDeclaredMethod("function",String.class);
            System.out.println("私有方法的方法名为："+methodStudent.getName());
            methodStudent.setAccessible(true);
            Object objectStudent = classStudent.newInstance();
            Student student = (Student) objectStudent;
            methodStudent.invoke(student,"我是给私有的function函数传的参数");

        }catch (Exception ex) {
            ex.printStackTrace();
         }
    }
    public static boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length()-1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
    public static int palindromeInsert(String a, String b) {
        int count = 0;
        for (int i = 0; i <= a.length(); i++) {
            StringBuilder sb = new StringBuilder(a);
            sb.insert(i,b);
            if (isPalindrome(sb.toString())) {
                count++;
            }
        }
        return count;
    }
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((n1,n2) -> n1 - n2);
        for (int i : nums) {
            heap.add(i);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.peek();
    }
    public static StringBuffer findLongNumString(String s) {
        StringBuffer nowNumStr = null;
        StringBuffer longNumStr = null;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 48 && s.charAt(i) <= 57) {
                if (nowNumStr == null) {
                    nowNumStr = new StringBuffer(String.valueOf(s.charAt(i)));
                }else {
                    nowNumStr.append(s.charAt(i));
                }
                if (nowNumStr.length() > (longNumStr != null ? longNumStr.length() : 0)) {
                    longNumStr = nowNumStr;
                }
            }else {
                nowNumStr = null;
            }
        }
        return longNumStr;

    }
    public boolean chkParenthesis(String A, int n) {
        // write code here
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (A.charAt(i) == '(') {
                stack.push('(');
            }else if (A.charAt(i) == ')') {
                if (stack.empty()) return false;
                stack.pop();
            }else {
                return false;
            }
        }
        return stack.empty();

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        StringBuffer s2 = findLongNumString(s);
        System.out.println(s2.toString());
    }
}



