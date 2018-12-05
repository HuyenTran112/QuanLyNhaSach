/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.BookBLL;
import Utilties.ControlFormat;
import java.util.Locale;
import Entity.*;
import DAL.*;
import BLL.*;
import javax.swing.JOptionPane;
import GUI.fManagement;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
//import sun.org.mozilla.javascript.internal.Token;


/**
 *
 * @author STIREN
 */
public class fListBook extends javax.swing.JInternalFrame {

    /**
     * Creates new form fListBook
     */
    ControlFormat control = new ControlFormat();
    BookBLL bookbll = new BookBLL();
    BookCategogyBLL categogyBLL=new BookCategogyBLL();
    //fManagement a = new fManagement();
    int flag=0;
    public fListBook() {
        
        initComponents();
        Toolkit tk =Toolkit.getDefaultToolkit();
        int x=(int) tk.getScreenSize().getWidth();
        int y=(int)tk.getScreenSize().getHeight();
        jPanel1.setSize(x, y);
        jPanel2.setSize(x,y);
        jLabel12.setSize((int)jPanel1.getSize().getWidth(), (int)jPanel1.getSize().getHeight());
        jLabel14.setSize((int)jPanel2.getSize().getWidth(),(int)jPanel2.getSize().getHeight());
        control.bindingBook(jTableBookInfo, bookbll.LoadBook());
        control.bindingBookCategogy(jTableBookCategory, categogyBLL.LoadBookCategogy());
        cbNameCategogyBookInfo.removeAllItems();
        for(BookCategogy bookCategogy: categogyBLL.LoadBookCategogy())
        {
            cbNameCategogyBookInfo.addItem(bookCategogy.getNameBookCategogy());
        }
        //cbNameCategogyBookInfo.addItem("Sách cố tích");
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txfIDBookInfo = new javax.swing.JTextField();
        cbNameCategogyBookInfo = new javax.swing.JComboBox<>();
        txfNameBookInfo = new javax.swing.JTextField();
        txfPublisherBookInfo = new javax.swing.JTextField();
        txfPublishingYearBookInfo = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaBriefBookInfo = new javax.swing.JTextArea();
        txfAuthorBookInfo = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txfCostBookInfo = new javax.swing.JTextField();
        txfSumInventory = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableBookInfo = new javax.swing.JTable();
        btnAddBookInfo = new javax.swing.JButton();
        btnEditBookInfo = new javax.swing.JButton();
        btnSaveBookInfo = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txfIDBookCategogy = new javax.swing.JTextField();
        txfNameBookCategogy = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        btnAddBookCategogy = new javax.swing.JButton();
        btnEditBookCategogy = new javax.swing.JButton();
        btnSaveBookCategogy = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableBookCategory = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();

        setClosable(true);

        jTabbedPane1.setForeground(new java.awt.Color(0, 0, 204));
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N

        jPanel2.setOpaque(false);
        jPanel2.setLayout(null);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 204));
        jLabel4.setText("QUẢN LÝ THÔNG TIN SÁCH");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(413, 11, 410, 37);

        jPanel6.setOpaque(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 204));
        jLabel5.setText("Mã sách");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 204));
        jLabel6.setText("Tên sách");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 204));
        jLabel7.setText("Nhà xuất bản");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 204));
        jLabel9.setText("Năm xuất bản");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 204));
        jLabel8.setText("Tóm tắt");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 204));
        jLabel10.setText("Tác giả");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 204));
        jLabel20.setText("Giá nhập");

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel21.setText("Tổng sách tồn");

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 0, 204));
        jLabel22.setText("Tên thể loại:");

        txfIDBookInfo.setEditable(false);
        txfIDBookInfo.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        cbNameCategogyBookInfo.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        txfNameBookInfo.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        txfPublisherBookInfo.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        txfPublishingYearBookInfo.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        txfPublishingYearBookInfo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfPublishingYearBookInfoKeyTyped(evt);
            }
        });

        txaBriefBookInfo.setColumns(20);
        txaBriefBookInfo.setRows(5);
        jScrollPane2.setViewportView(txaBriefBookInfo);

        txfAuthorBookInfo.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 204));
        jLabel11.setText("Tổng sách tồn:");

        txfCostBookInfo.setEditable(false);
        txfCostBookInfo.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        txfCostBookInfo.setText("0");

        txfSumInventory.setEditable(false);
        txfSumInventory.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        txfSumInventory.setText("0");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel22)
                            .addComponent(jLabel6)
                            .addComponent(jLabel9)
                            .addComponent(jLabel20)
                            .addComponent(jLabel8)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txfPublisherBookInfo)
                            .addComponent(txfPublishingYearBookInfo)
                            .addComponent(txfCostBookInfo)
                            .addComponent(txfSumInventory)
                            .addComponent(txfIDBookInfo)
                            .addComponent(cbNameCategogyBookInfo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txfNameBookInfo)
                            .addComponent(txfAuthorBookInfo)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)))
                    .addComponent(jLabel7))
                .addContainerGap(94, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfIDBookInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbNameCategogyBookInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addGap(17, 17, 17)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txfNameBookInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txfAuthorBookInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txfPublisherBookInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfPublishingYearBookInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel8)
                        .addGap(11, 11, 11))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel20))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txfCostBookInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txfSumInventory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(420, 420, 420)
                .addComponent(jLabel21)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel6);
        jPanel6.setBounds(28, 59, 490, 454);

        jTableBookInfo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTableBookInfo.setAutoResizeMode(jTableBookInfo.AUTO_RESIZE_OFF);
        jTableBookInfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã sách", "Mã thể loại sách", "Tên sách", "Nhà xuất bản", "Năm xuất bản", "Tóm tắt", "Giá nhập", "Giá bán"
            }
        ));
        jTableBookInfo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTableBookInfo.setMaximumSize(new java.awt.Dimension(2147483647, 70));
        jTableBookInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableBookInfoMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTableBookInfo);

        jPanel2.add(jScrollPane3);
        jScrollPane3.setBounds(560, 70, 770, 568);

        btnAddBookInfo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAddBookInfo.setForeground(new java.awt.Color(0, 0, 204));
        btnAddBookInfo.setText("THÊM");
        btnAddBookInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddBookInfoActionPerformed(evt);
            }
        });
        jPanel2.add(btnAddBookInfo);
        btnAddBookInfo.setBounds(53, 533, 100, 25);

        btnEditBookInfo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEditBookInfo.setForeground(new java.awt.Color(0, 0, 204));
        btnEditBookInfo.setText("CẬP NHẬT");
        btnEditBookInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditBookInfoActionPerformed(evt);
            }
        });
        jPanel2.add(btnEditBookInfo);
        btnEditBookInfo.setBounds(185, 533, 110, 25);

        btnSaveBookInfo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSaveBookInfo.setForeground(new java.awt.Color(0, 0, 204));
        btnSaveBookInfo.setText("LƯU");
        btnSaveBookInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveBookInfoActionPerformed(evt);
            }
        });
        jPanel2.add(btnSaveBookInfo);
        btnSaveBookInfo.setBounds(328, 533, 90, 25);

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/anhbia7.jpg"))); // NOI18N
        jPanel2.add(jLabel14);
        jLabel14.setBounds(0, 0, 1350, 680);

        jTabbedPane1.addTab("Thông tin sách", jPanel2);

        jPanel1.setOpaque(false);
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setText("QUẢN LÝ THỂ LOẠI SÁCH");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(376, 50, 380, 37);

        jPanel4.setOpaque(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 204));
        jLabel2.setText("Mã thể loại sách");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 204));
        jLabel3.setText("Tên thể loại sách");

        txfIDBookCategogy.setEditable(false);
        txfIDBookCategogy.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        txfNameBookCategogy.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txfIDBookCategogy, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfNameBookCategogy, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(92, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txfIDBookCategogy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txfNameBookCategogy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4);
        jPanel4.setBounds(27, 119, 452, 113);

        jPanel5.setOpaque(false);

        btnAddBookCategogy.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAddBookCategogy.setForeground(new java.awt.Color(0, 0, 204));
        btnAddBookCategogy.setText("THÊM");
        btnAddBookCategogy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddBookCategogyActionPerformed(evt);
            }
        });

        btnEditBookCategogy.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEditBookCategogy.setForeground(new java.awt.Color(0, 0, 204));
        btnEditBookCategogy.setText("CẬP NHẬT");
        btnEditBookCategogy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditBookCategogyActionPerformed(evt);
            }
        });

        btnSaveBookCategogy.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSaveBookCategogy.setForeground(new java.awt.Color(0, 0, 204));
        btnSaveBookCategogy.setText("LƯU");
        btnSaveBookCategogy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveBookCategogyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAddBookCategogy, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnEditBookCategogy)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(btnSaveBookCategogy, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditBookCategogy)
                    .addComponent(btnAddBookCategogy)
                    .addComponent(btnSaveBookCategogy))
                .addContainerGap())
        );

        jPanel1.add(jPanel5);
        jPanel5.setBounds(27, 265, 391, 60);

        jTableBookCategory.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTableBookCategory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Mã thể loại sách", "Tên thể loại sách"
            }
        ));
        jTableBookCategory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableBookCategoryMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableBookCategory);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(480, 110, 680, 550);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/anhbia7.jpg"))); // NOI18N
        jPanel1.add(jLabel12);
        jLabel12.setBounds(0, 0, 1360, 680);

        jTabbedPane1.addTab("Thể loại sách", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1343, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 702, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTableBookCategoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableBookCategoryMouseClicked
        // TODO add your handling code here:
        int row =jTableBookCategory.getSelectedRow();
        txfIDBookCategogy.setText(jTableBookCategory.getValueAt(row, 0).toString());
        txfNameBookCategogy.setText(jTableBookCategory.getValueAt(row, 1).toString());
    }//GEN-LAST:event_jTableBookCategoryMouseClicked
    public void ClearTextBookInfo()
    {
        txfIDBookInfo.setText("");
        //txfNameBookCategogy.setText("");
        txfNameBookInfo.setText("");
        txfPublisherBookInfo.setText("");
        txfPublishingYearBookInfo.setText("");
        txfPublishingYearBookInfo.setText("");
        txfAuthorBookInfo.setText("");
        txfCostBookInfo.setText("0");
        txfSumInventory.setText("0");
    }
    public String chuanHoa(String str) {
        str = str.trim();
        str = str.replaceAll("\\s+", " ");
        return str;
    }
    public boolean InsertBook()
    {
        String BookName =txfNameBookInfo.getText();
        String Author =txfAuthorBookInfo.getText().toString();
        String CategogyName =cbNameCategogyBookInfo.getSelectedItem().toString();
        String PublisherBook=txfPublisherBookInfo.getText();
        int PublishingYearBook =Integer.parseInt(txfPublishingYearBookInfo.getText());
        String Brief=txaBriefBookInfo.getText();
        float Cost =Float.parseFloat(txfCostBookInfo.getText());
        int SumInventory=Integer.parseInt(txfSumInventory.getText());
        int IDBookCategogy=categogyBLL.getIDBookCategogy(CategogyName);
        if(BookName.equals("") | Author.equals("") || CategogyName.equals("") || PublisherBook.equals("") || txfPublishingYearBookInfo.equals("") ||
                txfCostBookInfo.equals("") || txfSumInventory.equals("") )
        {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập đầy đủ thông tin");
            return false;
        }
        else
        {
            BookName=chuanHoa(BookName);
            PublisherBook=chuanHoa(PublisherBook);
            Brief=chuanHoa(Brief);
            Author=chuanHoa(Author);
            if(bookbll.InsertBook(BookName, Author, PublisherBook, PublishingYearBook, Brief, Cost, SumInventory, IDBookCategogy))
            {
                JOptionPane.showMessageDialog(this,"Thêm thành thành công sách");
                return true;
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Thêm sách thất bại");
                return false;
        }      
    }
 }
    public boolean UpdateBook()
    {
        String BookName =txfNameBookInfo.getText();
        String Author =txfAuthorBookInfo.getText().toString();
        String CategogyName =cbNameCategogyBookInfo.getSelectedItem().toString();
        String PublisherBook=txfPublisherBookInfo.getText();
        int PublishingYearBook =Integer.parseInt(txfPublishingYearBookInfo.getText());
        String Brief=txaBriefBookInfo.getText();
        float Cost =Float.parseFloat(txfCostBookInfo.getText());
        int SumInventory=Integer.parseInt(txfSumInventory.getText());
        int IDBookCategogy=categogyBLL.getIDBookCategogy(CategogyName);
        int IDBookName=Integer.parseInt(txfIDBookInfo.getText());
        if(BookName.equals("") | Author.equals("") || CategogyName.equals("") || PublisherBook.equals("") || txfPublishingYearBookInfo.equals("") ||
                txfCostBookInfo.equals("") || txfSumInventory.equals("") )
        {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập đầy đủ thông tin");
            return false;
        }
        else
        {
            BookName=chuanHoa(BookName);
            PublisherBook=chuanHoa(PublisherBook);
            Brief=chuanHoa(Brief);
            Author=chuanHoa(Author);
            if(bookbll.UpdateBook(IDBookName, BookName, Author, PublisherBook, PublishingYearBook, Brief, Cost, SumInventory, IDBookCategogy))
            {
                JOptionPane.showMessageDialog(this,"Cập nhật thành công sách");
                return true;
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Cập nhật sách thất bại");
                return false;
        }

    }
    }
    public boolean InsertBookCategogy()
    {
        String NameBookCategogy=txfNameBookCategogy.getText();
        NameBookCategogy=chuanHoa(NameBookCategogy);
        if(categogyBLL.InsertBookCategogy(NameBookCategogy))
        {
            JOptionPane.showMessageDialog(this, "Thêm thành công loại sách");
            return true;
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Thêm thất bại loại sách");
            return false;
        }
    }
    public boolean UpdateBookCategpgy()
    {
        String NameBookCategogy=txfNameBookCategogy.getText();
        int IDBookCategogy=Integer.parseInt(txfIDBookCategogy.getText());
         NameBookCategogy=chuanHoa(NameBookCategogy);
        if(categogyBLL.UpdateBookCategogy(IDBookCategogy, NameBookCategogy))
        {
            JOptionPane.showMessageDialog(this, "Cập nhật thành công thể loại sách");
            return true;
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Cập nhật thất bại thể loại sách");
            return false;
        }
    }
    private void btnSaveBookInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveBookInfoActionPerformed
        // TODO add your handling code here:
        if(flag==1)
        {
            if(InsertBook()==true);
            {
                control.bindingBook(jTableBookInfo, bookbll.LoadBook());
                ClearTextBookInfo();
                btnSaveBookInfo.setEnabled(false);
            }
            btnAddBookInfo.setEnabled(true);
            btnEditBookInfo.setEnabled(true);
        }
        if(flag==2)
        {
            if(UpdateBook()==true)
            {
                control.bindingBook(jTableBookInfo, bookbll.LoadBook());
                btnSaveBookInfo.setEnabled(false);
                ClearTextBookInfo();
            }
            btnAddBookInfo.setEnabled(true);
            btnEditBookInfo.setEnabled(true);
            
        }
    }//GEN-LAST:event_btnSaveBookInfoActionPerformed

    private void btnAddBookInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddBookInfoActionPerformed
        // TODO add your handling code here:
        ClearTextBookInfo();
        jTableBookInfo.clearSelection();
        btnAddBookInfo.setEnabled(false);
        btnEditBookInfo.setEnabled(false);
        btnSaveBookInfo.setEnabled(true);
        flag=1;

    }//GEN-LAST:event_btnAddBookInfoActionPerformed

    private void jTableBookInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableBookInfoMouseClicked
        // TODO add your handling code here:
        int row=jTableBookInfo.getSelectedRow();
        txfIDBookInfo.setText(jTableBookInfo.getValueAt(row, 0).toString());
        String bookcategogy =jTableBookInfo.getValueAt(row, 1).toString();
        if(jTableBookInfo.getValueAt(row, 1).toString().equals(bookcategogy))
        cbNameCategogyBookInfo.setSelectedItem(bookcategogy);
        txfNameBookInfo.setText(jTableBookInfo.getValueAt(row, 2).toString());
        txfAuthorBookInfo.setText(jTableBookInfo.getValueAt(row, 3).toString());
        txfPublisherBookInfo.setText(jTableBookInfo.getValueAt(row, 4).toString());
        txfPublishingYearBookInfo.setText(jTableBookInfo.getValueAt(row, 5).toString());
        if(jTableBookInfo.getValueAt(row, 6)==null)
             txaBriefBookInfo.setText("");
        else
            txaBriefBookInfo.setText(jTableBookInfo.getValueAt(row, 6).toString());
        txfCostBookInfo.setText(jTableBookInfo.getValueAt(row, 7).toString());
        txfSumInventory.setText(jTableBookInfo.getValueAt(row, 8).toString());
    }//GEN-LAST:event_jTableBookInfoMouseClicked

    private void btnEditBookInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditBookInfoActionPerformed
        // TODO add your handling code here:
        btnAddBookInfo.setEnabled(false);
        btnEditBookInfo.setEnabled(false);
        btnSaveBookInfo.setEnabled(true);
        flag=2;
    }//GEN-LAST:event_btnEditBookInfoActionPerformed
    public void ClearTextBookCategogy()
    {
        txfIDBookCategogy.setText("");
        txfNameBookCategogy.setText("");
    }
    private void btnAddBookCategogyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddBookCategogyActionPerformed
        // TODO add your handling code here:
        ClearTextBookCategogy();
        btnAddBookCategogy.setEnabled(false);
        btnEditBookCategogy.setEnabled(false);
        btnSaveBookCategogy.setEnabled(true);
        flag=4;
    }//GEN-LAST:event_btnAddBookCategogyActionPerformed

    private void btnSaveBookCategogyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveBookCategogyActionPerformed
        // TODO add your handling code here:
        if(flag==4)
        {
            if(InsertBookCategogy())
            {
                btnSaveBookCategogy.setEnabled(false);
                control.bindingBookCategogy(jTableBookCategory, categogyBLL.LoadBookCategogy());
                ClearTextBookCategogy();
            }
            btnAddBookCategogy.setEnabled(true);
            btnEditBookCategogy.setEnabled(true);
            
        }
        if(flag==5)
        {
            if(UpdateBookCategpgy()==true)
            {
                btnSaveBookCategogy.setEnabled(false);
                control.bindingBookCategogy(jTableBookCategory, categogyBLL.LoadBookCategogy());
                ClearTextBookCategogy();
            }
            btnAddBookCategogy.setEnabled(true);
            btnEditBookCategogy.setEnabled(true);
            
        }
    }//GEN-LAST:event_btnSaveBookCategogyActionPerformed

    private void btnEditBookCategogyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditBookCategogyActionPerformed
        // TODO add your handling code here:
        btnAddBookCategogy.setEnabled(false);
        btnEditBookCategogy.setEnabled(false);
        btnSaveBookCategogy.setEnabled(true);
        flag=5;
    }//GEN-LAST:event_btnEditBookCategogyActionPerformed
      boolean dot = false;
    private void txfPublishingYearBookInfoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfPublishingYearBookInfoKeyTyped
        // TODO add your handling code here:
        char vChar = evt.getKeyChar();
        if (txfPublishingYearBookInfo.getText().equals(""))
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
    }//GEN-LAST:event_txfPublishingYearBookInfoKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddBookCategogy;
    private javax.swing.JButton btnAddBookInfo;
    private javax.swing.JButton btnEditBookCategogy;
    private javax.swing.JButton btnEditBookInfo;
    private javax.swing.JButton btnSaveBookCategogy;
    private javax.swing.JButton btnSaveBookInfo;
    private javax.swing.JComboBox<String> cbNameCategogyBookInfo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
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
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableBookCategory;
    private javax.swing.JTable jTableBookInfo;
    private javax.swing.JTextArea txaBriefBookInfo;
    private javax.swing.JTextField txfAuthorBookInfo;
    private javax.swing.JTextField txfCostBookInfo;
    private javax.swing.JTextField txfIDBookCategogy;
    private javax.swing.JTextField txfIDBookInfo;
    private javax.swing.JTextField txfNameBookCategogy;
    private javax.swing.JTextField txfNameBookInfo;
    private javax.swing.JTextField txfPublisherBookInfo;
    private javax.swing.JTextField txfPublishingYearBookInfo;
    private javax.swing.JTextField txfSumInventory;
    // End of variables declaration//GEN-END:variables
}
