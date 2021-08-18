package com.polestar.json;

import java.io.*;

public class OneByteWriter {
//        2. 60초 동안 파일에 0값 write 해서 파일을 만들어보자. 몇바이트가 생성 될까?
// 1. 파일 0번째 값 가져오기
    public void sixtySecondInserter(){

        int count = 0;
        byte[] bytesIn = new byte[1];
        bytesIn[0] = 0;

        File file = new File("zeroByteInsert.txt");

        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for(; count < 60; count++){
            try {
                Thread.sleep(100);
                fos.write(bytesIn[0]);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //String content = new String();
            System.out.println(count);

        }

        long fileSize = file.length();
        System.out.println(file.getName() + " File Size : " + fileSize + " byte");

    }
}
