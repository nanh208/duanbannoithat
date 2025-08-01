/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.NhanVienEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import ulti.ConnectDB;

/**
 *
 * @author meoba
 */
public class TaiKhoanNVDAO {
        public List<NhanVienEntity> getAll() {
        List<NhanVienEntity> list = new ArrayList();
        try {
            Connection con = ConnectDB.getConnect();
            String sql = "select * from TaiKhoanNV";
            PreparedStatement statement  = con.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                NhanVienEntity ban = new NhanVienEntity(result.getLong("maTaiKhoan"),
                    result.getString("password"),
                    result.getString("tenTaiKhoan"),
                    result.getString("Email"),
                    result.getString("permission"),
                    result.getInt("SDT"),
                    result.getDate("namSinh"));
                list.add(ban);
            }
        } catch (Exception e) {
            
            System.out.println("Lỗi get all tk" + e.getMessage());
        }
        return list;
    }
        public void insert(NhanVienEntity nv) {
    try {
        Connection con = ConnectDB.getConnect();
        String sql = "INSERT INTO TaiKhoanNV (tenTaiKhoan, Email, password, namSinh, SDT, permission) "
                   + "VALUES ( ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = con.prepareStatement(sql);
        statement.setString(1, nv.getTenTK());
        statement.setString(2, nv.getEmail());
        statement.setString(3, nv.getPassword());
        statement.setDate(4, new java.sql.Date(nv.getNamSinh().getTime())); // chuyển từ java.util.Date sang java.sql.Date
        statement.setInt(5, nv.getSdt());
        statement.setString(6, nv.getPermission());

        statement.executeUpdate();
    } catch (Exception e) {
        System.out.println("Lỗi insert tài khoản nhân viên: " + e.getMessage());
    }
}
     public void update(NhanVienEntity nv) {
    try {
        Connection con = ConnectDB.getConnect();
        String sql = "UPDATE TaiKhoanNV SET tenTaiKhoan = ?, Email = ?, password = ?, namSinh = ?, SDT = ?, permission = ? WHERE maTaiKhoan = ?";
        PreparedStatement statement = con.prepareStatement(sql);

        statement.setString(1, nv.getTenTK());
        statement.setString(2, nv.getEmail());
        statement.setString(3, nv.getPassword());

        // Chuyển java.util.Date thành java.sql.Date
        java.sql.Date sqlDate = new java.sql.Date(nv.getNamSinh().getTime());
        statement.setDate(4, sqlDate);

        statement.setInt(5, nv.getSdt());
        statement.setString(6, nv.getPermission());
        statement.setLong(7, nv.getMaTK());

        statement.executeUpdate();
    } catch (Exception e) {
        System.out.println("Lỗi update tài khoản nhân viên: " + e.getMessage());
    }
}
     public void delete(long maTK) {
    try {
        Connection con = ConnectDB.getConnect();
        String sql = "DELETE FROM TaiKhoanNV WHERE maTaiKhoan = ?";
        PreparedStatement statement = con.prepareStatement(sql);
        statement.setLong(1, maTK);
        statement.executeUpdate();
    } catch (Exception e) {
        System.out.println("Lỗi xóa tài khoản nhân viên: " + e.getMessage());
    }
}
     public NhanVienEntity checkLogin(long maTaiKhoan, String password, String permission) {
    try {
        Connection con = ConnectDB.getConnect();
        String sql = "SELECT * FROM TaiKhoanNV WHERE maTaiKhoan = ? AND password = ? AND permission = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setLong(1, maTaiKhoan);
        stmt.setString(2, password);
        stmt.setString(3, permission);

        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return new NhanVienEntity(
                rs.getLong("maTaiKhoan"),
                rs.getString("password"),
                rs.getString("tenTaiKhoan"),
                rs.getString("Email"),
                rs.getString("permission"),
                rs.getInt("SDT"),
                rs.getDate("namSinh")
            );
        }
    } catch (Exception e) {
        System.out.println("Lỗi kiểm tra đăng nhập: " + e.getMessage());
    }
    return null;
}

}
