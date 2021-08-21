package com.polestar.excel;

import com.polestar.thread.Study;
import com.polestar.thread.ThreadTest;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudyListToExcel {

    // static 으로 처리는 나쁜 예
    //private static final String FILE_NAME = "excels/YjExcel3.xlsx";
    private String[] headers = {"patientId","patientName"};

    public void makeExcel(String fileName){

        ThreadTest threadTest = new ThreadTest();
        List<Study> studyList = threadTest.studyListRun();

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("yj excel task");
        Row row = null;

//        for (int i = 0; i < studyList.size(); i++) {
//            row = sheet.createRow(i);
//            row.setHeight((short) 356);
//            row.createCell(0).setCellValue(i);
//            row.createCell(1).setCellValue(studyList.get(i).getPatientId());
//            row.createCell(2).setCellValue(studyList.get(i).getPatientName());
//            sheet.autoSizeColumn(i);
//        }

        // test code start
        int rowNum = 0;
        int colNum = 0;
        // 헤더
        row = sheet.createRow(rowNum++);
        for(int i  = 0; i < headers.length; i++){
            //colNum = 0;
            row.createCell(colNum++).setCellValue(headers[i]);
           // row.createCell(colNum++).setCellValue(iExcel.getValue(headers));
        }

        // 내용
        for(int j = 0; j < studyList.size(); j ++){
            row = sheet.createRow(rowNum++);
            IExcel iExcel = studyList.get(j);
            colNum = 0;

            for(int k  = 0; k < headers.length; k++){
                row.createCell(colNum++).setCellValue(iExcel.getValue(headers[colNum -1]));
            }
        }
        // test code end

        try {
            FileOutputStream outputStream = new FileOutputStream("excels/" + fileName);
            workbook.write(outputStream);
            workbook.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Done");
    }


}
