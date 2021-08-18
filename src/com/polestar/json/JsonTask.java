package com.polestar.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.polestar.thread.Study;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JsonTask {

    private String dPath = System.getProperty("user.dir");

    public JsonTask() {
    }

    // 파일 쓰기용
    public void jsonWrite(String fileName, List<Study> studyList) throws JsonProcessingException {

        // 1. 리스트 생성 // 이미 만들어 놓은거 쓰기

        ObjectMapper objectMapper = new ObjectMapper();

        // writeValue로 해보기
//        try {
//            objectMapper.writeValue(new File("src/jsonFile2.json"),studyList);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        // 공백포함 시키기(줄 바꿈 해서 아웃풋 해준다.)
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        // .writerWithDefaultPrettyPrinter() -> .writerWithDefaultPrettyPrinter() 똑같음. 이쁘게 출력
        // writeValueAsString() -> String 으로 타입변환.
        // 파라미터 : String 으로 타입 변환 해줄 대상
        String objectFile = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(studyList);

        // 2. 파일 만들기
        System.out.println("dPath : " +dPath);

        File jsonFile = new File(dPath + "\\jsonFiles\\" + fileName);

        if(jsonFile.getParentFile().mkdirs()){
            System.out.println("디렉토리 생성");
        }else {
            System.out.println("디렉토리 생성안됨");
        }

        try {
            // * FilWriter 로도 파일 생성 가능 하다.
            FileWriter fw = new FileWriter(jsonFile);
            fw.write(objectFile);
            fw.flush();
            fw.close(); // close or flush 를 해야 파일에 써진다.
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void jsonReader(String fileName){

        FileInputStream fis = null;
        ByteArrayOutputStream byteArrayOutputStream = null;

        try {
            // 스트림을 써야댐(순수 바이트 그대로 가져오기위해)
            // 한줄씩 처리하면 객체로 변환 불가
            byte[] bytesIn = new byte[fileName.length()];
            int read = 0;
            String content = null;

            fis = new FileInputStream(dPath + "\\jsonFiles\\" + fileName);
            byteArrayOutputStream = new ByteArrayOutputStream();

            while ((read = fis.read(bytesIn)) != -1){
                byteArrayOutputStream.write(bytesIn, 0 ,read);
                content = new String(byteArrayOutputStream.toByteArray());
            }
                System.out.println(fileName + " : " + content);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
                byteArrayOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



}
