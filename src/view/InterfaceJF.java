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

    public InterfaceJF() {
        initComponents();
        pnlMain.setLayout(new BorderLayout());

    }

    private void showPanel(JPanel panel) {
        pnlMain.removeAll();
        pnlMain.add(panel, BorderLayout.CENTER);
        pnlMain.setLayout(new BorderLayout());
        pnlMain.revalidate();
        pnlMain.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
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
        tblkhohang = new javax.swing.JButton();
        tblthoat = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        pnlMain = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        QLNVbtn = new javax.swing.JButton();
        connectStatus = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 600));
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

        btlquanlysanpham.setText("Quản ly sản phẩm");
        btlquanlysanpham.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btlquanlysanpham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btlquanlysanphamMouseClicked(evt);
            }
        });

        tblchitiensanpham.setText("Chi tiết sản phẩm");
        tblchitiensanpham.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        tblchitiensanpham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblchitiensanphamMouseClicked(evt);
            }
        });

        tblloai.setText("Loại");
        tblloai.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        tblloai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblloaiMouseClicked(evt);
            }
        });

        tblVouchers.setText("Vouchers");
        tblVouchers.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        tblVouchers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblVouchersMouseClicked(evt);
            }
        });

        tblkhohang.setText("Kho hàng");
        tblkhohang.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        tblkhohang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblkhohangMouseClicked(evt);
            }
        });

        tblthoat.setText("Đăng Xuất");
        tblthoat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblthoatMouseClicked(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1)
                    .addComponent(tblkhohang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tblVouchers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tblloai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tblchitiensanpham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btlquanlysanpham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(QLKHbtn, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                    .addComponent(QLNVbtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(connectStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tblthoat)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(connectStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(QLNVbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(QLKHbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btlquanlysanpham, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tblchitiensanpham, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tblloai, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tblVouchers, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tblkhohang, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tblthoat))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnlMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void QLKHbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_QLKHbtnMouseClicked
        boolean connectionState = connectToDB();
        if (connectionState == false) {
            JOptionPane.showMessageDialog(rootPane, "Kết nối đến dữ liệu thất bại.");
        }
        else {
            showPanel(new CustomerJP());
        }
    }//GEN-LAST:event_QLKHbtnMouseClicked

    private void btlquanlysanphamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btlquanlysanphamMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btlquanlysanphamMouseClicked

    private void tblchitiensanphamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblchitiensanphamMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblchitiensanphamMouseClicked

    private void tblloaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblloaiMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblloaiMouseClicked

    private void tblVouchersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblVouchersMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblVouchersMouseClicked

    private void tblkhohangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblkhohangMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblkhohangMouseClicked

    private void tblthoatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblthoatMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblthoatMouseClicked

    private void QLKHbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QLKHbtnActionPerformed

    }//GEN-LAST:event_QLKHbtnActionPerformed

    private void QLNVbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_QLNVbtnMouseClicked
        showPanel(new AccountJP());
    }//GEN-LAST:event_QLNVbtnMouseClicked

    private void QLNVbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QLNVbtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_QLNVbtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InterfaceJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfaceJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfaceJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfaceJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfaceJF().setVisible(true);
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
    private javax.swing.JPanel pnlMain;
    private javax.swing.JButton tblVouchers;
    private javax.swing.JButton tblchitiensanpham;
    private javax.swing.JButton tblkhohang;
    private javax.swing.JButton tblloai;
    private javax.swing.JButton tblthoat;
    // End of variables declaration//GEN-END:variables
}
