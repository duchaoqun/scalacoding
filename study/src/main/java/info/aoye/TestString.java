package main.java.info.aoye;

import java.lang.System.*;

public class TestString {
    //定义String类型的数组
    String arrayStr[] = {"jdbc:mysql://10.2.118.210:3306/", "root", "123456", "2011-01", "2017-10", "ent_alter_index"};


    public static void main(String args[]) {
        //字符串是一个特殊的对象。
        //字符串一旦初始化就不会被改变。
        String str1 = "Hello?";  //存储在字符串常量池（缓冲区）中。
        String str2 = new String("abc"); //产生了两个对象，在堆中。

        System.out.println(str1 == str2); //False   比较地址，不一样
        System.out.println(str1.equals(str2)); //True， String类中的equals复写了Object中的函数，只判断字符串内容。//todo 这里打印false 为什么？
    }
}
