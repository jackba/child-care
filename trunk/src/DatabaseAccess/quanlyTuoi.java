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
public class quanlyTuoi {
        DefaultTableModel model;
    Connection conn;
    Statement st;
    PreparedStatement pstmt;
    ResultSet rs;
    Connect connect = new Connect();
    

public void Load(JTable tblAge) {

        model = (DefaultTableModel) tblAge.getModel();
        //Xóa dữ liệu trong data Vector object
        model.getDataVector().removeAllElements();
        //Cập nhật lại jTable để hiển thị trên màn hình
        tblAge.repaint();
        try {

            conn = connect.getConnection();

            st = conn.createStatement();
            String strsql = "SELECT AgeGroupID,AgeGroup,Fees from tblAgeGroup";
            rs = st.executeQuery(strsql);

            try {
                //Vector v = null;
                while (rs.next()) {
                    Vector v = new Vector();
                    v.addElement(rs.getString(1));
                    v.addElement(rs.getString(2));
                    v.addElement(rs.getFloat(3));


                    model.addRow(v);
                }
                //set lai model cho jtable
                tblAge.setModel(model);
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}