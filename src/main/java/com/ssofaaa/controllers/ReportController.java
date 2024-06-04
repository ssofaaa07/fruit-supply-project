package com.ssofaaa.controllers;

import com.ssofaaa.services.ReportService;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URI;
import java.sql.Date;

@RestController
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/downloadReport")
    public ResponseEntity<Resource> downloadExcelFile(@RequestParam String start, @RequestParam String end) throws IOException {
        Date startDate = Date.valueOf(start);
        Date endDate = Date.valueOf(end);
        Workbook workbook = reportService.createReport(startDate, endDate);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        workbook.write(outputStream);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=delivery_report.xlsx");
        headers.add("Location", "/");

        return ResponseEntity
                .ok()
                .contentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
                .headers(headers)
                .body(new ByteArrayResource(outputStream.toByteArray()));
    }
}

