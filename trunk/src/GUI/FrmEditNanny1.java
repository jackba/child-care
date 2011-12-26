/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FrmEditNanny1.java
 *
 * Created on Nov 27, 2011, 10:52:18 PM
 */
package GUI;

import DAO.Connect;
import DatabaseAccess.quanLyBaoMau;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Dell
 */
public class FrmEditNanny1 extends javax.swing.JFrame {

    Connect connect = new Connect();
    Connection conn;
    ResultSet rs;
    PreparedStatement pstmt;
    quanLyBaoMau nhap = new quanLyBaoMau();

    /** Creates new form FrmEditNanny1 */
    public FrmEditNanny1() {
        initComponents();
        fillDataEditNanny();
    }

    private void fillDataEditNanny() {
        try {

            conn = connect.getConnection();
            String strSql = "select NannyID,Name,DateOfBirth,Address,ContactNumber,ChargePaidToHer,WorkingHours from tblNanny where NannyID=?";
            pstmt = conn.prepareStatement(strSql);
            pstmt.setString(1, FrmQuanLyBaoMau1.NannyIDE);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                txtNannyID.setText(rs.getString(1));
                txtName.setText(rs.getString(2));
                txtBirthday.setDate(rs.getDate(3));
                txtAddress.setText(rs.getString(4));
                txtContactNumber.setText(rs.getString(5));
                txtCharge.setText(rs.getString(6));
                txtWorkingHours.setText(rs.getString(7));
            }
            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error:" + ex.getMessage());
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnSave = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        txtName = new javax.swing.JTextField();
        txtBirthday = new com.toedter.calendar.JDateChooser();
        txtAddress = new javax.swing.JTextField();
        txtContactNumber = new javax.swing.JTextField();
        txtCharge = new javax.swing.JTextField();
        txtWorkingHours = new javax.swing.JTextField();
        lblName = new javax.swing.JLabel();
        lblBirthday = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        lblContacNumber = new javax.swing.JLabel();
        lblCharge = new javax.swing.JLabel();
        lblWorkingHours = new javax.swing.JLabel();
        lblNannyID = new javax.swing.JLabel();
        txtNannyID = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Edit Nanny");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnSave.setFont(new java.awt.Font("Tahoma", 0, 12));
        btnSave.setForeground(new java.awt.Color(0, 0, 204));
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/save1.png"))); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnReset.setFont(new java.awt.Font("Tahoma", 0, 12));
        btnReset.setForeground(new java.awt.Color(0, 0, 204));
        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/reset.png"))); // NOI18N
        btnReset.setText("Reset");
        btnReset.setPreferredSize(new java.awt.Dimension(87, 31));
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnClose.setFont(new java.awt.Font("Tahoma", 0, 12));
        btnClose.setForeground(new java.awt.Color(0, 0, 204));
        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/close2.png"))); // NOI18N
        btnClose.setText("Close");
        btnClose.setPreferredSize(new java.awt.Dimension(87, 31));
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        txtName.setFont(new java.awt.Font("Tahoma", 0, 14));
        txtName.setForeground(new java.awt.Color(0, 0, 204));

        txtBirthday.setForeground(new java.awt.Color(0, 0, 204));
        txtBirthday.setDateFormatString("MMMM/dd/yyyy");

        txtAddress.setFont(new java.awt.Font("Tahoma", 0, 14));
        txtAddress.setForeground(new java.awt.Color(0, 0, 204));

        txtContactNumber.setFont(new java.awt.Font("Tahoma", 0, 14));
        txtContactNumber.setForeground(new java.awt.Color(0, 0, 204));

        txtCharge.setFont(new java.awt.Font("Tahoma", 0, 14));
        txtCharge.setForeground(new java.awt.Color(0, 0, 204));
        txtCharge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtChargeActionPerformed(evt);
            }
        });

        txtWorkingHours.setFont(new java.awt.Font("Tahoma", 0, 14));
        txtWorkingHours.setForeground(new java.awt.Color(0, 0, 204));
        txtWorkingHours.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtWorkingHoursActionPerformed(evt);
            }
        });

        lblName.setFont(new java.awt.Font("Tahoma", 0, 14));
        lblName.setForeground(new java.awt.Color(0, 0, 204));
        lblName.setText("Name");

        lblBirthday.setFont(new java.awt.Font("Tahoma", 0, 14));
        lblBirthday.setForeground(new java.awt.Color(0, 0, 204));
        lblBirthday.setText("Birthday");

        lblAddress.setFont(new java.awt.Font("Tahoma", 0, 14));
        lblAddress.setForeground(new java.awt.Color(0, 0, 204));
        lblAddress.setText("Address");

        lblContacNumber.setFont(new java.awt.Font("Tahoma", 0, 14));
        lblContacNumber.setForeground(new java.awt.Color(0, 0, 204));
        lblContacNumber.setText("Contact Number");

        lblCharge.setFont(new java.awt.Font("Tahoma", 0, 14));
        lblCharge.setForeground(new java.awt.Color(0, 0, 204));
        lblCharge.setText("Charge");

        lblWorkingHours.setFont(new java.awt.Font("Tahoma", 0, 14));
        lblWorkingHours.setForeground(new java.awt.Color(0, 0, 204));
        lblWorkingHours.setText("WorkingHours");

        lblNannyID.setFont(new java.awt.Font("Tahoma", 0, 14));
        lblNannyID.setForeground(new java.awt.Color(0, 0, 204));
        lblNannyID.setText("NannyID");

        txtNannyID.setFont(new java.awt.Font("Tahoma", 0, 14));
        txtNannyID.setForeground(new java.awt.Color(0, 0, 204));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblName)
                    .addComponent(lblNannyID)
                    .addComponent(lblBirthday)
                    .addComponent(lblAddress))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                    .addComponent(txtNannyID, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                    .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                    .addComponent(txtBirthday, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblContacNumber)
                    .addComponent(lblCharge)
                    .addComponent(lblWorkingHours))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtWorkingHours, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                    .addComponent(txtCharge, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                    .addComponent(txtContactNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE))
                .addGap(20, 20, 20))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addComponent(btnSave)
                .addGap(18, 18, 18)
                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(124, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNannyID)
                    .addComponent(txtNannyID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblContacNumber)
                    .addComponent(txtContactNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblName)
                    .addComponent(lblCharge)
                    .addComponent(txtCharge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblBirthday)
                        .addGap(18, 18, 18)
                        .addComponent(lblAddress))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblWorkingHours)
                                .addComponent(txtWorkingHours, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtBirthday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36));
        jLabel1.setForeground(new java.awt.Color(204, 0, 0));
        jLabel1.setText("Edit Nanny");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(229, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(199, 199, 199))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-643)/2, (screenSize.height-398)/2, 643, 398);
    }// </editor-fold>//GEN-END:initComponents

private void txtWorkingHoursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtWorkingHoursActionPerformed
    // TODO add your handling code here:
}//GEN-LAST:event_txtWorkingHoursActionPerformed

private void txtChargeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtChargeActionPerformed
    // TODO add your handling code here:
}//GEN-LAST:event_txtChargeActionPerformed

private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
    this.dispose();
}//GEN-LAST:event_btnCloseActionPerformed

private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
    txtAddress.setText("");
    txtBirthday.setDate(null);
    txtName.setText("");
    txtContactNumber.setText("");
    txtWorkingHours.setText("");
    txtCharge.setText("");
}//GEN-LAST:event_btnResetActionPerformed

private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
    if (txtNannyID.getText().equals("")) {
        JOptionPane.showMessageDialog(this, "Please,Enter NannyID");
        txtNannyID.requestFocus();
        return;
    }
    if (txtName.getText().equals("")) {
        JOptionPane.showMessageDialog(this, "Please,Enter Name");
        txtName.requestFocus();
        return;
    }
    if (txtAddress.getText().equals("")) {
        JOptionPane.showMessageDialog(this, "Please,Enter Address");
        txtAddress.requestFocus();
        return;
    }
    if (txtContactNumber.getText().equals("")) {
        JOptionPane.showMessageDialog(this, "Please,Enter PhoneNumber");
        txtContactNumber.requestFocus();
        return;
    }

    if (txtContactNumber.getText().equals("")) {
        JOptionPane.showMessageDialog(this, "Contact NumBer must Number");
        txtContactNumber.requestFocus();
        return;
    }
    if (txtCharge.getText().equals("")) {
        JOptionPane.showMessageDialog(this, "Please,Enter Charge");
        txtCharge.requestFocus();
        return;
    }
    if (txtWorkingHours.getText().equals("")) {
        JOptionPane.showMessageDialog(this, "Please,Enter WorkingHours");
        txtWorkingHours.requestFocus();
        return;
    }
    Date d = new Date();
    if (txtBirthday.getDate() != null) {
        if (txtBirthday.getCalendar().getTime().after(d)) {
            JOptionPane.showMessageDialog(this, "Birthday Date < today");
            txtBirthday.setDate(null);
            txtBirthday.requestFocus();
            return;
        }
    }
    try {
        conn = connect.getConnection();
        String strsql = "Update tblNanny set NannyID=?,Name=?,DateOfBirth=?,Address=?,ContactNumber=?,ChargePaidToHer=?,WorkingHours=? where NannyID=?";
        pstmt = conn.prepareStatement(strsql);
        pstmt.setString(1, txtNannyID.getText());
        pstmt.setString(2, txtName.getText());
        if (txtBirthday.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Please,Enter Birthday");
        } else {
            pstmt.setString(3, txtBirthday.getCalendar().getTime().toLocaleString());
        }
        pstmt.setString(4, txtAddress.getText());
        pstmt.setString(5, txtContactNumber.getText());
        pstmt.setFloat(6, Float.parseFloat(txtCharge.getText()));
        pstmt.setInt(7, Integer.parseInt(txtWorkingHours.getText()));
        pstmt.setString(8,FrmQuanLyBaoMau1.NannyIDE);
        pstmt.executeUpdate();
        JOptionPane.showMessageDialog(this, "Update successfully!");
        this.dispose();
        conn.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Error:" + ex.getMessage());
        return;
    }
}//GEN-LAST:event_btnSaveActionPerformed

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
            java.util.logging.Logger.getLogger(FrmEditNanny1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmEditNanny1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmEditNanny1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmEditNanny1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new FrmEditNanny1().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblBirthday;
    private javax.swing.JLabel lblCharge;
    private javax.swing.JLabel lblContacNumber;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNannyID;
    private javax.swing.JLabel lblWorkingHours;
    private javax.swing.JTextField txtAddress;
    private com.toedter.calendar.JDateChooser txtBirthday;
    private javax.swing.JTextField txtCharge;
    private javax.swing.JTextField txtContactNumber;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNannyID;
    private javax.swing.JTextField txtWorkingHours;
    // End of variables declaration//GEN-END:variables
}
