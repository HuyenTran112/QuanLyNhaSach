/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Date;

/**
 *
 * @author STIREN
 */
public class Bill {
    private int IDBill;
    private Date BillDate;    
    private int IDCustomer;
    private String NameCustomer;
    private int IDStaff;
    private String NameStaff;
    private float VAT;
    private float Discount;
    private float TotalPrice;
    private float TotalPay;

    public Bill() {
        this.IDBill = 0;
        this.BillDate = BillDate;
        this.IDCustomer = 0;
        this.NameCustomer = "";
        this.IDStaff = 0;
        this.NameStaff = "";
        this.VAT = 0;
        this.Discount = 0;
        this.TotalPrice = 0;
        this.TotalPay = 0;
    }

    public int getIDBill() {
        return IDBill;
    }

    public Date getBillDate() {
        return BillDate;
    }

    public int getIDCustomer() {
        return IDCustomer;
    }

    public String getNameCustomer() {
        return NameCustomer;
    }

    public String getNameStaff() {
        return NameStaff;
    }

    public int getIDStaff() {
        return IDStaff;
    }

    public float getVAT() {
        return VAT;
    }

    public float getDiscount() {
        return Discount;
    }
    
    public float getTotalPrice() {
        return TotalPrice;
    }

    public float getTotalPay() {
        return TotalPay;
    }

    public void setIDBill(int IDBill) {
        this.IDBill = IDBill;
    }

    public void setBillDate(Date BillDate) {
        this.BillDate = BillDate;
    }

    public void setIDCustomer(int IDCustomer) {
        this.IDCustomer = IDCustomer;
    }

    public void setNameCustomer(String NameCustomer) {
        this.NameCustomer = NameCustomer;
    }

    public void setNameStaff(String NameStaff) {
        this.NameStaff = NameStaff;
    }

    public void setIDStaff(int IDStaff) {
        this.IDStaff = IDStaff;
    }

    public void setVAT(float VAT) {
        this.VAT = VAT;
    }

    public void setDiscount(float Discount) {
        this.Discount = Discount;
    }

    public void setTotalPrice(float TotalPrice) {
        this.TotalPrice = TotalPrice;
    }

    public void setTotalPay(float TotalPay) {
        this.TotalPay = TotalPay;
    }    
}
