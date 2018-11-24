/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import  Entity.*;
import DAL.*;
import  BLL.*;
import Utilties.*;
import java.*;
import java.awt.Toolkit;
//import java.awt.font.GlyphVector;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import GUI.fManagement;
/**
 *
 * @author STIREN
 */
public class fDiscount extends javax.swing.JInternalFrame {

    /**
     * Creates new form fDiscount
     */
    ControlFormat control=new ControlFormat();
    DiscountBLL discountBLL=new DiscountBLL();
    private int flag=0;
    public fDiscount() {
        initComponents(); 
        control.bindingDiscount(jTableDiscount, discountBLL.LoadDiscount());
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
        txfIDDiscount = new java.awt.TextField();
        txfNameDiscount = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jDChStartDiscount = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jDChFinishDiscount = new com.toedter.calendar.JDateChooser();
        txfMinMoneyDiscount = new javax.swing.JTextField();
        txfDiscount = new javax.swing.JTextField();
        btnAddDiscount = new javax.swing.JButton();
        btnEditDiscount = new javax.swing.JButton();
        btnDelDiscount = new javax.swing.JButton();
        btnSaveDiscount = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDiscount = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();

        setClosable(true);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel1.setText("QUẢN LÝ KHUYẾN MÃI");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(352, 42, 343, 37);

        jPanel1.setOpaque(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Mã khuyến mãi");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Tên khuyến mãi");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Hệ số khuyến mãi (%)");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Mức tiền hưởng khuyến mãi");

        txfIDDiscount.setEditable(false);
        txfIDDiscount.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N

        txfNameDiscount.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Thời hạn áp dụng khuyến mãi");

        jDChStartDiscount.setDateFormatString("dd-MM-yyyy");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("- Ngày bắt đầu");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("- Ngày kết thúc");

        jDChFinishDiscount.setDateFormatString("dd-MM-yyyy");

        txfMinMoneyDiscount.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        txfDiscount.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7)))
                            .addComponent(jLabel4)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txfIDDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDChStartDiscount, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                            .addComponent(txfMinMoneyDiscount)
                            .addComponent(txfDiscount)
                            .addComponent(txfNameDiscount)
                            .addComponent(jDChFinishDiscount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txfIDDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(txfNameDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txfDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfMinMoneyDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jLabel6)
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jDChStartDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jDChFinishDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 120, 540, 357);

        btnAddDiscount.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAddDiscount.setText("THÊM");
        btnAddDiscount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddDiscountActionPerformed(evt);
            }
        });
        getContentPane().add(btnAddDiscount);
        btnAddDiscount.setBounds(10, 490, 110, 30);

        btnEditDiscount.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEditDiscount.setText("CẬP NHẬT");
        btnEditDiscount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditDiscountActionPerformed(evt);
            }
        });
        getContentPane().add(btnEditDiscount);
        btnEditDiscount.setBounds(170, 490, 110, 30);

        btnDelDiscount.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDelDiscount.setText("XÓA");
        btnDelDiscount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelDiscountActionPerformed(evt);
            }
        });
        getContentPane().add(btnDelDiscount);
        btnDelDiscount.setBounds(330, 490, 110, 30);

        btnSaveDiscount.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSaveDiscount.setText("LƯU");
        btnSaveDiscount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveDiscountActionPerformed(evt);
            }
        });
        getContentPane().add(btnSaveDiscount);
        btnSaveDiscount.setBounds(480, 490, 110, 30);

        jTableDiscount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTableDiscount.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã khuyến mãi", "Tên khuyến mãi", "Hệ số khuyến mãi", "Tổng tiền tối thiểu được hưởng khuyến mãi", "Ngày bắt đầu", "Ngày kết thúc"
            }
        ));
        jTableDiscount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableDiscountMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableDiscount);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(590, 110, 780, 680);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bia7.jpg"))); // NOI18N
        getContentPane().add(jLabel9);
        jLabel9.setBounds(0, 0, 1840, 830);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveDiscountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveDiscountActionPerformed
        // TODO add your handling code here:
        if(flag==1)
        {
            if(InsertDiscount())
            {
                btnSaveDiscount.setEnabled(false);
                control.bindingDiscount(jTableDiscount, discountBLL.LoadDiscount());
                ClearText();
            }
            btnAddDiscount.setEnabled(true);
            btnEditDiscount.setEnabled(true);
            btnDelDiscount.setEnabled(true);
            
        }
        if(flag==2)
        {
            if(UpdateDiscount())
            {
                btnSaveDiscount.setEnabled(false);
                control.bindingDiscount(jTableDiscount, discountBLL.LoadDiscount());
                ClearText();
            }
            btnAddDiscount.setEnabled(true);
            btnEditDiscount.setEnabled(true);
            btnDelDiscount.setEnabled(true);
        }
        if(flag==3)
        {
            if(DeleteDiscount())
            {
                btnSaveDiscount.setEnabled(false);
            control.bindingDiscount(jTableDiscount, discountBLL.LoadDiscount());
            ClearText();
            }
            btnAddDiscount.setEnabled(true);
            btnEditDiscount.setEnabled(true);
            btnDelDiscount.setEnabled(true); 
        }
    }//GEN-LAST:event_btnSaveDiscountActionPerformed

    private void btnAddDiscountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddDiscountActionPerformed
        // TODO add your handling code here:
        ClearText();
        btnAddDiscount.setEnabled(false);
        btnDelDiscount.setEnabled(false);
        btnEditDiscount.setEnabled(false);
        btnSaveDiscount.setEnabled(true);
        flag=1;
    }//GEN-LAST:event_btnAddDiscountActionPerformed

    private void btnEditDiscountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditDiscountActionPerformed
        // TODO add your handling code here:
        btnAddDiscount.setEnabled(false);
        btnDelDiscount.setEnabled(false);
        btnEditDiscount.setEnabled(false);
        btnSaveDiscount.setEnabled(true);
        flag=2;
    }//GEN-LAST:event_btnEditDiscountActionPerformed

    private void btnDelDiscountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelDiscountActionPerformed
        // TODO add your handling code here:
        btnAddDiscount.setEnabled(false);
        btnDelDiscount.setEnabled(false);
        btnEditDiscount.setEnabled(false);
        btnSaveDiscount.setEnabled(true);
        flag=3;
    }//GEN-LAST:event_btnDelDiscountActionPerformed

    private void jTableDiscountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableDiscountMouseClicked
        // TODO add your handling code here:
        int row=jTableDiscount.getSelectedRow();
        txfIDDiscount.setText(jTableDiscount.getValueAt(row, 0).toString());
        txfNameDiscount.setText(jTableDiscount.getValueAt(row, 1).toString());
        txfDiscount.setText(jTableDiscount.getValueAt(row, 2).toString());
        txfMinMoneyDiscount.setText(jTableDiscount.getValueAt(row, 3).toString());
        jDChStartDiscount.setDate((Date)jTableDiscount.getModel().getValueAt(row, 4));
        jDChFinishDiscount.setDate((Date)jTableDiscount.getModel().getValueAt(row, 5));
    }//GEN-LAST:event_jTableDiscountMouseClicked
    public void ClearText()
    {
        txfIDDiscount.setText("");
        txfNameDiscount.setText("");
        txfDiscount.setText("");
        txfMinMoneyDiscount.setText("");
        jDChStartDiscount.setDate(null);
        jDChFinishDiscount.setDate(null);
    }
    public boolean InsertDiscount()
    {
        //ClearText();
        //int IDDiscount=Integer.parseInt(txfIDDiscount.getText());
        String NameDiscount=txfNameDiscount.getText();
        float Discount=Float.parseFloat(txfDiscount.getText());
        float MinMoney=Float.parseFloat(txfMinMoneyDiscount.getText());
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date StartDate=jDChStartDiscount.getDate();
        String strStartDate  = formatter.format(StartDate);
        Date FinishDate=jDChFinishDiscount.getDate();
        String strFinishDate =formatter.format(FinishDate);
         if(NameDiscount.equals(""))
         {
             JOptionPane.showMessageDialog(this,"Tên khuyến mãi bắt buộc phải có");
             return false;
         }
        if(txfMinMoneyDiscount.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Mức tiền tối thiểu khuyến mãi bắt buộc hải có");
            return false;
        }
        if(txfDiscount.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Hệ số khuyến mãi bắt buộc phải có");
            return false;
        }
        if(jDChFinishDiscount.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Ngày bắt đầu khuyến mãi phải có");
            return false;
        }
        if(jDChFinishDiscount.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Ngày kết thúc khuyến mãi phải có");
            return false;
        }
        else
            if(discountBLL.InsertDiscount(NameDiscount, Discount, MinMoney, strStartDate, strFinishDate))
            {
                JOptionPane.showMessageDialog(this, "Thêm thành công khuyến mãi");
                return true;
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Thêm thất bại khuyến mãi");
                return true;
            }
            
        
    }
    public boolean UpdateDiscount()
    {
        int IDDiscount=Integer.parseInt(txfIDDiscount.getText());
        String NameDiscount=txfNameDiscount.getText();
        float Discount=Float.parseFloat(txfDiscount.getText());
        float MinMoney=Float.parseFloat(txfMinMoneyDiscount.getText());
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date StartDate=jDChStartDiscount.getDate();
        String strStartDate  = formatter.format(StartDate);
        Date FinishDate=jDChFinishDiscount.getDate();
        String strFinishDate =formatter.format(FinishDate);
        if(NameDiscount.equals(""))
        {
            JOptionPane.showMessageDialog(this,"Tên khuyến mãi bắt buộc phải có");
            return false;
        }
        if(txfMinMoneyDiscount.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Mức tiền tối thiểu khuyến mãi bắt buộc hải có");
            return false;
        }
        if(txfDiscount.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Hệ số khuyến mãi bắt buộc phải có");
            return false;
        }
        if(jDChFinishDiscount.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Ngày bắt đầu khuyến mãi phải có");
            return false;
        }
        if(jDChFinishDiscount.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Ngày kết thúc khuyến mãi phải có");
            return false;
        }
        else
            {
                if(discountBLL.UpdateDiscount(IDDiscount, NameDiscount, Discount, MinMoney, strStartDate, strFinishDate))
                {
                    JOptionPane.showMessageDialog(this, "Cập nhật thành công khuyến mãi");
                    return true;
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "Cập nhật thất bại khuyến mãi");
                    return false;
                }
            }
        
    }
    public boolean DeleteDiscount()
    {
        int IDDiscount=Integer.parseInt(txfIDDiscount.getText());
        if(discountBLL.DeleteDiscount(IDDiscount))
        {
            JOptionPane.showMessageDialog(this, "Xóa thành công khuyến mãi");
            return true;
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Xóa thất bại khuyến mãi");
            return false;
        }
            
    }
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddDiscount;
    private javax.swing.JButton btnDelDiscount;
    private javax.swing.JButton btnEditDiscount;
    private javax.swing.JButton btnSaveDiscount;
    private com.toedter.calendar.JDateChooser jDChFinishDiscount;
    private com.toedter.calendar.JDateChooser jDChStartDiscount;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableDiscount;
    private javax.swing.JTextField txfDiscount;
    private java.awt.TextField txfIDDiscount;
    private javax.swing.JTextField txfMinMoneyDiscount;
    private javax.swing.JTextField txfNameDiscount;
    // End of variables declaration//GEN-END:variables
}
