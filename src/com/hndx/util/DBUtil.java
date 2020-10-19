package com.hndx.util;

import java.sql.*;

public class DBUtil {
    /**
     * 工具类的构造方法都是私有的
     * 因为工具类的方法都是静态的，不需要new对象，直接采用类名调用
     */
    private  DBUtil(){}

    //静态代码块在类加载时执行，并且只执行一次
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接对象
     * @return 连接对象
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/zheng", "root", "123");
    }

    /**
     * 关闭资源
     * @param connection 连接对象
     * @param ps 数据库操作对象
     * @param rs 结果集
     */
    public static void close(Connection connection, Statement ps, ResultSet rs){
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}
