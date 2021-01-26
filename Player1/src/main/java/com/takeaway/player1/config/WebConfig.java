package com.takeaway.player1.config;

import com.takeaway.player1.interceptor.LogInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Web client configuration
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Autowired // Logging interceptor
	private LogInterceptor logInterceptor;

	// Player2 URL
	@Value("${player2.url}")
	private String player2Url;

	/**
	 * Web client to make calls to Player2
	 * @param builder Webclient builder
	 * @return Webclient
	 */
	@Bean
	public WebClient webClientPlayer2(WebClient.Builder builder) {
		return builder
				.baseUrl(player2Url)
				.build();
	}

	/**
	 * Add logging interceptor to the registry
	 * @param registry
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(logInterceptor);
	}

}
