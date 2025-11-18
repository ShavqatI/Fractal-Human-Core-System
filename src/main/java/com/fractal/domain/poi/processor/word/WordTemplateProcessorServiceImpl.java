package com.fractal.domain.poi.processor.word;

import org.apache.poi.xwpf.usermodel.*;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class WordTemplateProcessorServiceImpl implements WordTemplateProcessorService {

    @Override
    public void processTemplate(String templatePath, String outputPath, Map<String, String> values) throws IOException {
        try (FileInputStream fis = new FileInputStream(templatePath);
             XWPFDocument document = new XWPFDocument(fis)) {

            // Process main document body
            replaceInParagraphs(document.getParagraphs(), values);
            replaceInTables(document.getTables(), values);

            // Process headers
            for (XWPFHeader header : document.getHeaderList()) {
                replaceInParagraphs(header.getParagraphs(), values);
                replaceInTables(header.getTables(), values);
            }

            // Process footers
            for (XWPFFooter footer : document.getFooterList()) {
                replaceInParagraphs(footer.getParagraphs(), values);
                replaceInTables(footer.getTables(), values);
            }

            // Write result
            try (FileOutputStream fos = new FileOutputStream(outputPath)) {
                document.write(fos);
            }
        }
    }

    // === Replace in any list of paragraphs ===
    private void replaceInParagraphs(List<XWPFParagraph> paragraphs, Map<String, String> values) {
        for (XWPFParagraph paragraph : paragraphs) {
            replaceInParagraph(paragraph, values);
        }
    }

    // === Replace in any list of tables (supports nested tables) ===
    private void replaceInTables(List<XWPFTable> tables, Map<String, String> values) {
        for (XWPFTable table : tables) {
            replaceInTable(table, values);
        }
    }

    private void replaceInTable(XWPFTable table, Map<String, String> values) {
        for (XWPFTableRow row : table.getRows()) {
            for (XWPFTableCell cell : row.getTableCells()) {
                // Process paragraphs in cell
                replaceInParagraphs(cell.getParagraphs(), values);
                // Process nested tables inside cell
                replaceInTables(cell.getTables(), values);
            }
        }
    }

    // === Core: Replace placeholders in one paragraph with full formatting preserved ===
    private void replaceInParagraph(XWPFParagraph paragraph, Map<String, String> values) {
        List<XWPFRun> originalRuns = new ArrayList<>(paragraph.getRuns());
        if (originalRuns.isEmpty()) return;

        String fullText = paragraph.getText();
        if (!containsPlaceholder(fullText, values)) {
            return; // No placeholder → skip
        }

        // Remove all current runs (we'll rebuild them)
        while (!paragraph.getRuns().isEmpty()) {
            paragraph.removeRun(0);
        }

        // Rebuild runs with replaced text + original formatting
        for (XWPFRun oldRun : originalRuns) {
            String text = oldRun.getText(0);
            if (text == null) text = "";

            String replacedText = text;
            for (Map.Entry<String, String> entry : values.entrySet()) {
                replacedText = replacedText.replace(entry.getKey(), entry.getValue());
            }

            if (!replacedText.isEmpty()) {
                XWPFRun newRun = paragraph.createRun();
                newRun.setText(replacedText, 0);
                copyRunProperties(oldRun, newRun); // Full formatting copy
            }
        }
    }

    // === Check if text contains any placeholder ===
    private boolean containsPlaceholder(String text, Map<String, String> values) {
        if (text == null || text.isEmpty()) return false;
        return values.keySet().stream().anyMatch(text::contains);
    }

    // === Best-in-class: Copy ALL run properties (formatting, language, highlighting, etc.) ===
    private void copyRunProperties(XWPFRun source, XWPFRun target) {
        // Basic visible properties
        target.setBold(source.isBold());
        target.setItalic(source.isItalic());
        target.setUnderline(source.getUnderline());
        target.setStrikeThrough(source.isStrikeThrough());
        //target.setDoubleStrikeThrough(source.isDoubleStrikethrough());
        target.setSmallCaps(source.isSmallCaps());
        //target.setCaps(source.isCaps());
        target.setColor(source.getColor());
        target.setFontFamily(source.getFontFamily());
        if (source.getFontSize() > 0) {
            target.setFontSize(source.getFontSize());
        }
        //target.setTextHighlightColor(source.getTextHighlight());
        target.setCharacterSpacing(source.getCharacterSpacing());
        target.setKerning(source.getKerning());

        // Advanced styling
        target.setImprinted(source.isImprinted());
        target.setEmbossed(source.isEmbossed());
        //target.setShadow(source.isShadow());

        // Most important: copy full underlying run properties (RPr) from XML
        if (source.getCTR() != null && source.getCTR().getRPr() != null) {
            CTRPr rPr = source.getCTR().getRPr();
            target.getCTR().setRPr((CTRPr) rPr.copy());
        }
    }

    // Optional: Keep old method for backward compatibility or remove if not used elsewhere
    @Deprecated
    private void copyRunFormatting(XWPFRun source, XWPFRun target) {
        // Kept only if called from legacy code
        copyRunProperties(source, target);
    }
}
