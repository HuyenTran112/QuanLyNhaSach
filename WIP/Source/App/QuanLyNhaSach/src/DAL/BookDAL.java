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
/**
 *
 * @author Bui Thi Huyen Tran
 */
public class BookDAL extends  DataAccessHelper{
     public ArrayList<Book> layDanhSach(){
        ArrayList<Book> temp = new ArrayList<>();
        String SQL = "SELECT MASACH, TENTHELOAI,TENSACH, NHAXUATBAN, NAMXUATBAN, TOMTAT, GIANHAP, GIABAN, TONGSACHTON	FROM SACH, LOAISACH WHERE SACH.MATHELOAI=LOAISACH.MATHELOAI";
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
