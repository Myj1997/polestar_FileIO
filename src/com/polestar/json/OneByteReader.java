package com.polestar.json;

import java.io.*;

public class OneByteReader {

    private String dPath = System.getProperty("user.dir");


    public void byteReader(String fileName){

        try {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

            int read = 0;
            int count = 1;
            byte[] bytesIn = new byte[1];
            String content = null;
            System.out.println("123123123");

            while ((read = fileInputStream.read(bytesIn)) != -1){

                if(count <= 100){
                    byteArrayOutputStream.write(bytesIn,0,read);

                    content = new String(byteArrayOutputStream.toByteArray());

                    System.out.println("content : " + content);
                    System.out.println("count : " + count);
                    count ++;
                }else if(count > 100){
                    break;
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
