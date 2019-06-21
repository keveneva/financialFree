package com.example.demo;

import com.sun.demo.utils.ExportHVThreadtest;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.tomcat.util.threads.ThreadPoolExecutor;
import org.springframework.core.io.ClassPathResource;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by me on 2018/1/16.
 */
public class Test {
    private final static int sheetDealCount = 12;
    public void run() {
        System.out.println("测试========》");
        String url = "excelMode/historyImport.xls";
        ClassPathResource classPathResource = new ClassPathResource(url);
        System.out.println(classPathResource.getPath());
    }

    public static void main(String[] args) throws IOException {
        //定义一个CountDownLatch，它的作用可以理解为集齐七龙珠召唤神龙。
        //实际本例中我们必须要等线程池的所有线程执行完写数据的任务最后执行write操作。
        //在count到0之前，主线程将一直await状态。
        final CountDownLatch countDownLatch = new CountDownLatch(sheetDealCount);
        long startTime = System.currentTimeMillis();
        //我们定义一个窗口是100000大小的SXSSFWorkbook
        //这里所谓的窗口是指n条数据写到内存后，直接转移到磁盘中，从而节约内存空间
        SXSSFWorkbook sw = new SXSSFWorkbook(100000);
        List<SXSSFSheet> swList = new ArrayList<>();
        for(int i=1;i<=12;i++){
            swList.add(sw.createSheet("s"+i));
        }
        //创建线程池，最大容纳4条线程
        ThreadPoolExecutor tpe = new ThreadPoolExecutor(4, 4, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(12));
        try{
            for(SXSSFSheet sxssfSheet : swList){
                //创建线程对象，用于执行写Excelsheet页方法
                ExportHVThreadtest et = new ExportHVThreadtest(sxssfSheet, sxssfSheet.getSheetName().replace("s", "").toString());
                tpe.execute(() -> {
                    //执行写excel方法
                    et.run();
                    //每执行完一个线程方法，count数减一。
                    countDownLatch.countDown();
                });
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            tpe.shutdown();
        }
        try {
            OutputStream out = new FileOutputStream("D:/temp/test.xlsx");
            //只要countDown的数量大于0，那么主线程将一直处于阻塞状态
            countDownLatch.await();
            //一旦所有线程执行完毕，及执行write方法。所谓的write就是完成excel的数据插入操作。
            System.out.println("准备执行write");
            sw.write(out);
        } catch (Exception e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);
    }
}
