package com.fractal.domain.poi.processor.excel;

import java.nio.file.Path;

public interface ExcelToPdfConverterService {

    Path convert(Path excelFilePath, Path pdfFilePath);
}
