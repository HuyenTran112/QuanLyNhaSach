/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.BillInfoDAL;
import Entity.BillInfo;
import java.util.ArrayList;
/**
 *
 * @author STIREN
 */
public class BillInfoBLL {
    BillInfoDAL DAL = new BillInfoDAL();
    //Lấy danh sách chi tiết hóa đơn
    public ArrayList<BillInfo> LoadBillInfo(int IDBill)
    {
        return DAL.LoadBillInfo(IDBill);
    }
    //Thêm chi tiết hóa đơn
    public boolean InsertBillInfo(int IDBill, int IDBook, int Amount)
    {
        return DAL.InsertBillInfo(IDBill, IDBook, Amount);
    }
    //Cập nhật chi tiết hóa đơn
    public boolean UpdateBillInfo(int IDBill, int IDBook, int Amount)
    {
        return DAL.UpdateBillInfo(IDBill, IDBook, Amount);
    }
    //Xóa chi tiết hóa đơn
    public boolean DeleteBillInfo(int IDBill, int IDBook)
    {
        return DAL.DeleteBillInfo(IDBill, IDBook);
    }
    //Tìm kiếm CTHD
    public ArrayList<BillInfo> SearchBillInfo(String key)
    {
        return DAL.SearchBillInfo(key);
    }
}
