/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import java.util.ArrayList;
import  DAL.*;
import Entity.*;
/**
 *
 * @author Bui Thi Huyen Tran
 */
public class BookBLL {
    BookDAL DAL=new BookDAL();
    //Lấy danh sách SACH
    public ArrayList<Book> LoadBook()
    {
       //BookDAL DAL=new BookDAL();
        return DAL.LoadBook();
    }
    public boolean InsertBook(String BookName , String PublisherBook, int PublishingYear, String Brief, float Cost , float Price, int SumInventory,int IDBookCategogy )
    {
        return DAL.InsertBook(BookName, PublisherBook, PublishingYear, Brief, Cost, Price, SumInventory,IDBookCategogy);
    }
    public boolean  UpdateBook(int IDBookName, String BookName , String PublisherBook, int PublishingYear, String Brief, float Cost , float Price, int SumInventory, int IDBookCategogy)
    {
        return DAL.UpdateBook(IDBookName, BookName, PublisherBook, PublishingYear, Brief, Cost, Price, SumInventory, IDBookCategogy);
    }
    public boolean  DeleteBook(int IDBookName)
    {
        return DAL.DeleteBook(IDBookName);
    }
    
}
