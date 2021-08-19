package com.polestar.json;

import java.io.*;

public class ThreadByteInserter {

    public void inserter() throws FileNotFoundException {

        int count = 0;
        byte[] bytesIn = new byte[1];
        bytesIn[0] = 65;
        File file = new File("oneByteWriter.txt");

        FileOutputStream fos = null;
        // FileInputStream fis = null;

        fos = new FileOutputStream(file);


        long oneMinuteLater = System.currentTimeMillis() + 6000;
        System.out.println("cut : " + System.currentTimeMillis());
        System.out.println("onm : " + oneMinuteLater);

        while (System.currentTimeMillis() == oneMinuteLater){
            System.out.println("돌아간다");
            try {
                fos.write((char)bytesIn[0]);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        System.out.println("1");
        for (int i = 0; System.currentTimeMillis() >= oneMinuteLater; ){
            System.out.println("돌아간다2");
            try {
                fos.write((char)bytesIn[0]);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        long fileSize = file.length();
        System.out.println(file.getName() + " File Size : " + fileSize + " byte");

    }
}
