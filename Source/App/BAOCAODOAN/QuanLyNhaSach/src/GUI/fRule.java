/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import BLL.RuleBLL;
import Entity.Rule;
import Utilties.ControlFormat;
import java.awt.Font;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
/**
 *
 * @author STIREN
 */
public class fRule extends javax.swing.JInternalFrame {

    /**
     * Creates new form fRule
     */
    int flag = 0;
    ControlFormat control = new ControlFormat();
    RuleBLL ruleBLL = new RuleBLL();
    Rule rule =new Rule();
    public fRule() {
        initComponents();
        btnSaveRule.setEnabled(false);
        txfMinInventoryNum.setText(String.valueOf(ruleBLL.getMinInventoryNum()));
        txfMaxStockNum.setText(String.valueOf(ruleBLL.getMaxStockNum()));
        txfMinStockNum.setText(String.valueOf(ruleBLL.getMinStockNum()));
        txfVAT.setText(String.valueOf(ruleBLL.getVAT()));
        txfMinInventoryNum.setEnabled(false);
        txfMaxStockNum.setEnabled(false);
        txfMinStockNum.setEnabled(false);
        txfVAT.setEnabled(false);
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
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txfMinInventoryNum = new javax.swing.JTextField();
        txfMaxStockNum = new javax.swing.JTextField();
        txfMinStockNum = new javax.swing.JTextField();
        txfVAT = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnEditRule = new javax.swing.JButton();
        btnSaveRule = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setClosable(true);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setText("QUY ĐỊNH");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(600, 60, 158, 37);

        jPanel1.setOpaque(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 204));
        jLabel3.setText("Số lượng tồn tối thiểu");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 204));
        jLabel5.setText("Số lượng nhập tối đa");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 204));
        jLabel6.setText("Số lượng nhập tối thiểu");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 204));
        jLabel7.setText("VAT");

        txfMinInventoryNum.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        txfMinInventoryNum.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfMinInventoryNumKeyTyped(evt);
            }
        });

        txfMaxStockNum.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        txfMaxStockNum.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfMaxStockNumKeyTyped(evt);
            }
        });

        txfMinStockNum.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        txfMinStockNum.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfMinStockNumKeyTyped(evt);
            }
        });

        txfVAT.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        txfVAT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfVATKeyTyped(evt);
            }
        });

        jPanel2.setOpaque(false);

        btnEditRule.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEditRule.setForeground(new java.awt.Color(0, 0, 204));
        btnEditRule.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/tools.png"))); // NOI18N
        btnEditRule.setText("CẬP NHẬT");
        btnEditRule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditRuleActionPerformed(evt);
            }
        });

        btnSaveRule.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSaveRule.setForeground(new java.awt.Color(0, 0, 204));
        btnSaveRule.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/folder.png"))); // NOI18N
        btnSaveRule.setText("LƯU");
        btnSaveRule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveRuleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(181, Short.MAX_VALUE)
                .addComponent(btnEditRule)
                .addGap(44, 44, 44)
                .addComponent(btnSaveRule, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditRule)
                    .addComponent(btnSaveRule))
                .addGap(0, 32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txfMinStockNum, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txfMaxStockNum, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txfMinInventoryNum, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                                .addComponent(txfVAT)))))
                .addContainerGap(795, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txfMinInventoryNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txfMaxStockNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfMinStockNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txfVAT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(104, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(380, 120, 1320, 451);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/anhbia7.jpg"))); // NOI18N
        getContentPane().add(jLabel8);
        jLabel8.setBounds(0, 0, 1380, 730);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void ClearText()
    {
        txfMinInventoryNum.setText("");
        txfMaxStockNum.setText("");
        txfMinStockNum.setText("");
        txfVAT.setText("");
    }
    
    // Cập nhật quy định
    public boolean UpdateRule()
    {
        int MaxInventoryNum;
        int MinInventoryNum;
        float Priceratio;
        int MaxStockNum;
        int MinStockNum;
        float VAT;
        
        // Cần xét giá trị = 0 khi rỗng vì "" không convert được qua Int, khi đó chương trình mới báo nhập thiếu, nếu không xét = 0, chương trình báo lỗi nhưng không báo nhập thiếu
        
        if(txfMinInventoryNum.getText().equals(""))
            MinInventoryNum = 0;
        else
            MinInventoryNum = Integer.parseInt(txfMinInventoryNum.getText().toString());
        
        if(txfMaxStockNum.getText().equals(""))
            MaxStockNum = 0;
        else
            MaxStockNum = Integer.parseInt(txfMaxStockNum.getText().toString());
        
        if(txfMinStockNum.getText().equals(""))
            MinStockNum = 0;
        else
            MinStockNum = Integer.parseInt(txfMinStockNum.getText().toString());
        
        if(txfVAT.getText().equals(""))
            VAT = 0;
        else
            VAT = Float.parseFloat(txfVAT.getText().toString());
        
        if( txfMinInventoryNum.getText().equals("") ||  txfMaxStockNum.getText().equals("") || txfMinStockNum.getText().equals("") || txfVAT.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Tất cả quy định bắt buộc có");
            return false;
        }
        else
        {
            if(ruleBLL.UpdateRule( MinInventoryNum, MaxStockNum, MinStockNum, VAT))
            {
                JOptionPane.showMessageDialog(this, "Cập nhật quy định thành công");
                return true;
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Cập nhật quy định thất bại");
                return false;
            }
        }
    }
    
    private void btnEditRuleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditRuleActionPerformed
        // TODO add your handling code here:
        txfMinInventoryNum.setEnabled(true);
        txfMaxStockNum.setEnabled(true);
        txfMinStockNum.setEnabled(true);
        txfVAT.setEnabled(true);
        btnSaveRule.setEnabled(true);
        btnEditRule.setEnabled(false);
        flag = 1;
    }//GEN-LAST:event_btnEditRuleActionPerformed

    private void btnSaveRuleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveRuleActionPerformed
        // TODO add your handling code here:
        if(flag == 1)
        {
            if(UpdateRule() == true)
            {
                btnEditRule.setEnabled(true);
                txfMinInventoryNum.setText(String.valueOf(ruleBLL.getMinInventoryNum()));
                txfMaxStockNum.setText(String.valueOf(ruleBLL.getMaxStockNum()));
                txfMinStockNum.setText(String.valueOf(ruleBLL.getMinStockNum()));
                txfVAT.setText(String.valueOf(ruleBLL.getVAT()));
                txfMinInventoryNum.setEnabled(false);
                txfMaxStockNum.setEnabled(false);
                txfMinStockNum.setEnabled(false);
                txfVAT.setEnabled(false);
            }
        }
    }//GEN-LAST:event_btnSaveRuleActionPerformed
    
    private void txfMinInventoryNumKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfMinInventoryNumKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (((c < '0') || (c > '9')) || txfMinInventoryNum.getText().length() >= 10)
            evt.consume();
    }//GEN-LAST:event_txfMinInventoryNumKeyTyped
    boolean dot = false;
    private void txfMaxStockNumKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfMaxStockNumKeyTyped
        // TODO add your handling code here:
         char c = evt.getKeyChar();
        if (((c < '0') || (c > '9')) || txfMaxStockNum.getText().length() >= 10)
            evt.consume();
    }//GEN-LAST:event_txfMaxStockNumKeyTyped

    private void txfMinStockNumKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfMinStockNumKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (((c < '0') || (c > '9')) || txfMinStockNum.getText().length() >= 10)
            evt.consume();
    }//GEN-LAST:event_txfMinStockNumKeyTyped

    private void txfVATKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfVATKeyTyped
        // TODO add your handling code here:
        char vChar = evt.getKeyChar();
        if (txfVAT.getText().equals(""))
            dot = false;
        if (dot == false){
            if (vChar == '.') 
                dot = true;
            else if (!(Character.isDigit(vChar)|| (vChar == KeyEvent.VK_BACK_SPACE)|| (vChar == KeyEvent.VK_DELETE))) 
                evt.consume();
        } 
        else {
            if (!(Character.isDigit(vChar)|| (vChar == KeyEvent.VK_BACK_SPACE)|| (vChar == KeyEvent.VK_DELETE)))
                evt.consume();
        }
    }//GEN-LAST:event_txfVATKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditRule;
    private javax.swing.JButton btnSaveRule;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txfMaxStockNum;
    private javax.swing.JTextField txfMinInventoryNum;
    private javax.swing.JTextField txfMinStockNum;
    private javax.swing.JTextField txfVAT;
    // End of variables declaration//GEN-END:variables
}