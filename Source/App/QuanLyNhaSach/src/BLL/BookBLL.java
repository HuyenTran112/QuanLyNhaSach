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
        return DAL.LoadBook();
    }
    //Thêm sách
    public boolean InsertBook(String BookName , String Author ,String PublisherBook, int PublishingYear, String Brief, float Cost , int SumInventory,int IDBookCategogy )
    {
        return DAL.InsertBook(BookName,Author, PublisherBook, PublishingYear, Brief, Cost, SumInventory,IDBookCategogy);
    }
    //Cập nhật sách
    public boolean  UpdateBook(int IDBookName, String BookName ,String Author, String PublisherBook, int PublishingYear, String Brief, float Cost, int SumInventory, int IDBookCategogy)
    {
        return DAL.UpdateBook(IDBookName, BookName, Author,PublisherBook, PublishingYear, Brief, Cost,  SumInventory, IDBookCategogy);
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
    //Kiểm tra mã sách
    public boolean TestIDBook(int IDBook)
    {
        return DAL.TestIDBook(IDBook);
    }
    //Tra cứu sách
    public boolean  SearchBookKey(String key)
    {
        return DAL.SearchBookKey(key);
    }
}
