package main.java.info.aoye.TestAnnotation;

import javax.swing.*;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Java提供了四种注解，专门负责新注解的创建
 * 注解类的定义很像一个空的接口
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface DBTable {
    /*
    @Target：表示该注解可以用于什么地方。
    取值（ElementType）包括：
    CONSTRUCTOR:用于描述构造器
    FIELD:用于描述域,注解可以被添加在属性上
    LOCAL_VARIABLE:用于描述局部变量
    METHOD:用于描述方法
    PACKAGE:用于描述包
    PARAMETER:用于描述参数
    TYPE:用于描述类、接口(包括注解类型) 或enum声明

    @Retention：表示需要在什么级别保存该注解信息。
    取值（RetentionPolicy）包括：
    SOURCE:在源文件中有效（即源文件保留）
    CLASS:在class文件中有效（即class保留）
    RUNTIME:在运行时有效（即运行时保留），因此可以通过反射机制读取注解的信息。

    @Documented:表示将此注解包含在javadoc中。

    @Inherited：表示允许子类继承父类中的注解。
     */

    //注解类中定义的元素称为注解元素，注解元素所使用的类型有很多
    //所有的注解元素都有一个默认值
    public String name() default "";  //注解的name属性
}
