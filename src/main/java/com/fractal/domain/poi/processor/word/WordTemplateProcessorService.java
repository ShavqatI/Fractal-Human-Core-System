package com.fractal.domain.poi.processor.word;

import java.nio.file.Path;
import java.util.Map;

public interface WordTemplateProcessorService {

    void process(Path templatePath, Path outputPath, Map<String, String> values) throws Exception;
}
