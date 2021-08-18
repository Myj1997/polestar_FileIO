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
            study.setPatientId("13234 " + i);
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

        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        String objectFile = objectMapper.writeValueAsString(studyList);
        //System.out.println(fileName+ " : " + objectFile);

        // 파일 만들기
        File jsonFile = new File(fileName);

        try {
            FileWriter fw = new FileWriter(jsonFile);
            fw.write(objectFile);
            fw.close(); // close를 해야 파일에 써진다.
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
