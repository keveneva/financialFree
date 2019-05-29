package com.sun.demo.sys.controller;

import com.sun.demo.sys.service.LotteryServer;
import com.sun.demo.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class LotteryController {
    @Autowired
    private LotteryServer lotteryServer;

    @RequestMapping(value="sys/upload")
    public R upload( @RequestParam(value = "file") MultipartFile file) throws IOException {
        lotteryServer.importExcel(file);
        return R.ok();
    }
    @RequestMapping(value="sys/download")
    public R download() throws IOException {
        String fileName = lotteryServer.downloadMode();
        return R.ok().put("fileName", fileName);
    }




}
