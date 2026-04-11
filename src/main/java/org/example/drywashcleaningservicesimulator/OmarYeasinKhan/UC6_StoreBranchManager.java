package org.example.drywashcleaningservicesimulator.OmarYeasinKhan;
import org.example.drywashcleaningservicesimulator.User;

import java.io.*;
import java.time.LocalDate;
import java.util.*;


public class UC6_StoreBranchManager extends User {

    public UC6_StoreBranchManager(String userID, String userName, String email, String password, String role, String phoneNumber, String address) {
        super(userID, userName, email, password, role);




        }
    public void localDashBoard(){

    }


        /*public reviewDailyOperationsSummary(){

        }*/

    /* public boolean approveRefundRequest(String refundRequestID, String decision){

     } */
    public ArrayList<Attendance> viewAttendance(){
        return Attendance.loadAllFromFile();

    }
}
