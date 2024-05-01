package se.meepo.burgerorder.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class CorseConfig implements WebMvcConfigurer {

    @Value("${client.host}")
    private List<String> hostBaseUrl;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedHeaders("*")
                .exposedHeaders("JWT", HttpHeaders.CONTENT_DISPOSITION)
                .allowCredentials(true)
                .allowedOriginPatterns(hostBaseUrl.toArray(String[]::new))
                .maxAge(3600)
                .allowedMethods("GET", "HEAD", "POST", "OPTIONS");
    }

}

