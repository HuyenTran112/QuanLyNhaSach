/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilties;

import Entity.Book;
import Entity.BookCategogy;
import Entity.BookStock;
import Entity.BookStockDetail;
import Entity.Customer;
import Entity.Discount;
import Entity.Distributor;
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
    //Lấy dữ liệu lên bảng thể loại sách
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
    //Lấy dữ liệu lên bảng khuyến mãi
    public void bindingDiscount(JTable name , ArrayList<Discount> arrDiscount)
    {
        Vector header =new Vector();
        header.add("Mã khuyến mãi");
        header.add("Tên khuyến mãi");
        header.add("Hệ số khuyến mãi");
        header.add("Mức tiền");
        header.add("Ngày bắt đầu");
        header.add("Ngày hết hạn");
        Vector data =new Vector();
        for(Discount discount:arrDiscount)
        {
            Vector row = new Vector();
            row.add(discount.getIDDiscount());
            row.add(discount.getNameDiscount());
            row.add(discount.getDiscount());
            row.add(discount.getMoney());
            row.add(discount.getStartDate());
            row.add(discount.getFinishDate());
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
    
    //Lấy dữ liệu lên bảng khách hàng
    public void BindingCustomer(JTable name, ArrayList<Customer> arrCustomer)
    {
        Vector header = new Vector();
        header.add("Mã khách hàng");
        header.add("Tên khách hàng");
        header.add("Địa chỉ");
        header.add("Số điện thoại");
        header.add("Ngày sinh");
        header.add("Ngày đăng ký");
        header.add("Doanh số");
        
        Vector data = new Vector();
        for(Customer customer : arrCustomer)
        {
           Vector row = new Vector();
           row.add(customer.getIDCustomer());
           row.add(customer.getNameCustomer());
           row.add(customer.getAddressCustomer());
           row.add(customer.getPhoneCustomer());
           row.add(customer.getBirthdayCutomer());
           row.add(customer.getRegisDateCutomer());
           row.add(customer.getTurnoverCustomer());
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
    //Lấy dữ liệu ở bảng nhà cung cấp
    public void bindingDistributor(JTable name, ArrayList<Distributor> arrDistributor) {
        Vector header =new Vector();
        header.add("Mã nhà cung cấp");
        header.add("Tên nhà cung cấp");
        header.add("Số điện thoại");
        header.add("Số điện thoại");
        Vector data =new Vector();
        for(Distributor distributor:arrDistributor)
        {
            Vector row =new Vector();
            row.add(distributor.getIDDistributor());
            row.add(distributor.getNameDistributor());
            row.add(distributor.getAddress());
            row.add(distributor.getPhoneNumber());
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
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    //Lấy dữ liệu ở phiếu nhập sách
    public void bindingBookStock(JTable name ,ArrayList<BookStock> arrBookStock )
    {
        Vector header = new Vector();
        header.add("Số phiếu nhập");
        header.add("Ngày nhập");
        header.add("Tên công ty");
        header.add("Tổng tiền tiền");
        Vector data=new Vector();
        for(BookStock bookstock :arrBookStock)
        {
            Vector row = new Vector();
            row.add(bookstock.getIDBookStock());
            row.add(bookstock.getDateStock());
            row.add(bookstock.getNameDistributor());
            row.add(bookstock.getTotalStock());
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
    //Lấy dữ liệu chi tiết phiếu nhập sách
    public void bindingBookStockDetail(JTable name , ArrayList<BookStockDetail> arrBookStockDetail)
    {
        Vector header =new Vector();
        header.add("Số phiếu nhập");
        header.add("Tên sách");
        header.add("Số lượng nhập");
        header.add("Thành tiền");
        Vector data =new Vector();
        for(BookStockDetail bookstockdetail :arrBookStockDetail)
        {
            Vector row =new Vector();
            row.add(bookstockdetail.getIDBookStock());
            row.add(bookstockdetail.getNameBook());
            row.add(bookstockdetail.getAmountStock());
            row.add(bookstockdetail.getAmount());
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
