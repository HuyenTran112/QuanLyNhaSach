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
public class Book {
   private int IDBook;
   private String NameBook;
   private String NameCategogyBook;
   private String PublisherBook;
   private int PublishingYear;
   private String Brief ;
   private float Cost;
   private float Price;
   private int SumInventory;

    /**
     * @return the IDBook
     */
    public int getIDBook() {
        return IDBook;
    }

    /**
     * @param IDBook the IDBook to set
     */
    public void setIDBook(int IDBook) {
        this.IDBook = IDBook;
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
     * @return the NameCategogyBook
     */
    public String getNameCategogyBook() {
        return NameCategogyBook;
    }

    /**
     * @param NameCategogyBook the NameCategogyBook to set
     */
    public void setNameCategogyBook(String NameCategogyBook) {
        this.NameCategogyBook = NameCategogyBook;
    }

    /**
     * @return the PublisherBook
     */
    public String getPublisherBook() {
        return PublisherBook;
    }

    /**
     * @param PublisherBook the PublisherBook to set
     */
    public void setPublisherBook(String PublisherBook) {
        this.PublisherBook = PublisherBook;
    }

    /**
     * @return the PublishingYear
     */
    public int getPublishingYear() {
        return PublishingYear;
    }

    /**
     * @param PublishingYear the PublishingYear to set
     */
    public void setPublishingYear(int PublishingYear) {
        this.PublishingYear = PublishingYear;
    }

    /**
     * @return the Brief
     */
    public String getBrief() {
        return Brief;
    }

    /**
     * @param Brief the Brief to set
     */
    public void setBrief(String Brief) {
        this.Brief = Brief;
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

    /**
     * @return the Price
     */
    public float getPrice() {
        return Price;
    }

    /**
     * @param Price the Price to set
     */
    public void setPrice(float Price) {
        this.Price = Price;
    }

    /**
     * @return the SumInventory
     */
    public int getSumInventory() {
        return SumInventory;
    }

    /**
     * @param SumInventory the SumInventory to set
     */
    public void setSumInventory(int SumInventory) {
        this.SumInventory = SumInventory;
    }
   public Book()
   {
       IDBook=0;
       NameBook="";
       NameCategogyBook="";
       PublisherBook="";
       PublishingYear=0;
       Brief="" ;
       Cost=0;
       Price=0;
       SumInventory=0;
   }
}
