/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.BookReceiptDAL;
import Entity.BookReceipt;
import java.util.ArrayList;

/**
 *
 * @author Bui Thi Huyen Tran
 */
public class BookReceiptBLL {
    BookReceiptDAL DAL =new BookReceiptDAL();
    //Load dữ liệu lên bảng
    public ArrayList<BookReceipt> LoadBookReceipt()
    {
        return DAL.LoadBookReceipt();
    }
    //Thêm phiếu nhập sách
    public boolean  InsertBookReceipt(String DateReceipt ,int IDDistributor)
    {
        return DAL.InsertBookReceipt(DateReceipt, IDDistributor);
        
    }
    //Cập nhật phiếu nhập sách
    public boolean  UpdateBookReceipt(int IDBookReceipt ,String DateReceipt ,int IDDistributor)
    {
        return DAL.UpdateBookReceipt(IDBookReceipt,DateReceipt,IDDistributor);
    }
    //Xóa phiếu nhập sách
    public boolean  DeleteBookReceipt (int IDBookReceipt)
    {
        return DAL.DeleteBookReceipt(IDBookReceipt);
    }
    //Tìm phiếu nhập sách theo nhà cung cấp
    public ArrayList<BookReceipt>  SearchBookReceipt(String key)
    {
        return DAL.SearchBookReceipt(key);
    }
}
