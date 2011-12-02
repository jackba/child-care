/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseAccess;

import DAO.Connect;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dell
 */
public class quanLyLop {

    DefaultTableModel model;
    Connection conn;
    Statement st;
    PreparedStatement pstmt;
    ResultSet rs;
    Connect connect = new Connect();

    public void Load(JTable tblClass) {

        model = (DefaultTableModel) tblClass.getModel();
        //Xóa dữ liệu trong data Vector object
        model.getDataVector().removeAllElements();
        //Cập nhật lại jTable để hiển thị trên màn hình
        tblClass.repaint();
        try {

            conn = connect.getConnection();

            st = conn.createStatement();
            String strsql = "SELECT ClassID,ClassName,AgeGroupID from tblClass";
            rs = st.executeQuery(strsql);

            try {
                //Vector v = null;
                while (rs.next()) {
                    Vector v = new Vector();
                    v.addElement(rs.getString(1));
                    v.addElement(rs.getString(2));
                    v.addElement(rs.getString(3));


                    model.addRow(v);
                }
                //set lai model cho jtable
                tblClass.setModel(model);
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
            String strsql = "SELECT * from tblActivities";
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

    public void  getClassName(String classname) {
         classname = null;
        try {

            conn = connect.getConnection();
            String strSQL = "select ClassName from tblClass";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(strSQL);

            while (rs.next()) {
                classname = rs.getString(2);
            }

            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        //return classname;
    }
    public  void  inittableAgeGroupforGet(JTable jtable)
    {

        String MySql= "SELECT * FROM tblAgeGroup where AgeGroupID = ?";
        try {
            pstmt = conn.prepareStatement(MySql);
            ResultSet rs = pstmt.executeQuery();
            ResultSetMetaData rsmt = rs.getMetaData();

             Vector v = new Vector();
            //Add data to vtCol:
            for (int i = 1; i <= rsmt.getColumnCount(); i++) {
                v.add(rsmt.getColumnName(i));
            }
            try {
              Vector  vtData = new Vector();
                while (rs.next()) {
                    Vector vtRow = new Vector();
                    for (int i = 1; i <= rsmt.getColumnCount(); i++) {
                        vtRow.add(rs.getString(i));
                    }
                    vtData.add(vtRow);
                }
                jtable.setModel(new DefaultTableModel(vtData,v));
            } catch (SQLException ex) {
              ex.printStackTrace();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
    public  void  inittableActive(JTable jtable)
    {
        Vector vtHeader = null;
        String MySql= "SELECT * FROM tblActivities";
        try {
            pstmt = conn.prepareStatement(MySql);
            rs = pstmt.executeQuery();
            ResultSetMetaData rsmt = rs.getMetaData();

            vtHeader = new Vector();
            //Add data to vtCol:
            for (int i = 1; i <= rsmt.getColumnCount(); i++) {
                vtHeader.add(rsmt.getColumnName(i));
            }
            try {
              Vector  vtData = new Vector();
                while (rs.next()) {
                    Vector vtRow = new Vector();
                    for (int i = 1; i <= rsmt.getColumnCount(); i++) {
                        vtRow.add(rs.getString(i));
                    }
                    vtData.add(vtRow);
                }
                jtable.setModel(new DefaultTableModel(vtData,vtHeader));
            } catch (SQLException ex) {
              ex.printStackTrace();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
//        public void  getAgeGroupID(String classname) {
//         classname = null;
//        try {
//
//            conn = connect.getConnection();
//            String strSQL = "select AgeGroupID from tblClass";
//            Statement stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery(strSQL);
//
//            while (rs.next()) {
//                classname = rs.getString(3);
//            }
//
//            conn.close();
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        //return classname;
//    }
//                public void  getClassID(String classid) {
//         classid = null;
//        try {
//
//            conn = connect.getConnection();
//            String strSQL = "select ClassID from tblClass";
//            Statement stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery(strSQL);
//
//            while (rs.next()) {
//                classid = rs.getString(1);
//            }
//
//            conn.close();
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//       // return ClassID;
//    }
}
