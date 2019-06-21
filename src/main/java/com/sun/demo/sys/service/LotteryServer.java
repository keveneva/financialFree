package com.sun.demo.sys.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by dell on 2019/5/29.
 */
public interface LotteryServer {

    void importExcel(MultipartFile file) throws IOException;

    String downloadMode() throws IOException;


}
