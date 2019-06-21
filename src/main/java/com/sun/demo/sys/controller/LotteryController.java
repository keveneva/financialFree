package com.sun.demo.sys.controller;

import com.sun.demo.common.base.controller.BaseController;
import com.sun.demo.sys.service.LotteryServer;
import com.sun.demo.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class LotteryController extends BaseController {
    @Autowired
    private LotteryServer lotteryServer;

    @RequestMapping(value="sys/twoColor/upload")
    public R upload( @RequestParam(value = "file") MultipartFile file) throws IOException {
        lotteryServer.importExcel(file);
        return R.ok();
    }
    @RequestMapping(value="sys/twoColor/download")
    public R download() throws IOException {
        String fileName = lotteryServer.downloadMode();
        return R.ok().put("fileName", fileName);
    }

}
