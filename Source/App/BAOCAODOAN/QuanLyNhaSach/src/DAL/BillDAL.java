/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Entity.Bill;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author STIREN
 */
public class BillDAL extends DataAccessHelper{
    //Thêm hóa đơn
    public boolean  InsertBill(String BillDate, int IDCustomer, int IDStaff)
     {
         String SQL = "EXEC SP_INSERTBILL '" + BillDate + "', " + IDCustomer + ", " + IDStaff;
          try{
            getConnect();
            Statement st = conn.createStatement();
            int rs = st.executeUpdate(SQL);
            if(rs > 0)
                return true;
            getClose();
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
     }
    
    //Cập nhật hóa đơn
    public boolean UpdateBill(int IDBill, String BillDate, int IDCustomer, int IDStaff)
    {
        String SQL = "EXEC SP_UPDATEBILL " + IDBill + ", " + "'" + BillDate + "', " + IDCustomer + ", " + IDStaff;
        try {
            getConnect();
            Statement st = conn.createStatement();
            int rs=st.executeUpdate(SQL);
            if(rs > 0)
                return true;
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    //Tìm hóa đơn theo ngày
    public ArrayList<Bill> SearchBill(String BillDate)
    {
        ArrayList<Bill> temp = new ArrayList<>();
        String SQL = "EXEC SP_SEARCHBILL '" + BillDate +"'";
        try{
            getConnect();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            if(rs!=null)
                while(rs.next()){
                    Bill bill = new Bill();
                    bill.setIDBill(rs.getInt("SOHD"));
                    bill.setBillDate(rs.getDate("NGAYHD"));
                    bill.setIDCustomer(rs.getInt("MAKH"));
                    bill.setNameCustomer(rs.getString("TENKH"));
                    bill.setIDStaff(rs.getInt("MANV"));
                    bill.setNameStaff(rs.getString("TENNV"));
                    bill.setVAT(rs.getFloat("VAT"));
                    bill.setDiscount(rs.getFloat("HESOKM"));
                    bill.setTotalPrice(rs.getFloat("TRIGIA"));
                    bill.setTotalPay(rs.getFloat("TONGTIEN"));
                    
                    temp.add(bill);
                }
            getClose();
        }catch(Exception e){
            e.printStackTrace();
        }
        return temp;
    }
    
    //Lấy trị giá hóa đơn theo số HD
    public float getTotalPriceByIDBill(int IDBill)
    {
        String SQL = "SELECT TRIGIA FROM HOADON WHERE SOHD = " + IDBill;
        try {
            getConnect();
            PreparedStatement ps = conn.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            if(rs != null && rs.next())
                return rs.getFloat("TRIGIA");
            getClose();
        } catch (Exception e) {
        }
        return 0;
    }
    //Lấy tổng tiền hóa đơn theo số hóa đơn
    public float getTotalPayByIDBill(int IDBill)
    {
        String SQL = "SELECT TONGTIEN FROM HOADON WHERE SOHD = " + IDBill;
        try {
            getConnect();
            PreparedStatement ps = conn.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            if(rs != null && rs.next())
                return rs.getFloat("TONGTIEN");
            getClose();
        } catch (Exception e) {
        }
        return 0;
    }
    //Lấy Hệ số khuyến mãi hóa đơn theo số hóa đơn
    public float getDiscountByIDBill(int IDBill)
    {
        String SQL = "SELECT HESOKM FROM HOADON WHERE SOHD = " + IDBill;
        try {
            getConnect();
            PreparedStatement ps = conn.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            if(rs != null && rs.next())
                return rs.getFloat("HESOKM");
            getClose();
        } catch (Exception e) {
        }
        return 0;
    }
    //Lấy VAT hóa đơn theo số hóa đơn
    public float getVATByIDBill(int IDBill)
    {
        String SQL = "SELECT VAT FROM HOADON WHERE SOHD = " + IDBill;
        try {
            getConnect();
            PreparedStatement ps = conn.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            if(rs != null && rs.next())
                return rs.getFloat("VAT");
            getClose();
        } catch (Exception e) {
        }
        return 0;
    }
    //Lấy mã khách hàng theo số hóa đơn
    public int getIDCustomerByIDBill(int IDBill)
    {
        String SQL = "SELECT MAKH FROM HOADON WHERE SOHD = " + IDBill;
        try {
            getConnect();
            PreparedStatement ps = conn.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            if(rs != null && rs.next())
                return rs.getInt("MAKH");
            getClose();
        } catch (Exception e) {
        }
        return 0;
    }
    //Lấy tên nhân viên thu ngân theo số hóa đơn
    public String getNameStaffByIDBill(int IDBill)
    {
        String SQL = "EXEC SP_GETNAMESTAFFBYIDBILL " + IDBill;
        try {
            getConnect();
            PreparedStatement ps = conn.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            if(rs != null && rs.next())
                return rs.getString("TENNV");
            getClose();
        } catch (Exception e) {
        }
        return "";
    }
    //Lấy ngày hóa đơn theo số hóa đơn
    public String getDateBillByIDBill(int IDBill)
    {
        String SQL = "SELECT NGAYHD FROM HOADON WHERE SOHD = " + IDBill;
        try {
            getConnect();
            PreparedStatement ps = conn.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            if(rs != null && rs.next())
                return rs.getString("NGAYHD");
            getClose();
        } catch (Exception e) {
        }
        return "";
    }
    //Lấy trạng thái hóa đơn
    public String getStatusBill(int IDBill)
    {
        String SQL = "SELECT TRANGTHAI FROM HOADON WHERE SOHD = " + IDBill;
        try {
            getConnect();
            PreparedStatement ps = conn.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            if(rs != null && rs.next())
            {
                if(rs.getInt("TRANGTHAI") == 0)
                    return "Chưa thanh toán";
                else return "Đã thanh toán";
            }
            getClose();
        } catch (Exception e) {
        }
        return "";
    }
    
    //Cập nhật trạng thái hóa đơn sau khi thanh toán
    public boolean UpdateStatusBill(int IDBill)
    {
        String SQL = "EXEC SP_STATUSBILL " + IDBill;
        try {
            getConnect();
            Statement st = conn.createStatement();
            int rs=st.executeUpdate(SQL);
            if(rs > 0)
                return true;
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    //Lấy số hóa đơn sau cùng
    public int getMaxIDBill()
    {
        String SQL = "SELECT MAX(SOHD) AS maxSOHD FROM HOADON";
        try {
            getConnect();
            PreparedStatement ps = conn.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            if(rs != null && rs.next())
                return rs.getInt("maxSOHD");
            getClose();
        } catch (Exception e) {
        }
        return 0;
    }
    //Lấy danh sách hóa đơn cho báo cáo doanh thu
    public ArrayList<Bill> RPRevenue(String FromDate, String ToDate)
    {
        ArrayList<Bill> temp = new ArrayList<>();
        String SQL = "EXEC SP_TOP10BILL '" + FromDate +"', '" + ToDate + "'";
        try{
            getConnect();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            if(rs!=null)
                while(rs.next()){
                    Bill bill = new Bill();
                    //SOHD, NGAYHD, MAKH, MANV, TRIGIA, TONGTIEN
                    bill.setIDBill(rs.getInt("SOHD"));
                    bill.setBillDate(rs.getDate("NGAYHD"));
                    bill.setIDCustomer(rs.getInt("MAKH"));
                    bill.setNameStaff(rs.getString("TENNV"));
                    bill.setTotalPrice(rs.getFloat("TRIGIA"));
                    bill.setTotalPay(rs.getFloat("TONGTIEN"));
                    
                    temp.add(bill);
                }
            getClose();
        }catch(Exception e){
            e.printStackTrace();
        }
        return temp;
    }
    //Tính tổng doanh thu
    public float TotalRevenue(String FromDate, String ToDate)
    {
        String SQL = "EXEC SP_TOTAL_REVENUE '" + FromDate + "', '" + ToDate + "'";
        try {
            getConnect();
            PreparedStatement ps = conn.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            if(rs != null && rs.next())
                return rs.getFloat("S");
            getClose();
        } catch (Exception e) {
        }
        return 0;
    }
    //Đếm số lượng hóa đơn
    public int CountBill(String FromDate, String ToDate)
    {
        String SQL = "EXEC SP_COUNTBILL '" + FromDate + "', '" + ToDate + "'";
        try {
            getConnect();
            PreparedStatement ps = conn.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            if(rs != null && rs.next())
                return rs.getInt("AMOUNT");
            getClose();
        } catch (Exception e) {
        }
        return 0;
    }
}
