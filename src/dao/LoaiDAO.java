package dao;

import entity.LoaiEntity1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import ulti.ConnectDB;

public class LoaiDAO {

    public List<LoaiEntity1> getAll() {
        List<LoaiEntity1> list = new ArrayList<>();
        try {
            Connection con = ConnectDB.getConnect();
            String sql = "SELECT * FROM Loai";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                LoaiEntity1 loai = new LoaiEntity1(
                        rs.getLong("maLoai"),
                        rs.getString("ten"),
                        rs.getString("loaiSanPham")
                );
                list.add(loai);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public LoaiEntity1 getByName(String ten) {
        LoaiEntity1 loai = null;
        try {
            Connection con = ConnectDB.getConnect();
            String sql = "SELECT * FROM Loai WHERE ten = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ten);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                loai = new LoaiEntity1(
                        rs.getLong("maLoai"),
                        rs.getString("ten"),
                        rs.getString("loaiSanPham")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return loai;
    }

    public void insert(LoaiEntity1 ct) {
        try {
            Connection con = ConnectDB.getConnect();
            String sql = "INSERT INTO Loai (ten, loaiSanPham) VALUES (?, ?)";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, ct.getTen());
            statement.setString(2, ct.getLoaiSanPham());
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Lỗi Insert loại: " + e.getMessage());
        }
    }

    public void update(LoaiEntity1 ct) {
        try {
            Connection con = ConnectDB.getConnect();
            String sql = "UPDATE Loai SET ten = ?, loaiSanPham = ? WHERE maLoai = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, ct.getTen());
            statement.setString(2, ct.getLoaiSanPham());
            statement.setLong(3, ct.getMaLoai());
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Lỗi Update loại: " + e.getMessage());
        }
    }

    public void delete(long maLoai) {
        try {
            Connection con = ConnectDB.getConnect();
            String sql = "DELETE FROM Loai WHERE maLoai = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setLong(1, maLoai);
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Lỗi Delete loại: " + e.getMessage());
        }
    }
}
