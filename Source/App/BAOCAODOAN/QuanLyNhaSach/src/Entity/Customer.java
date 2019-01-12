/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.sql.Date;

/**
 *
 * @author STIREN
 */
public class Customer {
    private int IDCustomer;
    private String NameCustomer;
    private String AddressCustomer;
    private String PhoneCustomer;
    private Date BirthdayCutomer;
    private Date RegisDateCutomer;
    private double TurnoverCustomer;

    public Customer() {
        this.IDCustomer = IDCustomer;
        this.NameCustomer = NameCustomer;
        this.AddressCustomer = AddressCustomer;
        this.PhoneCustomer = PhoneCustomer;
        this.BirthdayCutomer = BirthdayCutomer;
        this.RegisDateCutomer = RegisDateCutomer;
        this.TurnoverCustomer = TurnoverCustomer;
    }

    public int getIDCustomer() {
        return IDCustomer;
    }

    public String getNameCustomer() {
        return NameCustomer;
    }

    public String getAddressCustomer() {
        return AddressCustomer;
    }

    public String getPhoneCustomer() {
        return PhoneCustomer;
    }

    public Date getBirthdayCutomer() {
        return BirthdayCutomer;
    }

    public Date getRegisDateCutomer() {
        return RegisDateCutomer;
    }

    public double getTurnoverCustomer() {
        return TurnoverCustomer;
    }

    public void setIDCustomer(int IDCustomer) {
        this.IDCustomer = IDCustomer;
    }

    public void setNameCustomer(String NameCustomer) {
        this.NameCustomer = NameCustomer;
    }

    public void setAddressCustomer(String AddressCustomer) {
        this.AddressCustomer = AddressCustomer;
    }

    public void setPhoneCustomer(String PhoneCustomer) {
        this.PhoneCustomer = PhoneCustomer;
    }

    public void setBirthdayCutomer(Date BirthdayCutomer) {
        this.BirthdayCutomer = BirthdayCutomer;
    }

    public void setRegisDateCutomer(Date RegisDateCutomer) {
        this.RegisDateCutomer = RegisDateCutomer;
    }

    public void setTurnoverCustomer(double TurnoverCustomer) {
        this.TurnoverCustomer = TurnoverCustomer;
    }

    
    
}
