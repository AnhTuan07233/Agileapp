/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mouse.pkg1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class KhachHang extends javax.swing.JInternalFrame {

    Connection cn;

    public KhachHang() {
        initComponents();
        cn = Tienich.ketnoi();
        if (cn == null) {
            JOptionPane.showMessageDialog(this, "Lỗi load dữ liệu !");
            System.exit(0);
        }
        loaddl();
        loadCBO();
        setResizable(false);
    }

    private void loaddl() {
        Vector row = new Vector();
        Vector c = new Vector();
        try {
            Statement st = cn.createStatement();
            String sql = "Select * from Customer";
            ResultSet rs = st.executeQuery(sql);
            c.clear();
            c.add("Tên đăng nhập");
            c.add("Tên ");
            c.add("Mật khẩu");
            c.add("Giới tính");
            c.add("Sđt");
            c.add("địa chỉ");
            
            while (rs.next()) {
                Vector d = new Vector();
                d.add(rs.getString("UserCustomer"));
                d.add(rs.getString("NameCustomer"));
                d.add(rs.getString("PasswordCustomer"));             
                d.add(rs.getString("Gender"));
                d.add(rs.getString("PhoneCustomer"));
                d.add(rs.getString("AddressCustomer"));
                row.add(d);
            }

            tbl_bang.setModel(new DefaultTableModel(row, c));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi load DL");
            e.printStackTrace();
        }
    }

    public void loadCBO() {
        try {
            Statement st = cn.createStatement();
            String sql = "Select * from Customer";
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            cbo_Vt.removeAllItems();
            while (rs.next()) {
                String vt = rs.getString("Gender");
                cbo_Vt.addItem(vt);
            }
        } catch (Exception e) {

        }
    }

    boolean ck() {
      

        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_bang = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        txt_ma = new javax.swing.JTextField();
        txt_ten = new javax.swing.JTextField();
        cbo_Vt = new javax.swing.JComboBox<>();
        txt_mk = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        txtdiachi = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtphone1 = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setTitle("Customer.Mouse");
        setToolTipText("Aglige");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Khách Hàng");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel2.setText("Tên Đăng Nhập");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel3.setText("Tên Khách Hàng");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel4.setText("Mật khẩu :");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel5.setText("Giới tính");

        tbl_bang.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_bang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_bangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_bang);

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/incons/Add.png"))); // NOI18N
        jButton1.setText("Thêm ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/incons/Edit.png"))); // NOI18N
        jButton2.setText("Sửa");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/incons/Delete.png"))); // NOI18N
        jButton3.setText("Xóa");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/incons/List.png"))); // NOI18N
        jButton4.setText("Làm mới ");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        cbo_Vt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1" }));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel6.setText("Phone");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel7.setText("Địa chỉ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(200, 200, 200))
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(18, 18, 18))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(22, 22, 22)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(74, 74, 74)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jButton2)
                        .addGap(33, 33, 33)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                        .addComponent(jButton4))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(txt_ten, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel5))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txt_ma, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel4)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtphone1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel7)))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtdiachi, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbo_Vt, 0, 165, Short.MAX_VALUE)
                            .addComponent(txt_mk))))
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(txt_ma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_mk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtdiachi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(jLabel7)
                        .addComponent(txtphone1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbo_Vt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(txt_ten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jButton3)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2)
                        .addComponent(jButton4)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (ck()) {
            try {
                String sql = "INSERT INTO Customer VALUES(?,?,?,?,?,?)";
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setString(1, txt_ma.getText());
                ps.setString(2, txt_mk.getText());
                ps.setString(3, txt_ten.getText());     
                ps.setString(4, (String) cbo_Vt.getSelectedItem());
                ps.setString(5, txtphone1.getText());
                ps.setString(6, txtdiachi.getText());               
                int rs = ps.executeUpdate();
                if (rs == -1) {
                    JOptionPane.showMessageDialog(this, "Thêm thất bại");
                } else {
                    JOptionPane.showMessageDialog(this, "Thêm thành công !");
                    loaddl();
                }                                                           
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Lỗi" + e);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tbl_bangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_bangMouseClicked
        int row = tbl_bang.getSelectedRow();
        txt_ma.setText(tbl_bang.getValueAt(row, 0).toString());
        txt_ten.setText(tbl_bang.getValueAt(row, 2).toString());
        txt_mk.setText(tbl_bang.getValueAt(row, 1).toString());
        cbo_Vt.setSelectedItem(tbl_bang.getValueAt(row, 3).toString());
        txtphone1.setText(tbl_bang.getValueAt(row, 4).toString());
        txtdiachi.setText(tbl_bang.getValueAt(row, 5).toString());

    }//GEN-LAST:event_tbl_bangMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int row = tbl_bang.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn đối tượng để Sửa");
        } else {
            String sql = "Update Customer set NameCustomer = ?,PasswordCustomer = ?, "
                    + "Gender = ? , PhoneCustomer = ?,AddressCustomer = ? where UserCustomer = ? ";
            if (ck()) {
                try {
                    PreparedStatement ps = cn.prepareStatement(sql);
                    
                    ps.setString(2, txt_ten.getText());
                    ps.setString(1, txt_mk.getText());
                    ps.setString(3, (String) cbo_Vt.getSelectedItem());
                    ps.setString(4, txtphone1.getText());
                    ps.setString(5, txtdiachi.getText());
                    ps.setString(6, txt_ma.getText());
                    ps.executeUpdate();
                    loaddl();
                    JOptionPane.showMessageDialog(this, "Sửa thành công !");
                } catch (SQLException ex) {
                  
                    JOptionPane.showMessageDialog(this, "Lỗi sửa !");
                    ex.printStackTrace();
                }
            }

        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int row = tbl_bang.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn đối tượng để xóa");
        } else {
            String sql = " Delete from Customer where UserCustomer = ?";
            try {
                PreparedStatement st = cn.prepareStatement(sql);
                st.setString(1, txt_ma.getText());
                int kq = st.executeUpdate();
                if (kq == -1) {
                    JOptionPane.showMessageDialog(this, "Lỗi xóa dữ liệu");
                } else {
                    JOptionPane.showMessageDialog(this, "Xóa thành công !");
                    loaddl();
                }

            } catch (SQLException ex) {
              
                JOptionPane.showMessageDialog(this, "Lỗi xóa !");
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        txt_ma.setText("");
        txt_ten.setText("");
        txt_mk.setText("");
        txtphone1.setText("");
        txtdiachi.setText("");
        cbo_Vt.setSelectedItem(1);
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbo_Vt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_bang;
    private javax.swing.JTextField txt_ma;
    private javax.swing.JPasswordField txt_mk;
    private javax.swing.JTextField txt_ten;
    private javax.swing.JTextField txtdiachi;
    private javax.swing.JTextField txtphone1;
    // End of variables declaration//GEN-END:variables
}
