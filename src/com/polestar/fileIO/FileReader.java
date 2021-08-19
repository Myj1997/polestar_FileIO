package com.polestar.fileIO;

import java.io.*;

public class FileReader {

    private  void readFIle(){

        File file = new File("readFiles/read_target.txt");
        boolean status = file.exists();
        System.out.println("FileReader.readFile : " + status +", " + file.getAbsolutePath());

        // 1 .파일 안의 내용능 읽으시오
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bytesIn = new byte[8];
            int read = 0;
            long size = 0;
            String value = null;
            while ((read = fileInputStream.read(bytesIn)) != -1) {
                byteArrayOutputStream.write(bytesIn, 0, read);
                System.out.println("read : " +read);
                value = new String(byteArrayOutputStream.toByteArray());
                System.out.println("value : " +value);
                size+=read;
            }
            System.out.println(" 1 " + read);
            System.out.println(" 2 " + size);
            System.out.println(" 3 " + value);
            System.out.println(" ");

        } catch (FileNotFoundException e) {
            
            e.printStackTrace();
            // 원래는 오류처리를 해야되요. 프린트 스택 처리해서 죽여버리면 서비스가 안되겠죠
            System.out.println("파일이 없습니다.");
        } catch (IOException e) {
            System.out.println("FileReader.readFile " + file.getName() +" read 오류.");
            e.printStackTrace();
        }
        // 일단 바이트로 다 뽑아서 스트림에 쌓아 놓은다음 쓰는거다.
        // 인풋스트림리더는 1바이트씩 읽어서 한글이 무조건 깨진다.

        // 2. 읽은 내용을 출력 하시오
        // 3. 파일 2로 복사해서 내용을 넣으시오
    }

    public static void main(String[] args) {

        FileReader fileReader = new FileReader();
        // 자기자신안에 new 메소드를 왜 썼을까  // 유닉스라는 철학 -> 프린트를 연결하든 루트하는 디바이스아래에 통신 // C언어 이전에 B언어

        fileReader.readFIle();
    }
}

