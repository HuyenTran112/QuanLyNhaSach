/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;
import  Entity.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
/**
 *
 * @author Bui Thi Huyen Tran
 */
public class BookCategogyDAL extends  DataAccessHelper{
    //Lấy thông tin tất cả thể loại sách
    public ArrayList<BookCategogy> getAllCategogy()
    {
        String SQL = "EXEC SP_LOADBOOKCATEGOGY";
        ArrayList<BookCategogy> temp = new ArrayList<BookCategogy>();
        try{
            getConnect();
            PreparedStatement ps = conn.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            if(rs!=null)
                while(rs.next()){
                    BookCategogy categogy = new BookCategogy();
                    categogy.setIDBookCategogy(rs.getInt("MATHELOAI"));
                    categogy.setNameBookCategogy(rs.getString("TENTHELOAI"));
                    temp.add(categogy);
                }
            getClose();
        }catch(Exception e){
            e.printStackTrace();
        }
        return temp;
    }
    //Lấy mã thể loại theo tên thể loại
    public int getIDBookCategogy(String NameBookCategogy)
    {
        String SQL="SELECT MATHELOAI FROM LOAISACH WHERE TENTHELOAI=N'"+NameBookCategogy+"'";
        try {
            getConnect();
            PreparedStatement ps=conn.prepareStatement(SQL);
            ResultSet rs =ps.executeQuery();
            if(rs!=null && rs.next())
                return rs.getInt("MATHELOAI");
            getClose();
        } catch (Exception e) {
        }
        return 0;
    }
     //Lấy tên thể loại theo mã thể loại
    public String getNameBookCategogy(int IDBookCategogy)
    {
        String SQL="SELECT TENTHELOAI FROM LOAISACH WHERE MATHELOAI=N'"+IDBookCategogy+"'";
        try {
            getConnect();
            PreparedStatement ps=conn.prepareStatement(SQL);
            ResultSet rs=ps.executeQuery();
            if(rs!=null && rs.next())
                return rs.getString("TENTHELOAI");
            getClose();
        } catch (Exception e) {
        }
        return "";
    }
    //Thêm thể loại
    public boolean InsertBookCategogy( String NameBookCategogy)
    {
        String SQL="EXEC SP_INSERTBOOKCATEGOGY N'"+NameBookCategogy+"'";
        try {
            getConnect();
            Statement  st =conn.createStatement();
            int rs=st.executeUpdate(SQL);
            if(rs>0)
                return true;
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
