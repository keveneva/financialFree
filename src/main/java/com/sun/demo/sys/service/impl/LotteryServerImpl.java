package com.sun.demo.sys.service.impl;

import com.sun.demo.sys.entity.TwoColourEntity;
import com.sun.demo.sys.repository.TwoColourRepository;
import com.sun.demo.sys.service.LotteryServer;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.CellType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by me on 2018/1/15.
 */
@Service("lotteryServer")
public class LotteryServerImpl implements LotteryServer {

    @Value("${lms.tempFilePath}")
    private String tempFilePath;

    @Autowired
    private TwoColourRepository twoColourRepository;


    @Override
    public void importExcel(MultipartFile file) throws IOException {

        try{
            HSSFWorkbook workbook = new HSSFWorkbook(new POIFSFileSystem(file.getInputStream()));
            HSSFSheet sheet = workbook.getSheetAt(0);
            //总列数
            int coloumNum = sheet.getRow(0).getPhysicalNumberOfCells();
            //总行数
            int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();

            List<TwoColourEntity> result = new ArrayList<>();
            for (int j = 0; j < physicalNumberOfRows; j++) {
                HSSFRow row = sheet.getRow(j);
                if (j == 0 || row == null) {
                    continue;
                }
                TwoColourEntity entity =  new TwoColourEntity();
                for (int k = 0; k < coloumNum; k++) {
                    HSSFCell cell = null!=row.getCell(k)?row.getCell(k):row.createCell(k);
                    cell.setCellType(CellType.STRING);
                    String cellValue = null ==cell?"":cell.getStringCellValue();
                    switch (k) {
                        case 0:
                            entity.setNumber(Integer.parseInt(cellValue));
                            break;
                        case 1:
                            entity.setA(Integer.parseInt(cellValue));
                            break;
                        case 2:
                            entity.setB(Integer.parseInt(cellValue));
                            break;
                        case 3:
                            entity.setC(Integer.parseInt(cellValue));
                            break;
                        case 4:
                            entity.setD(Integer.parseInt(cellValue));
                            break;
                        case 5:
                            entity.setE(Integer.parseInt(cellValue));
                            break;
                        case 6:
                            entity.setF(Integer.parseInt(cellValue));
                            break;
                        case 7:
                            entity.setBlue(Integer.parseInt(cellValue));
                            break;
                        case 8:
                            entity.setCumulative(Double.parseDouble(cellValue));
                            break;
                        case 9:
                            entity.setOneNum(Integer.parseInt(cellValue));
                            break;
                        case 10:
                            entity.setOneMoney(Double.parseDouble(cellValue));
                            break;
                        case 11:
                            entity.setTwoNum(Integer.parseInt(cellValue));
                            break;
                        case 12:
                            entity.setTwoMoney(Double.parseDouble(cellValue));
                            break;
                        case 13:
                            entity.setTotalMoney(Double.parseDouble(cellValue));
                            break;
                        case 14:
                            System.out.println("日期==================="+cellValue);
                            entity.setTime(new Date());
                            break;
                        default:{

                        }

                    }

                 }
                result.add(entity);
            }

            this.twoColourRepository.save(result);
        }catch (Exception e){

        }


    }

    @Override
    public String downloadMode() throws IOException {
        try {
            String url = "excelMode/historyImport.xls";
            ClassPathResource classPathResource = new ClassPathResource(url);
            InputStream inputStream = classPathResource.getInputStream();
            POIFSFileSystem fs = new POIFSFileSystem(inputStream);
            //读取excel模板
            HSSFWorkbook workbook = new HSSFWorkbook(fs);

            String name = UUID.randomUUID().toString() + ".xls";
            File file = new File(tempFilePath);
            if(!file.exists()){
                file.mkdirs();
                file.setWritable(true,true);
            }
            workbook.write(new File(tempFilePath+"/" +name));
            return name;
        }catch (Exception e){
            throw e;
        }finally {

        }
    }

}
