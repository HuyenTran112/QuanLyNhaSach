/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Entity.BookReceiptInfo;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Bui Thi Huyen Tran
 */
public class BookReceiptInfoDAL extends DataAccessHelper{
    //lấy dữ liệu bảng chi tiết phiếu nhập sách
    public ArrayList<BookReceiptInfo> LoadBookReceiptInfo ()
    {
        String SQL="EXEC SP_LOADBOOKSTOCKDETAIL";
        ArrayList<BookReceiptInfo> temp = new ArrayList<>();
        try {
            getConnect();
            Statement st =conn.createStatement();
            ResultSet rs =st.executeQuery(SQL);
            if(rs!=null)
                while(rs.next())
                {
                    BookReceiptInfo bookstockdetail =new BookReceiptInfo();
                    bookstockdetail.setIDBookReceipt(rs.getInt("SOPHIEUNHAP"));
                    bookstockdetail.setNameBook(rs.getString("TENSACH"));
                    bookstockdetail.setAmountReceipt(rs.getInt("SOLUONGNHAP"));
                    bookstockdetail.setCost(rs.getFloat("GIANHAP"));
                    bookstockdetail.setAmount(rs.getFloat("THANHTIEN"));
                    temp.add(bookstockdetail);
                }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return temp;
    }
    //thêm chi tiết phiếu nhập sách
    public boolean  InsertBookReceiptInfo(int IDBookReceipt ,int IDBook,int AmountReceipt,float cost )
    {
        String SQL="EXEC SP_INSERTBOOKSTOCKDETAIL '"+IDBookReceipt+"','"+IDBook+"','"+AmountReceipt+"','"+cost+"'";
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
    //Cập nhật chi tiết phiếu nhập sách
    public boolean UpdateBookReceiptInfo(int IDBookReceipt ,int IDBook,int AmountReceipt,float Cost)
    {
        String SQL="EXEC SP_UPDATEBOOKSTOCKDETAIL '"+IDBookReceipt+"','"+IDBook+"','"+AmountReceipt+"','"+Cost+"'";
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
    //Xóa chi tiết phiếu nhập sách
    public boolean  DeleteBookReceiptInfo(int IDBookReceipt,int IDBook)
    {
        String SQL="EXEC SP_DELETEBOOKSTOCKDETAIL '"+IDBookReceipt+"','"+IDBook+"'";
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
    //Tìm chi tiết phiếu nhập sách theo số phiếu nhập
    public ArrayList<BookReceiptInfo> SearchBookReceiptInfo (int key)
    {
        String SQL="EXEC SP_SEARCHBOOKSTOCKDETAIL'"+key+"'";
        ArrayList<BookReceiptInfo> temp = new ArrayList<>();
        try {
            getConnect();
            Statement st =conn.createStatement();
            ResultSet rs =st.executeQuery(SQL);
            if(rs!=null)
                while(rs.next())
                {
                    BookReceiptInfo bookstockdetail =new BookReceiptInfo();
                    bookstockdetail.setIDBookReceipt(rs.getInt("SOPHIEUNHAP"));
                    bookstockdetail.setNameBook(rs.getString("TENSACH"));
                    bookstockdetail.setAmountReceipt(rs.getInt("SOLUONGNHAP"));
                    bookstockdetail.setCost(rs.getFloat("GIANHAP"));
                    bookstockdetail.setAmount(rs.getFloat("THANHTIEN"));
                    temp.add(bookstockdetail);
                }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return temp;
    }
   
}
