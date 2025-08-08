/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author chann
 */
public class productEntity {
    long ID;
    long type;
    String name;
    String desc;
    int price;

    public productEntity() {
    }

    public productEntity(long type, String name, String desc, int price) {
        this.type = type;
        this.name = name;
        this.desc = desc;
        this.price = price;
    }
    

    public productEntity(long ID, long type, String name, String desc, int price) {
        this.ID = ID;
        this.type = type;
        this.name = name;
        this.desc = desc;
        this.price = price;
    }

    public long getID() {
        return ID;
    }

    public long getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public int getPrice() {
        return price;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public void setType(long type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    
}
