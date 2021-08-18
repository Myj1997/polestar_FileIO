package com.polestar.thread;

import java.util.List;

public class ThreadStudy2 implements Runnable{

    List<Study> studyList;

    public ThreadStudy2(List<Study> studyList){

        this.studyList = studyList;
    }

    @Override
    public void run()  {

        for (int i = studyList.size() -1 ; i >=0; i--) {

            Study study = studyList.get(i);

            System.out.println("B " + study.toString());

        }

    }


}
