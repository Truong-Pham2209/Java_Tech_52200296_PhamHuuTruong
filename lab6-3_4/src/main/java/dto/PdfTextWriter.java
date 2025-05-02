package dto;

import java.io.BufferedWriter;
import java.io.FileWriter;

import org.springframework.stereotype.Component;

@Component("pdfTextWriter")
public class PdfTextWriter implements TextWriter {
	@Override
    public void write(String fileName, String text) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
