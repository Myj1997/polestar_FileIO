package com.polestar.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.polestar.thread.ThreadTest;


public class Main {

    public static void main(String[] args) throws JsonProcessingException {

        ThreadTest threadTest = new ThreadTest();
        String filName = "read_target.json";

        // List를 Json 으로 출력
        JsonTask jsonTask = new JsonTask();
        jsonTask.jsonWrite(filName,threadTest.studyListRun());
        jsonTask.jsonReader(filName);

        // 과제 1. 1바이트 씩 100번 읽기
//        OneByteReader oneByteReader = new OneByteReader();
//        oneByteReader.byteReader(filName);

//        2. 60초 동안 파일에 0값 write 해서 파일을 만들어보자. 몇바이트가 생성 될까?
//        OneByteWriter oneByteWriter = new OneByteWriter();
//        oneByteWriter.sixtySecondInserter();


    }
}
