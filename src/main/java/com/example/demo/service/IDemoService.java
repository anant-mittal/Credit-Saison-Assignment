package com.example.demo.service;

import com.example.demo.dto.CardInfoDto;

public interface IDemoService {

	public static class DemoApiEndpoints {
		public static final String PREFIX = "/card-scheme";
		public static final String VERIFY_CARD = PREFIX + "/verify/{cardId}";
	}

	public static class Params {
		public static final String CARD_ID = "cardId";
	}

	public CardInfoDto fetchCardInfo(String cardId);

}
