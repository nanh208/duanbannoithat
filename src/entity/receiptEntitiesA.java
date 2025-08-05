/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author chann
 */
public class receiptEntitiesA {
  int detailedID;
  long receiptID;
  long furnitureID;
  int amount;
  int price;

    public receiptEntitiesA() {
    }

    public receiptEntitiesA(long receiptID, long furnitureID, int amount, int price) {
        this.receiptID = receiptID;
        this.furnitureID = furnitureID;
        this.amount = amount;
        this.price = price;
    }

    public receiptEntitiesA(int detailedID, long receiptID, long furnitureID, int amount, int price) {
        this.detailedID = detailedID;
        this.receiptID = receiptID;
        this.furnitureID = furnitureID;
        this.amount = amount;
        this.price = price;
    }

    public int getDetailedID() {
        return detailedID;
    }

    public long getReceiptID() {
        return receiptID;
    }

    public long getFurnitureID() {
        return furnitureID;
    }

    public int getAmount() {
        return amount;
    }

    public int getPrice() {
        return price;
    }

    public void setDetailedID(int detailedID) {
        this.detailedID = detailedID;
    }

    public void setReceiptID(long receiptID) {
        this.receiptID = receiptID;
    }

    public void setFurnitureID(long furnitureID) {
        this.furnitureID = furnitureID;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setPrice(int price) {
        this.price = price;
    }
  
            
}
