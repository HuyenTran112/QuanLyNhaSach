/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Bui Thi Huyen Tran
 */
public class BookReceiptInfo {
    private int IDBookReceipt;
    private String NameBook;
    private int AmountReceipt;
    private float Cost;
    private float Amount;

    /**
     * @return the IDBookReceipt
     */
    public int getIDBookReceipt() {
        return IDBookReceipt;
    }

    /**
     * @param IDBookReceipt the IDBookReceipt to set
     */
    public void setIDBookReceipt(int IDBookReceipt) {
        this.IDBookReceipt = IDBookReceipt;
    }

    /**
     * @return the NameBook
     */
    public String getNameBook() {
        return NameBook;
    }

    /**
     * @param NameBook the NameBook to set
     */
    public void setNameBook(String NameBook) {
        this.NameBook = NameBook;
    }

    /**
     * @return the AmountReceipt
     */
    public int getAmountReceipt() {
        return AmountReceipt;
    }

    /**
     * @param AmountReceipt the AmountReceipt to set
     */
    public void setAmountReceipt(int AmountReceipt) {
        this.AmountReceipt = AmountReceipt;
    }

    /**
     * @return the Amount
     */
    public float getAmount() {
        return Amount;
    }

    /**
     * @param Amount the Amount to set
     */
    public void setAmount(float Amount) {
        this.Amount = Amount;
    }

    /**
     * @return the Cost
     */
    public float getCost() {
        return Cost;
    }

    /**
     * @param Cost the Cost to set
     */
    public void setCost(float Cost) {
        this.Cost = Cost;
    }
    
}
