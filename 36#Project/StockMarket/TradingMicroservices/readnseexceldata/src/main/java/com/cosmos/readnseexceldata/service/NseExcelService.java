package com.cosmos.readnseexceldata.service;

import com.cosmos.readnseexceldata.pojo.NSEExcelData;
import com.cosmos.readnseexceldata.pojo.NSEExcelDatas;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@Slf4j
public class NseExcelService {
    public NSEExcelDatas readExcelFileData(String onDate){
        LocalDate date = LocalDate.parse(onDate, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        String fileName = generateFileName(date);
        List<NSEExcelData> nseExcelDataList = readExcelFile(fileName);
        NSEExcelDatas nseExcelDatas = new NSEExcelDatas();
        nseExcelDatas.setNseExcelDataList(nseExcelDataList);
        return nseExcelDatas;
    }

    private String generateFileName(LocalDate date){
        String month =date.getMonth().toString();
        int day = date.getDayOfMonth();
        String fileName = day+month+"NSEData2022.xlsx";
        System.out.println(fileName);
        return fileName;
    }
    public List<NSEExcelData> readExcelFile(String fileName){
        List<NSEExcelData> nseExcelDataList = new ArrayList<>();
        FileInputStream file = null;
        try {
            NSEExcelData nseExcelData= new NSEExcelData();
            File file1 = ResourceUtils.getFile("classpath:"+fileName);
            file = new FileInputStream(file1);
            Workbook workbook = new XSSFWorkbook(file);

            DataFormatter dataFormatter = new DataFormatter();
            Sheet sheet = workbook.getSheetAt(0);
            log.info("Read this sheet "+sheet.getSheetName());
            int rowCount = sheet.getPhysicalNumberOfRows();
            log.info("Read this sheet length : "+rowCount);
            Iterator<Row> rows = sheet.iterator();
            while(rows.hasNext()){
                Row row = rows.next();
                nseExcelData = assignCompany(row);
                nseExcelDataList.add(nseExcelData);
            }
            workbook.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return nseExcelDataList;
    }
    private NSEExcelData assignCompany(Row row){
        String companyName = row.getCell(0).toString();
        Float companyLTP = 0f;
        Float companyOpen = 0f;
        Float companyHigh = 0f;
        Float companyLow = 0f;
        Float companyVolume = 0f;
        Float companyPreviousClose = 0f;
        try{
             String ltp = row.getCell(1).toString();
             companyLTP = Float.parseFloat(ltp);
             companyOpen = Float.parseFloat(row.getCell(2).toString());
             companyHigh = Float.parseFloat(row.getCell(3).toString());
             companyLow = Float.parseFloat(row.getCell(4).toString());
             companyVolume = Float.parseFloat(row.getCell(5).toString());
             companyPreviousClose = Float.parseFloat(row.getCell(6).toString());

        }catch(Exception Ex){
            System.out.println(Ex.getMessage()+companyName);
        }
        return new NSEExcelData(companyName,companyLTP,companyOpen,companyHigh,companyLow,companyVolume,companyPreviousClose);
    }
}
