package com.cg.creditcardbillpaymen.services;

import java.util.List;

import com.cg.creditcardbillpaymen.entities.CreditCard;

public interface CreditCardService {
	public CreditCard addCreditCard(CreditCard creditCard);

	public CreditCard removeCreditCard(long cardId);

	public CreditCard updateCreditCard(long cardId, CreditCard card);

	public CreditCard getCreditCard(long cardId);

	public List<CreditCard> getAllCreditCards();

}
