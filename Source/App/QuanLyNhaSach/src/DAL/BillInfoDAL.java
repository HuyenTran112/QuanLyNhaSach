/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Entity.BillInfo;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
/**
 *
 * @author STIREN
 */
public class BillInfoDAL extends DataAccessHelper{
    //Lấy danh sách CTHD
    public ArrayList<BillInfo> LoadBillInfo(int IDBill){
        ArrayList<BillInfo> temp = new ArrayList<>();
        String SQL = "EXEC SP_LOADBILLINFO " + IDBill;
        try{
            getConnect();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            if(rs!=null)
                while(rs.next()){
                    BillInfo billinfo = new BillInfo();
                    billinfo.setIDBill(rs.getInt("SOHD"));
                    billinfo.setIDBook(rs.getInt("MASACH"));
                    billinfo.setNameBook(rs.getString("TENSACH"));
                    billinfo.setPriceBook(rs.getFloat("GIABAN"));
                    billinfo.setAmount(rs.getInt("SOLUONG"));                   
                    billinfo.setPriceBillInfo(rs.getFloat("THANHTIEN"));
                    
                    temp.add(billinfo);
                }
            getClose();
        }catch(Exception e){
            e.printStackTrace();
        }
        return temp;
    }
    
    //Thêm CTHD
    public boolean  InsertBillInfo(int IDBill, int IDBook, int Amount)
     {
         String SQL = "EXEC SP_INSERTBILLINFO " + IDBill + ", " + IDBook + ", " + Amount;
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
    
    //Cập nhật CTHD
    public boolean UpdateBillInfo(int IDBill, int IDBook, int Amount)
    {
        String SQL = "EXEC SP_UPDATEBILLINFO " + IDBill + ", " + IDBook + ", " + Amount;
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
    
    //Xóa CTHD
    public boolean  DeleteBillInfo(int IDBill, int IDBook)
    {
        String SQL = "EXEC SP_DELETEBILLINFO " + IDBill + ", " + IDBook;
        try {
            getConnect();
            Statement st =conn.createStatement();
            int rs=st.executeUpdate(SQL);
            if(rs>0)
                return true;
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    //Tìm kiếm CTHD
    public ArrayList<BillInfo> SearchBillInfo(String BillDate)
    {
        ArrayList<BillInfo> temp = new ArrayList<>();
        String SQL = "SP_SEARCHBILLINFO '" + BillDate +"'";
        try{
            getConnect();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            if(rs!=null)
                while(rs.next()){
                    BillInfo billinfo = new BillInfo();
                    billinfo.setIDBill(rs.getInt("SOHD"));
                    billinfo.setIDBook(rs.getInt("MASACH"));
                    billinfo.setNameBook(rs.getString("TENSACH"));
                    billinfo.setPriceBook(rs.getFloat("GIABAN"));
                    billinfo.setAmount(rs.getInt("SOLUONG"));                   
                    billinfo.setPriceBillInfo(rs.getFloat("THANHTIEN"));
                    
                    temp.add(billinfo);
                }
            getClose();
        }catch(Exception e){
            e.printStackTrace();
        }
        return temp;
    }
}
