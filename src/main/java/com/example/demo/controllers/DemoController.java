package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CardInfoDto;
import com.example.demo.service.DemoService;
import com.example.demo.service.IDemoService;

@RestController
public class DemoController implements IDemoService {

	@Autowired
	DemoService demoService;

	@RequestMapping(value = DemoApiEndpoints.VERIFY_CARD, method = RequestMethod.GET)
	public CardInfoDto fetchCardInfo(@PathVariable(Params.CARD_ID) String cardId) {
		CardInfoDto cardInfoDto = demoService.fetchCardInfo(cardId);
		return cardInfoDto;
	}

}
