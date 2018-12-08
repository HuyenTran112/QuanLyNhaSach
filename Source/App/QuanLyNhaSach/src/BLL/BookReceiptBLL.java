/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.BookReceiptDAL;
import Entity.BookReceipt;
import java.util.ArrayList;
import java.util.Date;

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
    //Lấy ngày nhập theo số phiếu nhập
    public Date getDateReceipt(int IDBookReceipt)
    {
        return DAL.getDateReceipt(IDBookReceipt);
    }
   //Lấy tên nhà cung cấp theo số phiếu nhập
    public String getDistributor(int IDBookReceipt)
    {
        return DAL.getDistributor(IDBookReceipt);
    } 
    ////Lấy tổng tiền của phiếu nhập theo số phiếu nhập
    public float getTotalReceipt(int IDBookReceipt)
    {
        return DAL.getTotalReceipt(IDBookReceipt);
    }
  }
