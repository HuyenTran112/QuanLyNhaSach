/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.StaffBLL;
import Utilties.ControlFormat;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.accessibility.AccessibleRole;
import javax.swing.JOptionPane;

/**
 *
 * @author STIREN
 */
public class fStaff extends javax.swing.JInternalFrame {

    /**
     * Creates new form fStaff
     */
    ControlFormat control =new ControlFormat();
    StaffBLL staffBLL=new StaffBLL();
    

    private int flag=0;
    public fStaff() {
        initComponents();
        btnSaveStaff.setEnabled(false);
        control.bindingStaff(jTableStaff, staffBLL.LoadStaff());
        jDChStartStaff.setDate(new Date());
        jTableStaff.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 14));
        txfNameStaff.setEnabled(false);
        txfAddressStaff.setEnabled(false);
        jDChBirthdayStaff.setEnabled(false);
        jDChStartStaff.setEnabled(false);
        txfPhoneStaff.setEnabled(false);
        cbStatus.setEnabled(false);
        rbFemaleStaff.setEnabled(false);
        rbMaleStaff.setEnabled(false);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txfSearchStaff = new javax.swing.JTextField();
        btnSearchStaff = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txfIDStaff = new javax.swing.JTextField();
        txfNameStaff = new javax.swing.JTextField();
        jDChBirthdayStaff = new com.toedter.calendar.JDateChooser();
        txfPhoneStaff = new javax.swing.JTextField();
        jDChStartStaff = new com.toedter.calendar.JDateChooser();
        rbFemaleStaff = new javax.swing.JRadioButton();
        rbMaleStaff = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        cbStatus = new javax.swing.JComboBox();
        txfAddressStaff = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        btnAddStaff = new javax.swing.JButton();
        btnEditStaff = new javax.swing.JButton();
        btnSaveStaff = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableStaff = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();

        setClosable(true);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setText("QUẢN LÍ NHÂN VIÊN");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(364, 45, 314, 37);

        jPanel1.setOpaque(false);

        txfSearchStaff.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        btnSearchStaff.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSearchStaff.setForeground(new java.awt.Color(0, 0, 204));
        btnSearchStaff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/search.png"))); // NOI18N
        btnSearchStaff.setText("Tìm kiếm");
        btnSearchStaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchStaffActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txfSearchStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(btnSearchStaff)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txfSearchStaff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnSearchStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(14, 100, 440, 47);

        jPanel2.setOpaque(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 204));
        jLabel2.setText("Mã nhân viên");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 204));
        jLabel3.setText("Tên nhân viên");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 204));
        jLabel4.setText("Ngày sinh");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 204));
        jLabel5.setText("Giới tính");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 204));
        jLabel6.setText("Địa chỉ");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 204));
        jLabel7.setText("Điện thoại");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 204));
        jLabel8.setText("Ngày vào làm");

        txfIDStaff.setEditable(false);
        txfIDStaff.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        txfNameStaff.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        jDChBirthdayStaff.setDateFormatString("dd-MM-yyyy");
        jDChBirthdayStaff.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        txfPhoneStaff.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        txfPhoneStaff.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfPhoneStaffKeyTyped(evt);
            }
        });

        jDChStartStaff.setDateFormatString("dd-MM-yyyy");
        jDChStartStaff.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        buttonGroup1.add(rbFemaleStaff);
        rbFemaleStaff.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        rbFemaleStaff.setText("Nữ");
        rbFemaleStaff.setOpaque(false);

        buttonGroup1.add(rbMaleStaff);
        rbMaleStaff.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        rbMaleStaff.setText("Nam");
        rbMaleStaff.setOpaque(false);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 204));
        jLabel9.setText("Trạng thái");

        cbStatus.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Làm việc", "Thôi việc" }));

        txfAddressStaff.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8))
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDChBirthdayStaff, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txfNameStaff)
                    .addComponent(txfPhoneStaff)
                    .addComponent(txfIDStaff)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(rbFemaleStaff)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 149, Short.MAX_VALUE)
                        .addComponent(rbMaleStaff)
                        .addGap(19, 19, 19))
                    .addComponent(cbStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txfAddressStaff)
                    .addComponent(jDChStartStaff, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txfIDStaff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txfNameStaff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jDChBirthdayStaff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel5)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel6))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbFemaleStaff)
                            .addComponent(rbMaleStaff))
                        .addGap(18, 18, 18)
                        .addComponent(txfAddressStaff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txfPhoneStaff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))))
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jDChStartStaff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(39, 39, 39))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(20, 177, 423, 380);

        jPanel4.setOpaque(false);

        btnAddStaff.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAddStaff.setForeground(new java.awt.Color(0, 0, 204));
        btnAddStaff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/add.png"))); // NOI18N
        btnAddStaff.setText("THÊM");
        btnAddStaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddStaffActionPerformed(evt);
            }
        });

        btnEditStaff.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEditStaff.setForeground(new java.awt.Color(0, 0, 204));
        btnEditStaff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/tools.png"))); // NOI18N
        btnEditStaff.setText("CẬP NHẬT");
        btnEditStaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditStaffActionPerformed(evt);
            }
        });

        btnSaveStaff.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSaveStaff.setForeground(new java.awt.Color(0, 0, 204));
        btnSaveStaff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/folder.png"))); // NOI18N
        btnSaveStaff.setText("LƯU");
        btnSaveStaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveStaffActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(btnAddStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btnEditStaff)
                .addGap(18, 18, 18)
                .addComponent(btnSaveStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAddStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnSaveStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnEditStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 36, Short.MAX_VALUE)
                        .addGap(2, 2, 2)))
                .addContainerGap())
        );

        getContentPane().add(jPanel4);
        jPanel4.setBounds(20, 580, 472, 60);

        jTableStaff.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jTableStaff.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã nhân viên", "Tên nhân viên", "Ngày sinh", "Giới tính", "Địa chỉ", "Điện thoại", "Ngày vào làm "
            }
        ));
        jTableStaff.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTableStaff.setAutoscrolls(false);
        jTableStaff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableStaffMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableStaff);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(450, 120, 870, 540);

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/anhbia7.jpg"))); // NOI18N
        getContentPane().add(jLabel11);
        jLabel11.setBounds(0, 0, 1360, 700);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //Hàm chuẩn hóa tên
    public String chuanHoa(String str) {
        str = str.trim();
        str = str.replaceAll("\\s+", " ");
        return str;
    }
 
    public String chuanHoaDanhTuRieng(String str) {
        str = chuanHoa(str.toLowerCase());
        String temp[] = str.split(" ");
        str = ""; // ? ^-^
        for (int i = 0; i < temp.length; i++) {
            str += String.valueOf(temp[i].charAt(0)).toUpperCase() + temp[i].substring(1);
            if (i < temp.length - 1) // ? ^-^
                str += " ";
        }
        return str;
    } 
    private void jTableStaffMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableStaffMouseClicked
        // TODO add your handling code here:
        txfNameStaff.setEnabled(false);
        txfAddressStaff.setEnabled(false);
        jDChBirthdayStaff.setEnabled(false);
        jDChStartStaff.setEnabled(false);
        txfPhoneStaff.setEnabled(false);
        cbStatus.setEnabled(false);
        rbFemaleStaff.setEnabled(false);
        rbMaleStaff.setEnabled(false);
        int row =jTableStaff.getSelectedRow();
        txfIDStaff.setText(jTableStaff.getValueAt(row, 0).toString());
        txfNameStaff.setText(jTableStaff.getValueAt(row, 1).toString());
        jDChBirthdayStaff.setDate((Date)jTableStaff.getModel().getValueAt(row, 2));
        String sex =jTableStaff.getValueAt(row, 3).toString();
        if(sex.equals("Nam"))
        {
            rbMaleStaff.setSelected(true);
            rbFemaleStaff.setSelected(false);
        }
        else
        {
            rbFemaleStaff.setSelected(true);
            rbMaleStaff.setSelected(false);
        }
        txfAddressStaff.setText(jTableStaff.getValueAt(row, 4).toString());
        txfPhoneStaff.setText(jTableStaff.getValueAt(row, 5).toString());
        jDChStartStaff.setDate((Date)jTableStaff.getModel().getValueAt(row, 6));
        String status =jTableStaff.getValueAt(row, 7).toString();
        int status_;
        if(status.equals("Làm việc"))
            status_=1;
        else
            status_=0;
    }//GEN-LAST:event_jTableStaffMouseClicked

    private void btnAddStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddStaffActionPerformed
        // TODO add your handling code here:
         Cleartext();
        txfNameStaff.setEnabled(true);
        txfAddressStaff.setEnabled(true);
        jDChBirthdayStaff.setEnabled(true);
        jDChStartStaff.setEnabled(true);
        txfPhoneStaff.setEnabled(true);
        cbStatus.setEnabled(true);
        rbFemaleStaff.setEnabled(true);
        rbMaleStaff.setEnabled(true);
        btnEditStaff.setEnabled(false);
        btnAddStaff.setEnabled(false);
        btnSaveStaff.setEnabled(true);
        flag=1;
    }//GEN-LAST:event_btnAddStaffActionPerformed

    private void btnEditStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditStaffActionPerformed
        // TODO add your handling code here:
        txfNameStaff.setEnabled(true);
        txfAddressStaff.setEnabled(true);
        jDChBirthdayStaff.setEnabled(true);
        jDChStartStaff.setEnabled(true);
        txfPhoneStaff.setEnabled(true);
        cbStatus.setEnabled(true);
        rbFemaleStaff.setEnabled(true);
        rbMaleStaff.setEnabled(true);
        btnEditStaff.setEnabled(false);
        btnAddStaff.setEnabled(false);
        btnSaveStaff.setEnabled(true);
        flag=2;
    }//GEN-LAST:event_btnEditStaffActionPerformed

    private void btnSaveStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveStaffActionPerformed
        // TODO add your handling code here:
        if(flag==1)
        {
            if(InsertStaff())
            {
                Cleartext();
                btnSaveStaff.setEnabled(false);
                control.bindingStaff(jTableStaff, staffBLL.LoadStaff());
                txfNameStaff.setEnabled(false);
                txfAddressStaff.setEnabled(false);
                jDChBirthdayStaff.setEnabled(false);
                jDChStartStaff.setEnabled(false);
                txfPhoneStaff.setEnabled(false);
                cbStatus.setEnabled(false);
                rbFemaleStaff.setEnabled(false);
                rbMaleStaff.setEnabled(false);
            }
            btnAddStaff.setEnabled(true);
            btnEditStaff.setEnabled(true);
        
        }
        if(flag==2)
        {
            if(UpdateStaff())
            {
                Cleartext();
                btnSaveStaff.setEnabled(false);
                control.bindingStaff(jTableStaff, staffBLL.LoadStaff());
                txfNameStaff.setEnabled(false);
                txfAddressStaff.setEnabled(false);
                jDChBirthdayStaff.setEnabled(false);
                jDChStartStaff.setEnabled(false);
                txfPhoneStaff.setEnabled(false);
                cbStatus.setEnabled(false);
                rbFemaleStaff.setEnabled(false);
                rbMaleStaff.setEnabled(false);
            }
            btnAddStaff.setEnabled(true);
            btnEditStaff.setEnabled(true);
        
        }
    }//GEN-LAST:event_btnSaveStaffActionPerformed

    private void btnSearchStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchStaffActionPerformed
        // TODO add your handling code here:
        String key=txfSearchStaff.getText().toString();
        control.bindingStaff(jTableStaff, staffBLL.arrSearchStaff(key));
        txfSearchStaff.setText("");
    }//GEN-LAST:event_btnSearchStaffActionPerformed

    private void txfPhoneStaffKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfPhoneStaffKeyTyped
        // TODO add your handling code here:
         char c = evt.getKeyChar();
        if (((c < '0') || (c > '9')) || txfPhoneStaff.getText().length() >= 10)
            evt.consume();
    }//GEN-LAST:event_txfPhoneStaffKeyTyped
    //Xóa text
    public void Cleartext()
    {
        txfIDStaff.setText("");
        txfNameStaff.setText("");
        txfAddressStaff.setText("");
        txfPhoneStaff.setText("");
        jDChBirthdayStaff.setDate(null);
        jDChStartStaff.setDate(new Date());
        rbFemaleStaff.setSelected(false);
        rbMaleStaff.setSelected(false);
    }
    //Thêm nhân viên
    public boolean InsertStaff()
    {
        String name =txfNameStaff.getText().toString();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date birthday =jDChBirthdayStaff.getDate();
        String str_birthday =formatter.format(birthday);
        Date startdate =jDChStartStaff.getDate();
        String str_startdate =formatter.format(startdate);
        String address=txfAddressStaff.getText().toString();
        String phonenumber =txfPhoneStaff.getText().toString();
        String sex="";
        if(rbFemaleStaff.isSelected())
            sex="Nữ";
        if(rbMaleStaff.isSelected())
            sex="Nam";
        int status_;
        String status =cbStatus.getSelectedItem().toString();
        if(status.equals("Làm việc"))
            status_=1;
        else
            status_=0;
        if(name.equals("") || str_birthday.equals("") || address.equals("") ||phonenumber.equals("")||str_startdate.equals("")||sex.equals(""))
        {
            JOptionPane.showMessageDialog(null,"Thông tin bạn nhập chưa đầy đủ. Vui lòng nhập lại");
            return false;
        }
        else{
            name=chuanHoaDanhTuRieng(name);
            address=chuanHoa(address);
            if(staffBLL.InsertStaff(name, str_birthday, sex, address, phonenumber, str_startdate, status_))
            {
                JOptionPane.showMessageDialog(this, "Thêm nhân viên thành công");
                return true;
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Thêm nhân viên thất bại");
                return false;
            }
        }
    }
    //Cập nhật nhân viên
    public boolean UpdateStaff()
    {
        int id =Integer.parseInt(txfIDStaff.getText().toString());
        String name =txfNameStaff.getText().toString();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date birthday =jDChBirthdayStaff.getDate();
        String str_birthday =formatter.format(birthday);
        Date startdate =jDChStartStaff.getDate();
        String str_startdate =formatter.format(startdate);
        String address=txfAddressStaff.getText().toString();
        String phonenumber =txfPhoneStaff.getText().toString();
        String sex="";
        if(rbFemaleStaff.isSelected())
            sex="Nữ";
        if(rbMaleStaff.isSelected())
            sex="Nam";
        int status_;
        String status =cbStatus.getSelectedItem().toString();
        if(status.equals("Làm việc"))
            status_=1;
        else
            status_=0;
        if(name.equals("") || str_birthday.equals("") || address.equals("") ||phonenumber.equals("")||str_startdate.equals("")||sex.equals(""))
        {
            JOptionPane.showMessageDialog(null,"Thông tin bạn nhập chưa đầy đủ. Vui lòng nhập lại");
            return false;
        }
        else{
            name=chuanHoaDanhTuRieng(name);
            address=chuanHoa(address);
            if(staffBLL.UpdateStaff(id,name, str_birthday, sex, address, phonenumber, str_startdate,status_))
            {
                JOptionPane.showMessageDialog(this, "Cập nhật nhân viên thành công");
                return true;
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Cập nhật nhân viên thất bại");
                return false;
            }
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddStaff;
    private javax.swing.JButton btnEditStaff;
    private javax.swing.JButton btnSaveStaff;
    private javax.swing.JButton btnSearchStaff;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cbStatus;
    private com.toedter.calendar.JDateChooser jDChBirthdayStaff;
    private com.toedter.calendar.JDateChooser jDChStartStaff;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableStaff;
    private javax.swing.JRadioButton rbFemaleStaff;
    private javax.swing.JRadioButton rbMaleStaff;
    private javax.swing.JTextField txfAddressStaff;
    private javax.swing.JTextField txfIDStaff;
    private javax.swing.JTextField txfNameStaff;
    private javax.swing.JTextField txfPhoneStaff;
    private javax.swing.JTextField txfSearchStaff;
    // End of variables declaration//GEN-END:variables
}