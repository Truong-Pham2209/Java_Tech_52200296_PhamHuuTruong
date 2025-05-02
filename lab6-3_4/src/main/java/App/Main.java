package App;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import config.AppConfig;
import dto.TextEditor;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        TextEditor textEditor = (TextEditor) context.getBean("textEditor");
        textEditor.input("Hello World: 52200296 - Phạm Hữu Trường");
        textEditor.save("out.txt");
        System.out.println("Output have been writen");
        ((AnnotationConfigApplicationContext) context).close();
    }
}
