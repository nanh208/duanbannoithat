/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import ulti.ConnectDB;  
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author Admin
 */
public class InterfaceJF extends javax.swing.JFrame {

    private String tenTaiKhoan;

    public InterfaceJF(String tenTaiKhoan) {
        this.tenTaiKhoan = tenTaiKhoan;
        initComponents();
        this.setLocationRelativeTo(null);
        jTextField1.setText(tenTaiKhoan);
        pnlMain.setLayout(new BorderLayout());
        showPanel(new DashboardJP1());
    }

    private void showPanel(JPanel panel) {
        pnlMain.removeAll();
        pnlMain.add(panel, BorderLayout.CENTER);
        pnlMain.revalidate();
        pnlMain.repaint();
    }

    private boolean connectToDB() {
        connectStatus.setText("Connecting...");
        try (Connection connect = ConnectDB.getConnect()) {
            if (connect != null) {
                connectStatus.setText("Connection successful.");
                return true;
            }
        } catch (Exception e) {
            System.out.println("Connection failed." + e);
            connectStatus.setText("Connection failed.");
            return false;
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        QLKHbtn = new javax.swing.JButton();
        btlquanlysanpham = new javax.swing.JButton();
        tblchitiensanpham = new javax.swing.JButton();
        tblloai = new javax.swing.JButton();
        tblVouchers = new javax.swing.JButton();
        tblBack = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        pnlMain = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        connectStatus = new javax.swing.JTextField();
        tblthoat1 = new javax.swing.JButton();
        QLNVbtn = new javax.swing.JButton();
        manageFurnitureBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1200, 600));
        setResizable(false);

        QLKHbtn.setText("Quản Lý Khách Hàng");
        QLKHbtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        QLKHbtn.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        QLKHbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                QLKHbtnMouseClicked(evt);
            }
        });
        QLKHbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QLKHbtnActionPerformed(evt);
            }
        });

        btlquanlysanpham.setText("Bán hàng");
        btlquanlysanpham.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btlquanlysanpham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btlquanlysanphamMouseClicked(evt);
            }
        });
        btlquanlysanpham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btlquanlysanphamActionPerformed(evt);
            }
        });

        tblchitiensanpham.setText("Chi tiết sản phẩm");
        tblchitiensanpham.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        tblchitiensanpham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblchitiensanphamMouseClicked(evt);
            }
        });
        tblchitiensanpham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tblchitiensanphamActionPerformed(evt);
            }
        });

        tblloai.setText("Loại");
        tblloai.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        tblloai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblloaiMouseClicked(evt);
            }
        });
        tblloai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tblloaiActionPerformed(evt);
            }
        });

        tblVouchers.setText("Vouchers");
        tblVouchers.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        tblVouchers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblVouchersMouseClicked(evt);
            }
        });

        tblBack.setText("BACK");
        tblBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBackMouseClicked(evt);
            }
        });
        tblBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tblBackActionPerformed(evt);
            }
        });

        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        pnlMain.setMaximumSize(new java.awt.Dimension(800, 500));
        pnlMain.setMinimumSize(new java.awt.Dimension(800, 500));
        pnlMain.setName(""); // NOI18N
        pnlMain.setPreferredSize(new java.awt.Dimension(800, 500));

        javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(pnlMain);
        pnlMain.setLayout(pnlMainLayout);
        pnlMainLayout.setHorizontalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        pnlMainLayout.setVerticalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        jLabel2.setText("Xin Chào");

        connectStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectStatusActionPerformed(evt);
            }
        });

        tblthoat1.setText("Đăng Xuất");
        tblthoat1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblthoat1MouseClicked(evt);
            }
        });
        tblthoat1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tblthoat1ActionPerformed(evt);
            }
        });

        QLNVbtn.setText("Quản Lý Nhân Viên");
        QLNVbtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        QLNVbtn.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        QLNVbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                QLNVbtnMouseClicked(evt);
            }
        });
        QLNVbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QLNVbtnActionPerformed(evt);
            }
        });

        manageFurnitureBtn.setText("Quản Lý Nội Thất");
        manageFurnitureBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        manageFurnitureBtn.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        manageFurnitureBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageFurnitureBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1)
                    .addComponent(tblVouchers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tblloai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tblchitiensanpham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btlquanlysanpham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(QLKHbtn, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addComponent(connectStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(QLNVbtn, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                    .addComponent(tblthoat1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tblBack, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(manageFurnitureBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(connectStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(btlquanlysanpham, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(QLKHbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(QLNVbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tblchitiensanpham, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tblloai, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tblVouchers, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(manageFurnitureBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tblBack)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tblthoat1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void QLKHbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_QLKHbtnMouseClicked
        boolean connectionState = connectToDB();
        if (connectionState == false) {
            JOptionPane.showMessageDialog(rootPane, "Kết nối đến dữ liệu thất bại.");
        } else {
            showPanel(new CustomerJP());
        }
    }//GEN-LAST:event_QLKHbtnMouseClicked

    private void btlquanlysanphamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btlquanlysanphamMouseClicked
        showPanel(new ProdmgmtJP());
    }//GEN-LAST:event_btlquanlysanphamMouseClicked

    private void tblchitiensanphamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblchitiensanphamMouseClicked
        showPanel(new DetailJP());
    }//GEN-LAST:event_tblchitiensanphamMouseClicked

    private void tblloaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblloaiMouseClicked
        showPanel(new TypeJP());
    }//GEN-LAST:event_tblloaiMouseClicked

    private void tblVouchersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblVouchersMouseClicked
        // TODO add your handling code here:
        boolean connectionState = connectToDB();
        if (connectionState == false) {
            JOptionPane.showMessageDialog(rootPane, "Kết nối đến dữ liệu thất bại.");
        } else {
            showPanel(new VoucherJP());
        }
    }//GEN-LAST:event_tblVouchersMouseClicked

    private void tblBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBackMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblBackMouseClicked

    private void QLKHbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QLKHbtnActionPerformed
        showPanel(new CustomerJP());
    }//GEN-LAST:event_QLKHbtnActionPerformed

    private void QLNVbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_QLNVbtnMouseClicked
        showPanel(new AccountJP());
    }//GEN-LAST:event_QLNVbtnMouseClicked

    private void QLNVbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QLNVbtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_QLNVbtnActionPerformed

    private void tblchitiensanphamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tblchitiensanphamActionPerformed
showPanel(new DetailJP());    }//GEN-LAST:event_tblchitiensanphamActionPerformed

    private void tblBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tblBackActionPerformed
        this.dispose();
        new SalesMgrJF(tenTaiKhoan).setVisible(true);
    }//GEN-LAST:event_tblBackActionPerformed

    private void tblloaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tblloaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tblloaiActionPerformed

    private void tblthoat1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblthoat1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblthoat1MouseClicked

    private void tblthoat1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tblthoat1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tblthoat1ActionPerformed

    private void btlquanlysanphamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btlquanlysanphamActionPerformed
        this.dispose(); // Đóng InterfaceJF hiện tại
        new SalesMgrJF(tenTaiKhoan).setVisible(true);
    }//GEN-LAST:event_btlquanlysanphamActionPerformed

    private void connectStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_connectStatusActionPerformed

    private void manageFurnitureBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageFurnitureBtnActionPerformed
        showPanel(new ProdmgmtJP());
    }//GEN-LAST:event_manageFurnitureBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfaceJF("Guest").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton QLKHbtn;
    private javax.swing.JButton QLNVbtn;
    private javax.swing.JButton btlquanlysanpham;
    private javax.swing.JTextField connectStatus;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton manageFurnitureBtn;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JButton tblBack;
    private javax.swing.JButton tblVouchers;
    private javax.swing.JButton tblchitiensanpham;
    private javax.swing.JButton tblloai;
    private javax.swing.JButton tblthoat1;
    // End of variables declaration//GEN-END:variables
}
