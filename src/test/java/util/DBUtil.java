package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    static String url = "jdbc:mysql://172.17.2.205:3306/aoye?useUnicode=true&characterEncoding=UTF-8";
    static String db_user = "root";
    static String db_password = "Rexen@123.com.cn";
    static Connection conn = null;

    static {
        // 加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, db_user, db_password);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return conn;
    }
}