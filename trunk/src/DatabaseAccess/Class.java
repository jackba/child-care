/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseAccess;

/**
 *
 * @author mr duy
 */
public class Class {
 private String ClassID;
 private String ClassName;
 private String AgeGroup;

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
 
}
