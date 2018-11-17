/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Entity.BookStockDetail;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Bui Thi Huyen Tran
 */
public class BookStockDetailDAL extends DataAccessHelper{
    //lấy dữ liệu bảng chi tiết phiếu nhập sách
    public ArrayList<BookStockDetail> LoadBookStockDetail ()
    {
        String SQL="EXEC SP_LOADBOOKSTOCKDETAIL";
        ArrayList<BookStockDetail> temp = new ArrayList<>();
        try {
            getConnect();
            Statement st =conn.createStatement();
            ResultSet rs =st.executeQuery(SQL);
            if(rs!=null)
                while(rs.next())
                {
                    BookStockDetail bookstockdetail =new BookStockDetail();
                    bookstockdetail.setIDBookStock(rs.getInt("SOPHIEUNHAP"));
                    bookstockdetail.setNameBook(rs.getString("TENSACH"));
                    bookstockdetail.setAmountStock(rs.getInt("SOLUONGNHAP"));
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
    public boolean  InsertBookStockDetail(int IDBookStock ,int IDBook,int AmountStock,float cost )
    {
        String SQL="EXEC SP_INSERTBOOKSTOCKDETAIL '"+IDBookStock+"','"+IDBook+"','"+AmountStock+"','"+cost+"'";
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
    public boolean UpdateBookStockDetail(int IDBookStock ,int IDBook,int AmountStock,float Cost)
    {
        String SQL="EXEC SP_UPDATEBOOKSTOCKDETAIL '"+IDBookStock+"','"+IDBook+"','"+AmountStock+"','"+Cost+"'";
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
    public boolean  DeleteBookStockDetail(int IDBookStock,int IDBook)
    {
        String SQL="EXEC SP_DELETEBOOKSTOCKDETAIL '"+IDBookStock+"','"+IDBook+"'";
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
    public ArrayList<BookStockDetail> SearchBookStockDetail (int key)
    {
        String SQL="EXEC SP_SEARCHBOOKSTOCKDETAIL '"+key+"'";
        ArrayList<BookStockDetail> temp = new ArrayList<>();
        try {
            getConnect();
            Statement st =conn.createStatement();
            ResultSet rs =st.executeQuery(SQL);
            if(rs!=null)
                while(rs.next())
                {
                    BookStockDetail bookstockdetail =new BookStockDetail();
                    bookstockdetail.setIDBookStock(rs.getInt("SOPHIEUNHAP"));
                    bookstockdetail.setNameBook(rs.getString("TENSACH"));
                    bookstockdetail.setAmountStock(rs.getInt("SOLUONGNHAP"));
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
