/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.PreparedStatement;
import entity.KhachHangEntity;
import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import ulti.ConnectDB;
import java.sql.ResultSet;

/**
 *
 * @author nem mèn mén
 */
public class KhachHangdao_1 {
    public List<KhachHangEntity> getAll(){
        List<KhachHangEntity> List = new ArrayList();
        try{
             Connection con = ConnectDB.getConnect();
            String sql = "select * from KhachHang";
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                KhachHangEntity khachhang = new KhachHangEntity(result.getLong("maKhachHang"),
                        result.getString("tenKhachHang"),
                        result.getString("diaChi"),
                        result.getString("gioiTinh"),
                        result.getInt("SDT"),
                        result.getDate("ngaySInh"));
                List.add(khachhang);
            }
        } catch(Exception e ){
            System.out.println("lỗi get all Khách Hàng" +  e.getMessage());
        }
    return List;
}    
    public void update(KhachHangEntity kh){
        try{
            Connection con = ConnectDB.getConnect();
            String sql = "update KhachHang set tenKhachHang = ?, diaChi= ?," 
                    + "SDT = ?,ngaySInh = ?, gioiTinh = ? where maKhachHang = ?  ";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, kh.getTenKH());
            statement.setString(2, kh.getDiaChi());
            statement.setInt(3, kh.getSdt());
            java.sql.Date sqlDate = new java.sql.Date(kh.getNgaySinh().getTime());
            statement.setDate(4, sqlDate);
            statement.setString(5, kh.getGioitinh());
            statement.setLong(6, kh.getMaKH());
            
            statement.execute();
            
        }catch(Exception e) {
            System.out.println("Lỗi update khách hàng: " + e.getMessage());
        }
        
    }
    public void delete(int maKH) {
        try {
            Connection con = ConnectDB.getConnect();
            String sql = "delete from KhachHang where maKhachHang = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, maKH);
            statement.execute();
        } catch (Exception e) {
            System.out.println("Lỗi delete Khách hàng: " + e.getMessage());
        }
    }
    public void insert (KhachHangEntity kh){
        try{
            Connection con = ConnectDB.getConnect();
            String sql = "INSERT INTO KhachHang (maKhachHang, tenKhachHang,diaChi, SDT, ngaySInh, gioiTinh)" 
                    + "VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setLong(1, kh.getMaKH());
            statement.setString(2, kh.getTenKH());
            statement.setString(3, kh.getDiaChi());
            statement.setInt(4, kh.getSdt());
            statement.setDate(5, new java.sql.Date(kh.getNgaySinh().getTime()));
            statement.setString(6, kh.getGioitinh());
            statement.executeUpdate();
            
        }catch(Exception e) {
            System.out.println("Lỗi insert khách hàng: " + e.getMessage());
        }
        
    }
}
