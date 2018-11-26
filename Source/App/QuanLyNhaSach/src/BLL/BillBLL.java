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
    public boolean InsertBill(String BillDate, int IDCustomer, int IDStaff)
    {
        return DAL.InsertBill(BillDate, IDCustomer, IDStaff);
    }
    //Cập nhật hóa đơn
    public boolean UpdateBill(int IDBill, String BillDate, int IDCustomer, int IDStaff)
    {
        return DAL.UpdateBill(IDBill, BillDate, IDCustomer, IDStaff);
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
    //Lấy trị giá hóa đơn
    public float getTotalPriceByIDBill(int IDBill)
    {
        return DAL.getTotalPriceByIDBill(IDBill);
    }
    //Lấy chiết khấu hóa đơn
    public float getDiscountByIDBill(int IDBill)
    {
        return DAL.getDiscountByIDBill(IDBill);
    }
    //Lấy VAT hóa đơn
    public float getVATByIDBill(int IDBill)
    {
        return DAL.getVATByIDBill(IDBill);
    }
    //Lấy tổng tiền hóa đơn
    public float getTotalPayByIDBill(int IDBill)
    {
        return DAL.getTotalPayByIDBill(IDBill);
    }
    //Lấy mã khách hàng theo số hóa đơn
    public int getIDCustomerByIDBill(int IDBill)
    {
        return DAL.getIDCustomerByIDBill(IDBill);
    }
    //Lấy tên nhân viên theo số hóa đơn
    public String getNameStaffByIDBill(int IDBill)
    {
        return DAL.getNameStaffByIDBill(IDBill);
    }
    //Lấy ngày hóa đơn theo số hóa đơn
    public String getDateBillByIDBill(int IDBill)
    {
        return DAL.getDateBillByIDBill(IDBill);
    }
    
}
