package com.kaansonmezoz.exceptionhandling;

import com.kaansonmezoz.exceptionhandling.exceptions.ErrorType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExceptionHandlingApplication {
	public static void main(String[] args) {
		SpringApplication.run(ExceptionHandlingApplication.class, args);

		// Throwing exception based on specific error
		ErrorType.USER_IS_BANNED.throwException("kaansonmezoz");
	}
}
