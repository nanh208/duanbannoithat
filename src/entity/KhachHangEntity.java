/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Date;

/**
 *
 * @author nem mèn mén
 */
public class KhachHangEntity {
    private long MaKH;
    private String tenKH,diaChi,Gioitinh;
    private int sdt;
    private Date ngaySinh;

    public KhachHangEntity(long MaKH, String tenKH, String diaChi, String Gioitinh, int sdt, Date ngaySinh) {
        this.MaKH = MaKH;
        this.tenKH = tenKH;
        this.diaChi = diaChi;
        this.Gioitinh = Gioitinh;
        this.sdt = sdt;
        this.ngaySinh = ngaySinh;
    }

    public KhachHangEntity() {
    }

    public long getMaKH() {
        return MaKH;
    }

    public void setMaKH(long MaKH) {
        this.MaKH = MaKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getGioitinh() {
        return Gioitinh;
    }

    public void setGioitinh(String Gioitinh) {
        this.Gioitinh = Gioitinh;
    }

    public int getSdt() {
        return sdt;
    }

    public void setSdt(int sdt) {
        this.sdt = sdt;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

   




    
    
    
}
