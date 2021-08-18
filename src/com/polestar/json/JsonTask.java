package com.polestar.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.polestar.study.Study;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JsonTask {


    public JsonTask() {
    }

    void jsonWrite(String fileName) throws JsonProcessingException {

        List<Study> studyList = new ArrayList<>();
        for(int i = 0; i < 10; i ++){
            Study study = new Study();
            study.setPatientId("pId " + i);
            study.setPatientName("홍길동 " + i);
            studyList.add(study);
        }

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

        // 파일 만들기
        File jsonFile = new File(fileName);

        try {
            FileWriter fw = new FileWriter(jsonFile);
            fw.write(objectFile);
            fw.flush();
            fw.close(); // close or flush 를 해야 파일에 써진다.
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void jsonReader(String fileName){

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fileReader);

            String str = null;
            while ((str = br.readLine()) != null){
                System.out.println(str);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
