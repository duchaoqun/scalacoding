package main.java.info.aoye.TestAnnotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * 实现注解处理器
 注解类使用上了，我们还需要一个注解处理器来解析我们定义的Bean，这样才能将注解转换成我们需要的操作。
 以下定义解析Bean的注解处理器，我们的目的是要输出一条SQL语句。主要用到了反射技术。
 */
public class TableCreator {
    public static void main(String[] args) throws Exception {
//传入我们定义好的Bean类名，带上包名
        Class<?> cl = Class.forName("annotation.Member");
//检查我们传入的类是否带有@DBTable注解
        DBTable dbTable = cl.getAnnotation(DBTable.class);
        List<String> columnDefs = new ArrayList<String>();
//得到类中的所有定义的属性
        for (Field filed : cl.getDeclaredFields()) {
            String columnName = null;
//得到属性的注解，对一个目标可以使用多个注解
            Annotation[] anns = filed.getAnnotations();
            if (anns.length < 1) {
                continue;
            }
//SQLString注解走着
            if (anns[0] instanceof SQLString) {
                SQLString sString = (SQLString) anns[0];
//name()使用的是默认值，所以这里取属性名
                if (sString.name().length() < 1) {
                    columnName = filed.getName().toUpperCase();
                } else {
                    columnName = sString.name();
                }
//构建SQL语句
                columnDefs.add(columnName + " VARCHAR(" + sString.value() + ")" + getConstraints(sString.constraints()));
            }
//SQLInteger注解走着
            if (anns[0] instanceof SQLInteger) {
                SQLInteger sInt = (SQLInteger) anns[0];
                if (sInt.name().length() < 1) {
                    columnName = filed.getName().toUpperCase();
                } else {
                    columnName = sInt.name();
                }
                columnDefs.add(columnName + " INT" + getConstraints(sInt.constraints()));
            }
        }
        StringBuilder creator = new StringBuilder("CREATE TABLE " + dbTable.name() + "( ");
        for (String c : columnDefs) {
            creator.append("\n" + c + ",");
        }
        creator.deleteCharAt(creator.length() - 1);
        creator.append(")");
        System.out.println(creator.toString());
    }

    private static String getConstraints(Constraints con) {
        String constraints = "";
        if (!con.allowNull()) {
            constraints += " NOT NULL";
        }
        if (con.primaryKey()) {
            constraints += " PRIMARY KEY";
        }
        if (con.unique()) {
            constraints += " UNIQUE";
        }
        return constraints;
    }
}