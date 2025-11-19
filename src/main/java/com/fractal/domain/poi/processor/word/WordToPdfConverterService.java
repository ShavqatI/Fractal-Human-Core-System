package com.fractal.domain.poi.processor.word;

import java.nio.file.Path;

public interface WordToPdfConverterService {

    Path convert(Path wordFilePath, Path pdfFilePath);
}
