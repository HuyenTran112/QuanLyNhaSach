/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;
import DAL.BookStockDetailDAL;
import Entity.BookStockDetail;
import java.util.ArrayList;
/**
 *
 * @author Bui Thi Huyen Tran
 */
public class BookStockDetailBLL {
    BookStockDetailDAL DAL =new BookStockDetailDAL();
    //load danh sách chi tiết phiếu nhập sách
    public ArrayList<BookStockDetail> LoadBookStockDetail()
    {
        return DAL.LoadBookStockDetail();
    }
    //thêm chi tiết phiếu nhập sách
    public boolean InsertBookStockDetail(int IDBookStock ,int IDBook ,int AmoutStock,float cost)
    {
        return DAL.InsertBookStockDetail(IDBookStock, IDBook, AmoutStock,cost);
        
    }
    //cập nhật chi tiết phiếu nhập sách
    public boolean  UpdateBookStockDetail(int IDBookStock ,int IDBook,int AmoutStock,float cost)
    {
        return DAL.UpdateBookStockDetail(IDBookStock, IDBook, AmoutStock,cost);
    }
    //xóa chi tiết phiếu nhập sách
    public boolean  DeleteBookStockDetail(int IDBookStock,int IDBook)
    {
        return DAL.DeleteBookStockDetail(IDBookStock,IDBook);
    }
    //tìm chi tiết phiếu nhập sách theo số phiếu nhập sách
    public ArrayList<BookStockDetail> SearchBookStockDetail(int key)
    {
        return DAL.SearchBookStockDetail(key);
    }
}
