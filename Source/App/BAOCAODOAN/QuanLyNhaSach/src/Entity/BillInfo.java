/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author STIREN
 */
public class BillInfo {
    private int IDBill;
    private int IDBook;
    private String NameBook;
    private int Amount;
    private float PriceBook;
    private float PriceBillInfo;

    public BillInfo() {
        this.IDBill = 0;
        this.IDBook = 0;
        this.NameBook = "";
        this.Amount = 0;
        this.PriceBook = 0;
        this.PriceBillInfo = 0;
    }

    public int getIDBill() {
        return IDBill;
    }

    public int getIDBook() {
        return IDBook;
    }

    public String getNameBook() {
        return NameBook;
    }

    public int getAmount() {
        return Amount;
    }

    public float getPriceBook() {
        return PriceBook;
    }

    public float getPriceBillInfo() {
        return PriceBillInfo;
    }

    public void setIDBill(int IDBill) {
        this.IDBill = IDBill;
    }

    public void setIDBook(int IDBook) {
        this.IDBook = IDBook;
    }

    public void setNameBook(String NameBook) {
        this.NameBook = NameBook;
    }

    public void setAmount(int Amount) {
        this.Amount = Amount;
    }

    public void setPriceBook(float PriceBook) {
        this.PriceBook = PriceBook;
    }

    public void setPriceBillInfo(float PriceBillInfo) {
        this.PriceBillInfo = PriceBillInfo;
    }
}
