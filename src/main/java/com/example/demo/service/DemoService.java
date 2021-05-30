package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dto.CardDetailsDto;
import com.example.demo.dto.CardInfoDto;
import com.example.demo.dto.PayloadDto;
import com.example.demo.exception.InvalidInputException;

@Service
public class DemoService {

	@Autowired
	RestTemplate restTemplate;

	public CardInfoDto fetchCardInfo(String cardId) {

		cardId = validateCardNumber(cardId);
		CardDetailsDto cardDetailsDto = null;

		cardDetailsDto = restTemplate.getForObject("https://lookup.binlist.net/" + cardId, CardDetailsDto.class);

		CardInfoDto cardInfoDto = new CardInfoDto();
		if (null != cardDetailsDto) {
			cardInfoDto.setSuccess(Boolean.TRUE);
			PayloadDto payloadDto = null;
			if (null != cardDetailsDto.getBank()) {
				payloadDto = new PayloadDto(cardDetailsDto.getScheme(), cardDetailsDto.getType(),
						cardDetailsDto.getBank().getName());
			} else {
				payloadDto = new PayloadDto(cardDetailsDto.getScheme(), cardDetailsDto.getType(), null);
			}

			cardInfoDto.setPayload(payloadDto);
		}
		return cardInfoDto;

	}

	private String validateCardNumber(String cardNumber) {

		if (!cardNumber.matches("\\d{6,19}")) {
			throw new InvalidInputException("Card Number Input is not valid");
		}

		if (cardNumber.length() > 8) {
			return cardNumber.substring(0, 8);
		}

		return cardNumber;
	}
}
