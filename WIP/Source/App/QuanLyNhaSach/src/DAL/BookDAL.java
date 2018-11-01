/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import Entity.*;
import java.lang.invoke.MethodHandles;
import java.sql.CallableStatement;
/**
 *
 * @author Bui Thi Huyen Tran
 */
public class BookDAL extends  DataAccessHelper{
    
     public ArrayList<Book> LoadBook(){
        ArrayList<Book> temp = new ArrayList<>();
        String SQL="EXEC SP_LOADBOOK";
        //String SQL = "SELECT MASACH, TENTHELOAI,TENSACH, NHAXUATBAN, NAMXUATBAN, TOMTAT, GIANHAP, GIABAN, TONGSACHTON	FROM SACH, LOAISACH WHERE SACH.MATHELOAI=LOAISACH.MATHELOAI";
        try{
            getConnect();
//            String sql ="{SP_LOADBOOK}";
//            CallableStatement call = conn.prepareCall(sql);
//            Statement st = conn.createStatement();
//            ResultSet rs=call.executeQuery();
             Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            if(rs!=null)
                while(rs.next()){
                    Book book = new Book();
                    book.setIDBook(rs.getInt("MASACH"));
                    book.setNameCategogyBook(rs.getString("TENTHELOAI"));
                    book.setNameBook(rs.getString("TENSACH"));
                    book.setPublisherBook(rs.getString("NHAXUATBAN"));
                    book.setPublishingYear(rs.getInt("NAMXUATBAN"));
                    book.setBrief(rs.getString("TOMTAT"));
                    book.setCost(rs.getFloat("GIANHAP"));
                    book.setPrice(rs.getFloat("GIABAN"));
                    book.setSumInventory(rs.getInt("TONGSACHTON"));
                    temp.add(book);
                }
            getClose();
        }catch(Exception e){
            e.printStackTrace();
        }
        return temp;
    }
     //Thêm sách
     public boolean  InsertBook(String BookName , String PublisherBook, int PublishingYear, String Brief, float Cost , float Price, int SumInventory, int IDBookCategogy )
     {
         String SQL="EXEC SP_INSERTBOOK N'"+BookName+"',N'"+PublisherBook+"','"+PublishingYear+"',N'"+Brief+"','"+Cost+"','"+Price+"','"+SumInventory+"','"+IDBookCategogy+"'";
          try{
            getConnect();
            Statement st = conn.createStatement();
            int rs = st.executeUpdate(SQL);
            if(rs>0)
                return true;
            getClose();
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
     }
     //Cập nhật sách
    public boolean  UpdateBook(int IDBookName, String BookName , String PublisherBook, int PublishingYear, String Brief, float Cost , float Price, int SumInventory, int IDBookCategogy )
    {
        String SQL="EXEC SP_UPDATEBOOK '"+IDBookName+"', N'"+BookName+"',N'"+PublisherBook+"','"+PublishingYear+"',N'"+Brief+"','"+Cost+"','"+Price+"','"+SumInventory+"','"+IDBookCategogy+"'";
        try{
            getConnect();
            Statement st=conn.createStatement();
            int rs=st.executeUpdate(SQL);
            if(rs>0)
                return true;
            getClose();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }
    //Xóa sách
    public boolean  DeleteBook(int IDBookName)
    {
        String SQL="EXEC SP_DELETEBOOK '"+IDBookName+"'";
        try {
            getConnect();
            Statement st =conn.createStatement();
            int rs=st.executeUpdate(SQL);
            if(rs>0)
                return true;
            getClass();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }
    //Tìm sách
    public ArrayList <Book> SearchBook(String key)
    {
        ArrayList<Book> temp = new ArrayList<>();
        String SQL="EXEC SP_SEARCHBOOK N'" + key +"'";
       try{
            getConnect();
             Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            if(rs!=null)
                while(rs.next()){
                    Book book = new Book();
                    book.setIDBook(rs.getInt("MASACH"));
                    book.setNameCategogyBook(rs.getString("TENTHELOAI"));
                    book.setNameBook(rs.getString("TENSACH"));
                    book.setPublisherBook(rs.getString("NHAXUATBAN"));
                    book.setPublishingYear(rs.getInt("NAMXUATBAN"));
                    book.setBrief(rs.getString("TOMTAT"));
                    book.setCost(rs.getFloat("GIANHAP"));
                    book.setPrice(rs.getFloat("GIABAN"));
                    book.setSumInventory(rs.getInt("TONGSACHTON"));
                    temp.add(book);
                }
            getClose();
        }catch(Exception e){
            e.printStackTrace();
        }
        return temp;
    }
 }
