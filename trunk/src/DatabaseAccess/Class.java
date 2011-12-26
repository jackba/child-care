/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseAccess;

import DAO.Connect;
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
 * @author mr duy
 */
public class Class {
 private String ClassID;
 private String ClassName;
 private String AgeGroup;
public static Vector vtData;
    public Class() {
    }

    public Class(String ClassID, String ClassName, String AgeGroup) {
        this.ClassID = ClassID;
        this.ClassName = ClassName;
        this.AgeGroup = AgeGroup;
    }

    public String getAgeGroup() {
        return AgeGroup;
    }

    public void setAgeGroup(String AgeGroup) {
        this.AgeGroup = AgeGroup;
    }

    public String getClassID() {
        return ClassID;
    }

    public void setClassID(String ClassID) {
        this.ClassID = ClassID;
    }

    public String getClassName() {
        return ClassName;
    }

    public void setClassName(String ClassName) {
        this.ClassName = ClassName;
    }
   public static void  inittableClass(JTable jtable)
    {
        Vector v;
        Connection conn;
        PreparedStatement pstmt;
        Connect connect = new Connect();
        ResultSet rs;
        String MySql= "SELECT * FROM tblClass";
        try {
            conn= connect.getConnection();
            pstmt = conn.prepareStatement(MySql);
             rs = pstmt.executeQuery();
            ResultSetMetaData rsmt = rs.getMetaData();

            v = new Vector();
            //Add data to vtCol:
            for (int i = 1; i <= rsmt.getColumnCount(); i++) {
                v.add(rsmt.getColumnName(i));
            }
            try {
                vtData = new Vector();
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
                 Vector v;
        Connection conn ;
        PreparedStatement pstmt;
        Connect connect = new Connect();
        ResultSet rs;
        conn=connect.getConnection();
            pstmt =conn.prepareStatement(MySql);
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
}
