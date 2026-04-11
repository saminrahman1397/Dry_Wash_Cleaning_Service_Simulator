package org.example.drywashcleaningservicesimulator.OmarYeasinKhan;
import org.example.drywashcleaningservicesimulator.utilitySamin.AppendableObjectOutputStream;

import java.io.*;
import java.util.ArrayList;

public class U5G5_DailyTargets implements Serializable {

    private String targetID;
    //private String targetDate;
    private double revenueTarget;
    private int    orderTarget;

    public U5G5_DailyTargets(double revenueTarget, int orderTarget) {
        //this.targetID      = generateTargetID();
        //this.targetDate    = LocalDate.now().toString();
        this.revenueTarget = revenueTarget;
        this.orderTarget   = orderTarget;
    }

    public String getTargetID(){
        return targetID;
    }
    public double getRevenueTarget(){
        return revenueTarget;
    }
    public int    getOrderTarget(){
        return orderTarget;
    }

    public static ArrayList<U5G5_DailyTargets> loadAllFromFile() {
        try{
            File dailyTargetsFile = new File("OmarsFiles/dailyTargetsFile");
            FileInputStream fis = new FileInputStream(dailyTargetsFile);
            ObjectInputStream ois = new ObjectInputStream(fis);

            ArrayList<U5G5_DailyTargets> list = (ArrayList<U5G5_DailyTargets>) ois.readObject();

            ois.close();
            fis.close();
            return list;
        } catch(FileNotFoundException e){
            e.printStackTrace();
            return new ArrayList<>();
        } catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public static void writeAll(ArrayList<U5G5_DailyTargets> list) {
        try{
            File dailyTargetsFile = new File("OmarsFiles/dailyTargets.bin");
            FileOutputStream fos = new FileOutputStream(dailyTargetsFile, true);
            ObjectOutputStream oos;
                if (dailyTargetsFile.exists() || dailyTargetsFile.length() > 1){
                    oos = new AppendableObjectOutputStream(fos);
                } else {
                    oos = new ObjectOutputStream(fos);
                }
                oos.writeObject(list);
            } catch (IOException e){
                e.printStackTrace();
            }

    }

    public void saveToFile() {
        ArrayList<U5G5_DailyTargets> list = loadAllFromFile();
        list.add(this);
        writeAll(list);
    }

}