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
    
    /**
     * Default patient constructor
     */ 
    public Patient() {
        patientID = 1234;
        ownerID = 1234;
        patientName = "Default";
    }
    /**
     * This 3 parameter constructor accounts for the IDs and name of patient
     * @param patientID patient's id number
     * @param ownerID owner's id number
     * @param patientName patient's name
     */
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
        return (patientID + " " + patientName + " " + ownerID + "\n");
    }
    
    
}
