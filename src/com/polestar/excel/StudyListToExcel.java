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
    private static final String FILE_NAME = "excels/YjExcel.xlsx";
    private String[] headers = {"patientId","patientName"};

    public static void main(String[] args) {

        // testCode // 스터디 객체에서 IExecl 오버라이드 한 후 if 페이션츠아이디.이퀄 일때 리턴 get페이션츠

        // test code end

        ThreadTest threadTest = new ThreadTest();
        List<Study> studyList = threadTest.studyListRun();

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("yj excel task");
        Row row = null;

        // 스터디 객체를 인터페이스로 만들고
        // 밸류를 파라미터로 주면 다른 객체를 사용해도 쓸 수 있지 않을까

        for (int i = 0; i < studyList.size(); i++) {
            row = sheet.createRow(i);
            row.setHeight((short) 356);
            sheet.autoSizeColumn(i);
            row.createCell(0).setCellValue(i);
            row.createCell(1).setCellValue(studyList.get(i).getPatientId());
            row.createCell(2).setCellValue(studyList.get(i).getPatientName());
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
