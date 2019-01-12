/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;
import DAL.BookReceiptInfoDAL;
import Entity.BookReceiptInfo;
import java.util.ArrayList;
/**
 *
 * @author Bui Thi Huyen Tran
 */
public class BookReceiptInfoBLL {
    BookReceiptInfoDAL DAL =new BookReceiptInfoDAL();
    //load danh sách chi tiết phiếu nhập sách
    public ArrayList<BookReceiptInfo> LoadBookReceiptInfo()
    {
        return DAL.LoadBookReceiptInfo();
    }
    //thêm chi tiết phiếu nhập sách
    public boolean InsertBookReceiptInfo(int IDBookReceipt ,int IDBook ,int AmoutReceipt,float cost)
    {
        return DAL.InsertBookReceiptInfo(IDBookReceipt, IDBook, AmoutReceipt,cost);
        
    }
    //cập nhật chi tiết phiếu nhập sách
    public boolean  UpdateBookReceiptInfo(int IDBookReceipt ,int IDBook,int AmoutReceipt,float cost)
    {
        return DAL.UpdateBookReceiptInfo(IDBookReceipt, IDBook, AmoutReceipt,cost);
    }
    //xóa chi tiết phiếu nhập sách
    public boolean  DeleteBookReceiptInfo(int IDBookReceipt,int IDBook)
    {
        return DAL.DeleteBookReceiptInfo(IDBookReceipt,IDBook);
    }
    //tìm chi tiết phiếu nhập sách theo số phiếu nhập sách
    public ArrayList<BookReceiptInfo> SearchBookReceiptInfo(int key)
    {
        return DAL.SearchBookReceiptInfo(key);
    }
}
