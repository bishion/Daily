package com.bizi.excel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.List;

/**
 * Created by guofangbi on 2016/11/24.
 */
public class ReadExcel {
    public static List<List<String>> readExcel(String filePath,String sheetNo){
        Workbook wb = null;
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(new File(filePath));
            if(filePath.endsWith("xls")){
                wb = new HSSFWorkbook(inputStream);
            }else{
                wb = new XSSFWorkbook(inputStream);
            }



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(inputStream!=null){
                try {
                    inputStream.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            if (wb != null){
                try {
                    wb.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
