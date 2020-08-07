package case_study.read_write;

import case_study.storeage.SneakerManager;

import java.io.*;


public class WriteObject {
    public static void main(String[] args) {
       SneakerManager sneakerManager = new SneakerManager();
       sneakerManager.setDefaultData();
       try {
           File file;

           FileOutputStream fos = new FileOutputStream("PRODUCTS/shose.txt");
           ObjectOutputStream oos = new ObjectOutputStream(fos);
           oos.writeObject(sneakerManager.list);

           oos.close();
           fos.close();
       } catch (FileNotFoundException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       }
    }
}
