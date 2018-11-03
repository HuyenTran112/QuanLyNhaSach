/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.BookStockDAL;
import Entity.BookStock;
import java.util.ArrayList;

/**
 *
 * @author Bui Thi Huyen Tran
 */
public class BookStockBLL {
    BookStockDAL DAL =new BookStockDAL();
    //Load dữ liệu lên bảng
    public ArrayList<BookStock> LoadBookStock()
    {
        return DAL.LoadBookStock();
    }
    //Thêm phiếu nhập sách
    public boolean  InsertBookStock(String DateStock ,int IDDistributor)
    {
        return DAL.InsertBookStock(DateStock, IDDistributor);
        
    }
    //Cập nhật phiếu nhập sách
    public boolean  UpdateBookStock(int IDBookStock ,String DateStock ,int IDDistributor)
    {
        return DAL.UpdateBookStock(IDBookStock,DateStock,IDDistributor);
    }
    //Xóa phiếu nhập sách
    public boolean  DeleteBookStock (int IDBookStock)
    {
        return DAL.DeleteBookStock(IDBookStock);
    }
    //Tìm phiếu nhập sách theo nhà cung cấp
    public ArrayList<BookStock>  SearchBookStock(String key)
    {
        return DAL.SearchBookStock(key);
    }
}
