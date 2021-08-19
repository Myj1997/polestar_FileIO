package com.polestar.excel;

import com.polestar.thread.Study;
import com.polestar.thread.ThreadTest;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class StudyListToExcel {

    private static final String FILE_NAME = "excels/YjExcel.xlsx";


    public static void main(String[] args) {

        ThreadTest threadTest = new ThreadTest();
        List<Study> studyList = threadTest.studyListRun();

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("yj excel task");

        int rowNum = 0;
        for (int i = 0; i < studyList.size(); i++){
            Row row = sheet.createRow(rowNum++);
            int colNum = 0;

            Cell cell0 = row.createCell(colNum++);
            cell0.setCellValue(i + " : ");

            Cell cell = row.createCell(colNum++);
            cell.setCellValue("patientId : ");


            Cell cell2 = row.createCell(colNum++);
            cell2.setCellValue(studyList.get(i).getPatientId());

            Cell cell3 = row.createCell(colNum++);
            cell3.setCellValue("patientName : ");

            Cell cell4 = row.createCell(colNum++);
            cell4.setCellValue(studyList.get(i).getPatientName());



        }




        try {
            FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
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
