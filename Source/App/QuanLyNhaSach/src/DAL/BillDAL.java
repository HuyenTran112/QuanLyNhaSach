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
    //Hiển thị danh sách hóa đơn
    public ArrayList<Bill> LoadBill(){
        ArrayList<Bill> temp = new ArrayList<>();
        String SQL="EXEC SP_LOADBILL";
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
                    bill.setIDStaff(rs.getInt("MANV"));
                    bill.setVAT(rs.getFloat("VAT"));
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
    
    //Thêm hóa đơn
    public boolean  InsertBill(String BillDate, int IDCustomer, int IDStaff, float VAT)
     {
         String SQL = "EXEC SP_INSERTBILL '" + BillDate + "', " + IDCustomer + ", " + IDStaff + ", " + VAT;
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
    public boolean UpdateBill(int IDBill, String BillDate, int IDCustomer, int IDStaff, float VAT)
    {
        String SQL = "EXEC SP_UPDATEBILL " + IDBill + ", " + "'" + BillDate + "', " + IDCustomer + ", " + IDStaff + ", " + VAT;
        try {
            getConnect();
            Statement st = conn.createStatement();
            int rs=st.executeUpdate(SQL);
            if(rs > 0)
                return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    //Xóa hóa đơn
    public boolean  DeleteBill(int IDBill)
    {
        String SQL="EXEC SP_DELETEBILL " + IDBill;
        try {
            getConnect();
            Statement st =conn.createStatement();
            int rs=st.executeUpdate(SQL);
            if(rs>0)
                return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    //Tìm hóa đơn theo ngày
    public ArrayList<Bill> SearchBill(String BillDate)
    {
        ArrayList<Bill> temp = new ArrayList<>();
        String SQL = "SP_SEARCHBILL '" + BillDate +"'";
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
                    bill.setIDStaff(rs.getInt("MANV"));
                    bill.setVAT(rs.getFloat("VAT"));
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
    
}
