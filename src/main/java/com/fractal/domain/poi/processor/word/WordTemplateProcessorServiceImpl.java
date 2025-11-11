package com.fractal.domain.poi.processor.word;

import org.apache.poi.xwpf.usermodel.*;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

@Service
class WordTemplateProcessorServiceImpl implements WordTemplateProcessorService {
    @Override
    public void processTemplate(String templatePath, String outputPath, Map<String, String> values) throws IOException {
        try (FileInputStream fis = new FileInputStream(templatePath);
             XWPFDocument document = new XWPFDocument(fis)) {

            replaceInParagraphs(document, values);
            replaceInTables(document, values);

            try (FileOutputStream fos = new FileOutputStream(outputPath)) {
                document.write(fos);
            }
        }
    }

    private  void replaceInParagraphs(XWPFDocument document, Map<String, String> values) {
        for (XWPFParagraph paragraph : document.getParagraphs()) {
            replaceInParagraph(paragraph, values);
        }
    }

    private  void replaceInTables(XWPFDocument document, Map<String, String> values) {
        for (XWPFTable table : document.getTables()) {
            for (XWPFTableRow row : table.getRows()) {
                for (XWPFTableCell cell : row.getTableCells()) {
                    for (XWPFParagraph paragraph : cell.getParagraphs()) {
                        replaceInParagraph(paragraph, values);
                    }
                }
            }
        }
    }

    private  void replaceInParagraph(XWPFParagraph paragraph, Map<String, String> values) {
        String fullText = paragraph.getText();

        // Only process if something matches
        if (!containsPlaceholder(fullText, values)) return;

        // Merge runs text
        for (int i = paragraph.getRuns().size() - 1; i >= 0; i--) {
            paragraph.removeRun(i);
        }

        // Replace placeholders
        for (Map.Entry<String, String> entry : values.entrySet()) {
            fullText = fullText.replace(entry.getKey(), entry.getValue());
        }

        // Write new run
        XWPFRun run = paragraph.createRun();
        run.setText(fullText);
    }

    private  boolean containsPlaceholder(String text, Map<String, String> values) {
        for (String key : values.keySet()) {
            if (text.contains(key)) return true;
        }
        return false;
    }

    private void copyRunFormatting(XWPFRun source, XWPFRun target) {
        target.setBold(source.isBold());
        target.setItalic(source.isItalic());
        target.setUnderline(source.getUnderline());
        target.setColor(source.getColor());
        target.setFontFamily(source.getFontFamily());
        target.setFontSize(source.getFontSize());
        target.setTextPosition(source.getTextPosition());
        target.setSmallCaps(source.isSmallCaps());
        target.setStrikeThrough(source.isStrikeThrough());
        //target.setSubscript(source.getSubscript());
    }
}
