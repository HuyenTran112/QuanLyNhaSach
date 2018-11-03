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
public class BookStock {
    private  int IDBookStock ;
    private Date DateStock;
    private String NameDistributor ;
    private float TotalStock;

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
     * @return the DateStock
     */
    public Date getDateStock() {
        return DateStock;
    }

    /**
     * @param DateStock the DateStock to set
     */
    public void setDateStock(Date DateStock) {
        this.DateStock = DateStock;
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
     * @return the TotalStock
     */
    public float getTotalStock() {
        return TotalStock;
    }

    /**
     * @param TotalStock the TotalStock to set
     */
    public void setTotalStock(float TotalStock) {
        this.TotalStock = TotalStock;
    }
    
}
