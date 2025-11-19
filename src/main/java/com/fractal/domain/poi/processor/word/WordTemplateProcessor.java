package com.fractal.domain.poi.processor.word;


import org.apache.poi.xwpf.usermodel.*;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public class WordTemplateProcessor {

    public void process(Path templatePath, Path outputPath, Map<String, String> variables) throws Exception {
        try (InputStream is = Files.newInputStream(templatePath);
             XWPFDocument document = new XWPFDocument(is)) {

            processDocument(document, variables);

            try (OutputStream os = Files.newOutputStream(outputPath)) {
                document.write(os);
            }
        }
    }

    private void processDocument(XWPFDocument document, Map<String, String> variables) {
        // Process paragraphs
        for (XWPFParagraph paragraph : document.getParagraphs()) {
            replaceInParagraph(paragraph, variables);
        }

        // Process tables
        for (XWPFTable table : document.getTables()) {
            for (XWPFTableRow row : table.getRows()) {
                for (XWPFTableCell cell : row.getTableCells()) {
                    for (XWPFParagraph paragraph : cell.getParagraphs()) {
                        replaceInParagraph(paragraph, variables);
                    }
                }
            }
        }

        // Process headers
        for (XWPFHeader header : document.getHeaderList()) {
            for (XWPFParagraph paragraph : header.getParagraphs()) {
                replaceInParagraph(paragraph, variables);
            }
        }

        // Process footers
        for (XWPFFooter footer : document.getFooterList()) {
            for (XWPFParagraph paragraph : footer.getParagraphs()) {
                replaceInParagraph(paragraph, variables);
            }
        }
    }

    private void replaceInParagraph(XWPFParagraph paragraph, Map<String, String> variables) {
        List<XWPFRun> runs = paragraph.getRuns();
        if (runs == null || runs.isEmpty()) return;

        // Collect full text
        StringBuilder fullText = new StringBuilder();
        for (XWPFRun run : runs) {
            String text = run.getText(0);
            if (text != null) fullText.append(text);
        }

        String originalText = fullText.toString();
        String replacedText = originalText;

        // Replace placeholders
        for (Map.Entry<String, String> e : variables.entrySet()) {
            replacedText = replacedText.replace("${" + e.getKey() + "}", e.getValue());
        }

        if (replacedText.equals(originalText)) return;

        int newTextIndex = 0;                     // pointer inside replacedText
        int newTextLength = replacedText.length();

        for (XWPFRun run : runs) {
            String oldRunText = run.getText(0);
            if (oldRunText == null) continue;

            int oldLen = oldRunText.length();
            int remaining = newTextLength - newTextIndex;

            if (remaining <= 0) {
                // No more characters left -> empty run
                run.setText("", 0);
                continue;
            }

            if (remaining < oldLen) {
                // Last run containing remaining characters
                String sub = replacedText.substring(newTextIndex, newTextIndex + remaining);
                run.setText(sub, 0);
                newTextIndex += remaining;
            } else {
                // Normal case
                String sub = replacedText.substring(newTextIndex, newTextIndex + oldLen);
                run.setText(sub, 0);
                newTextIndex += oldLen;
            }
        }
    }





    public static void main(String[] args) throws Exception {
        Path file =  Path.of("C:\\My Data\\fractal\\2025\\backend\\FILE-STORAGE\\document-template-manager\\0af7c45b-dda8-4293-824f-88415484eda8_37_Фармон - Танбех.docx");
        Path file2 =  Path.of("C:\\My Data\\fractal\\2025\\backend\\FILE-STORAGE\\myTemp2.docx");
        WordTemplateProcessor wordTemplateProcessor = new WordTemplateProcessor();
        Map<String, String> values = Map.of(
                "${docDate}", "2025-01-01",
                "${branchName}", "DMB",
                "${fullBankName}", "CJSC ICB",
                "employeeName", "Test test",
                "${employeePosition}", "Officer",
                "${punishmentType}", "Blblalal",
                "${sourceDocument}", "#12354788",
                "${hrHead}", "Jigarakt"
        );
        wordTemplateProcessor.process(file,file2,values);
    }
}