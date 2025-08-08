/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author chann
 */
public class receiptEntities {

    long ID;
    long CustomerID;
    long AccountID;
    String datetime;
    String desc;
    int total;
    boolean status;
    long voucherID;

    
    
    public receiptEntities(long CustomerID, long AccountID, String datetime, String desc, int total, boolean status, long voucherID) {
        this.CustomerID = CustomerID;
        this.AccountID = AccountID;
        this.datetime = datetime;
        this.desc = desc;
        this.total = total;
        this.status = status;
        this.voucherID = voucherID;
    }

    public receiptEntities(long ID, long CustomerID, long AccountID, String datetime, String desc, int total, boolean status, long voucherID) {
        this.ID = ID;
        this.CustomerID = CustomerID;
        this.AccountID = AccountID;
        this.datetime = datetime;
        this.desc = desc;
        this.total = total;
        this.status = status;
        this.voucherID = voucherID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public void setCustomerID(long CustomerID) {
        this.CustomerID = CustomerID;
    }

    public void setAccountID(long AccountID) {
        this.AccountID = AccountID;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setVoucherID(long voucherID) {
        this.voucherID = voucherID;
    }

    public long getID() {
        return ID;
    }

    public long getCustomerID() {
        return CustomerID;
    }

    public long getAccountID() {
        return AccountID;
    }

    public String getDatetime() {
        return datetime;
    }

    public String getDesc() {
        return desc;
    }

    public int getTotal() {
        return total;
    }

    public boolean isStatus() {
        return status;
    }

    public long getVoucherID() {
        return voucherID;
    }

}
