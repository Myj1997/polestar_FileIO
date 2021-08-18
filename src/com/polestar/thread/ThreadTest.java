package com.polestar.thread;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.polestar.json.JsonTask;

import java.util.ArrayList;
import java.util.List;

public class ThreadTest {

    public List<Study> studyListRun() {

        List<Study> studyList = new ArrayList<Study>();

        for (int i = 0; i < 100; i++){
            Study study = new Study();

            study.setPatientId("pId" + i);
            study.setPatientName("민연준 " + i);

            studyList.add(study);
        }

//        Thread thread1 = new Thread(new ThreadStudy1(studyList));
//        Thread thread2 = new Thread(new ThreadStudy2(studyList));
//
//
//
//        thread1.start();
//        thread2.start();

        return studyList;
    }
}
