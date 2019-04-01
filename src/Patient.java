/**
 *
 * @author Kevin
 * @date today
 */
public class Patient {
    public final int NAME_SIZE = 30;
    private int patientID;
    private int ownerID;
    private String patientName;
    
    public Patient() {
        patientID = 1;
        ownerID = 1;
        patientName = "Default Patient";
    }
    public Patient(int patientID, int ownerID, String patientName) {
        this.patientID = patientID;
        this.ownerID = ownerID;
        this.patientName = patientName;
    }
    public int getPatientID() {
        return patientID;
    }
    public int getOwnerID() {
        return ownerID;
    }
    public String getPatientName() {
        return patientName;
    }
    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }
    public void setOwnerID(int ownerID) {
        this.ownerID = ownerID;
    }
    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }
    @Override
    public String toString() {
        return (patientID + " " + patientName);
    }
    
    
}
