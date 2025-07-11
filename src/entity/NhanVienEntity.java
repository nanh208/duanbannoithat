/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Date;

/**
 *
 * @author meoba
 */
public class NhanVienEntity {
    private long maTK, password;
    private String tenTK, email, permission;
    private int sdt;
    private Date namSinh;

    public NhanVienEntity() {
    }

    public NhanVienEntity(long maTK, long password, String tenTK, String email, String permission, int sdt, Date namSinh) {
        this.maTK = maTK;
        this.password = password;
        this.tenTK = tenTK;
        this.email = email;
        this.permission = permission;
        this.sdt = sdt;
        this.namSinh = namSinh;
    }

    public NhanVienEntity(long password, String tenTK, String email, String permission, int sdt, Date namSinh) {
        this.password = password;
        this.tenTK = tenTK;
        this.email = email;
        this.permission = permission;
        this.sdt = sdt;
        this.namSinh = namSinh;
    }

    public long getMaTK() {
        return maTK;
    }

    public void setMaTK(long maTK) {
        this.maTK = maTK;
    }

    public long getPassword() {
        return password;
    }

    public void setPassword(long password) {
        this.password = password;
    }

    public String getTenTK() {
        return tenTK;
    }

    public void setTenTK(String tenTK) {
        this.tenTK = tenTK;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public int getSdt() {
        return sdt;
    }

    public void setSdt(int sdt) {
        this.sdt = sdt;
    }

    public Date getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(Date namSinh) {
        this.namSinh = namSinh;
    }
    
}
