/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author nem mèn mén
 */
public class vouCher {

    private long MaVouch;
    private String moTa;
    private int giamGia;

    public vouCher(String moTa, int giamGia) {
        this.moTa = moTa;
        this.giamGia = giamGia;
    }

    public vouCher(long MaVouch, String moTa, int giamGia) {
        this.MaVouch = MaVouch;
        this.moTa = moTa;
        this.giamGia = giamGia;
    }

    public long getMaVouch() {
        return MaVouch;
    }

    public void setMaVouch(long MaVouch) {
        this.MaVouch = MaVouch;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(int giamGia) {
        this.giamGia = giamGia;
    }

    public vouCher() {
    }

}
