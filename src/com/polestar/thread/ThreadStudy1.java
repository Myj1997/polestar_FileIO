package com.polestar.thread;

import java.util.ArrayList;
import java.util.List;

public class ThreadStudy1 implements Runnable{

    List<Study> studyList;

    public ThreadStudy1(List<Study> studyList) {

        this.studyList = studyList; // Task2 의 리스트를 사용하기위해 기본생성자로 사용
    }

    @Override
    public void run() {

        for (int i = 0; i < studyList.size(); i ++){
            Study study = studyList.get(i);
           // study.setPatientName(studyList.get(i).getPatientName() + " A");

            System.out.println("A " + study.toString());
        }

    }
}
