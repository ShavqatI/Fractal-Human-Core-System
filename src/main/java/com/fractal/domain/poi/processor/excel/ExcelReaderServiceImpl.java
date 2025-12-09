package com.fractal.domain.poi.processor.excel;

import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;

@Service
@RequiredArgsConstructor
class ExcelReaderServiceImpl implements ExcelReaderService {
    @Override
    public Workbook read(Path path) {
        try (FileInputStream fis = new FileInputStream(path.toFile());
             Workbook workbook = new XSSFWorkbook(fis)
           ) {
            return workbook;
        } catch (IOException e) {
            e.printStackTrace();
        }
       return null;
    }
}
