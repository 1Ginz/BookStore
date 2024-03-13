package bookstore.app.book.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Path;
import java.nio.file.Paths;
@AllArgsConstructor
@Configuration
public class MvcConfig implements WebMvcConfigurer {
    private final AppConfig appConfig;
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        Path uploadDir = Paths.get("./" + appConfig.getFileUploadPath());
        String uploadPath = uploadDir.toFile().getAbsolutePath();
        registry
                .addResourceHandler(String.format("/%s/**", appConfig.getFileUploadPath()))
                .addResourceLocations("file:/" + uploadPath + "/");
        if (!registry.hasMappingForPattern("/assets/**")) {
            registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/assets/");
        }
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:4200")
                .allowedMethods(HttpMethod.GET.name(),HttpMethod.POST.name(), HttpMethod.PUT.name(), HttpMethod.DELETE.name())
                .allowedHeaders("Origin", "Content-Type", "Accept", "Authorization")
                .allowCredentials(true)
                .maxAge(3600);
    }


}
