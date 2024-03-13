package bookstore.app.book.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Value("${file.upload.path}")
    private String fileUploadPath;

    public String getFileUploadPath() {
        return this.fileUploadPath;
    }
}
