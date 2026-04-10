package org.example.drywashcleaningservicesimulator.utility;

import org.example.drywashcleaningservicesimulator.SaminRahman.Order;

import java.io.*;

public class OrderUtility {
    public static void SaveOrder(Order order){
        File file = new File("Data/orders.bin");
        try{
            FileOutputStream fos = new FileOutputStream(file,true);
            ObjectOutputStream oos;
            if (file.length() > 0){
                oos = new AppendableObjectOutputStream(fos);
            }
            else{
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(order);
            oos.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
