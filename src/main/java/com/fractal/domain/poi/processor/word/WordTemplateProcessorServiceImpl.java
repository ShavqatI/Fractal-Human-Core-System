package com.fractal.domain.poi.processor.word;

import org.apache.poi.xwpf.usermodel.*;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

@Service
class WordTemplateProcessorServiceImpl implements WordTemplateProcessorService {

    @Override
    public void process(Path templatePath, Path outputPath, Map<String, String> variables) throws Exception {
        try (InputStream is = Files.newInputStream(templatePath);
             XWPFDocument document = new XWPFDocument(is)) {
              processDocument(document, variables);
            try (OutputStream os = Files.newOutputStream(outputPath)) {
                document.write(os);
            }
        }
    }

    @Override
    public void processDocument(XWPFDocument document, Map<String, String> variables) {
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

        // Combine runs text to find placeholders
        StringBuilder paragraphText = new StringBuilder();
        for (XWPFRun run : runs) {
            String text = run.getText(0);
            paragraphText.append(text != null ? text : "");
        }
        String fullText = paragraphText.toString();
        System.out.println(fullText);

        for (Map.Entry<String, String> entry : variables.entrySet()) {
            String placeholder = "${" + entry.getKey() + "}";
            String value = entry.getValue();

            int index = fullText.indexOf(placeholder);
            while (index >= 0) { // Replace all occurrences
                int remaining = placeholder.length();
                int runIndex = 0;
                int runPos = 0;
                boolean firstRun = true;

                while (runIndex < runs.size() && remaining > 0) {
                    XWPFRun run = runs.get(runIndex);
                    String runText = run.getText(0);
                    if (runText == null) {
                        runIndex++;
                        continue;
                    }

                    int runLength = runText.length();

                    if (runPos + runLength <= index) {
                        runPos += runLength;
                        runIndex++;
                        continue;
                    }

                    // Placeholder starts in this run
                    int startInRun = Math.max(0, index - runPos);
                    int endInRun = Math.min(runLength, startInRun + remaining);

                    String before = runText.substring(0, startInRun);
                    String after = runText.substring(endInRun);

                    // Insert value only in the first run
                    String newText = before + (firstRun ? value : "") + after;
                    run.setText(newText, 0);

                    firstRun = false;

                    remaining -= (endInRun - startInRun);
                    runPos += runLength;
                    runIndex++;
                }

                // Update fullText to find next occurrence
                fullText = fullText.substring(0, index) + value + fullText.substring(index + placeholder.length());
                index = fullText.indexOf(placeholder);
            }
        }
    }


}
