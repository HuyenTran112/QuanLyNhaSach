/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import  DAL.DiscountDAL;
import BLL.DiscountBLL;
import Utilties.ControlFormat;
import java.awt.Toolkit;

/**
 *
 * @author STIREN
 */
public class fSearchDiscount extends javax.swing.JInternalFrame {

    /**
     * Creates new form fSearchDiscount
     */
    public ControlFormat control =new ControlFormat();
    public DiscountBLL discountBLL=new DiscountBLL();
    public fSearchDiscount() {
        initComponents();
        Toolkit tk =Toolkit.getDefaultToolkit();
        int x=(int) tk.getScreenSize().getWidth();
        int y=(int)tk.getScreenSize().getHeight();  
        setSize(x, y);
        jLabel2.setSize(x,y);
        control.bindingDiscount(jTableSearchDiscount, discountBLL.LoadDiscount());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txfSearchDiscount = new javax.swing.JTextField();
        btnSearchDiscount = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableSearchDiscount = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setClosable(true);
        getContentPane().setLayout(null);

        jPanel1.setOpaque(false);

        txfSearchDiscount.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        btnSearchDiscount.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSearchDiscount.setText("Tìm kiếm");
        btnSearchDiscount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchDiscountActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txfSearchDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(btnSearchDiscount)
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfSearchDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchDiscount))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(101, 140, 515, 71);

        jTableSearchDiscount.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableSearchDiscount);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(42, 254, 914, 291);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel1.setText("TRA CỨU KHUYẾN MÃI");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(349, 39, 344, 37);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bia7.jpg"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(-10, 0, 1120, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchDiscountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchDiscountActionPerformed
        // TODO add your handling code here:
        String key =txfSearchDiscount.getText();
        control.bindingDiscount(jTableSearchDiscount, discountBLL.SearchDiscount(key));
        txfSearchDiscount.setText("");
    }//GEN-LAST:event_btnSearchDiscountActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSearchDiscount;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableSearchDiscount;
    private javax.swing.JTextField txfSearchDiscount;
    // End of variables declaration//GEN-END:variables
}
