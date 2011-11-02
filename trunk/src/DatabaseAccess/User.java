/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseAccess;

/**
 *
 * @author mr duy
 */
public class User {
    private String UserName;
    private String PassWord;
    private String Permission;

    public User() {
    }

    public User(String UserName, String PassWord, String Permission) {
        this.UserName = UserName;
        this.PassWord = PassWord;
        this.Permission = Permission;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String PassWord) {
        this.PassWord = PassWord;
    }

    public String getPermission() {
        return Permission;
    }

    public void setPermission(String Permission) {
        this.Permission = Permission;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }
    
    
}
