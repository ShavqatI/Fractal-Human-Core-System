package com.fractal.domain.poi.processor.word;

import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.nio.file.Path;
import java.util.Map;

public interface WordTemplateProcessorService {

    void process(Path templatePath, Path outputPath, Map<String, String> values) throws Exception;
    void processDocument(XWPFDocument document, Map<String, String> variables);
}
