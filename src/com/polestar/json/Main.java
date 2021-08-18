package com.polestar.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.polestar.thread.ThreadTest;


public class Main {

    public static void main(String[] args) throws JsonProcessingException {

        ThreadTest threadTest = new ThreadTest();

        JsonTask jsonTask = new JsonTask();
        String filName = "jsonFile1.json";
//        jsonTask.jsonWrite(filName,threadTest.studyListRun());
//        jsonTask.jsonReader(filName);


        // 과제 1. 1바이트 씩 100번 읽기
        OneByteReader oneByteReader = new OneByteReader();
        oneByteReader.byteReader("chiwawa.jpg");

        // 과제 2.
    }
}
