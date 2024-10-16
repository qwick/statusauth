package com.shenlan.springboot.controller;

import com.shenlan.springboot.service.ExcelExportService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Date;

@RestController
public class ExportController {

    private final ExcelExportService excelExportService;

    public ExportController(ExcelExportService excelExportService) {
        this.excelExportService = excelExportService;
    }

    @GetMapping("/export")
    public String exportData() {
        try {
            System.out.println("当前时间："+new Date());
            excelExportService.exportToExcel();
            System.out.println("当前时间："+new Date());
            return "Export started! Check the console for the file location.";
        } catch (IOException e) {
            return "Export failed: " + e.getMessage();
        }
    }
}
