/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ulti;


import java.sql.*;

/**
 *
 * @author luand
 */
public class ConnectDB {
    public static Connection con = null;
    public static Connection getConnect() {
        String strDbUrl = "jdbc:sqlserver://localhost:1433; databaseName=NOI_THAT;user=sa;password=1234;"
                + "encrypt=true;trustServerCertificate=true";
        try {
            con = DriverManager.getConnection(strDbUrl);
            System.out.println("Connection Successful.");
        } catch (SQLException e) {
            System.out.println("Connection Error.: " + e);
        }
        return con;
    }
    public static void main(String[] args) {
        ConnectDB.getConnect();
    }

    public static Connection getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
