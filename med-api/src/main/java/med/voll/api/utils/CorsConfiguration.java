package med.voll.api.utils;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 
 * lidando com CORS (Cross-Origin Resource Sharing), habilitando diferentes origens no Spring Boot para aceitar url diferente proveniente do front-end
 * 
 * @author Ricardo Spinoza
 * 
 */

@Configuration
public class CorsConfiguration implements WebMvcConfigurer {

	
	/**
	 * Habilitando diferentes origens no Spring Boot
	 */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedOrigins("http://localhost:3000")
            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT");
    }
}

