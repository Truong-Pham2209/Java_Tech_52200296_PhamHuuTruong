package dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("textEditor")
public class TextEditor {
    private String text;
    private TextWriter writer;

    
    @Autowired
    public TextEditor(@Qualifier("pdfTextWriter")TextWriter writer) {
        this.writer = writer;
    }

    public void input(String text) {
        this.text = text;
    }

    public void save(String fileName) {
        if (text != null) {
            writer.write(fileName, text);
        }
    }
}
