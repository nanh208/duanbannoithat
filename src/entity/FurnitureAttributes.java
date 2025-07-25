/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author chann
 */
public class FurnitureAttributes {
    long furnID;
    long furnType;
    String furnName;
    String furnDesc;
    int furnPrice;
    String imgPath;

    public FurnitureAttributes() {
    }

    public FurnitureAttributes(long furnID, long furnType, String furnName, String furnDesc, int furnPrice) {
        this.furnID = furnID;
        this.furnType = furnType;   
        this.furnName = furnName;
        this.furnDesc = furnDesc;
        this.furnPrice = furnPrice;
    }
    
    public FurnitureAttributes(long furnID, long furnType, String furnName, String furnDesc, int furnPrice, String imgPath) {
        this.furnID = furnID;
        this.furnType = furnType;
        this.furnName = furnName;
        this.furnDesc = furnDesc;
        this.furnPrice = furnPrice;
        this.imgPath = imgPath;
    }

    public long getFurnID() {
        return furnID;
    }

    public long getFurnType() {
        return furnType;
    }

    public String getFurnName() {
        return furnName;
    }

    public String getFurnDesc() {
        return furnDesc;
    }

    public int getFurnPrice() {
        return furnPrice;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setFurnID(long furnID) {
        this.furnID = furnID;
    }

    public void setFurnType(long furnType) {
        this.furnType = furnType;
    }

    public void setFurnName(String furnName) {
        this.furnName = furnName;
    }

    public void setFurnDesc(String furnDesc) {
        this.furnDesc = furnDesc;
    }

    public void setFurnPrice(int furnPrice) {
        this.furnPrice = furnPrice;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }
    
    
}
