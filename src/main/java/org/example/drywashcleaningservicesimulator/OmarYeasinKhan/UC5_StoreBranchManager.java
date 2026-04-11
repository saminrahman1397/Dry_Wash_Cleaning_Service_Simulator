package org.example.drywashcleaningservicesimulator.OmarYeasinKhan;
import org.example.drywashcleaningservicesimulator.User;

import java.io.Serializable;
import java.util.*;


public class UC5_StoreBranchManager extends User implements Serializable {

    public UC5_StoreBranchManager(String userID, String userName, String email, String password, String role, String phoneNumber, String address) {
        super(userID, userName, email, password, role);




        }
    public void localDashBoard(){

    }


        /*public reviewDailyOperationsSummary(){

        }*/

    /* public boolean approveRefundRequest(String refundRequestID, String decision){

     } */
    public ArrayList<U5G3_Attendance> viewAttendance(){
        return U5G3_Attendance.loadAllFromFile();

    }
    public ArrayList<U5G4_ViewFeedback> viewFeedback(){
        return U5G4_ViewFeedback.loadAllFromFile();
    }

    public void setDailyTargets(double dailyRevenueTarget, int dailyOrderTarget) {

    }
}
