package com.fractal.domain.poi.processor.word;

import java.io.IOException;
import java.util.Map;

public interface WordTemplateProcessorService {

    void processTemplate(String templatePath, String outputPath, Map<String, String> values) throws IOException;
}
