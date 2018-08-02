package main.java.info.aoye; //package用于定义包,并将类定义到这个包中.

/**
 * 1. 标示符 由字母、数字、下划线、和$ 美元符号组成，严格区分大小写，不能使用关键字作为标示符。
 * 2. 包名：通常使用小写字母
 * 3. 类名和接口名：通常定义为具有含义的单词，首字母大写
 * 4. 方法名：通常定义为具有含义的单词，第一个单词的首字母小写，后面的首字母大写
 * 5. 变量名：成员变量和方法相同，局部变量全部使用小写
 * 6. 常量名：全部使用大写字母，多个单子中间使用下划线连接。
 * 7. 单行注释// 多行注释,文档注释.
 * 8. protected：用于修饰方法和变量，这些方法可以被同一个包中的类或者子类访问。
 * 9. private： 方法和变量只能由所在类访问
 * 10 任何类都是Object类的子类
 * 11 在Java里面关键字都是小写的
 */

// 1. public所修饰的类,方法和变量是公共的,其他的类可以访问该关键字修饰的类,方法,变量.
// 2. class告诉系统后面的一个单词是一个类名,从而定义一个类.
// 3. class类名和java源文件名称必须一致
// 4. 类名称的第一个字母书写规范是大写的，多个单词，每个单词的首字母大写。
public class TestMain {


    //常量：定义一个常量需要使用final关键字，常量一般使用大写字母
    final double PI = 3.14;
    //全局常量：只要是固定的变量值(常量)都使用final声明，只要数值固定就需要使用static修饰。所以一般见到的都是
    public static final int int1 = 1; //全局常量
    static final int x = 1; //?

    //变量：变量使用小写字母
    int int2 = 5;

    /**
     * 基本数据类型,Java是一门强数据类型语言，程序中所有定义的数据都一个固定的数据类型
     * 数据类型关键字
     * 8 种基本数据类型 boolean布尔型 char字符型 字节型byte short,int、long、flort、double数值型
     */
    public void dataType() {

    }

    //todo 复合数据类型


    /**
     * java 程序的主入口点
     *
     * @param args 命令行参数，args返回的是一个字符串数组。
     */
    public static void main(String[] args) {
        System.out.println(args);
    }
}
