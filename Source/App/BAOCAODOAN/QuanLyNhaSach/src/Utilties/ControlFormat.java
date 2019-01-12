/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilties;

import Entity.Bill;
import Entity.BillInfo;
import Entity.Book;
import Entity.BookCategogy;
import Entity.BookReceipt;
import Entity.BookReceiptInfo;
import Entity.Customer;
import Entity.Discount;
import Entity.Distributor;
import Entity.Rule;
import Entity.Staff;
import Entity.User;
import java.awt.Font;
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
        header.add("Tác giả");
        header.add("Nhà xuất bản");
        header.add("Năm XB");
        header.add("Tóm tắt");
        header.add("Giá bán");
        header.add("Tổng sách");
        Vector data = new Vector();
        for(Book book: arrBook)
        {
            Vector row=new Vector();
            row.add(book.getIDBook());
            row.add(book.getNameCategogyBook());
            row.add(book.getNameBook());
            row.add(book.getAuthor());
            row.add(book.getPublisherBook());
            row.add(book.getPublishingYear());
            row.add(book.getBrief());
            row.add(book.getCost());
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
        name.getColumnModel().getColumn(0).setPreferredWidth(70);
        name.getColumnModel().getColumn(1).setPreferredWidth(200);
        name.getColumnModel().getColumn(2).setPreferredWidth(200);
        name.getColumnModel().getColumn(3).setPreferredWidth(150);
        name.getColumnModel().getColumn(4).setPreferredWidth(150);
        name.getColumnModel().getColumn(5).setPreferredWidth(50);
        name.getColumnModel().getColumn(6).setPreferredWidth(100);
        name.getColumnModel().getColumn(7).setPreferredWidth(100);
        name.getColumnModel().getColumn(8).setPreferredWidth(100);
        name.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 14));
        name.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 14));
 
    }
     //Lấy dữ liệu lên bảng Sách
    public void bindingIDNameBook(JTable name, ArrayList<Book> arrBook)
    {
        Vector header = new Vector();
        header.add("Mã sách");
        header.add("Tên sách");
        Vector data = new Vector();
        for(Book book: arrBook)
        {
            Vector row=new Vector();
            row.add(book.getIDBook());
            row.add(book.getNameBook());
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
        header.add("Mã KM");
        header.add("Tên khuyến mãi");
        header.add("Hệ số KM");
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
        name.getColumnModel().getColumn(0).setPreferredWidth(70);
        name.getColumnModel().getColumn(1).setPreferredWidth(200);
        name.getColumnModel().getColumn(2).setPreferredWidth(150);
        name.getColumnModel().getColumn(3).setPreferredWidth(150);
        name.getColumnModel().getColumn(4).setPreferredWidth(150);
        name.getColumnModel().getColumn(5).setPreferredWidth(150);
       
    }
    
    //Lấy dữ liệu lên bảng khách hàng
    public void BindingCustomer(JTable name, ArrayList<Customer> arrCustomer)
    {
        Vector header = new Vector();
        header.add("Mã KH");
        header.add("Tên khách hàng");
        header.add("Địa chỉ");
        header.add("Số điện thoại");
        header.add("Ngày sinh");
        header.add("Ngày ĐK");
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
        name.getColumnModel().getColumn(0).setPreferredWidth(70);
        name.getColumnModel().getColumn(1).setPreferredWidth(200);
        name.getColumnModel().getColumn(2).setPreferredWidth(200);
        name.getColumnModel().getColumn(3).setPreferredWidth(100);
        name.getColumnModel().getColumn(4).setPreferredWidth(100);
        name.getColumnModel().getColumn(5).setPreferredWidth(100);
        
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
    public void bindingBookReceipt(JTable name ,ArrayList<BookReceipt> arrBookReceipt )
    {
        Vector header = new Vector();
        header.add("Số PN");
        header.add("Ngày nhập");
        header.add("Tên công ty");
        header.add("Tổng tiền tiền");
        Vector data=new Vector();
        for(BookReceipt bookstock :arrBookReceipt)
        {
            Vector row = new Vector();
            row.add(bookstock.getIDBookReceipt());
            row.add(bookstock.getDateReceipt());
            row.add(bookstock.getNameDistributor());
            row.add(bookstock.getTotalReceipt());
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
        name.getColumnModel().getColumn(0).setPreferredWidth(70);
        name.getColumnModel().getColumn(1).setPreferredWidth(100);
        name.getColumnModel().getColumn(2).setPreferredWidth(200);
        name.getColumnModel().getColumn(3).setPreferredWidth(150);
        
    }
    //Lấy dữ liệu chi tiết phiếu nhập sách
    public void bindingBookReceiptInfo(JTable name , ArrayList<BookReceiptInfo> arrBookReceiptInfo)
    {
        Vector header =new Vector();
        header.add("Tên sách");
        header.add("Số lượng nhập");
        header.add("Giá nhập");
        header.add("Thành tiền");
        Vector data =new Vector();
        for(BookReceiptInfo bookstockdetail :arrBookReceiptInfo)
        {
            Vector row =new Vector();
            row.add(bookstockdetail.getNameBook());
            row.add(bookstockdetail.getAmountReceipt());
            row.add(bookstockdetail.getCost());
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
    //Lấy dữ liệu lên bảng hóa đơn
    public void bindingBill(JTable name, ArrayList<Bill> arrBill)
    {
        Vector header = new Vector();
        header.add("Số hóa đơn");
        header.add("Ngày hóa đơn");
        header.add("Mã khách hàng");
        header.add("Tên khách hàng");
        header.add("Mã nhân viên");
        header.add("Tên nhân viên");
        header.add("VAT");
        header.add("Hệ số khuyến mãi");
        header.add("Trị giá");
        header.add("Tổng tiền");
        
        Vector data = new Vector();
        for(Bill bill : arrBill)
        {
            Vector row = new Vector();
            row.add(bill.getIDBill());
            row.add(bill.getBillDate());
            row.add(bill.getIDCustomer());
            row.add(bill.getNameCustomer());
            row.add(bill.getIDStaff());
            row.add(bill.getNameStaff());
            row.add(bill.getVAT());
            row.add(bill.getDiscount());
            row.add(bill.getTotalPrice());
            row.add(bill.getTotalPay());
            
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
    
    //Lấy dữ liệu chi tiết hóa đơn
    public void bindingBillInfo(JTable name, ArrayList<BillInfo> arrBillInfo)
    {
        Vector header = new Vector();
        header.add("Số hóa đơn");
        header.add("Mã sách");
        header.add("Tên sách");
        header.add("Giá bán");
        header.add("Số lượng");       
        header.add("Thành tiền");
        
        Vector data = new Vector();
        for(BillInfo billinfo : arrBillInfo)
        {
            Vector row = new Vector();
            row.add(billinfo.getIDBill());
            row.add(billinfo.getIDBook());
            row.add(billinfo.getNameBook());
            row.add(billinfo.getPriceBook());
            row.add(billinfo.getAmount());           
            row.add(billinfo.getPriceBillInfo());
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
    //Lấy dữ liệu nhân viên
    public void bindingStaff(JTable name ,ArrayList<Staff> arrStaff)
    {
        Vector header =new Vector();
        header.add("Mã NV");
        header.add("Tên nhân viên");
        header.add("Ngày sinh");
        header.add("Giới tính");
        header.add("Địa chỉ");
        header.add("Số điện thoại");
        header.add("Ngày vào làm");
        header.add("Trạng thái");
        Vector data =new Vector();
        for(Staff staff: arrStaff)
        {
            Vector row =new Vector();
            row.add(staff.getID());
            row.add(staff.getName());
            row.add(staff.getBirthDay());
            row.add(staff.getSex());
            row.add(staff.getAddress());
            row.add(staff.getPhoneNumber());
            row.add(staff.getStartDate());
            if(staff.getStatus()==1)
                row.add("Làm việc");
            if(staff.getStatus()==0)
                row.add("Thôi việc");
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
        name.getColumnModel().getColumn(0).setPreferredWidth(70);
        name.getColumnModel().getColumn(1).setPreferredWidth(200);
        name.getColumnModel().getColumn(2).setPreferredWidth(100);
        name.getColumnModel().getColumn(3).setPreferredWidth(100);
        name.getColumnModel().getColumn(4).setPreferredWidth(150);
        name.getColumnModel().getColumn(5).setPreferredWidth(150);
        name.getColumnModel().getColumn(6).setPreferredWidth(150);
        name.getColumnModel().getColumn(7).setPreferredWidth(150);
    }
    //Lấy dữ liệu quy định
    public void bindingRule(JTable name ,ArrayList<Rule> arrRule)
    {
        Vector header = new Vector();
        header.add("Số lượng tồn tối đa");
        header.add("Số lượng tồn tối thiểu");
        header.add("Tỉ lệ tính giá bán");
        header.add("Số lượng nhập tối đa");
        header.add("Số lượng nhập tối thiểu");
        header.add("VAT");
        
        Vector data = new Vector();
        for(Rule rule : arrRule)
        {
            Vector row = new Vector();
            row.add(rule.getMaxInventoryNum());
            row.add(rule.getMinInventoryNum());
            row.add(rule.getPriceRatio());
            row.add(rule.getMaxStockNum());
            row.add(rule.getMinStockNum());
            row.add(rule.getVAT());
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
    //Lấy dữ liệu người dùng
    public void bindingUser(JTable name ,ArrayList<User> arr)
    {
        Vector header = new Vector();
        header.add("Tên nhóm");
        header.add("Tên nhân viên");
        header.add("Tên đăng nhập");
        header.add("Tên hiện thị");
        header.add("Mật khẩu");
        Vector data = new Vector();
        for(User user : arr)
        {
            Vector row = new Vector();
            row.add(user.getNameCategogy());
            row.add(user.getNameStaff());
            row.add(user.getUserName());
            row.add(user.getDisplayName());
            row.add(user.getPassWord());
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
        name.getColumnModel().getColumn(0).setPreferredWidth(100);
        name.getColumnModel().getColumn(1).setPreferredWidth(200);
        name.getColumnModel().getColumn(2).setPreferredWidth(200);
        name.getColumnModel().getColumn(3).setPreferredWidth(100);
        name.getColumnModel().getColumn(4).setPreferredWidth(100);
    }
    // Lấy dữ liệu báo cáo doanh thu
    public void bindingRPRevenue(JTable name ,ArrayList<Bill> arrBill)
    { 
        Vector header = new Vector();
        header.add("Số hóa đơn");
        header.add("Ngày hóa đơn");
        header.add("Mã khách hàng");
        header.add("Tên nhân viên");
        header.add("Trị giá");
        header.add("Tổng tiền");
        
        Vector data = new Vector();
        for(Bill bill : arrBill)
        {
            Vector row = new Vector();
            row.add(bill.getIDBill());
            row.add(bill.getBillDate());
            row.add(bill.getIDCustomer());
            row.add(bill.getNameStaff());
            row.add(bill.getTotalPrice());
            row.add(bill.getTotalPay());

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
    // Lấy dữ liệu báo cáo doanh thu top 20 sách bán chạy
    public void bindingRPInventoryTop20(JTable name ,ArrayList<Book> arrBook)
    { //MASACH, TENTHELOAI, TENSACH, TACGIA, NHAXUATBAN, NAMXUATBAN, GIANHAP
        Vector header = new Vector();
        header.add("Mã sách");
        header.add("Tên thể loại");
        header.add("Tên sách");
        header.add("Tác giả");
        header.add("Nhà xuất bản");
        header.add("Năm xuất bản");
        header.add("Giá nhập");
        
        Vector data = new Vector();
        for(Book book : arrBook)
        {
            Vector row = new Vector();
            row.add(book.getIDBook());
            row.add(book.getNameCategogyBook());
            row.add(book.getNameBook());
            row.add(book.getAuthor());
            row.add(book.getPublisherBook());
            row.add(book.getPublishingYear());
            row.add(book.getCost());
            
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
    // Lấy dữ liệu báo cáo doanh thu các quyển sách có số lượng tồn <= quy định
    public void bindingRPInventoryMinInventory(JTable name ,ArrayList<Book> arrBook)
    { //MASACH, TENTHELOAI, TENSACH, TACGIA, NHAXUATBAN, NAMXUATBAN, GIANHAP
        Vector header = new Vector();
        header.add("Mã sách");
        header.add("Tên thể loại");
        header.add("Tên sách");
        header.add("Tác giả");
        header.add("Nhà xuất bản");
        header.add("Năm xuất bản");
        header.add("Giá nhập");
        header.add("Tổng sách tồn");
        
        Vector data = new Vector();
        for(Book book : arrBook)
        {
            Vector row = new Vector();
            row.add(book.getIDBook());
            row.add(book.getNameCategogyBook());
            row.add(book.getNameBook());
            row.add(book.getAuthor());
            row.add(book.getPublisherBook());
            row.add(book.getPublishingYear());
            row.add(book.getCost());
            row.add(book.getSumInventory());
            
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
