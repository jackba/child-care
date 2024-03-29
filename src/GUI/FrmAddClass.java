/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FrmAddClass.java
 *
 * Created on Nov 24, 2011, 11:22:07 PM
 */
package GUI;

import DAO.Connect;
import DatabaseAccess.quanLyLop;
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
public class FrmAddClass extends javax.swing.JFrame {

    Connect connect = new Connect();
    Connection conn;
    ResultSet rs;
    PreparedStatement pstmt;
    quanLyLop nhap = new quanLyLop();

    /** Creates new form FrmAddClass */
    public FrmAddClass() {
        initComponents();
    }
         public void getClass(String str){
        txtAgeGroupID.setText(str);
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
        txtClassName = new javax.swing.JTextField();
        txtAgeGroupID = new javax.swing.JTextField();
        txtClassID = new javax.swing.JTextField();
        lblClassName = new javax.swing.JLabel();
        lblAgeGroupID = new javax.swing.JLabel();
        lblClassId = new javax.swing.JLabel();
        btnGet = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add Class");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        txtClassName.setFont(new java.awt.Font("Tahoma", 0, 12));
        txtClassName.setForeground(new java.awt.Color(0, 0, 204));

        txtAgeGroupID.setFont(new java.awt.Font("Tahoma", 0, 12));
        txtAgeGroupID.setForeground(new java.awt.Color(0, 0, 204));

        txtClassID.setFont(new java.awt.Font("Tahoma", 0, 12));
        txtClassID.setForeground(new java.awt.Color(0, 0, 204));
        txtClassID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClassIDActionPerformed(evt);
            }
        });

        lblClassName.setFont(new java.awt.Font("Tahoma", 0, 12));
        lblClassName.setForeground(new java.awt.Color(0, 0, 204));
        lblClassName.setText("ClassName");

        lblAgeGroupID.setFont(new java.awt.Font("Tahoma", 0, 12));
        lblAgeGroupID.setForeground(new java.awt.Color(0, 0, 204));
        lblAgeGroupID.setText("AgeGroupID");

        lblClassId.setFont(new java.awt.Font("Tahoma", 0, 12));
        lblClassId.setForeground(new java.awt.Color(0, 0, 204));
        lblClassId.setText("ClassID");

        btnGet.setFont(new java.awt.Font("Tahoma", 0, 12));
        btnGet.setForeground(new java.awt.Color(0, 0, 204));
        btnGet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/download.png"))); // NOI18N
        btnGet.setText("Get");
        btnGet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAgeGroupID)
                    .addComponent(lblClassName)
                    .addComponent(lblClassId))
                .addGap(63, 63, 63)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtClassName)
                        .addComponent(txtClassID, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
                    .addComponent(txtAgeGroupID, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(btnGet, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                .addGap(76, 76, 76))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblClassId)
                    .addComponent(txtClassID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtClassName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblClassName))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAgeGroupID)
                    .addComponent(btnGet)
                    .addComponent(txtAgeGroupID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(85, 85, 85))
        );

        btnAdd.setFont(new java.awt.Font("Tahoma", 0, 12));
        btnAdd.setForeground(new java.awt.Color(0, 0, 204));
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/add.png"))); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnCancel.setFont(new java.awt.Font("Tahoma", 0, 12));
        btnCancel.setForeground(new java.awt.Color(0, 0, 204));
        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/reset.png"))); // NOI18N
        btnCancel.setText("Reset");
        btnCancel.setPreferredSize(new java.awt.Dimension(89, 31));

        btnClose.setFont(new java.awt.Font("Tahoma", 0, 12));
        btnClose.setForeground(new java.awt.Color(0, 0, 204));
        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/close2.png"))); // NOI18N
        btnClose.setText("Close");
        btnClose.setPreferredSize(new java.awt.Dimension(83, 31));
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36));
        jLabel1.setForeground(new java.awt.Color(204, 0, 0));
        jLabel1.setText("Add Class");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(101, 101, 101))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(189, 189, 189)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-596)/2, (screenSize.height-340)/2, 596, 340);
    }// </editor-fold>//GEN-END:initComponents

private void btnGetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGetActionPerformed
    FrmViewAgeGroup frmviewagegroup= new FrmViewAgeGroup();
    frmviewagegroup.setVisible(true);
    this.dispose();
}//GEN-LAST:event_btnGetActionPerformed

private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
    if (txtClassID.getText().equals("")) {
        JOptionPane.showMessageDialog(this, "Please,Enter Class ID");
        txtClassID.requestFocus();
        return;
    }
    if (txtClassName.getText().equals("")) {
        JOptionPane.showMessageDialog(this, "Please,Enter ClassName");
        txtClassName.requestFocus();
        return;
    }
  //  String str = quanLyLop.getClassName();
//    if (txtClassName.getText().equals(str)) {
//        JOptionPane.showMessageDialog(this, "class name has please choose another name ");
//        txtClassName.requestFocus();
//        return;
//    }
    if (txtAgeGroupID.getText().equals("")) {
        JOptionPane.showMessageDialog(this, "Please,Enter AgeGroupID");
        txtAgeGroupID.requestFocus();
        return;
    }
    conn = connect.getConnection();

    try {
        String strSql;

        strSql = "insert tblClass values(?,?,?)";



        pstmt = conn.prepareStatement(strSql);
        pstmt.setString(1, txtClassID.getText());
        pstmt.setString(2, txtClassName.getText());
        pstmt.setString(3, txtAgeGroupID.getText());
        pstmt.executeUpdate();
        JOptionPane.showMessageDialog(this, "insert successfully!");
        this.dispose();
        conn.close();
    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error:" + ex.getMessage());
        return;
    }



}//GEN-LAST:event_btnAddActionPerformed

private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
    this.dispose();
}//GEN-LAST:event_btnCloseActionPerformed

private void txtClassIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClassIDActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_txtClassIDActionPerformed

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
            java.util.logging.Logger.getLogger(FrmAddClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmAddClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmAddClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmAddClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new FrmAddClass().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnGet;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAgeGroupID;
    private javax.swing.JLabel lblClassId;
    private javax.swing.JLabel lblClassName;
    private javax.swing.JTextField txtAgeGroupID;
    private javax.swing.JTextField txtClassID;
    private javax.swing.JTextField txtClassName;
    // End of variables declaration//GEN-END:variables
}
