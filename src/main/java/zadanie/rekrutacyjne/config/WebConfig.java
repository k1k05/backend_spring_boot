package zadanie.rekrutacyjne.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Zezwolenie na wszystkie endpointy
                        .allowedOrigins("http://localhost:4200") // Zezwolenie tylko dla tej domeny
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Dozwolone metody HTTP
                        .allowedHeaders("*") // Wszystkie nagłówki
                        .allowCredentials(true); // Wsparcie dla ciasteczek (opcjonalne)
            }
        };
    }
}