package com.fractal.domain.poi.processor.word;

import fr.opensagres.poi.xwpf.converter.pdf.PdfConverter;
import fr.opensagres.poi.xwpf.converter.pdf.PdfOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
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
}
