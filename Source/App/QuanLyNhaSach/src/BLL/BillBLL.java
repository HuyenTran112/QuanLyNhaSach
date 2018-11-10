/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.BillDAL;
import Entity.Bill;
import java.util.ArrayList;

/**
 *
 * @author STIREN
 */
public class BillBLL {
    BillDAL DAL = new BillDAL();
    //Lấy danh sách hóa đơn
    public ArrayList<Bill> LoadBill()
    {
        return DAL.LoadBill();
    }
    //Thêm hóa đơn
    public boolean InsertBill(String BillDate, int IDCustomer, int IDStaff, float VAT)
    {
        return DAL.InsertBill(BillDate, IDCustomer, IDStaff, VAT);
    }
    //Cập nhật hóa đơn
    public boolean UpdateBill(int IDBill, String BillDate, int IDCustomer, int IDStaff, float VAT)
    {
        return DAL.UpdateBill(IDBill, BillDate, IDCustomer, IDStaff, VAT);
    }
    //Xóa hóa đơn
    public boolean DeleteBill(int IDBill)
    {
        return DAL.DeleteBill(IDBill);
    }
    //Tìm hóa đơn
    public ArrayList<Bill> SearchBill(String BillDate)
    {
        return DAL.SearchBill(BillDate);
    }
    
}
