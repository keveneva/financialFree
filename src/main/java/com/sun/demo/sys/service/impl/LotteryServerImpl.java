package com.sun.demo.sys.service.impl;

import com.sun.demo.sys.service.LotteryServer;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

/**
 * Created by me on 2018/1/15.
 */
@Component
public class LotteryServerImpl implements LotteryServer {
    @Value("${lms.tempFilePath}")
    private String tempFilePath;

    @Override
    public void importExcel(MultipartFile file) throws IOException {
        System.out.println("上传成功");
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
