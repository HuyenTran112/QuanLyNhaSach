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
    //Thêm sách
    public boolean InsertBook(String BookName , String PublisherBook, int PublishingYear, String Brief, float Cost , float Price, int SumInventory,int IDBookCategogy )
    {
        return DAL.InsertBook(BookName, PublisherBook, PublishingYear, Brief, Cost, Price, SumInventory,IDBookCategogy);
    }
    //Cập nhật sách
    public boolean  UpdateBook(int IDBookName, String BookName , String PublisherBook, int PublishingYear, String Brief, float Cost , float Price, int SumInventory, int IDBookCategogy)
    {
        return DAL.UpdateBook(IDBookName, BookName, PublisherBook, PublishingYear, Brief, Cost, Price, SumInventory, IDBookCategogy);
    }
    //Xóa sách
    public boolean  DeleteBook(int IDBookName)
    {
        return DAL.DeleteBook(IDBookName);
    }
    //Tra cứu sách
    public ArrayList<Book> SearchBook(String key)
    {
        return DAL.SearchBook(key);
    }
    //lấy mã sách
    public int getIDBook(String NameBook)
    {
        return DAL.getIDBook(NameBook);
    }
    
}
