/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseAccess;

/**
 *
 * @author mr duy
 */
public class AgeGroup {
    private String AgeGroupID;
    private String AgeGroup;
    private String Fees;

    public AgeGroup() {
    }

    public AgeGroup(String AgeGroupID, String AgeGroup, String Fees) {
        this.AgeGroupID = AgeGroupID;
        this.AgeGroup = AgeGroup;
        this.Fees = Fees;
    }

    public String getAgeGroup() {
        return AgeGroup;
    }

    public void setAgeGroup(String AgeGroup) {
        this.AgeGroup = AgeGroup;
    }

    public String getAgeGroupID() {
        return AgeGroupID;
    }

    public void setAgeGroupID(String AgeGroupID) {
        this.AgeGroupID = AgeGroupID;
    }

    public String getFees() {
        return Fees;
    }

    public void setFees(String Fees) {
        this.Fees = Fees;
    }
    
    
}
