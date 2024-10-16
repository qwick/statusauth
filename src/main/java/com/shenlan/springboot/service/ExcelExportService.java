package com.shenlan.springboot.service;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.shenlan.springboot.entity.MyEntity;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Service
public class ExcelExportService {

    private final DataService dataService;

    public ExcelExportService(DataService dataService) {
        this.dataService = dataService;
    }

    public void exportToExcel() throws IOException {
        File tempFile = File.createTempFile("data", ".xlsx");

        // 创建 ExcelWriter
        ExcelWriterBuilder writerBuilder = EasyExcel.write(tempFile, MyEntity.class);
        WriteSheet writeSheet = EasyExcel.writerSheet("Data").build();

        int pageSize = 1000;
        int[] pageNumber = {0}; // 使用数组作为可变容器
        List<MyEntity> data;

        ExecutorService executor = Executors.newFixedThreadPool(4); // 4个线程并行处理
        try {
            do {
                data = dataService.fetchData(pageNumber[0], pageSize);

                // 获取当前的 sheetNo
                int currentSheetNo = writeSheet.getSheetNo();

                // 使用不可变的 List 进行传递
                final List<MyEntity> finalData = Collections.unmodifiableList(data);

                executor.submit(() -> {
                    // 多线程处理数据并写入到 Excel
                    writerBuilder.sheet(currentSheetNo).doWrite(finalData);
                });

                pageNumber[0]++; // 增加页码
            } while (data.size() == pageSize);

            executor.shutdown();
            executor.awaitTermination(1, TimeUnit.HOURS); // 等待线程池完成任务
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("Excel file created at: " + tempFile.getAbsolutePath());
        }
    }
}



