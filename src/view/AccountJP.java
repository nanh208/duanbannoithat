/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import dao.TaiKhoanNVDAO;
import entity.NhanVienEntity;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author nem mèn mén
 */
public class AccountJP extends javax.swing.JPanel {
    int row;
    TaiKhoanNVDAO dao = new TaiKhoanNVDAO();
    /**
     * Creates new form TaiKhoanNhanVien
     */
    public AccountJP() {
        initComponents();
        fillTable();
        resetSearch();
        JLabel lbl = new JLabel("Đây là giao diện quản lý nhân viên");
        add(lbl);
    }
    public void fillTable() {
    DefaultTableModel model = (DefaultTableModel) tblNhanVien.getModel();
    model.setRowCount(0); 

    for (NhanVienEntity nv : dao.getAll()) {
        Object row[] = {
            nv.getTenTK(),    
            nv.getMaTK(),      
            nv.getEmail(),      
            nv.getSdt(),        
            nv.getNamSinh(),    
            nv.getPassword(),   
            nv.getPermission()  
        };
        model.addRow(row);
    }
    tblNhanVien.setModel(model);
    }
    public NhanVienEntity getNhanVien() {
    try {
        long maTK = 1;
        if (!txtMaTK.getText().trim().isEmpty()) {
            maTK = Long.parseLong(txtMaTK.getText().trim());
        }

        String tenTK = txtTenTK.getText().trim();
        String email = txtEmail.getText().trim();
        String password = txtPassword.getText().trim();

        int sdt;
        try {
            sdt = Integer.parseInt(txtSDT.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Số điện thoại không hợp lệ (phải là số nguyên)");
            return null;
        }

        String strNgaySinh = txtNamSinh.getText().trim();
        String permission = rdoNhanVien.isSelected() ? "Nhân Viên" : "Quản Lý";

        if (!strNgaySinh.matches("^\\d{4}-\\d{2}-\\d{2}$")) {
    JOptionPane.showMessageDialog(null, "Ngày sinh không đúng định dạng (yyyy-MM-dd)");
    return null;
}

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date namSinh = sdf.parse(strNgaySinh);

        return new NhanVienEntity(maTK, password, tenTK, email, permission, sdt, namSinh);

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Mã tài khoản không hợp lệ");
        return null;
    } catch (ParseException e) {
        JOptionPane.showMessageDialog(null, "Lỗi định dạng ngày sinh");
        return null;
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Lỗi không xác định: " + e.getMessage());
        return null;
    }
}
    
    public void setNhanVien(NhanVienEntity nv) {
    txtMaTK.setText(String.valueOf(nv.getMaTK()));
    txtTenTK.setText(nv.getTenTK());
    txtEmail.setText(nv.getEmail());
    txtPassword.setText(nv.getPassword());
    txtSDT.setText(String.valueOf(nv.getSdt()));

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    txtNamSinh.setText(sdf.format(nv.getNamSinh()));

    if ("Nhân Viên".equalsIgnoreCase(nv.getPermission())) {
        rdoNhanVien.setSelected(true);
    } else {
        rdoQuanLy.setSelected(true);
    }
}
    
    public boolean kiemTraTrungEmailPasswordSDT(String email, String password, int sdt) {
    boolean emailTrung = false;
    boolean passwordTrung = false;
    boolean sdtTrung = false;

    List<NhanVienEntity> listNV = dao.getAll();

    for (NhanVienEntity nv : listNV) {
        if (nv.getEmail().equalsIgnoreCase(email)) {
            emailTrung = true;
        }
        if (nv.getPassword().equals(password)) {
            passwordTrung = true;
        }
        if (nv.getSdt() == sdt) {
            sdtTrung = true;
        }
    }

    if (emailTrung && passwordTrung && sdtTrung) {
        JOptionPane.showMessageDialog(null, "Email, mật khẩu và số điện thoại đã tồn tại!");
        return true; 
    } else if (emailTrung && passwordTrung) {
        JOptionPane.showMessageDialog(null, "Email và mật khẩu đã tồn tại!");
        return true;
    } else if (emailTrung && sdtTrung) {
        JOptionPane.showMessageDialog(null, "Email và số điện thoại đã tồn tại!");
        return true;
    } else if (passwordTrung && sdtTrung) {
        JOptionPane.showMessageDialog(null, "Mật khẩu và số điện thoại đã tồn tại!");
        return true;
    } else if (emailTrung) {
        JOptionPane.showMessageDialog(null, "Email đã tồn tại!");
        return true;
    } else if (passwordTrung) {
        JOptionPane.showMessageDialog(null, "Mật khẩu đã tồn tại!");
        return true;
    } else if (sdtTrung) {
        JOptionPane.showMessageDialog(null, "Số điện thoại đã tồn tại!");
        return true;
    }

    return false; // không trùng, cho phép thêm
}
    public void resetSearch(){
        txtTimkiem.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                timKiem();
            }

            public void removeUpdate(DocumentEvent e) {
                timKiem();
            }

            public void insertUpdate(DocumentEvent e) {
                timKiem();
            }

            public void timKiem() {
                String tuKhoa = txtTimkiem.getText().trim();
                DefaultTableModel model = (DefaultTableModel) tblNhanVien.getModel();
                TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
                tblNhanVien.setRowSorter(sorter);

                if (tuKhoa.isEmpty()) {
                    sorter.setRowFilter(null);
                } else {
                    sorter.setRowFilter(RowFilter.regexFilter("(?i)" + tuKhoa));
                }
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtMaTK = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNamSinh = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        rdoNhanVien = new javax.swing.JRadioButton();
        rdoQuanLy = new javax.swing.JRadioButton();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNhanVien = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        txtTenTK = new javax.swing.JTextField();
        txtTimkiem = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(800, 500));
        setMinimumSize(new java.awt.Dimension(800, 500));
        setPreferredSize(new java.awt.Dimension(800, 600));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Q.L. Tài Khoản Nhân Viên");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Mã Tài Khoàn");

        txtMaTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaTKActionPerformed(evt);
            }
        });

        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Email");

        txtSDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSDTActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Số Điện Thoại");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Năm Sinh");

        txtNamSinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamSinhActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Mật Khẩu");

        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Quyền");

        buttonGroup1.add(rdoNhanVien);
        rdoNhanVien.setText("Nhân Viên");
        rdoNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoNhanVienActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoQuanLy);
        rdoQuanLy.setText("Quản Lý");

        btnThem.setBackground(new java.awt.Color(0, 204, 0));
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(204, 0, 0));
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        tblNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Tên", "Mã TK", "Email", "SDT", "Năm Sinh", "Mật Khẩu", "Quyền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNhanVienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblNhanVien);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Tên Tài Khoản");

        txtTenTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenTKActionPerformed(evt);
            }
        });

        jLabel9.setText("TÌm kiếm");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(16, 16, 16))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaTK, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(txtNamSinh, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rdoNhanVien)
                                .addGap(18, 18, 18)
                                .addComponent(rdoQuanLy))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnXoa)
                                .addGap(18, 18, 18)
                                .addComponent(btnSua)
                                .addGap(18, 18, 18)
                                .addComponent(btnThem))
                            .addComponent(jLabel8)
                            .addComponent(txtTenTK, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtMaTK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTenTK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNamSinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(rdoNhanVien)
                            .addComponent(rdoQuanLy))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(119, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtMaTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaTKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaTKActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void txtSDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSDTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSDTActionPerformed

    private void txtNamSinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamSinhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamSinhActionPerformed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void rdoNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoNhanVienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoNhanVienActionPerformed

    private void txtTenTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenTKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenTKActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
       NhanVienEntity nv = getNhanVien();
if (nv == null) return; // lỗi nhập ngày hoặc sdt sai

if (!kiemTraTrungEmailPasswordSDT(nv.getEmail(), nv.getPassword(), nv.getSdt())) {
    dao.insert(nv);
    JOptionPane.showMessageDialog(null, "Thêm nhân viên thành công!");
    fillTable();
} else {
    // Bị trùng nên không thêm
}
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        NhanVienEntity nv = this.getNhanVien();
    if (nv != null) {
        this.dao.update(nv); 
        JOptionPane.showMessageDialog(btnSua, "Cập nhật tài khoản nhân viên thành công");
        fillTable(); 
    }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
         try {
        if (!txtMaTK.getText().trim().isEmpty()) {
            long maTK = Long.parseLong(txtMaTK.getText().trim());

            int confirm = JOptionPane.showConfirmDialog(
                this, "Bạn có chắc muốn xóa tài khoản này?", "Xác nhận", JOptionPane.YES_NO_OPTION
            );

            if (confirm == JOptionPane.YES_OPTION) {
                this.dao.delete(maTK); // Gọi DAO xóa theo mã
                JOptionPane.showMessageDialog(btnXoa, "Xóa tài khoản nhân viên thành công");
                fillTable(); 
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn tài khoản để xóa");
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Mã tài khoản không hợp lệ");
    }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void tblNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanVienMouseClicked
this.row = tblNhanVien.getSelectedRow();
    String tenTK = String.valueOf(tblNhanVien.getValueAt(this.row, 0));
    String maTK = String.valueOf(tblNhanVien.getValueAt(this.row, 1));
    String email = String.valueOf(tblNhanVien.getValueAt(this.row, 2));
    String sdt = String.valueOf(tblNhanVien.getValueAt(this.row, 3));
    String namSinhStr = String.valueOf(tblNhanVien.getValueAt(this.row, 4));
    String password = String.valueOf(tblNhanVien.getValueAt(this.row, 5));
    String permission = String.valueOf(tblNhanVien.getValueAt(this.row, 6));

    Date namSinh = null;
    try {
        namSinh = new SimpleDateFormat("yyyy-MM-dd").parse(namSinhStr);
    } catch (ParseException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Ngày sinh không hợp lệ!");
        return; // tránh lỗi tiếp tục khi ngày sai
    }

    NhanVienEntity nv = new NhanVienEntity(
        Long.parseLong(maTK),
        password,
        tenTK,
        email,
        permission,
        Integer.parseInt(sdt),
        namSinh
    );
    this.setNhanVien(nv);
    }//GEN-LAST:event_tblNhanVienMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdoNhanVien;
    private javax.swing.JRadioButton rdoQuanLy;
    private javax.swing.JTable tblNhanVien;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMaTK;
    private javax.swing.JTextField txtNamSinh;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenTK;
    private javax.swing.JTextField txtTimkiem;
    // End of variables declaration//GEN-END:variables
}
