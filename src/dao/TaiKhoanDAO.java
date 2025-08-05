/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.NhanVienEntity;
import java.sql.*;
import java.util.List;
import javax.swing.JOptionPane;
import ulti.ConnectDB;

/**
 *
 * @author Admin
 */
public class TaiKhoanDAO {

    public boolean kiemTraDangNhap(String username, String password) {
        String sql = "SELECT * FROM TaiKhoan WHERE TenDangNhap = ? AND MatKhau = ?";
        try (Connection con = ConnectDB.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            return rs.next(); // true nếu tìm thấy
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public long getAccountID(String username) {
        String query = "SELECT * FROM TaiKhoanNV WHERE tenTaiKhoan = ?";
        try (Connection con = ConnectDB.getConnect(); PreparedStatement statement = con.prepareStatement(query)) {

            statement.setString(1, username);

            ResultSet result = statement.executeQuery();
            if (result.next()) {
                return result.getLong("maTaiKhoan");
            } else {
                JOptionPane.showMessageDialog(null, "Không thể tìm thấy tài khoản. \nHãy báo cho quản trị viên để hỗ trợ.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
