//package util;
//
//import java.sql.ResultSetMetaData;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//import com.google.gson.*;
//
//public class ResultToJson {
//
//    /**
//     * 将SQL执行结果集 转换成 JsonArray
//     *
//     * @param rs
//     * @return
//     */
//    public static JsonArray ResultSetToJsonArray(ResultSet rs) {
//        JsonObject element = null;
//        JsonArray ja = new JsonArray();
//        ResultSetMetaData rsmd = null;
//        String columnName, columnValue = null;
//        try {
//            rsmd = rs.getMetaData();
//            while (rs.next()) {
//                element = new JsonObject();
//                for (int i = 0; i < rsmd.getColumnCount(); i++) {
//                    columnName = rsmd.getColumnName(i + 1);
//                    columnValue = rs.getString(columnName);
//                    element.addProperty(columnName, columnValue);
//                }
//                ja.add(element);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return ja;
//    }
//
//    /**
//     * 将SQL执行结果集 转换成JsonObject
//     *
//     * @param rs
//     * @return
//     */
//    public static JsonObject ResultSetToJsonObject(ResultSet rs) {
//        JsonObject element = null;
//        JsonArray ja = new JsonArray();
//        JsonObject jo = new JsonObject();
//        ResultSetMetaData rsmd = null;
//        String columnName, columnValue = null;
//        try {
//            rsmd = rs.getMetaData();
//            while (rs.next()) {
//                element = new JsonObject();
//                for (int i = 0; i < rsmd.getColumnCount(); i++) {
//                    columnName = rsmd.getColumnName(i + 1);
//                    columnValue = rs.getString(columnName);
//                    element.addProperty(columnName, columnValue);
//                }
//                ja.add(element);
//            }
//            jo.add("result", ja);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return jo;
//    }
//
//    /**
//     * 将SQL执行结果返回的ResultSet 转换成JsonString
//     * @param rs
//     * @return
//     */
//    public static String ResultSetToJsonString(ResultSet rs) {
//        return ResultSetToJsonObject(rs).toString();
//    }
//
//    /**
//     * 将bean转换成Json字符串
//     * @param bean
//     * @return
//     */
//    public static String beanToJSONString(Object bean) {
//        return new Gson().toJson(bean);
//    }
//
//    /**
//     * 将jsonString 转换成beanClass
//     * 注：转换后的对象使用前进行强转：例如bean bean1 = (bean)FormatUtil.JSONToObject(json, bean.class);
//     * @param jsonStr
//     * @param beanClass
//     * @return
//     */
//    public static Object JsonStringToObject(String jsonStr,Class beanClass) {
//        Gson gson = new Gson();
//        Object res = gson.fromJson(jsonStr, beanClass);
//        return res;
//    }
//}
//
