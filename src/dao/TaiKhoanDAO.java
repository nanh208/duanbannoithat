/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.*;
import ulti.ConnectDB;
/**
 *
 * @author Admin
 */
public class TaiKhoanDAO {
    public boolean kiemTraDangNhap(String username, String password) {
        String sql = "SELECT * FROM TaiKhoan WHERE TenDangNhap = ? AND MatKhau = ?";
        try (Connection con = ConnectDB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            return rs.next(); // true nếu tìm thấy
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
