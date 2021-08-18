package com.polestar.json;

import com.fasterxml.jackson.core.FormatSchema;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.polestar.thread.Study;

import java.io.*;

public class JsonExample {
    public static void main(String [] args) {
        JsonExample jsonExample = new JsonExample();
        try {
            jsonExample.writeFile("jsontest.json");
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    private void writeFile(String path) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        Study study = new Study();
        study.setPatientId("13234");
        study.setPatientName("홍길동");
        // 데이터 객체를 스트링으로 저장한것

        String objectFile = objectMapper.writeValueAsString(study);

        System.out.println("JsonExample.writeFile OBJECT : " + objectFile);


        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
        String xmlFile = xmlMapper.writeValueAsString(study);
        System.out.println("XmlExample.writeFile XML : " + xmlFile);
    }
}
