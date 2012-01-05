/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseAccess;

import DAO.Connect;
import GUI.FrmQuanlyhoatdong;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author darK.x9
 */
public class quanlyHoatdong {
    DefaultTableModel model;
    Connection conn;
    Statement st;
    PreparedStatement pstmt;
    ResultSet rs;
    
    Connect connect = new Connect();
    public String txtActiveID,txtActiveName,
            a,b;
    
    public void btnLoad(JTable jTableQLHD)
    {
        model = (DefaultTableModel) jTableQLHD.getModel();
        //Xóa dữ liệu trong data Vector object
        model.getDataVector().removeAllElements();
        //Cập nhật lại jTable để hiển thị trên màn hình
        jTableQLHD.repaint();
     try {

            conn = connect.getConnection();

            st = conn.createStatement();
            String strsql = "SELECT ActiveID,ActiveName from tblActivities";
            rs = st.executeQuery(strsql);

            try {
                Vector v = null;
                while (rs.next()) 
                    {
                    v = new Vector();
                    for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {

                        v.addElement(rs.getString(i));

                    }
                    model.addRow(v);
                    }
                //set lai model cho jtable
                 jTableQLHD.setModel(model);
                conn.close();
                }
            catch (Exception e) 
                {
                    e.printStackTrace();
                }
        }
            catch (Exception e)
            {
                e.printStackTrace();
            }
      
            
      }
     public void loadEditAdmin() {
        try {

            conn = connect.getConnection();

            

            String strsql = "SELECT * from tblActivities where ActiveID=?";
             pstmt = conn.prepareStatement(strsql);
        pstmt.setString(1, FrmQuanlyhoatdong.ActiveIDE);
            rs = pstmt.executeQuery();

            try {

                while (rs.next()) {
                    a = rs.getString(1);
                    b = rs.getString(2);               
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

    


    
