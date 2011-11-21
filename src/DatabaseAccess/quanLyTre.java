/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseAccess;

import DAO.Connect;
import GUI.FrmQuanLyTre;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrator
 */
public class quanLyTre {

    DefaultTableModel model;
    Connection conn;
    Statement st;
    PreparedStatement pstmt;
    ResultSet rs;
    Connect connect = new Connect();
    public String txtSex,txtClassID, txtLastName, txtFirstName,
            txtAddress, txtCurrentMedication, txtPastIllness, txtDoctorName, txtParentName, txtParentWorkNumber, txtParentMobileNumber, txtParentEmailAddress, txtNoteAboutChild, txtID,
            a,b,c,d,f,g,h,j,k,l,m,n;
    public Date txtRegistrationDate, txtDateReceived, txtBirthday,e,o,p;
    public void btnLoad(JTable jTableQLT) {

        model = (DefaultTableModel) jTableQLT.getModel();
        //Xóa dữ liệu trong data Vector object
        model.getDataVector().removeAllElements();
        //Cập nhật lại jTable để hiển thị trên màn hình
        jTableQLT.repaint();
        try {

            conn = connect.getConnection();

            st = conn.createStatement();
            String strsql = "SELECT ChildID,ClassID,LastName,FirstName,Sex,DateOfBirth,ParentName,DateRegistration,DateReceived from tblChild";
            rs = st.executeQuery(strsql);

            try {
                Vector v = null;
                while (rs.next()) {
                    v = new Vector();
                    for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {

                        v.addElement(rs.getString(i));

                    }
                    model.addRow(v);
                }
                //set lai model cho jtable
                jTableQLT.setModel(model);
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void btnLoadClass(JTable jTableClass) {

        model = (DefaultTableModel) jTableClass.getModel();
        //Xóa dữ liệu trong data Vector object
        model.getDataVector().removeAllElements();
        //Cập nhật lại jTable để hiển thị trên màn hình
        jTableClass.repaint();
        try {

            conn = connect.getConnection();

            st = conn.createStatement();
            String strsql = "SELECT * from tblClass";
            rs = st.executeQuery(strsql);

            try {
                Vector v = null;
                while (rs.next()) {
                    v = new Vector();
                    for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {

                        v.addElement(rs.getString(i));

                    }
                    model.addRow(v);
                }
                //set lai model cho jtable
                jTableClass.setModel(model);
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void fillDataDetailChild() {
        try {

            conn = connect.getConnection();
            String strSql = "select ChildID,ClassID,LastName,FirstName,DateOfBirth,Address,CurrentMedications,PastIllness,"
                    + "DoctorName,ParentName,ParentWorkNumber,"
                    + "ParentMobileNumber,ParentEmailAddress,"
                    + "DateRegistration,DateReceived,Sex from tblChild where ChildID=?";
            pstmt = conn.prepareStatement(strSql);
            pstmt.setString(1, FrmQuanLyTre.ChildIDD);

            rs = pstmt.executeQuery();
            while (rs.next()) {
                txtID = rs.getString(1);
                txtClassID = rs.getString(2);
                txtLastName = rs.getString(3);
                txtFirstName = rs.getString(4);
                txtBirthday = rs.getDate(5);
                txtAddress = rs.getString(6);
                txtCurrentMedication = rs.getString(7);
                txtPastIllness = rs.getString(8);
                txtDoctorName = rs.getString(9);
                txtParentName = rs.getString(10);
                txtParentWorkNumber = rs.getString(11);
                txtParentMobileNumber = rs.getString(12);
                txtParentEmailAddress = rs.getString(13);
                txtRegistrationDate = rs.getDate(14);
                txtDateReceived = rs.getDate(15);
                txtSex = rs.getString(16);
            }
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
     public  void fillDataEditChild()
    {
        try {
            
            conn = connect.getConnection();
            String strSql = "select ChildID,ClassID,LastName,FirstName,DateOfBirth,Address,CurrentMedications,PastIllness,"+
                    "DoctorName,ParentName,ParentWorkNumber,"+
                    "ParentMobileNumber,ParentEmailAddress,"+
                    "DateRegistration,DateReceived from tblChild where ChildID=?";
            pstmt = conn.prepareStatement(strSql);
            pstmt.setString(1,FrmQuanLyTre.ChildIDE);
            rs = pstmt.executeQuery();
            while(rs.next()){
                a = rs.getString(1);
                b = rs.getString(2);
                c = rs.getString(3);
                d = rs.getString(4);
                e = rs.getDate(5);
                f = rs.getString(6);
                g = rs.getString(7);
                h = rs.getString(8);
                j = rs.getString(9);
                k = rs.getString(10);
                l = rs.getString(11);
                m = rs.getString(12);
                n = rs.getString(13);
                o = rs.getDate(14);
                p = rs.getDate(15);
            }
           conn.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
         
        }
    }
}
