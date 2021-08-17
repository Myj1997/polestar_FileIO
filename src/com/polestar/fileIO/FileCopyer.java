package com.polestar.fileIO;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileCopyer {

    public FileCopyer(String fileName) {
        // 경로 확인 방법
//        Path path = Paths.get("");
//        String cPath = path.toAbsolutePath().toString();
//        String dPath = System.getProperty("user.dir");
//        System.out.println("cPath : " + cPath);
//        System.out.println("dPath : " + dPath);

        // 원본 파일
        String originFileName = "read_target.txt";
        File originFile = new File(originFileName);

        // 복사할 파일의 경로 설정
        String filePath = originFile.getAbsolutePath().replace(originFileName,"");
        // 복사할 파일 생성
        File copyFile = new File(filePath + "\\CopyFiles\\" +  fileName);
        // fileName 만 넣었을 때 파일이 생성되지 않는 이유는 ? <- 찾아보기
        System.out.println("filePath : " + filePath);

        // 복사할 파일 디렉토리 생성
        // mkdir = 최하위 디렉토리만 생성
        // mkdirs = 디렉토리가 없다면 기술한 모든 디렉토리 생성
        if (copyFile.exists()){
            System.out.println("이미 파일이 존재합니다.");
        }else {
            System.out.println("파일을 생성합니다.");
        }

        if(copyFile.getParentFile().mkdirs()){
            System.out.println("디렉토리 생성 성공 하였습니다.");
        }else {
            System.out.println("디렉토리 생성 하지 않았습니다.");
        }

        try {
            // 원본 파일의 내용 읽기
            FileInputStream fileInputStream = new FileInputStream(originFile);
            // 복사할 파일 아웃풋 스트림 생성
            FileOutputStream fileOutputStream = new FileOutputStream(copyFile);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            
            // 바이트 배열 원본 파일의 길이만큼 생성
            byte[] bytesIn = new byte[(int) originFile.length()];
            int read = 0;

            // 원본 파일의 문자 길이만큼 반복하는 반복문 생성
            while ((read = fileInputStream.read(bytesIn)) != -1) {
                System.out.println("글자 수 : "  + read);
                // 바이트 어레이 아웃풋 스트림에 담는다.
                byteArrayOutputStream.write(bytesIn);
                // 파일 아웃풋 스트림으로 복사할 파일에 내용 복사
                fileOutputStream.write(byteArrayOutputStream.toByteArray());

                // 바이트로 바로 출력 시 글자 깨짐 현상이 나타난다.
                System.out.println("bytesIn : ");
                for(int i = 0; i < bytesIn.length; i++){
                    System.out.print((char)bytesIn[i]);
                }
                System.out.println("");

                String content = new String(bytesIn,0,read);
                System.out.println("content : " + content);
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
