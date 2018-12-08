/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Entity.BookReceipt;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.ErrorMsg;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Bui Thi Huyen Tran
 */
public class BookReceiptDAL extends  DataAccessHelper{
    //Lấy danh sách phiếu nhập sách
    public ArrayList<BookReceipt> LoadBookReceipt()
    {
        ArrayList<BookReceipt> temp =new ArrayList<>();
        String SQL="EXEC SP_LOADBOOKSTOCK";
        try {
            getConnect();
            Statement st =conn.createStatement();
            ResultSet rs=st.executeQuery(SQL);
            if(rs!=null)
                while(rs.next())
                {
                    BookReceipt bookstock =new BookReceipt();
                    bookstock.setIDBookReceipt(rs.getInt("SOPHIEUNHAP"));
                    bookstock.setDateReceipt(rs.getDate("NGAYNHAP"));
                    bookstock.setNameDistributor(rs.getString("TENCTY"));
                    bookstock.setTotalReceipt(rs.getFloat("TONGTIEN"));
                    temp.add(bookstock);
                }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return temp;
    }
    //Thêm danh sách phiếu nhập sách
    public boolean  InsertBookReceipt(String DateReceipt ,int IDDistributor)
    {
        String SQL="EXEC SP_INSERTBOOKSTOCK '"+DateReceipt+"','"+IDDistributor+"'";
        try {
            getConnect();
            Statement st =conn.createStatement();
            int rs =st.executeUpdate(SQL);
            if(rs>0)
                return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    //Cập nhật phiếu nhập sách
    public boolean  UpdateBookReceipt(int IDBookReceipt, String DateReceipt ,int IDDistributor)
    {
        String SQL="EXEC SP_UPDATEBOOKSTOCK '"+IDBookReceipt+"','"+DateReceipt+"','"+IDDistributor+"'";
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
    //Xóa phiếu nhập sách
    public boolean  DeleteBookReceipt(int IDBookReceipt)
    {
        String SQL="EXEC SP_DELETEBOOKSTOCK '"+IDBookReceipt+"'";
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
    //Tìm phiếu nhập sách theo nhà cung cấp
    public ArrayList<BookReceipt> SearchBookReceipt(String key)
    {
        String SQL="EXEC SP_SEARCHBOOKSTOCK N'"+key+"'";
        ArrayList<BookReceipt> temp=new ArrayList<>();
        try {
            getConnect();
            Statement st = conn.createStatement();
            ResultSet rs =st.executeQuery(SQL);
            if(rs!=null)
                while(rs.next())
                {
                    BookReceipt bookstock =new BookReceipt();
                    bookstock.setIDBookReceipt(rs.getInt("SOPHIEUNHAP"));
                    bookstock.setDateReceipt(rs.getDate("NGAYNHAP"));
                    bookstock.setNameDistributor(rs.getString("TENCTY"));
                    bookstock.setTotalReceipt(rs.getFloat("TONGTIEN"));
                    temp.add(bookstock);
                }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return temp;
    }
    //lấy số phiếu nhập
    public int getIDBookReceipt()
    {
        String SQL="SELECT SOPHIEUNHAP FROM PHIEUNHAP";
        try {
            getConnect();
            Statement st = conn.createStatement();
            ResultSet rs =st.executeQuery(SQL);
            if(rs!=null && rs.next())
                return rs.getInt("SOPHIEUNHAP");
                
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;

    }
    //Lấy ngày nhập theo số phiếu nhập
    public Date getDateReceipt(int IDBookReceipt)
    {
        String SQL="SELECT NGAYNHAP FROM PHIEUNHAP WHERE SOPHIEUNHAP='"+IDBookReceipt+"'";
        try {
            getConnect();
            Statement st = conn.createStatement();
            ResultSet rs =st.executeQuery(SQL);
            if(rs!=null && rs.next())
                return rs.getDate("NGAYNHAP");
                
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    //Lấy tên nhà cung cấp theo số phiếu nhập
    public String getDistributor(int IDBookReceipt)
    {
         String SQL="SELECT TENCTY FROM PHIEUNHAP,CONGTY WHERE PHIEUNHAP.MACTY=CONGTY.MACTY AND SOPHIEUNHAP='"+IDBookReceipt+"'";
        try {
            getConnect();
            Statement st = conn.createStatement();
            ResultSet rs =st.executeQuery(SQL);
            if(rs!=null && rs.next())
                return rs.getString("TENCTY");
                
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
    //Lấy tổng tiền của phiếu nhập theo số phiếu nhập
    public float getTotalReceipt(int IDBookReceipt)
    {
        String SQL="SELECT TONGTIEN FROM PHIEUNHAP WHERE SOPHIEUNHAP='"+IDBookReceipt+"'";
        try {
            getConnect();
            Statement st = conn.createStatement();
            ResultSet rs =st.executeQuery(SQL);
            if(rs!=null && rs.next())
                return rs.getFloat("TONGTIEN");
                
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
