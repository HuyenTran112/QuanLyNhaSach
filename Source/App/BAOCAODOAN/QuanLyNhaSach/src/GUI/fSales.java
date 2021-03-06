/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.BillBLL;
import BLL.BillInfoBLL;
import BLL.BookBLL;
import BLL.CustomerBLL;
import BLL.StaffBLL;
import Utilties.ControlFormat;
import java.awt.Font;
import java.awt.print.PrinterException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author STIREN
 */
public class fSales extends javax.swing.JInternalFrame {

    /**
     * Creates new form fSales
     */
    Date Today = new Date();
    private int flag = 0;
    CustomerBLL customerBLL = new CustomerBLL();
    BookBLL bookBLL = new BookBLL();
    ControlFormat control = new ControlFormat();
    BillBLL billBLL = new BillBLL();
    BillInfoBLL billinfoBLL = new BillInfoBLL();
    StaffBLL staffBLL=new StaffBLL();
    public fSales() {
        initComponents();
        txaBill.setFont(new Font("Tahoma", Font.PLAIN, 10));
        txaBill.setVisible(false);
        btnSaveBill.setEnabled(false);
        btnSaveBillInfo.setEnabled(false);
        jDChBillDate.setDate(Today);
        jDChSearchBill.setDate(Today);
        jTableBill.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 14));
        jTableBillInfo.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 14));
        for(int i=1; i<=20; i++)
            cbAmountBillInfo.addItem(String.valueOf(i)); 
        
        txfIDStaffBill.setText("1");
        txfIDBookBillInfo.setEnabled(false);
        cbAmountBillInfo.setEnabled(false);
        txfIDCustomerBill.getDocument().addDocumentListener(new DocumentListener() {
            int IDCustomer;           
            @Override
            
            public void insertUpdate(DocumentEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                if(txfIDCustomerBill.getText().equals("") == false)
                    IDCustomer = Integer.parseInt(txfIDCustomerBill.getText());
                else IDCustomer = 0;
                txfNameCustomerBill.setText(customerBLL.getNameCustomerByID(IDCustomer));
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                
                if(txfIDCustomerBill.getText().equals("") == false)
                    IDCustomer = Integer.parseInt(txfIDCustomerBill.getText());
                else IDCustomer = 0;
                txfNameCustomerBill.setText(customerBLL.getNameCustomerByID(IDCustomer));
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                if(txfIDCustomerBill.getText().equals("") == false)
                    IDCustomer = Integer.parseInt(txfIDCustomerBill.getText());
                else IDCustomer = 0;
                txfNameCustomerBill.setText(customerBLL.getNameCustomerByID(IDCustomer));
            }
        });
        
        txfIDBookBillInfo.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent de) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                int IDBook;
                if(txfIDBookBillInfo.getText().equals("") == false)
                    IDBook = Integer.parseInt(txfIDBookBillInfo.getText());
                else IDBook = 0;
                txfNameBook.setText(bookBLL.getNameBook(IDBook));
            }

            @Override
            public void removeUpdate(DocumentEvent de) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                int IDBook;
                if(txfIDBookBillInfo.getText().equals("") == false)
                    IDBook = Integer.parseInt(txfIDBookBillInfo.getText());
                else IDBook = 0;
                txfNameBook.setText(bookBLL.getNameBook(IDBook));
            }

            @Override
            public void changedUpdate(DocumentEvent de) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                int IDBook;
                if(txfIDBookBillInfo.getText().equals("") == false)
                    IDBook = Integer.parseInt(txfIDBookBillInfo.getText());
                else IDBook = 0;
                txfNameBook.setText(bookBLL.getNameBook(IDBook));
            }
        });
    }
    public void setUserName(String namestaff){
         txfNameStaffBill.setText(namestaff);
    }

    public void setNameStaff(String namestaff){
         this.txfNameStaffBill.setText(namestaff);
         int id=staffBLL.getIDStaff(namestaff);
         String ID=String.valueOf(id);
         this.txfIDStaffBill.setText(ID);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    public void ClearTextBill()
    {
        txfIDBill.setText("");
        jDChBillDate.setDate(Today);
        txfIDCustomerBill.setText("");
        txfNameCustomerBill.setText("");
        
        txfVATBill.setText("");
        txfDiscountBill.setText("");
        txfTotalPriceBill.setText("");
        txfTotalPayBill.setText("");
    }
   //Thêm hóa đơn
    public void InsertBill()
    {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String BillDate = formatter.format(jDChBillDate.getDate());
        
        int IDCustomer;
        if(txfIDCustomerBill.getText().equals(""))
            IDCustomer = 0;
        else IDCustomer = Integer.parseInt(txfIDCustomerBill.getText());
        
        int IDStaff;
        if(txfIDStaffBill.getText().equals(""))
            IDStaff = 0;
        else IDStaff = Integer.parseInt(txfIDStaffBill.getText());
        
        if(customerBLL.TestIDCustomer(IDCustomer) == false)
            JOptionPane.showMessageDialog(this, "Mã khách hàng không tồn tại");
        else
        {
            if(billBLL.InsertBill(BillDate, IDCustomer, IDStaff))
            {
                JOptionPane.showMessageDialog(this, "Thêm thành công hóa đơn");
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Thêm thất bại hóa đơn");
            }
        }
    }
    //Cập nhật hóa đơn
    public void UpdateBill()
    {
        int IDBill = Integer.parseInt(txfIDBill.getText());
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String BillDate = formatter.format(jDChBillDate.getDate());
        
        int IDCustomer;
        if(txfIDCustomerBill.getText().equals(""))
            IDCustomer = 0;
        else IDCustomer = Integer.parseInt(txfIDCustomerBill.getText());
        
        int IDStaff;
        if(txfIDStaffBill.getText().equals(""))
            IDStaff = 0;
        else IDStaff = Integer.parseInt(txfIDStaffBill.getText());    
        
        if(customerBLL.TestIDCustomer(IDCustomer) == false)
            JOptionPane.showMessageDialog(this, "Mã khách hàng không tồn tại");
        else
        {
            if(billBLL.UpdateBill(IDBill, BillDate, IDCustomer, IDStaff))
            {
                JOptionPane.showMessageDialog(this, "Cập nhật thành công hóa đơn");
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Cập nhật thất bại hóa đơn");
            }
        }                               
    }
    //Cập nhật trạng thái hóa đơn sau khi thanh toán
    public void UpdateStatusBill()
    {       
        int IDBill = Integer.parseInt(txfIDBill.getText());
        billBLL.UpdateStatusBill(IDBill);
    }
    
    //Xóa dữ liệu trong ô nhập CTHD
    public void ClearTextBillInfo()
    {
        txfIDBookBillInfo.setText("");
        txfNameBook.setText("");
        txfPriceBookBillInfo.setText("");
        txfPriceBillInfo.setText("");
    }
    
    //Thêm CTHD
    public boolean InsertBillInfo()
    {
        int IDBill = Integer.parseInt(txfIDBill.getText());
        int IDBook;
        if(txfIDBookBillInfo.getText().equals(""))
            IDBook = 0;
        else 
            IDBook = Integer.parseInt(txfIDBookBillInfo.getText());
        int Amount = Integer.parseInt(cbAmountBillInfo.getSelectedItem().toString());
               
        if(txfIDBookBillInfo.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Mã sách bắt buộc có");
            return false;
        }       
        else
        {
            if(bookBLL.TestIDBook(IDBook) == false)
            {
                JOptionPane.showMessageDialog(this, "Mã sách không tồn tại");
                return false;
            }
            else
            {
                if(billinfoBLL.InsertBillInfo(IDBill, IDBook, Amount))
                {
                    //JOptionPane.showMessageDialog(this, "Thêm thành công chi tiết hóa đơn");
                    return true;
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "Thêm thất bại chi tiết hóa đơn");
                    return false;
                }
            }                       
        }
    }
    //Cập nhật CTHD
    public boolean UpdateBillInfo()
    {
        int IDBill = Integer.parseInt(txfIDBill.getText());
        int IDBook;
        if(txfIDBookBillInfo.getText().equals(""))
            IDBook = 0;
        else 
            IDBook = Integer.parseInt(txfIDBookBillInfo.getText());
        int Amount = Integer.parseInt(cbAmountBillInfo.getSelectedItem().toString());
        
        if(txfIDBookBillInfo.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Mã sách bắt buộc có");
            return false;
        }        
        else
        {
            if(billinfoBLL.UpdateBillInfo(IDBill, IDBook, Amount))
            {
                JOptionPane.showMessageDialog(this, "Cập nhật thành công chi tiết hóa đơn");
                return true;
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Cập nhật thất bại chi tiết hóa đơn");
                return false;
            }
        }
    }
    
    //Xóa CTHD
    public void DeleteBillInfo()
    {
        int IDBill = Integer.parseInt(txfIDBill.getText());            
        int IDBook = Integer.parseInt(txfIDBookBillInfo.getText());
        
        if(billinfoBLL.DeleteBillInfo(IDBill, IDBook))
        {
                JOptionPane.showMessageDialog(this, "Xóa thành công hóa đơn");
        }
        else
            JOptionPane.showMessageDialog(this, "Xóa thất bại");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txfIDCustomerBill = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txfNameCustomerBill = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txfTotalPriceBill = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txfTotalPayBill = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jDChBillDate = new com.toedter.calendar.JDateChooser();
        jLabel20 = new javax.swing.JLabel();
        txfVATBill = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txfDiscountBill = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txfNameStaffBill = new javax.swing.JTextField();
        txfIDBill = new javax.swing.JTextField();
        txfIDStaffBill = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        btnAddBill = new javax.swing.JButton();
        btnEditBill = new javax.swing.JButton();
        btnSaveBill = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txfPriceBillInfo = new javax.swing.JTextField();
        cbAmountBillInfo = new javax.swing.JComboBox<>();
        txfPriceBookBillInfo = new javax.swing.JTextField();
        txfNameBook = new javax.swing.JTextField();
        txfIDBookBillInfo = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        btnAddBillInfo = new javax.swing.JButton();
        btnEditBillInfo = new javax.swing.JButton();
        btnDelBillInfo = new javax.swing.JButton();
        btnSaveBillInfo = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        txaBill = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        btnPayBillInfo = new javax.swing.JButton();
        txfCashBillInfo = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txfRepayBillInfo = new javax.swing.JTextField();
        btnPrintBillInfo = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableBillInfo = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jDChSearchBill = new com.toedter.calendar.JDateChooser();
        btnSearchBill = new javax.swing.JButton();
        btnSearchBillInfo = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableBill = new javax.swing.JTable();
        lbSearch = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setClosable(true);

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 204));
        jLabel1.setText("HÓA ĐƠN");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(231, 11, 97, 25);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 204));
        jLabel2.setText("CHI TIẾT HÓA ĐƠN");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(534, 11, 193, 25);

        jPanel5.setOpaque(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 204));
        jLabel3.setText("Mã nhân viên");

        txfIDCustomerBill.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        txfIDCustomerBill.setName("txfIDCustomerBill"); // NOI18N
        txfIDCustomerBill.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfIDCustomerBillKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 204));
        jLabel4.setText("Mã khách hàng");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 204));
        jLabel15.setText("Tên khách hàng");

        txfNameCustomerBill.setEditable(false);
        txfNameCustomerBill.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 204));
        jLabel16.setText("Thuế VAT");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 204));
        jLabel17.setText("Trị giá");

        txfTotalPriceBill.setEditable(false);
        txfTotalPriceBill.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 0, 51));
        jLabel18.setText("Tổng tiền");

        txfTotalPayBill.setEditable(false);
        txfTotalPayBill.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 204));
        jLabel19.setText("Số hóa đơn");

        jDChBillDate.setDateFormatString("dd-MM-yyyy hh:mm");
        jDChBillDate.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 204));
        jLabel20.setText("Ngày hóa đơn");

        txfVATBill.setEditable(false);
        txfVATBill.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 0, 204));
        jLabel22.setText("Khuyến mãi");

        txfDiscountBill.setEditable(false);
        txfDiscountBill.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 0, 204));
        jLabel23.setText("Tên nhân viên");

        txfNameStaffBill.setEditable(false);
        txfNameStaffBill.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        txfIDBill.setEditable(false);
        txfIDBill.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        txfIDStaffBill.setEditable(false);
        txfIDStaffBill.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20)
                            .addComponent(jLabel4))
                        .addGap(52, 52, 52)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txfIDCustomerBill)
                            .addComponent(jDChBillDate, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                            .addComponent(txfIDBill)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel15)
                            .addComponent(jLabel23)
                            .addComponent(jLabel16)
                            .addComponent(jLabel22)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txfTotalPayBill)
                            .addComponent(txfTotalPriceBill)
                            .addComponent(txfDiscountBill)
                            .addComponent(txfVATBill)
                            .addComponent(txfNameStaffBill)
                            .addComponent(txfIDStaffBill)
                            .addComponent(txfNameCustomerBill))))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txfIDBill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jDChBillDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txfIDCustomerBill, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfNameCustomerBill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txfIDStaffBill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfNameStaffBill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txfVATBill, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txfDiscountBill, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfTotalPriceBill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txfTotalPayBill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        jPanel1.add(jPanel5);
        jPanel5.setBounds(10, 42, 430, 480);

        jPanel7.setOpaque(false);

        btnAddBill.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAddBill.setForeground(new java.awt.Color(0, 0, 204));
        btnAddBill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/add.png"))); // NOI18N
        btnAddBill.setText("THÊM");
        btnAddBill.setName("btnAddBill"); // NOI18N
        btnAddBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddBillActionPerformed(evt);
            }
        });

        btnEditBill.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEditBill.setForeground(new java.awt.Color(0, 0, 204));
        btnEditBill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/tools.png"))); // NOI18N
        btnEditBill.setText("CẬP NHẬT");
        btnEditBill.setName("btnEditBill"); // NOI18N
        btnEditBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditBillActionPerformed(evt);
            }
        });

        btnSaveBill.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSaveBill.setForeground(new java.awt.Color(0, 0, 204));
        btnSaveBill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/folder.png"))); // NOI18N
        btnSaveBill.setText("LƯU");
        btnSaveBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveBillActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAddBill, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEditBill)
                .addGap(18, 18, 18)
                .addComponent(btnSaveBill, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddBill, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnEditBill, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(btnSaveBill)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel7);
        jPanel7.setBounds(20, 550, 440, 41);

        jPanel3.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel3.setOpaque(false);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 204));
        jLabel6.setText("Mã sách");

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 0, 204));
        jLabel26.setText("Tên sách");

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 0, 204));
        jLabel24.setText("Giá bán");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 204));
        jLabel7.setText("Số lượng");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 204));
        jLabel8.setText("Thành tiền");

        txfPriceBillInfo.setEditable(false);
        txfPriceBillInfo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txfPriceBillInfo.setText("0");
        txfPriceBillInfo.setName("txfPriceBillInfo"); // NOI18N

        cbAmountBillInfo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbAmountBillInfo.setName("cbAmountBillInfo"); // NOI18N

        txfPriceBookBillInfo.setEditable(false);
        txfPriceBookBillInfo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txfNameBook.setEditable(false);
        txfNameBook.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txfIDBookBillInfo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txfIDBookBillInfo.setName("txfIDBookBillInfo"); // NOI18N
        txfIDBookBillInfo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfIDBookBillInfoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel26)
                    .addComponent(jLabel24)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txfNameBook, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfPriceBillInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbAmountBillInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfPriceBookBillInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfIDBookBillInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txfIDBookBillInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(txfNameBook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24)
                    .addComponent(txfPriceBookBillInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cbAmountBillInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txfPriceBillInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(517, 42, 341, 227);

        jPanel8.setOpaque(false);

        btnAddBillInfo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAddBillInfo.setForeground(new java.awt.Color(0, 0, 204));
        btnAddBillInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/add.png"))); // NOI18N
        btnAddBillInfo.setText("THÊM");
        btnAddBillInfo.setName("btnAddBillInfo"); // NOI18N
        btnAddBillInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddBillInfoActionPerformed(evt);
            }
        });

        btnEditBillInfo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEditBillInfo.setForeground(new java.awt.Color(0, 0, 204));
        btnEditBillInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/tools.png"))); // NOI18N
        btnEditBillInfo.setText("CẬP NHẬT");
        btnEditBillInfo.setName("btnEditBillInfo"); // NOI18N
        btnEditBillInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditBillInfoActionPerformed(evt);
            }
        });

        btnDelBillInfo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDelBillInfo.setForeground(new java.awt.Color(0, 0, 204));
        btnDelBillInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/rubbish-bin.png"))); // NOI18N
        btnDelBillInfo.setText("XÓA");
        btnDelBillInfo.setName("btnDelIfoBill"); // NOI18N
        btnDelBillInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelBillInfoActionPerformed(evt);
            }
        });

        btnSaveBillInfo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSaveBillInfo.setForeground(new java.awt.Color(0, 0, 204));
        btnSaveBillInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/folder.png"))); // NOI18N
        btnSaveBillInfo.setText("LƯU");
        btnSaveBillInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveBillInfoActionPerformed(evt);
            }
        });

        jScrollPane4.setOpaque(false);

        txaBill.setColumns(20);
        txaBill.setRows(5);
        jScrollPane4.setViewportView(txaBill);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAddBillInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(btnEditBillInfo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDelBillInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSaveBillInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSaveBillInfo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDelBillInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnEditBillInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAddBillInfo)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jPanel8);
        jPanel8.setBounds(505, 287, 540, 60);

        jPanel4.setOpaque(false);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 204));
        jLabel11.setText("Tiền mặt thanh toán");
        jLabel11.setName(""); // NOI18N

        btnPayBillInfo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnPayBillInfo.setForeground(new java.awt.Color(255, 0, 0));
        btnPayBillInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/clipboard_edit.png"))); // NOI18N
        btnPayBillInfo.setText("THANH TOÁN");
        btnPayBillInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPayBillInfoActionPerformed(evt);
            }
        });

        txfCashBillInfo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txfCashBillInfo.setName("txfCashBillInfo"); // NOI18N

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 204));
        jLabel12.setText("Tiền trả lại");

        txfRepayBillInfo.setEditable(false);
        txfRepayBillInfo.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        txfRepayBillInfo.setName("txfRepayBillInfo"); // NOI18N

        btnPrintBillInfo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnPrintBillInfo.setForeground(new java.awt.Color(255, 0, 0));
        btnPrintBillInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/print.png"))); // NOI18N
        btnPrintBillInfo.setText("IN HÓA ĐƠN");
        btnPrintBillInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintBillInfoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(btnPayBillInfo))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txfCashBillInfo, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                            .addComponent(txfRepayBillInfo))
                        .addContainerGap())
                    .addComponent(btnPrintBillInfo, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txfCashBillInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnPayBillInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(btnPrintBillInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txfRepayBillInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4);
        jPanel4.setBounds(912, 52, 364, 131);

        jTableBillInfo.setBorder(new javax.swing.border.MatteBorder(null));
        jTableBillInfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã sách", "Tên sách", "Giá", "Số lượng", "Thành tiền"
            }
        ));
        jTableBillInfo.setName("jTableBillInfo"); // NOI18N
        jTableBillInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableBillInfoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableBillInfo);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(510, 370, 751, 240);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/anhbia7.jpg"))); // NOI18N
        jPanel1.add(jLabel10);
        jLabel10.setBounds(0, -10, 1420, 690);

        jTabbedPane1.addTab("Hóa đơn", jPanel1);

        jPanel6.setLayout(null);

        jPanel9.setOpaque(false);

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 0, 204));
        jLabel21.setText("Tìm hóa đơn theo ngày");

        jDChSearchBill.setDateFormatString("dd-MM-yyyy");
        jDChSearchBill.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        btnSearchBill.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSearchBill.setForeground(new java.awt.Color(0, 51, 204));
        btnSearchBill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/search.png"))); // NOI18N
        btnSearchBill.setText("TÌM KIẾM");
        btnSearchBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchBillActionPerformed(evt);
            }
        });

        btnSearchBillInfo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSearchBillInfo.setForeground(new java.awt.Color(0, 51, 204));
        btnSearchBillInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/search.png"))); // NOI18N
        btnSearchBillInfo.setText("TÌM KIẾM");
        btnSearchBillInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchBillInfoActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 51, 204));
        jLabel5.setText("Tra cứu hóa đơn");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 51, 204));
        jLabel9.setText("Tra cứu chi tiết hóa đơn");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jDChSearchBill, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(104, 104, 104)
                        .addComponent(btnSearchBill)))
                .addGap(115, 115, 115)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSearchBillInfo, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(20, 20, 20))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jDChSearchBill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel5))
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(btnSearchBill, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSearchBillInfo)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(11, 11, 11))))
        );

        jPanel6.add(jPanel9);
        jPanel9.setBounds(36, 39, 720, 87);

        jTableBill.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Số hóa đơn", "Mã nhân viên", "Mã khách hàng", "Ngày hóa đơn", "Title 5", "Title 6", "Title 7"
            }
        ));
        jTableBill.setName("jTableBill"); // NOI18N
        jScrollPane1.setViewportView(jTableBill);

        jPanel6.add(jScrollPane1);
        jScrollPane1.setBounds(47, 200, 1240, 380);

        lbSearch.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        lbSearch.setForeground(new java.awt.Color(0, 51, 204));
        lbSearch.setText("TRA CỨU HÓA ĐƠN");
        jPanel6.add(lbSearch);
        lbSearch.setBounds(471, 155, 740, 37);

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/anhbia7.jpg"))); // NOI18N
        jPanel6.add(jLabel13);
        jLabel13.setBounds(0, 0, 1410, 710);

        jTabbedPane1.addTab("Tra cứu hóa đơn", jPanel6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1404, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTableBillInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableBillInfoMouseClicked
        // TODO add your handling code here:
        txfIDBookBillInfo.setEnabled(false);
        cbAmountBillInfo.setEnabled(false);
        int row = jTableBillInfo.getSelectedRow();
        txfIDBookBillInfo.setText(jTableBillInfo.getValueAt(row, 1).toString());
        txfNameBook.setText(jTableBillInfo.getValueAt(row, 2).toString());
        txfPriceBookBillInfo.setText(jTableBillInfo.getValueAt(row, 3).toString());
        cbAmountBillInfo.setSelectedItem(jTableBillInfo.getValueAt(row, 4).toString());
        txfPriceBillInfo.setText(jTableBillInfo.getValueAt(row, 5).toString());
    }//GEN-LAST:event_jTableBillInfoMouseClicked

    private void btnPrintBillInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintBillInfoActionPerformed
        txaBill.setText("");
        txaBill.append("\t \t  NHÀ SÁCH TYQ \n \n");
        txaBill.append("Địa chỉ: Khu phố 6, P.Linh Trung, Q.Thủ Đức, TP.Hồ Chí Minh. \n" +
            "SĐT: 0962 111 222 \n" +
            "Email: nhasachTYQ@gmail.com \n \n");
        txaBill.append("\t \t HÓA ĐƠN THANH TOÁN \n \n");

        int idbill = Integer.parseInt(txfIDBill.getText());

        if(billBLL.getIDCustomerByIDBill(idbill) == 0)
        txaBill.append("Mã khách hàng: \n");
        else
        txaBill.append("Mã khách hàng: " + billBLL.getIDCustomerByIDBill(idbill) + "\n");
        txaBill.append("Nhân viên thu ngân: " + billBLL.getNameStaffByIDBill(idbill) + "\n");
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy hh:mm");
        txaBill.append("Ngày hóa đơn: " + df.format(jDChBillDate.getDate()) + "\n");
        //txaBill.append("Ngày hóa đơn: " + billBLL.getDateBillByIDBill(idbill) + "\n");
        txaBill.append("Số hóa đơn: " + idbill + "\n \n");
        txaBill.append("--------------------------------------------------------------------------------------------------------------------------------\n");
        txaBill.append("Mã sách \t Tên sách \t\t Giá bán \t Số lượng \t Thành tiền \n");
        txaBill.append("--------------------------------------------------------------------------------------------------------------------------------\n");

        control.bindingBillInfo(jTableBillInfo, billinfoBLL.LoadBillInfo(idbill));
        int row = jTableBillInfo.getRowCount();
        int column = jTableBillInfo.getColumnCount();
        for(int i=0; i < row; i++)
        {
            for(int j=1; j < column; j++)
            {
                txaBill.append(jTableBillInfo.getValueAt(i, j).toString() + "\t");
                if(j == 2)
                txaBill.append("\t");
            }
            txaBill.append("\n");
        }
        txaBill.append("--------------------------------------------------------------------------------------------------------------------------------\n");
        txaBill.append("\nTrị giá: " + txfTotalPriceBill.getText() + "\n" +
            "Chiết khấu: " + txfDiscountBill.getText() + "\n" +
            "VAT: " + txfVATBill.getText() + "\n" +
            "Tổng tiền: " + txfTotalPayBill.getText() + "\n" +
            "Tiền mặt thanh toán: " + txfCashBillInfo.getText() + "\n" +
            "Tiền trả lại khách: " + txfRepayBillInfo.getText() + "\n \n" +
            "Cám ơn và hẹn gặp lại quý khách!");
        try {
            txaBill.print();
        } catch (PrinterException ex) {
            Logger.getLogger(fSales.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPrintBillInfoActionPerformed

    private void btnPayBillInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPayBillInfoActionPerformed
        // TODO add your handling code here:
        int idbill = Integer.parseInt(txfIDBill.getText());
        //control.bindingBillInfo(jTableBillInfo, billinfoBLL.LoadBillInfo(idbill));
        if(billBLL.getStatusBill(idbill).equals("Đã thanh toán"))
        JOptionPane.showMessageDialog(this, "Hóa đơn này đã thanh toán");
        else{
            if(txfCashBillInfo.getText().equals(""))
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tiền mặt khách trả");
            else{
                float Repay = Float.parseFloat(txfCashBillInfo.getText()) - Float.parseFloat(txfTotalPayBill.getText());
                if(Repay < 0)
                JOptionPane.showMessageDialog(this, "Không đủ tiền trả");
                else
                {
                    txfRepayBillInfo.setText(String.valueOf(Repay));
                    UpdateStatusBill();
                }
            }
        }
    }//GEN-LAST:event_btnPayBillInfoActionPerformed

    private void btnSaveBillInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveBillInfoActionPerformed
        // TODO add your handling code here:
        if(flag == 4)
        {
            if(InsertBillInfo())
            {
                txfIDBookBillInfo.setEnabled(false);
                cbAmountBillInfo.setEnabled(false);
                btnAddBillInfo.setEnabled(true);
                btnDelBillInfo.setEnabled(true);
                btnEditBillInfo.setEnabled(true);
                btnSaveBillInfo.setEnabled(false);
                int idbill = Integer.parseInt(txfIDBill.getText());
                control.bindingBillInfo(jTableBillInfo, billinfoBLL.LoadBillInfo(idbill));
                //Xét lại các giá trị của hóa đơn khi thêm CTHD
                txfTotalPayBill.setText(String.valueOf(billBLL.getTotalPayByIDBill(idbill)));
                txfDiscountBill.setText(String.valueOf(billBLL.getDiscountByIDBill(idbill)));
                txfTotalPriceBill.setText(String.valueOf(billBLL.getTotalPriceByIDBill(idbill)));
                ClearTextBillInfo();
            }
        }
        if(flag == 5)
        {
            if(UpdateBillInfo())
            {
                txfIDBookBillInfo.setEnabled(false);
                cbAmountBillInfo.setEnabled(false);
                btnAddBillInfo.setEnabled(true);
                btnDelBillInfo.setEnabled(true);
                btnEditBillInfo.setEnabled(true);
                btnSaveBillInfo.setEnabled(false);
                int idbill = Integer.parseInt(txfIDBill.getText());
                control.bindingBillInfo(jTableBillInfo, billinfoBLL.LoadBillInfo(idbill));
                //Xét lại các giá trị của hóa đơn khi sửa CTHD
                txfTotalPayBill.setText(String.valueOf(billBLL.getTotalPayByIDBill(idbill)));
                txfDiscountBill.setText(String.valueOf(billBLL.getDiscountByIDBill(idbill)));
                txfTotalPriceBill.setText(String.valueOf(billBLL.getTotalPriceByIDBill(idbill)));
                ClearTextBillInfo();
            }
        }
        if(flag == 6)
        {
            txfIDBookBillInfo.setEnabled(false);
            cbAmountBillInfo.setEnabled(false);
            DeleteBillInfo();
            btnAddBillInfo.setEnabled(true);
            btnDelBillInfo.setEnabled(true);
            btnEditBillInfo.setEnabled(true);
            btnSaveBillInfo.setEnabled(false);
            int idbill = Integer.parseInt(txfIDBill.getText());
            control.bindingBillInfo(jTableBillInfo, billinfoBLL.LoadBillInfo(idbill));
            //Xét lại các giá trị của hóa đơn khi sửa CTHD
            txfTotalPayBill.setText(String.valueOf(billBLL.getTotalPayByIDBill(idbill)));
            txfDiscountBill.setText(String.valueOf(billBLL.getDiscountByIDBill(idbill)));
            txfTotalPriceBill.setText(String.valueOf(billBLL.getTotalPriceByIDBill(idbill)));
            ClearTextBillInfo();
        }
    }//GEN-LAST:event_btnSaveBillInfoActionPerformed

    private void btnDelBillInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelBillInfoActionPerformed
        // TODO add your handling code here:
        txfIDBookBillInfo.setEnabled(true);
        cbAmountBillInfo.setEnabled(true);
        int IDBill = Integer.parseInt(txfIDBill.getText());
        if (billBLL.getStatusBill(IDBill).equals("Đã thanh toán"))
        JOptionPane.showMessageDialog(this, "Không được xóa khi hóa đơn đã thanh toán");
        else{
            btnAddBillInfo.setEnabled(false);
            btnDelBillInfo.setEnabled(false);
            btnEditBillInfo.setEnabled(false);
            btnSaveBillInfo.setEnabled(true);
            flag = 6;
        }
    }//GEN-LAST:event_btnDelBillInfoActionPerformed

    private void btnEditBillInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditBillInfoActionPerformed
        // TODO add your handling code here:
        int IDBill = Integer.parseInt(txfIDBill.getText());
        if (billBLL.getStatusBill(IDBill).equals("Đã thanh toán"))
        JOptionPane.showMessageDialog(this, "Không được cập nhật khi hóa đơn đã thanh toán");
        else{
            btnAddBillInfo.setEnabled(false);
            btnDelBillInfo.setEnabled(false);
            btnEditBillInfo.setEnabled(false);
            btnSaveBillInfo.setEnabled(true);
            flag = 5;
        }
    }//GEN-LAST:event_btnEditBillInfoActionPerformed

    private void btnAddBillInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddBillInfoActionPerformed
        // TODO add your handling code here:
        txfIDBookBillInfo.setEnabled(true);
        cbAmountBillInfo.setEnabled(true);
        txfIDBookBillInfo.setEnabled(true);
        cbAmountBillInfo.setEnabled(true);
        ClearTextBillInfo();
        int IDBill = Integer.parseInt(txfIDBill.getText());
        if (billBLL.getStatusBill(IDBill).equals("Đã thanh toán"))
        JOptionPane.showMessageDialog(this, "Không được thêm khi hóa đơn đã thanh toán");
        else{
            btnAddBillInfo.setEnabled(false);
            btnDelBillInfo.setEnabled(false);
            btnEditBillInfo.setEnabled(false);
            btnSaveBillInfo.setEnabled(true);
            flag = 4;
        }
    }//GEN-LAST:event_btnAddBillInfoActionPerformed

    private void txfIDBookBillInfoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfIDBookBillInfoKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (((c < '0') || (c > '9')) || txfIDBookBillInfo.getText().length() >= 10)
        evt.consume();
    }//GEN-LAST:event_txfIDBookBillInfoKeyTyped

    private void btnSaveBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveBillActionPerformed
        // TODO add your handling code here:
        int IDCustomer;
        if(txfIDCustomerBill.getText().equals(""))
        IDCustomer = 0;
        else IDCustomer = Integer.parseInt(txfIDCustomerBill.getText());

        if(flag == 1)
        {
            InsertBill();
            btnAddBill.setEnabled(true);
            btnEditBill.setEnabled(true);
            btnSaveBill.setEnabled(false);
            txfIDBill.setText(String.valueOf(billBLL.getMaxIDBill()));
            txfNameCustomerBill.setText(customerBLL.getNameCustomerByID(IDCustomer));
            int IDBill;
            if(txfIDBill.getText().equals(""))
            IDBill = 0;
            else IDBill = Integer.parseInt(txfIDBill.getText());
            txfVATBill.setText(String.valueOf(billBLL.getVATByIDBill(IDBill)));

            jDChBillDate.setDate(new Date());
        }
        if(flag == 2)
        {
            UpdateBill();
            btnAddBill.setEnabled(true);
            btnEditBill.setEnabled(true);
            btnSaveBill.setEnabled(false);
            txfNameCustomerBill.setText(customerBLL.getNameCustomerByID(IDCustomer));
        }
    }//GEN-LAST:event_btnSaveBillActionPerformed

    private void btnEditBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditBillActionPerformed
        // TODO add your handling code here:
        int IDBill = Integer.parseInt(txfIDBill.getText());
        if(billBLL.getStatusBill(IDBill).equals("Đã thanh toán"))
        JOptionPane.showMessageDialog(this, "Không được cập nhật hóa đơn đã thanh toán");
        else{
            btnAddBill.setEnabled(false);
            btnEditBill.setEnabled(false);
            btnSaveBill.setEnabled(true);
            flag = 2;
        }
    }//GEN-LAST:event_btnEditBillActionPerformed

    private void btnAddBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddBillActionPerformed
        // TODO add your handling code here:
        ClearTextBill();
        btnAddBill.setEnabled(false);
        btnEditBill.setEnabled(false);
        btnSaveBill.setEnabled(true);
        flag=1;
    }//GEN-LAST:event_btnAddBillActionPerformed

    private void txfIDCustomerBillKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfIDCustomerBillKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (((c < '0') || (c > '9')) || txfIDCustomerBill.getText().length() >= 10)
        evt.consume();
    }//GEN-LAST:event_txfIDCustomerBillKeyTyped

    private void btnSearchBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchBillActionPerformed
        // TODO add your handling code here:
        lbSearch.setText("TRA CỨU HÓA ĐƠN");
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date search = jDChSearchBill.getDate();
        String key;
        if(jDChSearchBill.getDate() == null)
        key = "";
        else
        key = formatter.format(search);
        control.bindingBill(jTableBill, billBLL.SearchBill(key));
        jDChSearchBill.setDate(new Date());
    }//GEN-LAST:event_btnSearchBillActionPerformed

    private void btnSearchBillInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchBillInfoActionPerformed
        // TODO add your handling code here:
        lbSearch.setText("TRA CỨU CHI TIẾT HÓA ĐƠN");
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date search = jDChSearchBill.getDate();
        String key;
        if(jDChSearchBill.getDate() == null)
        key = "";
        else
        key = formatter.format(search);
        control.bindingBillInfo(jTableBill, billinfoBLL.SearchBillInfo(key));
        jDChSearchBill.setDate(new Date());
    }//GEN-LAST:event_btnSearchBillInfoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddBill;
    private javax.swing.JButton btnAddBillInfo;
    private javax.swing.JButton btnDelBillInfo;
    private javax.swing.JButton btnEditBill;
    private javax.swing.JButton btnEditBillInfo;
    private javax.swing.JButton btnPayBillInfo;
    private javax.swing.JButton btnPrintBillInfo;
    private javax.swing.JButton btnSaveBill;
    private javax.swing.JButton btnSaveBillInfo;
    private javax.swing.JButton btnSearchBill;
    private javax.swing.JButton btnSearchBillInfo;
    private javax.swing.JComboBox<String> cbAmountBillInfo;
    private com.toedter.calendar.JDateChooser jDChBillDate;
    private com.toedter.calendar.JDateChooser jDChSearchBill;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableBill;
    private javax.swing.JTable jTableBillInfo;
    private javax.swing.JLabel lbSearch;
    private javax.swing.JTextArea txaBill;
    private javax.swing.JTextField txfCashBillInfo;
    private javax.swing.JTextField txfDiscountBill;
    private javax.swing.JTextField txfIDBill;
    private javax.swing.JTextField txfIDBookBillInfo;
    private javax.swing.JTextField txfIDCustomerBill;
    private javax.swing.JTextField txfIDStaffBill;
    private javax.swing.JTextField txfNameBook;
    private javax.swing.JTextField txfNameCustomerBill;
    private javax.swing.JTextField txfNameStaffBill;
    private javax.swing.JTextField txfPriceBillInfo;
    private javax.swing.JTextField txfPriceBookBillInfo;
    private javax.swing.JTextField txfRepayBillInfo;
    private javax.swing.JTextField txfTotalPayBill;
    private javax.swing.JTextField txfTotalPriceBill;
    private javax.swing.JTextField txfVATBill;
    // End of variables declaration//GEN-END:variables
}
