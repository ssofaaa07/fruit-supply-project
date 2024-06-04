package com.ssofaaa.services;

import com.ssofaaa.entities.Delivery;
import com.ssofaaa.entities.DeliveryItem;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class ReportService {

    @Autowired
    private DeliveryService deliveryService;
    public Workbook createReport(Date startDate, Date endDate) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Отчет о поставках");

        CellStyle headerCellStyle = workbook.createCellStyle();
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontName("Times New Roman");
        headerFont.setFontHeightInPoints((short) 14);
        headerCellStyle.setFont(headerFont);

        Row titleRow = sheet.createRow(0);
        titleRow.createCell(0).setCellValue("Отчет о поставках за выбранный период: " + startDate.toString() + " - " + endDate.toString());
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 5));
        titleRow.getCell(0).setCellStyle(headerCellStyle);

        Row headerRow = sheet.createRow(1);
        headerRow.createCell(0).setCellValue("№");
        headerRow.createCell(1).setCellValue("Дата поставки");
        headerRow.createCell(2).setCellValue("Компания-поставщик");
        headerRow.createCell(3).setCellValue("Наименование фрукта");
        headerRow.createCell(4).setCellValue("Вес, кг");
        headerRow.createCell(5).setCellValue("Стоимость");

        List<Delivery> deliveries = deliveryService.listDeliveriesByDeliveryDateBetween(startDate, endDate);

        CellStyle cellStyle = workbook.createCellStyle();
        headerCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);

        BigDecimal resultSum = new BigDecimal(0);
        int rowNum = 2;
        int rowStartNum = 2;
        for (Delivery delivery : deliveries) {
            List<DeliveryItem> deliveryItems = deliveryService.listDeliveryItemsByDeliveryId(delivery.getId());
            for (DeliveryItem deliveryItem : deliveryItems) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(delivery.getId());
                row.createCell(1).setCellValue(delivery.getDeliveryDate().toString());
                row.createCell(2).setCellValue(delivery.getSupplier().getSupplierName());
                row.createCell(3).setCellValue(deliveryItem.getFruit().getFruitType() + " " + deliveryItem.getFruit().getFruitName());
                row.createCell(4).setCellValue(deliveryItem.getCountOfFruits());
                row.createCell(5).setCellValue(Double.parseDouble(deliveryItem.getSumPrice().toString()));
                resultSum = resultSum.add(deliveryItem.getSumPrice());
            }
            sheet.addMergedRegion(new CellRangeAddress(rowStartNum, rowNum - 1, 0, 0));
            sheet.addMergedRegion(new CellRangeAddress(rowStartNum, rowNum - 1, 1, 1));
            sheet.addMergedRegion(new CellRangeAddress(rowStartNum, rowNum - 1, 2, 2));
            rowStartNum = rowNum;
        }

        Row row = sheet.createRow(rowNum);
        row.createCell(4).setCellValue("Итого");
        row.getCell(4).setCellStyle(headerCellStyle);
        row.createCell(5).setCellValue(resultSum.toString());

        for (int i = 0; i < 6; i++) {
            headerRow.getCell(i).setCellStyle(headerCellStyle);
            sheet.autoSizeColumn(i);
        }

        try (FileOutputStream fileOut = new FileOutputStream("delivery_report.xlsx")) {
            workbook.write(fileOut);
        }
        return workbook;
    }
}
