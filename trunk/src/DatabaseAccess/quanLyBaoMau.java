/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseAccess;

import DAO.Connect;
import GUI.FrmQuanLyBaoMau;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dell
 */
public class quanLyBaoMau {

    DefaultTableModel model;
    Connection conn;
    Statement st;
    PreparedStatement pstmt;
    ResultSet rs;
    Connect connect = new Connect();
    public String txtNannyID, txtName, txtAddress, txtContactNumber, a, b, c, d;
    public float txtChargePaidToHer, f;
    public int txtWorkingHours, e;
    public Date txtDateOfBirth, h;

    public void Load(JTable jTableQLBM) {

        model = (DefaultTableModel) jTableQLBM.getModel();
        //Xóa dữ liệu trong data Vector object
        model.getDataVector().removeAllElements();
        //Cập nhật lại jTable để hiển thị trên màn hình
        jTableQLBM.repaint();
        try {

            conn = connect.getConnection();

            st = conn.createStatement();
            String strsql = "SELECT NannyID,Name,DateOfBirth,Address,ContactNumber,ChargePaidToHer,WorkingHours from tblNanny";
            rs = st.executeQuery(strsql);

            try {
                //Vector v = null;
                while (rs.next()) {
                     Vector v = new Vector();
                     v.addElement(rs.getString(1));
                     v.addElement(rs.getString(2));
                     v.addElement(rs.getDate(3));
                     v.addElement(rs.getString(4));
                     v.addElement(rs.getString(5));
                     v.addElement(rs.getFloat(6));
                     v.addElement(rs.getInt(7));
            
                    model.addRow(v);
                }
                //set lai model cho jtable
                jTableQLBM.setModel(model);
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
}
//
//    public void fillDataDetailNanny() {
//        try {
//
//            conn = connect.getConnection();
//            String strSql = "select NannyID,Name,DateOfBirth,Address,ContactNumber,ChargePaidToHer,WorkingHours from tblNanny where NannyID=?";
//            pstmt = conn.prepareStatement(strSql);
//            pstmt.setString(1, FrmQuanLyBaoMau.NannyIDD);
//
//            rs = pstmt.executeQuery();
//            while (rs.next()) {
//                txtNannyID = rs.getString(1);
//                txtName = rs.getString(2);
//                txtDateOfBirth = rs.getDate(3);
//                txtAddress = rs.getString(4);
//                txtContactNumber = rs.getString(5);
//                txtChargePaidToHer = rs.getFloat(6);
//                txtWorkingHours = rs.getInt(7);
//            }
//            conn.close();
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//    }

//    public void fillDataEditNanny() {
//        try {
//
//            conn = connect.getConnection();
//            String strSql = "select NannyID,Name,DateOfBirth,Address,ContactNumber,ChargePaidToHer,WorkingHours from tblNanny where NannyID=?";
//            pstmt = conn.prepareStatement(strSql);
//            pstmt.setString(1, FrmQuanLyBaoMau.NannyIDE);
//            rs = pstmt.executeQuery();
//            while (rs.next()) {
//                a = rs.getString(1);
//                b = rs.getString(2);
//                h = rs.getDate(3);
//                c = rs.getString(4);
//                d = rs.getString(5);
//                e = rs.getInt(6);
//                f = rs.getFloat(7);
//
//            }
//            conn.close();
//
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//
//        }
//    }
//}
