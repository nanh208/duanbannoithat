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
      public List<vouCher> getAll(){
        List<vouCher> List = new ArrayList();
        try{
             Connection con = ConnectDB.getConnect();
            String sql = "select * from Vouchers";
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                vouCher voucher = new vouCher(result.getLong("maVouch"),
                result.getString("moTa"),
                result.getString("giamGia"));
                List.add(voucher);
            }
        } catch(Exception e ){
            System.out.println("lỗi get all voucher" +  e.getMessage());
        }
    return List;
}   
      public void insert (vouCher vc){
        try{
            Connection con = ConnectDB.getConnect();
            String sql = "INSERT INTO Vouchers (moTa, giamGia)" 
                    + "VALUES (?, ?)";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, vc.getMoTa());
            statement.setString(2, vc.getGiamGia());
            
            statement.executeUpdate();
            
        }catch(Exception e) {
            System.out.println("Lỗi insert voucher: " + e.getMessage());
        }
        
    }
      public void update(vouCher vc){
        try{
            Connection con = ConnectDB.getConnect();
            String sql = "UPDATE Vouchers SET moTa = ?, giamGia = ? WHERE maVouch = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, vc.getMoTa());
            statement.setString(2, vc.getGiamGia());
            statement.setLong(3, vc.getMaVouch());

            
            statement.execute();
            
        }catch(Exception e) {
            System.out.println("Lỗi update Voucher: " + e.getMessage());
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
            System.out.println("Lỗi delete Voucher: " + e.getMessage());
        }
    }
      
}
