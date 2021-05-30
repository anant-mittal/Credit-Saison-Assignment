package com.example.demo.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.context.request.WebRequest;

import com.example.demo.dto.CardInfoDto;

@ControllerAdvice
public class GlobalExceptionHandler {
	private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@org.springframework.web.bind.annotation.ExceptionHandler(value = { InvalidInputException.class })
	public ResponseEntity<?> invalidInputException(InvalidInputException ex, WebRequest request) {
		logger.error(ex.getMessage());
		CardInfoDto cardInfoDto = new CardInfoDto();
		cardInfoDto.setSuccess(false);
		cardInfoDto.setPayload(null);
		return new ResponseEntity<>(cardInfoDto, HttpStatus.BAD_REQUEST);
	}

	@org.springframework.web.bind.annotation.ExceptionHandler(value = { HttpStatusCodeException.class })

	public ResponseEntity<?> statusCodeException(HttpStatusCodeException ex, WebRequest request) {
		logger.error(ex.getMessage());
		CardInfoDto responseDto = new CardInfoDto();
		responseDto.setSuccess(false);
		responseDto.setPayload(null);
		return new ResponseEntity<>(responseDto, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
	public ResponseEntity<?> globalExceptionHandler(Exception ex, WebRequest request) {
		logger.error(ex.getMessage());
		CardInfoDto responseDto = new CardInfoDto();
		responseDto.setSuccess(false);
		responseDto.setPayload(null);
		return new ResponseEntity<>(responseDto, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
