package org.alfresco.transform.transformer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.Map;

import org.alfresco.transform.base.CustomTransformer;
import org.alfresco.transform.base.TransformManager;
import org.springframework.stereotype.Component;

import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.options.convert.PdfConvertOptions;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class DwgTransformer implements CustomTransformer {

    @Override
    public String getTransformerName() {
        return "dwg";
    }

    @Override
    public void transform(String sourceMimetype,
            InputStream inputStream,
            String targetMimetype,
            OutputStream outputStream,
            Map<String, String> transformOptions,
            TransformManager transformManager) throws Exception {
        File tempInput = Files.createTempFile("dwg_in", ".dwg").toFile();
        File tempOutput = Files.createTempFile("dwg_out", ".pdf").toFile();

        try (FileOutputStream fos = new FileOutputStream(tempInput)) {
            inputStream.transferTo(fos);
        }

        try (Converter converter = new Converter(tempInput.getAbsolutePath())) {
            PdfConvertOptions options = new PdfConvertOptions();
            converter.convert(tempOutput.getAbsolutePath(), options);
        }


        try (FileInputStream fis = new FileInputStream(tempOutput)) {
            fis.transferTo(outputStream);
        }

        tempInput.delete();
        tempOutput.delete();
    }
}
