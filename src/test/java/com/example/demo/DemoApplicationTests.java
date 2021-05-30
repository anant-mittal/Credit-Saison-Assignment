package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dto.CardInfoDto;
import com.example.demo.service.DemoService;

@SpringBootTest
class DemoApplicationTests {

	
	@Autowired
	DemoService demoService;
	
	@Test
	public void fetchCardInfo() {
		CardInfoDto cardInfoDto = demoService.fetchCardInfo("45717360");
		assertNotNull(cardInfoDto, "Response is null");
	}

}
