package com.polestar.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.polestar.thread.ThreadTest;

import java.io.FileNotFoundException;


public class Main {

    public static void main(String[] args) throws JsonProcessingException {

        ThreadTest threadTest = new ThreadTest();

        // 과제 0. List를 Json 으로 출력
        JsonTask jsonTask = new JsonTask();
        // List -> json 파일로 만들기
        jsonTask.jsonWrite("jsonFile.json",threadTest.studyListRun());
        // json 파일 바이트스트림으로 읽기
        jsonTask.jsonReader("jsonFile.json");

        // 과제 1. 1바이트 씩 100번 읽기
//        OneByteReader oneByteReader = new OneByteReader();
//        oneByteReader.byteReader("ASCII.png");

//        // 과제 2. 60초 동안 파일에 0값 write 해서 파일을 만들어보자. 몇바이트가 생성 될까?
//        OneByteWriter oneByteWriter = new OneByteWriter();
//        oneByteWriter.sixtySecondInserter();


    }
}
