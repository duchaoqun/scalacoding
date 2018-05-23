package info.aoye;


import java.util.ArrayList;

/**
 * Array
 */
public class TestArray {

    public static void main(String args[]) {
        //创建字符串数组
        String[] strArray1 = new String[]{"sys_info", "sys_detailinfo"};


        int array1[];            //声明一个数组
        array1 = new int[6];    //给数组分配内存

        array1[0] = 1;  //初始化数组
        array1[1] = 2;  //初始化数组
        array1[2] = 3;  //初始化数组
        array1[3] = 4;  //初始化数组,未初始化的部分使用0补充。

        int[] array2 = {1, 2, 3, 4};  //初始化数组

        int[] array3, array4;    //声明两个数组，这个更常用

        //读取数组中的内容
        int a = array1[1];       //数组下标从0开始，这里取第二个元素赋值给变量a


        //在Java中数组是一种对象，它有一个自己的实例变量，length变量，这个变量值是数组的长度
        System.out.println(array1.length);

        //遍历这个数组
        for (int i = 0; i < array1.length; i++) {
            System.out.println(array1[i]);
        }
    }
}
