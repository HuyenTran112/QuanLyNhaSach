/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import BLL.RuleBLL;
import Utilties.ControlFormat;
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
    
    public fRule() {
        initComponents();
        control.bindingRule(jTableRule, ruleBLL.LoadRule());
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
        txfMaxInventoryNum = new javax.swing.JTextField();
        txfMinInventoryNum = new javax.swing.JTextField();
        txfPriceRatio = new javax.swing.JTextField();
        txfMaxStockNum = new javax.swing.JTextField();
        txfMinStockNum = new javax.swing.JTextField();
        txfVAT = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableRule = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnEditRule = new javax.swing.JButton();
        btnSaveRule = new javax.swing.JButton();

        setClosable(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel1.setText("QUY ĐỊNH");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel2.setText("Số lượng tồn tối đa");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel3.setText("Số lượng tồn tối thiểu");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel4.setText("Tỉ lệ tính giá bán");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel5.setText("Số lượng nhập tối đa");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel6.setText("Số lượng nhập tối thiểu");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel7.setText("VAT");

        txfMaxInventoryNum.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        txfMinInventoryNum.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        txfPriceRatio.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        txfMaxStockNum.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        txfMinStockNum.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        txfVAT.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        jTableRule.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableRule.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableRuleMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableRule);

        btnEditRule.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        btnEditRule.setText("CẬP NHẬT");
        btnEditRule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditRuleActionPerformed(evt);
            }
        });

        btnSaveRule.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
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
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnEditRule)
                .addGap(47, 47, 47)
                .addComponent(btnSaveRule, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(166, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditRule)
                    .addComponent(btnSaveRule))
                .addContainerGap(21, Short.MAX_VALUE))
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
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txfMaxInventoryNum)
                            .addComponent(txfMinInventoryNum)
                            .addComponent(txfPriceRatio)
                            .addComponent(txfMaxStockNum)
                            .addComponent(txfMinStockNum)
                            .addComponent(txfVAT, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 761, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txfMaxInventoryNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txfMinInventoryNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txfPriceRatio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txfMaxStockNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txfMinStockNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txfVAT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(112, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(369, 369, 369)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(51, 51, 51)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void ClearText()
    {
        txfMaxInventoryNum.setText("");
        txfMinInventoryNum.setText("");
        txfPriceRatio.setText("");
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
        if(txfMaxInventoryNum.getText().equals(""))
            MaxInventoryNum = 0;
        else
            MaxInventoryNum = Integer.parseInt(txfMaxInventoryNum.getText());
        
        if(txfMinInventoryNum.getText().equals(""))
            MinInventoryNum = 0;
        else
            MinInventoryNum = Integer.parseInt(txfMinInventoryNum.getText());
        
        if(txfPriceRatio.getText().equals(""))
            Priceratio = 0;
        else
            Priceratio = Float.parseFloat(txfPriceRatio.getText());
        
        if(txfMaxStockNum.getText().equals(""))
            MaxStockNum = 0;
        else
            MaxStockNum = Integer.parseInt(txfMaxStockNum.getText());
        
        if(txfMinStockNum.getText().equals(""))
            MinStockNum = 0;
        else
            MinStockNum = Integer.parseInt(txfMinStockNum.getText());
        
        if(txfVAT.getText().equals(""))
            VAT = 0;
        else
            VAT = Float.parseFloat(txfVAT.getText());
        
        if(txfMaxInventoryNum.getText().equals("")|| txfMinInventoryNum.getText().equals("") || txfPriceRatio.getText().equals("") || txfMaxStockNum.getText().equals("") || txfMinStockNum.getText().equals("") || txfVAT.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Tất cả quy định bắt buộc có");
            return false;
        }
        else
        {
            if(ruleBLL.UpdateRule(MaxInventoryNum, MinInventoryNum, Priceratio, MaxStockNum, MinStockNum, VAT))
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
    
    private void jTableRuleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableRuleMouseClicked
        // TODO add your handling code here:
        int row = jTableRule.getSelectedRow();
        txfMaxInventoryNum.setText(jTableRule.getValueAt(row, 0).toString());
        txfMinInventoryNum.setText(jTableRule.getValueAt(row, 1).toString());
        txfPriceRatio.setText(jTableRule.getValueAt(row, 2).toString());
        txfMaxStockNum.setText(jTableRule.getValueAt(row, 3).toString());
        txfMinStockNum.setText(jTableRule.getValueAt(row, 4).toString());
        txfVAT.setText(jTableRule.getValueAt(row, 5).toString());
    }//GEN-LAST:event_jTableRuleMouseClicked

    private void btnEditRuleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditRuleActionPerformed
        // TODO add your handling code here:
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
                control.bindingRule(jTableRule, ruleBLL.LoadRule());
                ClearText();
            }
        }
    }//GEN-LAST:event_btnSaveRuleActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditRule;
    private javax.swing.JButton btnSaveRule;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableRule;
    private javax.swing.JTextField txfMaxInventoryNum;
    private javax.swing.JTextField txfMaxStockNum;
    private javax.swing.JTextField txfMinInventoryNum;
    private javax.swing.JTextField txfMinStockNum;
    private javax.swing.JTextField txfPriceRatio;
    private javax.swing.JTextField txfVAT;
    // End of variables declaration//GEN-END:variables
}