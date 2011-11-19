/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseAccess;

import DAO.Connect;
import GUI.FrmDetail;
import GUI.FrmQuanLyTaiKhoan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrator
 */
public class quanLyTaiKhoan {

    DefaultTableModel model;
    Connection conn;
    Statement st;
    PreparedStatement pstmt;
    ResultSet rs;
    Connect connect = new Connect();
    public String a, b, c, d, e, f, g, h, j;

    public void btnLoad(JTable jTableQLTK) {

        model = (DefaultTableModel) jTableQLTK.getModel();
        //Xóa dữ liệu trong data Vector object
        model.getDataVector().removeAllElements();
        //Cập nhật lại jTable để hiển thị trên màn hình
        jTableQLTK.repaint();
        try {

            conn = connect.getConnection();

            st = conn.createStatement();
            String strsql = "SELECT  * from tblUser";
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
                jTableQLTK.setModel(model);
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadDetail() {
        try {

            conn = connect.getConnection();

            st = conn.createStatement();

            String strsql = "SELECT * from tblUser";

            rs = st.executeQuery(strsql);

            try {

                while (rs.next()) {
                    a = rs.getString(1);
                    b = rs.getString(2);
                    c = rs.getString(3);
                    d = rs.getString(4);
                    e = rs.getString(5);
                    f = rs.getString(6);
                    g = rs.getString(7);
                    h = rs.getString(8);
                    j = rs.getString(9);
                }
                rs.close();
                st.close();
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
