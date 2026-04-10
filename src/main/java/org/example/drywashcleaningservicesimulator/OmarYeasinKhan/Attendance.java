package org.example.drywashcleaningservicesimulator.OmarYeasinKhan;
import java.io.*;
import java.util.ArrayList;

public class Attendance implements Serializable{
    private boolean attendanceSBM;
    private boolean attendanceIM;
    private boolean attendanceFDR;
    private boolean attendanceCT;
    private boolean attendanceDD;
    private boolean attendanceCCR;
    private boolean attendanceOC;

    public Attendance(){
        this.attendanceSBM = false;
        this.attendanceIM = false;
        this.attendanceFDR = false;
        this.attendanceCT = false;
        this.attendanceDD = false;
        this.attendanceCCR = false;
        this.attendanceOC = false;
    }

    public boolean getAttendanceSBM(){
        return attendanceSBM;
    }
    public boolean getAttendanceIM(){
        return attendanceIM;
    }
    public boolean getAttendanceFDR(){
        return attendanceFDR;
    }
    public boolean getAttendanceCT(){
        return attendanceCT;
    }
    public boolean getAttendanceDD(){
        return attendanceDD;
    }
    public boolean getAttendanceCCR(){
        return attendanceCCR;
    }
    public boolean getAttendanceOC(){
        return attendanceOC;
    }

    public void setAttendanceSBM(boolean a){
        attendanceSBM = a;
    }
    public void setAttendanceIM(boolean a){
        attendanceIM = a;
    }
    public void setAttendanceFDR(boolean a){
        attendanceFDR = a;
    }
    public void setAttendanceCT(boolean a){
        attendanceCT = a;
    }
    public void setAttendanceDD(boolean a){
        attendanceDD = a;
    }
    public void setAttendanceCCR(boolean a){
        attendanceCCR = a;
    }
    public void setAttendanceOC(boolean a){
        attendanceOC = a;
    }


    public static ArrayList<Attendance> loadAllFromFile(){
        try{
            FileInputStream fis =  new FileInputStream("OmarsFiles/attendance.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);

            ArrayList<Attendance> list = (ArrayList<Attendance>) ois.readObject();

            ois.close();
            fis.close();
            return list;

        } catch (FileNotFoundException e){
            return new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading attendance");
            return new ArrayList<>();
        }
    }

    private static void writeAll(ArrayList<Attendance> list) {
        try {
            FileOutputStream fos = new FileOutputStream("OmarsFiles/attendance.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
        } catch (IOException e) {
            System.out.println("Error saving attendance");
        }
    }

    public void saveToFile() {
        ArrayList<Attendance> list = loadAllFromFile();
        list.add(this);
        writeAll(list);
    }
}
