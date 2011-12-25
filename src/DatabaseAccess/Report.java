/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseAccess;
import java.io.*;

/**
 *
 * @author Dell
 */
public class Report {
    
public Report(){}
OutputStream out=null;
    /** Creates a new instance of ExportApplication */
   
       public void reportApplication(byte[] i,String URL){
        try {
            out = new FileOutputStream(URL+".doc");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        try {
            
            out.write(i);
            out.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public String openFile(String nameFile){
        FileReader fr;
        String b = "";
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(nameFile));
            String s = null;
            while((s=br.readLine())!=null) {
                b=b+s;
            }
        } catch (FileNotFoundException ex) {
            // ex.printStackTrace();
        } catch (IOException ex) {
            // ex.printStackTrace();
        }
        
        return b;
    }
}
