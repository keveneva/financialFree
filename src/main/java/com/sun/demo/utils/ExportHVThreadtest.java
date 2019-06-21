package com.sun.demo.utils;

import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;

public class ExportHVThreadtest extends Thread{
    private SXSSFSheet sheet; //sheet实体
    private String sheetCode; //sheet名
    public ExportHVThreadtest(SXSSFSheet sheet, String sheetCode) {
        this.sheet = sheet;
        this.sheetCode = sheetCode;
    }
    public void run() {
        System.out.println(Thread.currentThread().getName() + " " + sheetCode);
        //区分1-12Sheet编号
        switch(sheetCode){
            case "1":
                for(int i=0;i<100;i++){
                    SXSSFRow sxssfRow = sheet.createRow(i);
                    for(int j=0;j<14;j++){
                        sxssfRow.createCell(j).setCellValue("(" + i + "," + j + ")");
                    }
                    System.out.println("sheet:"+sheetCode+" row:"+i);
                }
                break;
            case "2" :
                for(int i=0;i<1000000;i++){
                    SXSSFRow sxssfRow = sheet.createRow(i);
                    for(int j=0;j<14;j++){
                        sxssfRow.createCell(j).setCellValue("(" + i + "," + j + ")");
                    }
                    System.out.println("sheet:"+sheetCode+" row:"+i);
                }
                break;
            case "3" :
                for(int i=0;i<1000000;i++){
                    SXSSFRow sxssfRow = sheet.createRow(i);
                    for(int j=0;j<14;j++){
                        sxssfRow.createCell(j).setCellValue("(" + i + "," + j + ")");
                    }
                    System.out.println("sheet:"+sheetCode+" row:"+i);
                }
                break;
            case "4" :
                for(int i=0;i<1000;i++){
                    SXSSFRow sxssfRow = sheet.createRow(i);
                    for(int j=0;j<14;j++){
                        sxssfRow.createCell(j).setCellValue("(" + i + "," + j + ")");
                    }
                    System.out.println("sheet:"+sheetCode+" row:"+i);
                }
                break;
            case "5" :
                for(int i=0;i<10000;i++){
                    SXSSFRow sxssfRow = sheet.createRow(i);
                    for(int j=0;j<14;j++){
                        sxssfRow.createCell(j).setCellValue("(" + i + "," + j + ")");
                    }
                    System.out.println("sheet:"+sheetCode+" row:"+i);
                }
                break;
            case "6" :
                for(int i=0;i<10000;i++){
                    SXSSFRow sxssfRow = sheet.createRow(i);
                    for(int j=0;j<14;j++){
                        sxssfRow.createCell(j).setCellValue("(" + i + "," + j + ")");
                    }
                    System.out.println("sheet:"+sheetCode+" row:"+i);
                }
                break;
            case "7" :
                for(int i=0;i<10000;i++){
                    SXSSFRow sxssfRow = sheet.createRow(i);
                    for(int j=0;j<14;j++){
                        sxssfRow.createCell(j).setCellValue("(" + i + "," + j + ")");
                    }
                    System.out.println("sheet:"+sheetCode+" row:"+i);
                }
                break;
            case "8" :
                for(int i=0;i<10000;i++){
                    SXSSFRow sxssfRow = sheet.createRow(i);
                    for(int j=0;j<14;j++){
                        sxssfRow.createCell(j).setCellValue("(" + i + "," + j + ")");
                    }
                    System.out.println("sheet:"+sheetCode+" row:"+i);
                }
                break;
            case "9" :
                for(int i=0;i<10000;i++){
                    SXSSFRow sxssfRow = sheet.createRow(i);
                    for(int j=0;j<14;j++){
                        sxssfRow.createCell(j).setCellValue("(" + i + "," + j + ")");
                    }
                    System.out.println("sheet:"+sheetCode+" row:"+i);
                }
                break;
            case "10" :
                for(int i=0;i<10000;i++){
                    SXSSFRow sxssfRow = sheet.createRow(i);
                    for(int j=0;j<14;j++){
                        sxssfRow.createCell(j).setCellValue("(" + i + "," + j + ")");
                    }
                    System.out.println("sheet:"+sheetCode+" row:"+i);
                }
                break;
            case "11" :
                for(int i=0;i<10000;i++){
                    SXSSFRow sxssfRow = sheet.createRow(i);
                    for(int j=0;j<14;j++){
                        sxssfRow.createCell(j).setCellValue("(" + i + "," + j + ")");
                    }
                    System.out.println("sheet:"+sheetCode+" row:"+i);
                }
                break;
            case "12" :
                for(int i=0;i<10000;i++){
                    SXSSFRow sxssfRow = sheet.createRow(i);
                    for(int j=0;j<14;j++){
                        sxssfRow.createCell(j).setCellValue("(" + i + "," + j + ")");
                    }
                    System.out.println("sheet:"+sheetCode+" row:"+i);
                }
                break;
            default:
                break;
        }
    }
}
