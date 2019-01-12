/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.sql.Date;

/**
 *
 * @author Bui Thi Huyen Tran
 */
public class Discount {
    private int IDDiscount;
    private String NameDiscount ;
    private float Money;
    private float Discount;
    private Date StartDate;
    private Date FinishDate;

    /**
     * @return the IDDiscount
     */
    public int getIDDiscount() {
        return IDDiscount;
    }

    /**
     * @param IDDiscount the IDDiscount to set
     */
    public void setIDDiscount(int IDDiscount) {
        this.IDDiscount = IDDiscount;
    }

    /**
     * @return the NameDiscount
     */
    public String getNameDiscount() {
        return NameDiscount;
    }

    /**
     * @param NameDiscount the NameDiscount to set
     */
    public void setNameDiscount(String NameDiscount) {
        this.NameDiscount = NameDiscount;
    }

    

    /**
     * @return the Money
     */
    public float getMoney() {
        return Money;
    }

    /**
     * @param MoneyMax the MoneyMax to set
     */
    public void setMoney(float Money) {
        this.Money = Money;
    }

    /**
     * @return the Discount
     */
    public float getDiscount() {
        return Discount;
    }

    /**
     * @param Discount the Discount to set
     */
    public void setDiscount(float Discount) {
        this.Discount = Discount;
    }

    /**
     * @return the StartDate
     */
    public Date getStartDate() {
        return StartDate;
    }

    /**
     * @param StartDate the StartDate to set
     */
    public void setStartDate(Date StartDate) {
        this.StartDate = StartDate;
    }

    /**
     * @return the FinishDate
     */
    public Date getFinishDate() {
        return FinishDate;
    }

    /**
     * @param FinishDate the FinishDate to set
     */
    public void setFinishDate(Date FinishDate) {
        this.FinishDate = FinishDate;
    }
    public Discount()
    {
        
    }
}
