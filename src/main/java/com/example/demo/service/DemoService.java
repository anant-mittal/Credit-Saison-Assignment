package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dto.CardDetailsDto;
import com.example.demo.dto.CardInfoDto;
import com.example.demo.dto.PayloadDto;

@Service
public class DemoService {

	@Autowired
	RestTemplate restTemplate;

	public CardInfoDto fetchCardInfo(String cardId) {
		CardDetailsDto cardDetailsDto = null;
		try {
			cardDetailsDto = restTemplate.getForObject("https://lookup.binlist.net/" + cardId, CardDetailsDto.class);
		} catch (Exception e) {

		}
		CardInfoDto cardInfoDto = new CardInfoDto();
		if (null != cardDetailsDto) {
			cardInfoDto.setSuccess(Boolean.TRUE);
			PayloadDto payloadDto = new PayloadDto(cardDetailsDto.getScheme(), cardDetailsDto.getType(),
					cardDetailsDto.getBank().getName());
			cardInfoDto.setPayload(payloadDto);
		} else {
			cardInfoDto.setSuccess(Boolean.FALSE);
		}
		return cardInfoDto;

	}
}
