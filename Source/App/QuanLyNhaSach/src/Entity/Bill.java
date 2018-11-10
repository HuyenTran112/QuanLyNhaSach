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
    private int IDStaff;
    private float VAT;
    private float TotalPrice;
    private float TotalPay;

    public Bill() {
        this.IDBill = IDBill;
        this.BillDate = BillDate;
        this.IDCustomer = IDCustomer;
        this.IDStaff = IDStaff;
        this.VAT = VAT;
        this.TotalPrice = TotalPrice;
        this.TotalPay = TotalPay;
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

    public int getIDStaff() {
        return IDStaff;
    }

    public float getVAT() {
        return VAT;
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

    public void setIDStaff(int IDStaff) {
        this.IDStaff = IDStaff;
    }

    public void setVAT(float VAT) {
        this.VAT = VAT;
    }

    public void setTotalPrice(float TotalPrice) {
        this.TotalPrice = TotalPrice;
    }

    public void setTotalPay(float TotalPay) {
        this.TotalPay = TotalPay;
    }    
}
