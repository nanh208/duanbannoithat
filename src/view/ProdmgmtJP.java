/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import entity.*;
import dao.*;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;

/**
 *
 * @author meoba
 */
public class ProdmgmtJP extends javax.swing.JPanel {
    ProductDAO PDAO = new ProductDAO();
    LoaiDAO LDAO = new LoaiDAO();
    List<productEntity> listP = PDAO.getAllProducts();
    public ProdmgmtJP() {
        initComponents();
        JLabel lbl = new JLabel("Đây là giao diện quản lý nhân viên");
        add(lbl);
        this.listItems();
        resetSearch();
        this.listTypes();
        
    }

    public void listItems() {
        DefaultTableModel model1 = (DefaultTableModel) tblNoiThat.getModel();
        model1.setRowCount(0);
        for (productEntity product : PDAO.getAllProducts()) {
            Object[] data = {product.getID(), product.getName(), product.getType(), product.getDesc(), product.getPrice()};
            model1.addRow(data);
        }
        tblNoiThat.setModel(model1);
    }

    public void listTypes() {
        DefaultComboBoxModel model1 = (DefaultComboBoxModel) cbLoai.getModel();
        model1.removeAllElements();
        for (LoaiEntity1 type : LDAO.getAll()) {
            Object data = String.valueOf(type.getTen());
            model1.addElement(data);
        }
        cbLoai.setModel(model1);
    }

    public void showItems(int index) {
        txtMaNT.setText(String.valueOf(tblNoiThat.getValueAt(index, 0)));
        txtTenNT.setText(String.valueOf(tblNoiThat.getValueAt(index, 1)));
        cbLoai.setSelectedItem(String.valueOf(tblNoiThat.getValueAt(index, 2)));
        txtMota.setText(String.valueOf(tblNoiThat.getValueAt(index, 3)));
        txtGia.setText(String.valueOf(tblNoiThat.getValueAt(index, 4)));
    }

    public void updateItem() {
        long ID = Long.parseLong(txtMaNT.getText());
        LoaiEntity1 type = LDAO.getByName(cbLoai.getSelectedItem().toString());
        long typeID = type.getMaLoai();
        String desc = txtMota.getText();
        int price = Integer.parseInt(txtGia.getText());
        String name = txtTenNT.getText();
        productEntity product = new productEntity(ID, typeID, name, desc, price);

        int choice = JOptionPane.showConfirmDialog(null, "Bạn có muốn cập nhật cho " + name + " không?", "Cập nhật sản phẩm", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            PDAO.updateProduct(product);
            JOptionPane.showMessageDialog(null, "Cập nhật thành công.");
        }
    }

    public void addItem() {
        int option = JOptionPane.showConfirmDialog(null, "Thêm " + txtTenNT.getText() + "?", "Thêm nội thất", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            LoaiEntity1 type = LDAO.getByName(cbLoai.getSelectedItem().toString());
            long typeID = type.getMaLoai();
            String desc = txtMota.getText();
            int price = Integer.parseInt(txtGia.getText());
            String name = txtTenNT.getText();
            productEntity product = new productEntity(typeID, name, desc, price);
            PDAO.addProduct(product);
            JOptionPane.showMessageDialog(null, "Thêm nội thất thành công.");
        }
        listItems();
        
    }

    public void delItem(long ID) {

        int choice = JOptionPane.showConfirmDialog(null, "Bạn có muốn xoá không?", "Xoá nội thất", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            PDAO.deleteProduct(ID);
            JOptionPane.showMessageDialog(null, "Nội thất xoá thành công.");
        } else {
            JOptionPane.showMessageDialog(null, "Nội thất đã không xoá.");
        }
    }
    private void timKiem() {
    String tuKhoa = txtTimkiem.getText().trim().toLowerCase();
    DefaultTableModel model = (DefaultTableModel) tblNoiThat.getModel();
    model.setRowCount(0); 

    for (productEntity Pro : listP) {
        String maSP = String.valueOf(Pro.getID());
        String tenSP = Pro.getName().toLowerCase();

        if (tuKhoa.isEmpty() || maSP.contains(tuKhoa) || tenSP.contains(tuKhoa)) {
            model.addRow(new Object[]{
                Pro.getID(),
                Pro.getName(),
                Pro.getType(),
                Pro.getDesc(),
                Pro.getPrice()
            });
        }
    }
}
               private void resetSearch() {
    txtTimkiem.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
        @Override
        public void insertUpdate(DocumentEvent e) {
            timKiem();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            timKiem();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            timKiem();
        }
    });
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
        txtMaNT = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNoiThat = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTenNT = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtMota = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtGia = new javax.swing.JTextField();
        btnSua = new javax.swing.JButton();
        cbLoai = new javax.swing.JComboBox<>();
        txtTimkiem = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(800, 500));
        setMinimumSize(new java.awt.Dimension(800, 500));
        setPreferredSize(new java.awt.Dimension(800, 500));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Mã nội thất");

        txtMaNT.setEditable(false);
        txtMaNT.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        btnThem.setBackground(new java.awt.Color(0, 204, 0));
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(204, 0, 0));
        btnXoa.setText("Xoá");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        tblNoiThat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Nội Thất", "Tên Nội Thất", "Tên Loại", "Mô Tả", "Giá"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblNoiThat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNoiThatMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblNoiThat);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Quản Lý Nội Thất");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Tên Nội Thất");

        txtTenNT.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Tên Loại");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Mô Tả");

        txtMota.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Giá");

        txtGia.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        jLabel7.setText("Tìm kiếm");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtMaNT, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtTenNT, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                                        .addComponent(cbLoai, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnXoa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSua)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(txtMota, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel2)
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtMaNT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTenNT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cbLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtMota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnThem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        addItem();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int index = tblNoiThat.getSelectedRow();
        if (index != -1) {
            long ID = Long.parseLong(tblNoiThat.getValueAt(index, 0).toString());
            delItem(ID);
        }
        else {
            JOptionPane.showMessageDialog(null, "Xin hãy chọn nội thất ở bảng bên dưới.");
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        updateItem();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void tblNoiThatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNoiThatMouseClicked
        int index = tblNoiThat.getSelectedRow();
        showItems(index);
    }//GEN-LAST:event_tblNoiThatMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbLoai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblNoiThat;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtMaNT;
    private javax.swing.JTextField txtMota;
    private javax.swing.JTextField txtTenNT;
    private javax.swing.JTextField txtTimkiem;
    // End of variables declaration//GEN-END:variables
}
