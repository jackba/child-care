package DAO;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author W7
 */


import java.sql.*;

public class Connect {

    static String conStr = "jdbc:sqlserver://localhost;databaseName=ChildCare";
    static String userName = "sa";
    static String passWord = "123456";

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(conStr, userName, passWord);   
            System.out.println("Connect Successfull!");
        } 
        catch (ClassNotFoundException ex) 
        {
        } 
        catch (SQLException ex) 
        {
        }
        return conn;
    }
}
