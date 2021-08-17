package com.polestar.fileIO;

import java.io.*;

public class FileCopyer {

    public FileCopyer(String fileName) {
        // 원본 파일
        File originfile = new File("read_target.txt");

        // 복사할 파일의 경로 설정
        String filePath = originfile.getAbsolutePath().replace("read_target.txt","");
        // 복사할 파일 생성
        File copyFile = new File(filePath + fileName);
        System.out.println("filePath : " + filePath);

        // 복사할 파일 디렉토리 생성
        if(copyFile.getParentFile().mkdir()){
            System.out.println("디렉토리 생성 성공");
        }else {
            System.out.println("실패");
        }

        try {
            // 원본 파일의 내용 읽기
            FileInputStream fileInputStream = new FileInputStream(originfile);
            // 복사할 파일 아웃풋 스트림 생성
            FileOutputStream fileOutputStream = new FileOutputStream(copyFile);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            
            // 바이트 배열 원본 파일의 길이만큼 생성
            byte[] bytesIn = new byte[(int) originfile.length()];
            int read = 0;
            
            while ((read = fileInputStream.read(bytesIn)) != -1) {
                System.out.println("글자 수 : "  + read);
                // 바이트 어레이 아웃풋 스트림에 담는다.
                byteArrayOutputStream.write(bytesIn);
                // 파일 아웃풋 스트림으로 복사할 파일에 내용 복사
                fileOutputStream.write(byteArrayOutputStream.toByteArray());

                System.out.println("내용 복사 완료");
            }

        } catch (FileNotFoundException e) {
            System.out.println("파일이 없습니다.");
            e.printStackTrace();

        } catch (IOException e) {
            System.out.println("파일을 읽는중 오류 발생 했습니다.");
            e.printStackTrace();
        }

    }
}
