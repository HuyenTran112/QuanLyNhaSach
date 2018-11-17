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
public class BookStockDetail {
    private int IDBookStock;
    private String NameBook;
    private int AmountStock;
    private float Cost;
    private float Amount;

    /**
     * @return the IDBookStock
     */
    public int getIDBookStock() {
        return IDBookStock;
    }

    /**
     * @param IDBookStock the IDBookStock to set
     */
    public void setIDBookStock(int IDBookStock) {
        this.IDBookStock = IDBookStock;
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
     * @return the AmountStock
     */
    public int getAmountStock() {
        return AmountStock;
    }

    /**
     * @param AmountStock the AmountStock to set
     */
    public void setAmountStock(int AmountStock) {
        this.AmountStock = AmountStock;
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
