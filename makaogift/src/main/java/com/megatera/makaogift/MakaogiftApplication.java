package com.megatera.makaogift;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.web.configuration.*;

@SpringBootApplication
public class MakaogiftApplication {

	public static void main(String[] args) {
		SpringApplication.run(MakaogiftApplication.class, args);
	}

	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		return (web) -> web.ignoring().antMatchers("/**");
	}
}
