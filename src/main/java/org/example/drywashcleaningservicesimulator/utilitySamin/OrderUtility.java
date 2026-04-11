package org.example.drywashcleaningservicesimulator.utilitySamin;

import org.example.drywashcleaningservicesimulator.SaminRahman.Order;

import java.io.*;

public class OrderUtility {
    public static void SaveOrder(Order order) {
        File file = new File("Data/orders.bin");
        ObjectOutputStream oos = null;
        try {
            FileOutputStream fos = new FileOutputStream(file, true);

            if (file.exists()  && file.length() > 0) {
                oos = new AppendableObjectOutputStream(fos);
            } else {
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(order);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static String getNextOrderID(){
        File file = new File("Data/orders.bin");
        int lastOrderNumber = 0;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        if(file.exists() && file.length() > 0){
            try{
                fis = new FileInputStream(file);
                ois = new ObjectInputStream(fis);
                while(true){
                    try{
                        Order obj = (Order) ois.readObject();
                        lastOrderNumber = Integer.parseInt(obj.getOrderID());
                    }catch(EOFException e){
                        break;
                    }
                }
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                try{
                    if (ois != null){
                        ois.close();
                    }
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
        return String.format("%04d", lastOrderNumber + 1);
    }
}
