package cse213.drycleaning.Mark_2420189;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;

public class GenericFileManager {


    public static <T> ObservableList<T> readAll(Class<T> clazz, String fileName) {
        ObservableList<T> list = FXCollections.observableArrayList();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            while (true) {
                try {
                    Object obj = ois.readObject();
                    if (clazz.isInstance(obj)) {
                        list.add(clazz.cast(obj));
                    }
                } catch (EOFException eof) {
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            //ignore
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return list;
    }


    public static <T> void writeAll(ObservableList<T>  list, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            for (T obj : list) {
                oos.writeObject(obj);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}