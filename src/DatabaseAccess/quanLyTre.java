/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseAccess;

import DAO.Connect;
import GUI.FrmManagementChild;
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
    public String txtSex,txtClassID, txtLastName ,txtMiddleName, txtFirstName,
            txtAddress, txtCurrentMedication, txtPastIllness, txtDoctorName, txtParentName, txtParentWorkNumber, txtParentMobileNumber, txtParentEmailAddress, txtNoteAboutChild, txtID,
            a,b,c,d,f,g,h,j,k,l,m,n,q;
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
            String strsql = "SELECT ChildID,ClassID,LastName,MiddleName,FirstName,Sex,DateOfBirth,ParentName,DateRegistration,DateReceived from tblChild";
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
            String strSql = "select ChildID,ClassID,LastName,MiddleName, FirstName,DateOfBirth,Address,CurrentMedications,PastIllness,"
                    + "DoctorName,ParentName,ParentWorkNumber,"
                    + "ParentMobileNumber,ParentEmailAddress,"
                    + "DateRegistration,DateReceived,Sex from tblChild where ChildID=?";
            pstmt = conn.prepareStatement(strSql);
            pstmt.setString(1, FrmManagementChild.ChildIDD);

            rs = pstmt.executeQuery();
            while (rs.next()) {
                txtID = rs.getString(1);
                txtClassID = rs.getString(2);
                txtLastName = rs.getString(3);
                txtMiddleName = rs.getString(4);
                txtFirstName = rs.getString(5);
                txtBirthday = rs.getDate(6);
                txtAddress = rs.getString(7);
                txtCurrentMedication = rs.getString(8);
                txtPastIllness = rs.getString(9);
                txtDoctorName = rs.getString(10);
                txtParentName = rs.getString(11);
                txtParentWorkNumber = rs.getString(12);
                txtParentMobileNumber = rs.getString(13);
                txtParentEmailAddress = rs.getString(14);
                txtRegistrationDate = rs.getDate(15);
                txtDateReceived = rs.getDate(16);
                txtSex = rs.getString(17);
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
                    "DateRegistration,DateReceived,MiddleName from tblChild where ChildID=?";
            pstmt = conn.prepareStatement(strSql);
            pstmt.setString(1,FrmManagementChild.ChildIDE);
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
                q = rs.getString(16);
            }
           conn.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
         
        }
    }
}
