package com.polestar.excel;

public class Main {

    public static void main(String[] args) {

        String[] headers = {"patientId2","patientName2"};


        StudyListToExcel studyListToExcel = new StudyListToExcel();
        studyListToExcel.MakeExcel(headers);

    }
}
