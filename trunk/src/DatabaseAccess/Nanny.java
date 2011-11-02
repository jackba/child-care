/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseAccess;

/**
 *
 * @author mr duy
 */
public class Nanny {
    private String NannyID;
    private String Name;
    private String Address;
    private String ContactNumber;
    private String ChildAssignedToHer;
    private float ChagerPaidToHer;
    private int WorkingHours;

    public Nanny() {
    }

    public Nanny(String NannyID, String Name, String Address, String ContactNumber, String ChildAssignedToHer, float ChagerPaidToHer, int WorkingHours) {
        this.NannyID = NannyID;
        this.Name = Name;
        this.Address = Address;
        this.ContactNumber = ContactNumber;
        this.ChildAssignedToHer = ChildAssignedToHer;
        this.ChagerPaidToHer = ChagerPaidToHer;
        this.WorkingHours = WorkingHours;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public float getChagerPaidToHer() {
        return ChagerPaidToHer;
    }

    public void setChagerPaidToHer(float ChagerPaidToHer) {
        this.ChagerPaidToHer = ChagerPaidToHer;
    }

    public String getChildAssignedToHer() {
        return ChildAssignedToHer;
    }

    public void setChildAssignedToHer(String ChildAssignedToHer) {
        this.ChildAssignedToHer = ChildAssignedToHer;
    }

    public String getContactNumber() {
        return ContactNumber;
    }

    public void setContactNumber(String ContactNumber) {
        this.ContactNumber = ContactNumber;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getNannyID() {
        return NannyID;
    }

    public void setNannyID(String NannyID) {
        this.NannyID = NannyID;
    }

    public int getWorkingHours() {
        return WorkingHours;
    }

    public void setWorkingHours(int WorkingHours) {
        this.WorkingHours = WorkingHours;
    }
    
}
