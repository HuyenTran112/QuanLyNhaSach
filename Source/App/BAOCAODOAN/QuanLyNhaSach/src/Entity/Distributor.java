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
public class Distributor {
    private int IDDistributor;
    private String NameDistributor ;
    private String Address;
    private String PhoneNumber ;

    /**
     * @return the IDDistributor
     */
    public int getIDDistributor() {
        return IDDistributor;
    }

    /**
     * @param IDDistributor the IDDistributor to set
     */
    public void setIDDistributor(int IDDistributor) {
        this.IDDistributor = IDDistributor;
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
     * @return the Address
     */
    public String getAddress() {
        return Address;
    }

    /**
     * @param Address the Address to set
     */
    public void setAddress(String Address) {
        this.Address = Address;
    }

    /**
     * @return the PhoneNumber
     */
    public String getPhoneNumber() {
        return PhoneNumber;
    }

    /**
     * @param PhoneNumber the PhoneNumber to set
     */
    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }
    
    
}
