/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilties;

import Entity.Book;
import Entity.BookCategogy;
import javax.swing.JTable;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Bui Thi Huyen Tran
 */
public class ControlFormat {
    //Lấy dữ liệu lên bảng Sách
    public void bindingBook(JTable name, ArrayList<Book> arrBook)
    {
        Vector header = new Vector();
        header.add("Mã sách");
        header.add("Tên thể loại");
        header.add("Tên sách");
        header.add("Nhà xuất bản");
        header.add("Năm xuất bản");
        header.add("Tóm tắt");
        header.add("Giá nhập");
        header.add("Giá bán");
        header.add("Tổng sách tồn");
        Vector data = new Vector();
        for(Book book: arrBook)
        {
            Vector row=new Vector();
            row.add(book.getIDBook());
            row.add(book.getNameCategogyBook());
            row.add(book.getNameBook());
            row.add(book.getPublisherBook());
            row.add(book.getPublishingYear());
            row.add(book.getBrief());
            row.add(book.getCost());
            row.add(book.getPrice());
            row.add(book.getSumInventory());
            data.add(row);
        }
        //DefaultTableModel
        DefaultTableModel dtm = new DefaultTableModel(data,header){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        name.setModel(dtm);      
    }
    public void bindingBookCategogy(JTable name , ArrayList<BookCategogy> arrBookCategogy )
    {
        Vector header =new Vector();
        header.add("Mã thể loại");
        header.add("Tên thể loại");
        Vector data = new Vector();
        for(BookCategogy categogy : arrBookCategogy)
        {
            Vector row =new Vector();
            row.add(categogy.getIDBookCategogy());
            row.add(categogy.getNameBookCategogy());
            data.add(row);
        }
        DefaultTableModel dtm = new DefaultTableModel(data , header)
        {
            public boolean isCellEditable(int row , int column)
            {
                return false;
            }
        };
        name.setModel(dtm);
    }
    
}
