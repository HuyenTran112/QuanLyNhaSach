/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Date;

/**
 *
 * @author Bui Thi Huyen Tran
 */
public class BookReceipt {
    private  int IDBookReceipt ;
    private Date DateReceipt;
    private String NameDistributor ;
    private int TotalReceipt;

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
     * @return the DateReceipt
     */
    public Date getDateReceipt() {
        return DateReceipt;
    }

    /**
     * @param DateReceipt the DateReceipt to set
     */
    public void setDateReceipt(Date DateReceipt) {
        this.DateReceipt = DateReceipt;
    }

    /**
     * @return the NameDistributor
     */
    public String getNameDistributor() {
        return NameDistributor;
    }

    /**
     * @param NameDistributor the NameDistributor to set
     */
    public void setNameDistributor(String NameDistributor) {
        this.NameDistributor = NameDistributor;
    }

    /**
     * @return the TotalReceipt
     */
    public int getTotalReceipt() {
        return TotalReceipt;
    }

    /**
     * @param TotalReceipt the TotalReceipt to set
     */
    public void setTotalReceipt(int TotalReceipt) {
        this.TotalReceipt = TotalReceipt;
    }
    
}
