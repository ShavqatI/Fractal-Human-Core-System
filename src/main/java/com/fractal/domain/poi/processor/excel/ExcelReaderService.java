package com.fractal.domain.poi.processor.excel;

import org.apache.poi.ss.usermodel.Workbook;

import java.nio.file.Path;

public interface ExcelReaderService {
    Workbook read(Path path);
}
