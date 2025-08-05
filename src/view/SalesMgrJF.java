/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import view.InterfaceJF;
import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import entity.*;
import dao.*;
import java.util.*;

public class SalesMgrJF extends javax.swing.JFrame {

    private String username;
    private String tenTaiKhoan;

    private ReceiptDAO RDAO = new ReceiptDAO();
    private KhachHangdao_1 KDAO = new KhachHangdao_1();
    private ProductDAO PDAO = new ProductDAO();
    private TaiKhoanNVDAO NDAO = new TaiKhoanNVDAO();
    private TaiKhoanDAO NDAO2 = new TaiKhoanDAO();
    private VoucherDao VDAO = new VoucherDao();

    receiptMenu menu = new receiptMenu(this);

    public ReceiptDAO getRDAO() {
        return RDAO;
    }

    public VoucherDao getVDAO() {
        return VDAO;
    }

    public void refreshDetail(long ID) {
        DefaultTableModel shopList = (DefaultTableModel) cartList.getModel();
        shopList.setRowCount(0);
        for (receiptEntitiesA receiptA : RDAO.getSpecifics(ID)) {
            productEntity product = PDAO.getProductByID(ID);
            Object[] dataRA = {receiptA.getFurnitureID(), product.getName(), receiptA.getAmount(), receiptA.getPrice()};
            shopList.addRow(dataRA);
        }
        cartList.setModel(shopList);
    }

    public void loadDetail(long receiptAID) {
        DefaultTableModel shopList = (DefaultTableModel) cartList.getModel();
        
        shopList.setRowCount(0);
        for (receiptEntitiesA receiptA : RDAO.getSpecifics(receiptAID)) {
            productEntity product = PDAO.getProductByID(receiptAID);
            Object[] dataA = {receiptA.getFurnitureID(), product.getName(), receiptA.getAmount(), receiptA.getPrice()};
            shopList.addRow(dataA);
        }
    }

    public void loadAllat() {
        DefaultTableModel waitList = (DefaultTableModel) waitingList.getModel();
        DefaultTableModel custList = (DefaultTableModel) customerList.getModel();
        DefaultTableModel prodList = (DefaultTableModel) productList.getModel();

        waitList.setRowCount(0);
        custList.setRowCount(0);
        prodList.setRowCount(0);

        for (receiptEntities receipt : RDAO.getAllat()) {
            Object[] dataR = {receipt.getID(), receipt.getDatetime(), receipt.isStatus() ? "Đã thanh toán" : "Chưa thanh toán"};
            waitList.addRow(dataR);
        }
        for (KhachHangEntity customer : KDAO.getAll()) {
            Object[] dataC = {customer.getTenKH(), customer.getSdt()};
            custList.addRow(dataC);
        }
        for (productEntity product : PDAO.getAllProducts()) {
            Object[] dataP = {product.getID(), product.getName(), product.getType(), product.getDesc(), product.getPrice()};
            prodList.addRow(dataP);
        }
        waitingList.setModel(waitList);
        customerList.setModel(custList);
        productList.setModel(prodList);
    }

    public SalesMgrJF(String username) {
        initComponents();
        this.loadAllat();
        setLocationRelativeTo(null);
        this.username = username;
        searchField.setText(tenTaiKhoan);
        displayUsername.setText(username);
    }

    private void showPnl(JPanel panel) {
        receiptPanel.removeAll();
        receiptPanel.add(panel, BorderLayout.CENTER);
        receiptPanel.revalidate();
        receiptPanel.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        interfaceButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        waitingList = new javax.swing.JTable();
        newReceipt = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        productList = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        customerList = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        cartList = new javax.swing.JTable();
        refreshButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        receiptPanel = new javax.swing.JPanel();
        searchField = new javax.swing.JTextField();
        findButton = new javax.swing.JButton();
        displayUsername = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        detailedID = new javax.swing.JLabel();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("[The Stone] Sales Manager");
        setBackground(new java.awt.Color(51, 51, 51));
        setForeground(new java.awt.Color(51, 51, 51));
        setMinimumSize(new java.awt.Dimension(1280, 800));
        setResizable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Sales Manager");

        interfaceButton.setText("Quản lý phần khác");
        interfaceButton.setBorder(new javax.swing.border.MatteBorder(null));
        interfaceButton.setBorderPainted(false);
        interfaceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                interfaceButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("Hoá Đơn Chờ");

        waitingList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã HD", "Ngày Lập", "T. Thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        waitingList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                waitingListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(waitingList);

        newReceipt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        newReceipt.setText("Tạo hoá đơn mới");
        newReceipt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newReceiptActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setText("Sản Phẩm");

        productList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã", "Tên", "Mã Loại", "Mô Tả", "Giá"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(productList);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4.setText("Khách Hàng");

        customerList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên", "Số Điện Thoại"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(customerList);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel5.setText("Chi Tiết Hoá Đơn");

        cartList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã NT", "Tên NT", "S. Lượng", "Thành Tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(cartList);

        refreshButton.setText("Làm Mới");

        addButton.setText("Thêm");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        receiptPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        receiptPanel.setMaximumSize(new java.awt.Dimension(390, 680));
        receiptPanel.setMinimumSize(new java.awt.Dimension(390, 680));
        receiptPanel.setPreferredSize(new java.awt.Dimension(390, 680));
        receiptPanel.setLayout(new java.awt.BorderLayout());

        findButton.setText("Tìm");
        findButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findButtonActionPerformed(evt);
            }
        });

        displayUsername.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jLabel6.setText("ID:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(28, 28, 28)
                        .addComponent(displayUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(newReceipt, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(349, 349, 349)
                        .addComponent(interfaceButton, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(detailedID, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(findButton, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(refreshButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(receiptPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addComponent(jSeparator1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(interfaceButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(displayUsername, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(newReceipt)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(detailedID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5)
                                .addComponent(jLabel6)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(refreshButton)
                                    .addComponent(addButton)
                                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(findButton)
                                    .addComponent(jLabel3))
                                .addGap(11, 11, 11)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)))
                    .addComponent(receiptPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 678, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void findButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_findButtonActionPerformed

    private void newReceiptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newReceiptActionPerformed
        long accountID = NDAO2.getAccountID(username);
        RDAO.createReceipt(0, accountID); //debug
        this.loadAllat();
    }//GEN-LAST:event_newReceiptActionPerformed

    private void interfaceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_interfaceButtonActionPerformed
        InterfaceJF next = new InterfaceJF(username); // truyền username vào constructor
        next.setVisible(true);                 // hiển thị
        this.dispose();
    }//GEN-LAST:event_interfaceButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        int index = productList.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(null, "Hãy chọn một nội thất trước khi bạn thêm nó vào hoá đơn nhé.");
        } else {
            String input = JOptionPane.showInputDialog(null, "Hãy nhập số lượng bạn muốn thêm cho " + productList.getValueAt(index, 1), "Thêm", JOptionPane.QUESTION_MESSAGE);
            if (input == null) {
                JOptionPane.showMessageDialog(null, "Nội thất đã không được cho thêm.");
            }
            input = input.trim();
            if (input.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Số lượng không thể rỗng.");
            }

            try {
                int quantity = Integer.parseInt(input);
                if (quantity <= 0) {
                    JOptionPane.showMessageDialog(null, "Lỗi, số lượng phải là số dương (+)");
                } else {
                    long receiptID = 0; //Temporary
                    long productID = Long.parseLong(productList.getValueAt(index, 0).toString());
                    int price = Integer.parseInt(productList.getValueAt(index, 4).toString()) * quantity;

                    RDAO.addItemRA(receiptID, productID, quantity, price);
                    this.refreshDetail(receiptID);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Không đúng loại số, hãy nhập loại số hợp lệ.");
            }
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void waitingListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_waitingListMouseClicked
        int selection = waitingList.getSelectedRow();
        if (selection != -1) {
            long receiptID = Long.parseLong(waitingList.getValueAt(selection, 0).toString());

            receiptMenu newMenu = new receiptMenu(this); // create and store reference
            newMenu.displayData(receiptID);              // populate data BEFORE showing
            showPnl(newMenu);                            // then show it
            loadDetail(receiptID);
        }
        
    }//GEN-LAST:event_waitingListMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new SalesMgrJF("Guest").setVisible(true));

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JTable cartList;
    private javax.swing.JTable customerList;
    private javax.swing.JLabel detailedID;
    private javax.swing.JLabel displayUsername;
    private javax.swing.JButton findButton;
    private javax.swing.JButton interfaceButton;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton newReceipt;
    private javax.swing.JTable productList;
    private javax.swing.JPanel receiptPanel;
    private javax.swing.JButton refreshButton;
    private javax.swing.JTextField searchField;
    private javax.swing.JTable waitingList;
    // End of variables declaration//GEN-END:variables
}
