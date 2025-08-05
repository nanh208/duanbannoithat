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
                vouCher voucher = new vouCher(result.getLong("maVouch"),
                        result.getString("moTa"),
                        result.getInt("giamGia"));
                List.add(voucher);
            }
        } catch (Exception e) {
            System.out.println("Lỗi lấy thông tin tất cả voucher" + e.getMessage());
        }
        return List;
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
                        result.getLong("maVouch"),
                        result.getString("moTa"),
                        result.getInt("giamGia")
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

    public void update(vouCher vc) {
        try {
            Connection con = ConnectDB.getConnect();
            String sql = "UPDATE Vouchers SET moTa = ?, giamGia = ? WHERE maVouch = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, vc.getMoTa());
            statement.setInt(2, vc.getGiamGia());
            statement.setLong(3, vc.getMaVouch());

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
