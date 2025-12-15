package com.fractal.domain.poi.processor.word;

import fr.opensagres.poi.xwpf.converter.pdf.PdfConverter;
import fr.opensagres.poi.xwpf.converter.pdf.PdfOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTblLayoutType;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.nio.file.Path;

@Service
class WordToPdfConverterServiceImpl implements WordToPdfConverterService {

    @Override
    public Path convert(Path wordFilePath, Path pdfFilePath)  {
        try (InputStream in = new FileInputStream(wordFilePath.toFile());
             OutputStream out = new FileOutputStream(pdfFilePath.toFile())) {
             XWPFDocument document = new XWPFDocument(in);
             PdfOptions options = PdfOptions.create();
             PdfConverter.getInstance().convert(document, out, options);
             return pdfFilePath;
        } catch (Exception e) {
            throw new RuntimeException("An error occurred during conversion: " + e.getMessage());
        }
    }

    /*public Path convert(Path wordFilePath, Path pdfFilePath)  {
        try (InputStream in = new FileInputStream(wordFilePath.toFile());
             OutputStream out = new FileOutputStream(pdfFilePath.toFile())) {

            XWPFDocument document = new XWPFDocument(in);

            // --- Preserve original table widths ---
            for (XWPFTable table : document.getTables()) {
                // Set table layout to fixed width
                table.getCTTbl().getTblPr().getTblLayout().setType(STTblLayoutType.FIXED);

                // Ensure each cell width is preserved
                for (XWPFTableRow row : table.getRows()) {
                    for (XWPFTableCell cell : row.getTableCells()) {
                        // Get current cell width (if exists) or default
                        if (cell.getCTTc().getTcPr() == null) cell.getCTTc().addNewTcPr();
                        if (cell.getCTTc().getTcPr().getTcW() != null) continue; // already has width
                        cell.getCTTc().getTcPr().addNewTcW().setW(BigInteger.valueOf(2000)); // default width
                    }
                }
            }

            // --- Convert to PDF without scaling ---
            PdfOptions options = PdfOptions.create();
            PdfConverter.getInstance().convert(document, out, options);

            return pdfFilePath;
        } catch (Exception e) {
            throw new RuntimeException("An error occurred during conversion: " + e.getMessage(), e);
        }
    }*/

}
