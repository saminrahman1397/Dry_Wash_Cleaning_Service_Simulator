package org.example.drywashcleaningservicesimulator.OmarYeasinKhan;

import java.io.*;
import java.util.ArrayList;



public class U5G4_ViewFeedback implements Serializable {

    private final String orderID;
    //private final String customerID;
    private int rating;
    private String comment;
    private boolean wouldRecommend;
    //private String feedbackDate;

    public U5G4_ViewFeedback(String orderID,  int rating, String comment, boolean wouldRecommend){
        this.orderID = orderID;
        this.rating = rating;
        this.comment = comment;
        this.wouldRecommend = wouldRecommend;
        //this.feedbackDate = LocalDate.now().toString();
    }

    public String  getOrderID(){
        return orderID;
    }

    public int getRating(){
        return rating;
    }
    public String  getComment(){
        return comment;
    }
    public boolean isWouldRecommend(){
        return wouldRecommend;
    }
    /*public String  getFeedbackDate(){
        return feedbackDate;
    } */

    public static ArrayList<U5G4_ViewFeedback> loadAllFromFile(){
        try{
            File feedbackFile = new File("OmarsFiles/feedbackFile");
            FileInputStream fis = new FileInputStream(feedbackFile);
            ObjectInputStream ois = new ObjectInputStream(fis);

            ArrayList<U5G4_ViewFeedback> list = (ArrayList<U5G4_ViewFeedback>) ois.readObject();
            ois.close();
            fis.close();
            return list;

        } catch (FileNotFoundException e){
            e.printStackTrace();
            return new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }

    }




}
