/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.StaffBLL;
import BLL.UserBLL;
import Entity.Staff;
import Utilties.ControlFormat;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

/**
 *
 * @author STIREN
 */
public class fUser extends javax.swing.JInternalFrame {

    /**
     * Creates new form fUser
     */
    UserBLL userBLL=new UserBLL();
    ControlFormat control =new ControlFormat();
    StaffBLL staffBLL=new StaffBLL();
    private int flag=0;
    public fUser() {
        initComponents();
        control.bindingUser(jTableUser, userBLL.LoadUser());
        control.bindingStaff(jTableStaff,staffBLL.LoadStaffNoAccount());
        jTableUser.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 14));
        jTableStaff.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 14));
        cbNameUserCategory_User.setEnabled(false);
        txfNameStaff.setEnabled(false);
        txfUserName.setEnabled(false);
        txfDisplayName.setEnabled(false);
        txfPassWord.setEnabled(false);
        btnSaveUser.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableUser = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        btnAddUser = new javax.swing.JButton();
        btnSaveUser = new javax.swing.JButton();
        txfUserName = new javax.swing.JTextField();
        btnEditUser = new javax.swing.JButton();
        btnDelUser = new javax.swing.JButton();
        cbNameUserCategory_User = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        txfPassWord = new javax.swing.JTextField();
        txfSearchUser = new javax.swing.JTextField();
        btnSeaechUser = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableStaff = new javax.swing.JTable();
        txfNameStaff = new javax.swing.JTextField();
        txfSearchStaff = new javax.swing.JTextField();
        btnSeaechStaff = new javax.swing.JButton();
        txfDisplayName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bia7.jpg"))); // NOI18N

        setClosable(true);
        getContentPane().setLayout(null);

        jPanel5.setLayout(null);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 51, 204));
        jLabel11.setText("QUẢN LÝ NGƯỜI DÙNG");
        jPanel5.add(jLabel11);
        jLabel11.setBounds(432, 39, 352, 37);

        jTableUser.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTableUser.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableUserMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTableUser);

        jPanel5.add(jScrollPane3);
        jScrollPane3.setBounds(70, 490, 1170, 150);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 51, 204));
        jLabel15.setText("Tên đăng nhập");
        jPanel5.add(jLabel15);
        jLabel15.setBounds(38, 213, 110, 17);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 51, 204));
        jLabel16.setText("Tên hiển thị");
        jPanel5.add(jLabel16);
        jLabel16.setBounds(38, 256, 90, 17);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 51, 204));
        jLabel14.setText("Tên nhóm");
        jPanel5.add(jLabel14);
        jLabel14.setBounds(38, 116, 80, 17);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 51, 204));
        jLabel17.setText("Mật khẩu");
        jPanel5.add(jLabel17);
        jLabel17.setBounds(38, 303, 70, 17);

        btnAddUser.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAddUser.setForeground(new java.awt.Color(0, 51, 204));
        btnAddUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/add.png"))); // NOI18N
        btnAddUser.setText("THÊM");
        btnAddUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddUserActionPerformed(evt);
            }
        });
        jPanel5.add(btnAddUser);
        btnAddUser.setBounds(20, 370, 110, 40);

        btnSaveUser.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSaveUser.setForeground(new java.awt.Color(0, 51, 204));
        btnSaveUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/folder.png"))); // NOI18N
        btnSaveUser.setText("LƯU");
        btnSaveUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveUserActionPerformed(evt);
            }
        });
        jPanel5.add(btnSaveUser);
        btnSaveUser.setBounds(420, 370, 120, 40);

        txfUserName.setEditable(false);
        txfUserName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel5.add(txfUserName);
        txfUserName.setBounds(209, 203, 250, 30);

        btnEditUser.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEditUser.setForeground(new java.awt.Color(0, 51, 204));
        btnEditUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/tools.png"))); // NOI18N
        btnEditUser.setText("CẬP NHẬT");
        btnEditUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditUserActionPerformed(evt);
            }
        });
        jPanel5.add(btnEditUser);
        btnEditUser.setBounds(140, 370, 143, 40);

        btnDelUser.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDelUser.setForeground(new java.awt.Color(0, 51, 204));
        btnDelUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/rubbish-bin.png"))); // NOI18N
        btnDelUser.setText("XÓA");
        btnDelUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelUserActionPerformed(evt);
            }
        });
        jPanel5.add(btnDelUser);
        btnDelUser.setBounds(300, 370, 110, 40);

        cbNameUserCategory_User.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbNameUserCategory_User.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nhân viên quản lý", "Nhân viên bán hàng" }));
        jPanel5.add(cbNameUserCategory_User);
        cbNameUserCategory_User.setBounds(209, 106, 250, 30);

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 51, 204));
        jLabel18.setText("Tên nhân viên");
        jPanel5.add(jLabel18);
        jLabel18.setBounds(38, 167, 110, 17);

        txfPassWord.setEditable(false);
        txfPassWord.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel5.add(txfPassWord);
        txfPassWord.setBounds(212, 300, 250, 30);

        txfSearchUser.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel5.add(txfSearchUser);
        txfSearchUser.setBounds(200, 450, 353, 23);

        btnSeaechUser.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSeaechUser.setForeground(new java.awt.Color(0, 51, 204));
        btnSeaechUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/search.png"))); // NOI18N
        btnSeaechUser.setText("Tìm kiếm");
        btnSeaechUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeaechUserActionPerformed(evt);
            }
        });
        jPanel5.add(btnSeaechUser);
        btnSeaechUser.setBounds(580, 430, 140, 40);

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

        jPanel5.add(jScrollPane1);
        jScrollPane1.setBounds(564, 130, 787, 290);

        txfNameStaff.setEditable(false);
        txfNameStaff.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jPanel5.add(txfNameStaff);
        txfNameStaff.setBounds(209, 158, 250, 30);

        txfSearchStaff.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel5.add(txfSearchStaff);
        txfSearchStaff.setBounds(564, 95, 367, 23);

        btnSeaechStaff.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSeaechStaff.setForeground(new java.awt.Color(0, 51, 204));
        btnSeaechStaff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/search.png"))); // NOI18N
        btnSeaechStaff.setText("Tìm kiếm");
        btnSeaechStaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeaechStaffActionPerformed(evt);
            }
        });
        jPanel5.add(btnSeaechStaff);
        btnSeaechStaff.setBounds(970, 90, 130, 30);

        txfDisplayName.setEditable(false);
        txfDisplayName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel5.add(txfDisplayName);
        txfDisplayName.setBounds(209, 253, 250, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/anhbia7.jpg"))); // NOI18N
        jPanel5.add(jLabel1);
        jLabel1.setBounds(0, 0, 1490, 770);

        getContentPane().add(jPanel5);
        jPanel5.setBounds(0, 0, 1350, 750);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void ClearText()
    {
        cbNameUserCategory_User.setSelectedItem(null);
        txfNameStaff.setText("");
        txfPassWord.setText("");
        txfUserName.setText("");
        txfPassWord.setText("");
        txfDisplayName.setText("");
    }
    public boolean  Insert()
    {
        String NameCategogy =cbNameUserCategory_User.getSelectedItem().toString();
        String NameStaff =txfNameStaff.getText().toString();
        int IDStaff=staffBLL.getIDStaff(NameStaff);
        int IDCategogy;
        if(NameCategogy.equals("Nhân viên quản lý"))
            IDCategogy=1;
        else
            IDCategogy=2;
        if(NameCategogy.equals("")|| NameStaff.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập thông tin đầy đủ");
            return false;
        }
        else
        {
            if(userBLL.InsertUser(IDCategogy, IDStaff))
            {
                JOptionPane.showMessageDialog(this, "Thêm thành công người dùng");
                return true;
            }
            else
            {
                JOptionPane.showMessageDialog(this,"Thêm thất bại người dùng");
                return false;
            }
        }
    }
    public boolean  Update()
    {
        String NameCategogy =cbNameUserCategory_User.getSelectedItem().toString();
        String NameStaff =txfNameStaff.getText().toString();
        int IDStaff=staffBLL.getIDStaff(NameStaff);
        int IDCategogy;
        if(NameCategogy.equals("Nhân viên quản lý"))
            IDCategogy=1;
        else
            IDCategogy=2;
        String PassWord =txfPassWord.getText().toString();
        if(NameCategogy.equals("")|| NameStaff.equals("")||PassWord.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập thông tin đầy đủ");
            return false;
        }
        else
        {
            if(userBLL.UpdateUser(IDCategogy, IDStaff, PassWord))
            {
                JOptionPane.showMessageDialog(this, "Cập nhật thành công người dùng");
                return true;
            }
            else
            {
                JOptionPane.showMessageDialog(this,"Cập nhật thất bại người dùng");
                return false;
            }
        }
    }
    public boolean  Delete()
    {
        String NameStaff =txfNameStaff.getText().toString();
        int IDStaff=staffBLL.getIDStaff(NameStaff);
        if(userBLL.DeleteUser(IDStaff))
        {
            JOptionPane.showMessageDialog(this, "Xóa thành công người dùng");
            return true;
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Xóa thất bại người dùng");
            return false;
        }
    }
    private void btnAddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddUserActionPerformed
        // TODO add your handling code here:
        cbNameUserCategory_User.setEnabled(true);
        txfNameStaff.setEnabled(true);
        txfUserName.setEnabled(true);
        txfDisplayName.setEnabled(true);
        txfPassWord.setEnabled(true);
        ClearText();
        btnAddUser.setEnabled(false);
        btnEditUser.setEnabled(false);
        btnDelUser.setEnabled(false);
        btnSaveUser.setEnabled(true);
        flag=1;
    }//GEN-LAST:event_btnAddUserActionPerformed

    private void btnEditUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditUserActionPerformed
        // TODO add your handling code here:
        cbNameUserCategory_User.setEnabled(true);
        txfNameStaff.setEnabled(true);
        txfUserName.setEnabled(true);
        txfDisplayName.setEnabled(true);
        txfPassWord.setEnabled(true);
        btnAddUser.setEnabled(false);
        btnEditUser.setEnabled(false);
        btnDelUser.setEnabled(false);
        btnSaveUser.setEnabled(true);
        flag=2;
    }//GEN-LAST:event_btnEditUserActionPerformed

    private void btnDelUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelUserActionPerformed
        // TODO add your handling code here:
        cbNameUserCategory_User.setEnabled(true);
        txfNameStaff.setEnabled(true);
        txfUserName.setEnabled(true);
        txfDisplayName.setEnabled(true);
        txfPassWord.setEnabled(true);
        btnAddUser.setEnabled(false);
        btnEditUser.setEnabled(false);
        btnDelUser.setEnabled(false);
        btnSaveUser.setEnabled(true);
        flag=3;
    }//GEN-LAST:event_btnDelUserActionPerformed

    private void btnSaveUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveUserActionPerformed
        // TODO add your handling code here:
        if(flag==1)
        {
            if(Insert())
            {
                btnSaveUser.setEnabled(false);
                control.bindingUser(jTableUser, userBLL.LoadUser());
                control.bindingStaff(jTableStaff, staffBLL.LoadStaffNoAccount());
                ClearText();
                cbNameUserCategory_User.setEnabled(false);
                txfNameStaff.setEnabled(false);
                txfUserName.setEnabled(false);
                txfDisplayName.setEnabled(false);
                txfPassWord.setEnabled(false);
            }
            btnAddUser.setEnabled(true);
            btnEditUser.setEnabled(true);
            btnDelUser.setEnabled(true);
        }
        if(flag==2)
        {
            if(Update())
            {
                btnSaveUser.setEnabled(false);
                control.bindingUser(jTableUser, userBLL.LoadUser());
                control.bindingStaff(jTableStaff, staffBLL.LoadStaffNoAccount());
                ClearText();
                cbNameUserCategory_User.setEnabled(false);
                txfNameStaff.setEnabled(false);
                txfUserName.setEnabled(false);
                txfDisplayName.setEnabled(false);
                txfPassWord.setEnabled(false);
            }
            btnAddUser.setEnabled(true);
            btnEditUser.setEnabled(true);
            btnDelUser.setEnabled(true);
        }
        if(flag==3)
        {
            if(Delete())
            {
                btnSaveUser.setEnabled(false);
                control.bindingUser(jTableUser, userBLL.LoadUser());
                control.bindingStaff(jTableStaff, staffBLL.LoadStaffNoAccount());
                ClearText();
                cbNameUserCategory_User.setEnabled(false);
                txfNameStaff.setEnabled(false);
                txfUserName.setEnabled(false);
                txfDisplayName.setEnabled(false);
                txfPassWord.setEnabled(false);
            }
            btnAddUser.setEnabled(true);
            btnEditUser.setEnabled(true);
            btnDelUser.setEnabled(true);
        }
    }//GEN-LAST:event_btnSaveUserActionPerformed

    private void btnSeaechUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeaechUserActionPerformed
        // TODO add your handling code here:
        String key =txfSearchUser.getText().toString();
        control.bindingUser(jTableUser, userBLL.SearchUser(key));
        txfSearchUser.setText("");
    }//GEN-LAST:event_btnSeaechUserActionPerformed

    private void jTableUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableUserMouseClicked
        // TODO add your handling code here:
        cbNameUserCategory_User.setEnabled(false);
        txfNameStaff.setEnabled(false);
        txfUserName.setEnabled(false);
        txfDisplayName.setEnabled(false);
        txfPassWord.setEnabled(false);
        int row =jTableUser.getSelectedRow();
        cbNameUserCategory_User.setSelectedItem(jTableUser.getValueAt(row, 0).toString());
        txfNameStaff.setText(jTableUser.getValueAt(row, 1).toString());
        txfUserName.setText(jTableUser.getValueAt(row, 2).toString());
        txfDisplayName.setText(jTableUser.getValueAt(row, 3).toString());
        txfPassWord.setText(jTableUser.getValueAt(row, 4).toString());
    }//GEN-LAST:event_jTableUserMouseClicked

    private void jTableStaffMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableStaffMouseClicked
        // TODO add your handling code here:
        int row =jTableStaff.getSelectedRow();
        txfNameStaff.setText(jTableStaff.getValueAt(row, 1).toString());
        
    }//GEN-LAST:event_jTableStaffMouseClicked
    Toolkit tk = Toolkit.getDefaultToolkit();
    private void btnSeaechStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeaechStaffActionPerformed
        // TODO add your handling code here:
        String namestaff =txfSearchStaff.getText().toString();
        control.bindingStaff(jTableStaff, staffBLL.arrSearchStaff(namestaff));
        txfSearchStaff.setText("");
         
    }//GEN-LAST:event_btnSeaechStaffActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddUser;
    private javax.swing.JButton btnDelUser;
    private javax.swing.JButton btnEditUser;
    private javax.swing.JButton btnSaveUser;
    private javax.swing.JButton btnSeaechStaff;
    private javax.swing.JButton btnSeaechUser;
    private javax.swing.JComboBox<String> cbNameUserCategory_User;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableStaff;
    private javax.swing.JTable jTableUser;
    private javax.swing.JTextField txfDisplayName;
    private javax.swing.JTextField txfNameStaff;
    private javax.swing.JTextField txfPassWord;
    private javax.swing.JTextField txfSearchStaff;
    private javax.swing.JTextField txfSearchUser;
    private javax.swing.JTextField txfUserName;
    // End of variables declaration//GEN-END:variables
}
