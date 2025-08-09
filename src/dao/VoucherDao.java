/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.vouCher;
import java.util.ArrayList;
import java.util.List;
import ulti.ConnectDB;
import java.sql.*;

/**
 *
 * @author nem mèn mén
 */
public class VoucherDao {

    public List<vouCher> getAll() {
        List<vouCher> List = new ArrayList();
        try {
            Connection con = ConnectDB.getConnect();
            String sql = "select * from Vouchers";
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                vouCher voucher = new vouCher(result.getLong("maVouch"), result.getString("moTa"), result.getInt("giamGia"), result.getBoolean("active"));
                List.add(voucher);
            }
        } catch (Exception e) {
            System.out.println("Lỗi lấy thông tin tất cả voucher" + e.getMessage());
        }
        return List;
    }
    
    public List<vouCher> getAllByStatus(boolean activeStatus) {
    List<vouCher> list = new ArrayList<>();
    try {
        Connection con = ConnectDB.getConnect();
        String sql = "SELECT * FROM Vouchers WHERE active = ?";
        PreparedStatement statement = con.prepareStatement(sql);
        statement.setBoolean(1, activeStatus);
        ResultSet result = statement.executeQuery();
        while (result.next()) {
            vouCher voucher = new vouCher(
                result.getLong("maVouch"),
                result.getString("moTa"),
                result.getInt("giamGia"),
                result.getBoolean("active")
            );
            list.add(voucher);
        }
    } catch (Exception e) {
        System.out.println("Lỗi lấy voucher theo trạng thái: " + e.getMessage());
    }
    return list;
}


    public vouCher getSpecific(long ID) {
        vouCher voucher = null;
        try {
            Connection con = ConnectDB.getConnect();
            String sql = "SELECT * FROM Vouchers WHERE maVouch = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setLong(1, ID);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                voucher = new vouCher(
                        result.getString("moTa"),
                        result.getInt("giamGia"),
                        result.getBoolean("active")
                );
            }
        } catch (Exception e) {
            System.out.println("Lỗi get voucher cụ thể: " + e.getMessage());
        }
        return voucher;
    }

    public void insert(vouCher vc) {
        try {
            Connection con = ConnectDB.getConnect();
            String sql = "INSERT INTO Vouchers (moTa, giamGia)"
                    + "VALUES (?, ?)";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, vc.getMoTa());
            statement.setInt(2, vc.getGiamGia());

            statement.executeUpdate();

        } catch (Exception e) {
            System.out.println("Lỗi thêm voucher: " + e.getMessage());
        }

    }

    public void setStatus(long ID, boolean status) {
        try {
            Connection database = ConnectDB.getConnect();
            String query = "UPDATE Vouchers SET active = ? WHERE maVouch = ?";
            PreparedStatement statement = database.prepareStatement(query);
            statement.setBoolean(1, status);
            statement.setLong(2, ID);
            statement.execute();
        } catch (Exception e) {
            System.out.println("Error updating the voucher status: " + e);
        }
    }

    public void update(vouCher vc) {
        try {
            Connection con = ConnectDB.getConnect();
            String sql = "UPDATE Vouchers SET moTa = ?, giamGia = ?, active = ? WHERE maVouch = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, vc.getMoTa());
            statement.setInt(2, vc.getGiamGia());
            statement.setLong(4, vc.getMaVouch());
            statement.setBoolean(3, vc.isStatus());
            

            statement.execute();

        } catch (Exception e) {
            System.out.println("Lỗi cập nhật voucher: " + e.getMessage());
        }

    }

    public void delete(int MaVouch) {
        try {
            Connection con = ConnectDB.getConnect();
            String sql = "delete from Vouchers where maVouch = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, MaVouch);
            statement.execute();
        } catch (Exception e) {
            System.out.println("Lỗi xoá voucher: " + e.getMessage());
        }
    }

}
