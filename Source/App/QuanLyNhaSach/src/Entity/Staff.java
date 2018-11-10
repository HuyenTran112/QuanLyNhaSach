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
public class Staff {
    private int ID;
    private String Name ;
    private Date BirthDay;
    private String Sex ;
    private String Address;
    private String PhoneNumber;
    private Date StartDate ;

    /**
     * @return the ID
     */
    public int getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * @return the Name
     */
    public String getName() {
        return Name;
    }

    /**
     * @param Name the Name to set
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * @return the BirthDay
     */
    public Date getBirthDay() {
        return BirthDay;
    }

    /**
     * @param BirthDay the BirthDay to set
     */
    public void setBirthDay(Date BirthDay) {
        this.BirthDay = BirthDay;
    }

    /**
     * @return the Sex
     */
    public String getSex() {
        return Sex;
    }

    /**
     * @param Sex the Sex to set
     */
    public void setSex(String Sex) {
        this.Sex = Sex;
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
    
}
