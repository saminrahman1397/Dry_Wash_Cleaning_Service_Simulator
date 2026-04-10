package org.example.drywashcleaningservicesimulator.OmarYeasinKhan;
import java.io.*;
import java.time.LocalDate;
import java.util.*;


public class UC6_StoreBranchManager implements Serializable {

    private String managerID;
    private String managerName;

    public UC6_StoreBranchManager (String managerID, String managerName){
        this.managerID = managerID;
        this.managerName = managerName;




        }

        /*public reviewDailyOperationsSummary(){

        }*/

    /* public boolean approveRefundRequest(String refundRequestID, String decision){

     } */
    public ArrayList<Attendance> viewAttendance(){
        return Attendance.loadAllFromFile();

    }
}
