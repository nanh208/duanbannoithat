/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ulti;


import java.sql.*;
import javax.swing.JOptionPane;

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
            JOptionPane.showMessageDialog(null, "Không kết nối được với dữ liệu. Lỗi: " + e + "\nHãy báo với quản trị viên để hỗ trợ.");
        }
        return con;
    }
    public static void main(String[] args) {
        ConnectDB.getConnect();
    }

    public static Connection getConnection() {
        throw new UnsupportedOperationException("Wrong method vro, use getConnect() instead of getConnect*ion*()"
                + "\nNhầm phương thức r vro, hãy dùng getConnect() thay vì getConnectION()"); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
