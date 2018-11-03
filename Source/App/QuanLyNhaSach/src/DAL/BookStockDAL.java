/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Entity.BookStock;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.ErrorMsg;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Bui Thi Huyen Tran
 */
public class BookStockDAL extends  DataAccessHelper{
    //Lấy danh sách phiếu nhập sách
    public ArrayList<BookStock> LoadBookStock()
    {
        ArrayList<BookStock> temp =new ArrayList<>();
        String SQL="EXEC SP_LOADBOOKSTOCK";
        try {
            getConnect();
            Statement st =conn.createStatement();
            ResultSet rs=st.executeQuery(SQL);
            if(rs!=null)
                while(rs.next())
                {
                    BookStock bookstock =new BookStock();
                    bookstock.setIDBookStock(rs.getInt("SOPHIEUNHAP"));
                    bookstock.setDateStock(rs.getDate("NGAYNHAP"));
                    bookstock.setNameDistributor(rs.getString("TENCTY"));
                    bookstock.setTotalStock(rs.getFloat("TONGTIEN"));
                    temp.add(bookstock);
                }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return temp;
    }
    //Thêm danh sách phiếu nhập sách
    public boolean  InsertBookStock(String DateStock ,int IDDistributor)
    {
        String SQL="EXEC SP_INSERTBOOKSTOCK '"+DateStock+"','"+IDDistributor+"'";
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
    public boolean  UpdateBookStock(int IDBookStock, String DateStock ,int IDDistributor)
    {
        String SQL="EXEC SP_UPDATEBOOKSTOCK '"+IDBookStock+"','"+DateStock+"','"+IDDistributor+"'";
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
    public boolean  DeleteBookStock(int IDBookStock)
    {
        String SQL="EXEC SP_DELETEBOOKSTOCK '"+IDBookStock+"'";
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
    public ArrayList<BookStock> SearchBookStock(String key)
    {
        String SQL="EXEC SP_SEARCHBOOKSTOCK N'"+key+"'";
        ArrayList<BookStock> temp=new ArrayList<>();
        try {
            getConnect();
            Statement st = conn.createStatement();
            ResultSet rs =st.executeQuery(SQL);
            if(rs!=null)
                while(rs.next())
                {
                    BookStock bookstock =new BookStock();
                    bookstock.setIDBookStock(rs.getInt("SOPHIEUNHAP"));
                    bookstock.setDateStock(rs.getDate("NGAYNHAP"));
                    bookstock.setNameDistributor(rs.getString("TENCTY"));
                    bookstock.setTotalStock(rs.getFloat("TONGTIEN"));
                    temp.add(bookstock);
                }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return temp;
    }
    //lấy số phiếu nhập
    public int getIDBookStock()
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
}
