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
 * @author Dell
 */
public class Active {

    String ActiveID;
    String ActiveName;
    public static Vector vtData;

    public String getActiveID() {
        return ActiveID;
    }

    public void setActiveID(String ActiveID) {
        this.ActiveID = ActiveID;
    }

    public String getActiveName() {
        return ActiveName;
    }

    public void setActiveName(String ActiveName) {
        this.ActiveName = ActiveName;
    }

    public Active() {
    }

    public void inittableActive(JTable jtable) {
        Vector vtHeader = null;
        String MySql = "SELECT * FROM tblActivities";
        try {
            Connection conn;
            PreparedStatement pstmt;
            Connect connect = new Connect();
            ResultSet rs;
            conn = connect.getConnection();
            pstmt = conn.prepareStatement(MySql);
            rs = pstmt.executeQuery();
            ResultSetMetaData rsmt = rs.getMetaData();
            vtHeader = new Vector();
            //Add data to vtCol:
            for (int i = 1; i <= rsmt.getColumnCount(); i++) {
                vtHeader.add(rsmt.getColumnName(i));
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
                jtable.setModel(new DefaultTableModel(vtData, vtHeader));
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
}
