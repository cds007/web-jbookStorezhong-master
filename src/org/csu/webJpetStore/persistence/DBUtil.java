package org.csu.webJpetStore.persistence;

import java.sql.*;

public class DBUtil {
    //改成cj
    private static String driveString = "com.mysql.cj.jdbc.Driver";
    private static String connectionString = "jdbc:mysql://localhost:3306/book2";
    private static String username = "root";
    private static String password = "123456";

    //获取连接
    public static Connection getConnection() throws Exception {
        Connection connection = null;
        try {
            Class.forName(driveString);
            connection = DriverManager.getConnection(connectionString, username, password);
        }catch (Exception e){
            throw e;
        }
        if (connection == null){
            System.out.println("connection is null!");
        }else{
            System.out.println("connection is not null!");
        }
        return connection;

    }

    public static void closeStatement(Statement statement) throws Exception {
        statement.close();
    }

    public static void closePreparedStatent(PreparedStatement pStatement) throws Exception{
        pStatement.close();
    }

    public static void closeResultSet(ResultSet resultSet) throws Exception{
        resultSet.close();
    }

    //关闭连接
    public static void closeConnection(Connection connection) throws Exception {
        connection.close();
    }

    /*test the db connection
    public static void main(String[] args) throws Exception{
        Connection conn = DBUtil.getConnection();
        System.out.println(conn);
    }
    */
}
