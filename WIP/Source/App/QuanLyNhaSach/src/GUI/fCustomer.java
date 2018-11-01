/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.CustomerBLL;
import Utilties.ControlFormat;
import java.text.DateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
/**
 *
 * @author STIREN
 */
public class fCustomer extends javax.swing.JInternalFrame {

    /**
     * Creates new form fCustomer
     */
    int flag = 0;
    ControlFormat control = new ControlFormat();
    CustomerBLL customerBLL = new CustomerBLL();
    
    public fCustomer() {
        initComponents();
        control.BindingCustomer(jTableCustomer, customerBLL.LoadCustomer());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txfIDCustomer = new javax.swing.JTextField();
        txfNameCustomer = new javax.swing.JTextField();
        txfAddressCustomer = new javax.swing.JTextField();
        txfPhoneCustomer = new javax.swing.JTextField();
        jDChBirthdayCustomer = new com.toedter.calendar.JDateChooser();
        txfTurnoverCustomer = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jDChRegisDateCustomer = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        txfSearchCustomer = new javax.swing.JTextField();
        btnSearchCustomer = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnAddCustomer = new javax.swing.JButton();
        btnEditCustomer = new javax.swing.JButton();
        btnSaveCustomer = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCustomer = new javax.swing.JTable();

        setClosable(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel1.setText("QUẢN LÝ KHÁCH HÀNG");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel2.setText("Mã khách hàng");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel3.setText("Tên khách hàng");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel4.setText("Địa chỉ");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel5.setText("Số điện thoại");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel6.setText("Ngày sinh");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel7.setText("Doanh số");

        txfIDCustomer.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        txfNameCustomer.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        txfAddressCustomer.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        txfPhoneCustomer.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        jDChBirthdayCustomer.setDateFormatString("dd-MM-yyyy");
        jDChBirthdayCustomer.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        txfTurnoverCustomer.setEditable(false);
        txfTurnoverCustomer.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel8.setText("Ngày đăng kí");

        jDChRegisDateCustomer.setDateFormatString("dd-MM-yyyy");
        jDChRegisDateCustomer.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txfNameCustomer)
                    .addComponent(txfIDCustomer)
                    .addComponent(txfAddressCustomer)
                    .addComponent(txfPhoneCustomer)
                    .addComponent(jDChBirthdayCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                    .addComponent(txfTurnoverCustomer)
                    .addComponent(jDChRegisDateCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txfIDCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txfNameCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txfAddressCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txfPhoneCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6))
                    .addComponent(jDChBirthdayCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jDChRegisDateCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 3, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfTurnoverCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(37, 37, 37))
        );

        txfSearchCustomer.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        btnSearchCustomer.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        btnSearchCustomer.setText("Tìm kiếm");
        btnSearchCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchCustomerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txfSearchCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(btnSearchCustomer)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfSearchCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchCustomer))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnAddCustomer.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        btnAddCustomer.setText("THÊM");
        btnAddCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCustomerActionPerformed(evt);
            }
        });

        btnEditCustomer.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        btnEditCustomer.setText("CẬP NHẬT");
        btnEditCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditCustomerActionPerformed(evt);
            }
        });

        btnSaveCustomer.setText("LƯU");
        btnSaveCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveCustomerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(btnAddCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btnEditCustomer)
                .addGap(29, 29, 29)
                .addComponent(btnSaveCustomer)
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddCustomer)
                    .addComponent(btnEditCustomer)
                    .addComponent(btnSaveCustomer))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTableCustomer.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jTableCustomer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã khách hàng", "Tên khách hàng", "Địa chỉ", "Số điện thoại", "Ngày sinh", "Ngày đăng kí", "Doanh số"
            }
        ));
        jTableCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableCustomerMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableCustomer);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(345, 345, 345)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(53, 53, 53))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 122, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //METHODS
    public void ClearTextCustomer()
    {
        txfIDCustomer.setText("");
        txfNameCustomer.setText("");
        txfAddressCustomer.setText("");
        txfPhoneCustomer.setText("");
        jDChBirthdayCustomer.setDate(null);
        jDChRegisDateCustomer.setDate(null);
    }
    
    
    //Thêm khách hàng
    public boolean InsertCustomer()
    {        
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        
        String NameCustomer = txfNameCustomer.getText();
        String AddressCustomer = txfAddressCustomer.getText();
        String PhoneCustomer = txfPhoneCustomer.getText();

        String strBirthdayCustomer = formatter.format(jDChBirthdayCustomer.getDate());
        String strRegisDateCustomer = formatter.format(jDChRegisDateCustomer.getDate());
        
        if(NameCustomer.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Tên khách hàng bắt buộc phải có");
            return false;
        }
        else if(AddressCustomer.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Địa chỉ khách hàng bắt buộc phải có");
            return false;
        }
            
        else
        {
        
            if(customerBLL.InsertCustomer(NameCustomer, AddressCustomer, PhoneCustomer, strBirthdayCustomer, strRegisDateCustomer))
            {
                JOptionPane.showMessageDialog(this, "Thêm thành công khách hàng");
                return true;
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Thêm thất bại khách hàng!");
                return false;
            }
            
        }
    }
    
    //Cập nhật khách hàng
    public boolean UpdateCustomer()
    {        
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        
        int IDCustomer = Integer.parseInt(txfIDCustomer.getText());
        String NameCustomer = txfNameCustomer.getText();
        String AddressCustomer = txfAddressCustomer.getText();
        String PhoneCustomer = txfPhoneCustomer.getText();

        String strBirthdayCustomer = formatter.format(jDChBirthdayCustomer.getDate());
        String strRegisDateCustomer = formatter.format(jDChRegisDateCustomer.getDate());
        
        if(NameCustomer.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Tên khách hàng bắt buộc phải có");
            return false;
        }
        else if(AddressCustomer.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Địa chỉ khách hàng bắt buộc phải có");
            return false;
        }
            
        else
        {
        
            if(customerBLL.UpdateCustomer(IDCustomer, NameCustomer, AddressCustomer, PhoneCustomer, strBirthdayCustomer, strRegisDateCustomer))
            {
                JOptionPane.showMessageDialog(this, "Cập nhật thành công khách hàng");
                return true;
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Cập nhật thất bại khách hàng!");
                return false;
            }
            
        }
    }
    
    //EVENTS
    
    private void btnEditCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditCustomerActionPerformed
        // TODO add your handling code here:
        btnAddCustomer.setEnabled(false);
        btnEditCustomer.setEnabled(false);
        btnSaveCustomer.setEnabled(true);
        flag=2;
    }//GEN-LAST:event_btnEditCustomerActionPerformed

    private void btnAddCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCustomerActionPerformed
        // TODO add your handling code here:
        ClearTextCustomer();
        btnAddCustomer.setEnabled(false);
        btnEditCustomer.setEnabled(false);
        btnSaveCustomer.setEnabled(true);
        flag = 4;
    }//GEN-LAST:event_btnAddCustomerActionPerformed

    private void btnSaveCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveCustomerActionPerformed
        // TODO add your handling code here:
        if(flag==4)
        {
            if(InsertCustomer() == true)
            {
            btnAddCustomer.setEnabled(true);
            btnEditCustomer.setEnabled(true);
            btnSaveCustomer.setEnabled(false);
            control.BindingCustomer(jTableCustomer, customerBLL.LoadCustomer());
            ClearTextCustomer();
            }
        }
        
        if(flag==2)
        {
            if(UpdateCustomer() == true)
            {
            btnAddCustomer.setEnabled(true);
            btnEditCustomer.setEnabled(true);
            btnSaveCustomer.setEnabled(false);
            control.BindingCustomer(jTableCustomer, customerBLL.LoadCustomer());
            ClearTextCustomer();
            }
        }
    }//GEN-LAST:event_btnSaveCustomerActionPerformed

    private void btnSearchCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchCustomerActionPerformed
        // TODO add your handling code here:
        String key = txfSearchCustomer.getText();
        control.BindingCustomer(jTableCustomer, customerBLL.SearchCustomer(key));
        txfSearchCustomer.setText("");
    }//GEN-LAST:event_btnSearchCustomerActionPerformed

    private void jTableCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableCustomerMouseClicked
        // TODO add your handling code here:
        int row = jTableCustomer.getSelectedRow();
        txfIDCustomer.setText(jTableCustomer.getValueAt(row, 0).toString());
        txfNameCustomer.setText(jTableCustomer.getValueAt(row, 1).toString());
        txfAddressCustomer.setText(jTableCustomer.getValueAt(row, 2).toString());
        txfPhoneCustomer.setText(jTableCustomer.getValueAt(row, 3).toString());
        jDChBirthdayCustomer.setDate((Date) jTableCustomer.getModel().getValueAt(row, 4));
        jDChRegisDateCustomer.setDate((Date) jTableCustomer.getModel().getValueAt(row, 5));
        txfTurnoverCustomer.setText(jTableCustomer.getValueAt(row, 6).toString());
    }//GEN-LAST:event_jTableCustomerMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddCustomer;
    private javax.swing.JButton btnEditCustomer;
    private javax.swing.JButton btnSaveCustomer;
    private javax.swing.JButton btnSearchCustomer;
    private com.toedter.calendar.JDateChooser jDChBirthdayCustomer;
    private com.toedter.calendar.JDateChooser jDChRegisDateCustomer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableCustomer;
    private javax.swing.JTextField txfAddressCustomer;
    private javax.swing.JTextField txfIDCustomer;
    private javax.swing.JTextField txfNameCustomer;
    private javax.swing.JTextField txfPhoneCustomer;
    private javax.swing.JTextField txfSearchCustomer;
    private javax.swing.JTextField txfTurnoverCustomer;
    // End of variables declaration//GEN-END:variables
}
