package com.masai.service;

import java.util.List;

import com.masai.model.Quote;

public interface QuoteService {
	List<Quote> getAllQuotes();
    Quote getQuoteById(Long quoteId);
    Quote createQuote(Quote quote);
    Quote updateQuote(Long quoteId, Quote quoteDetails);
    String deleteQuote(Long quoteId);
    List<Quote> getQuotesForPolicy(Long policyId);
    Double getAverageQuoteAmount();
}
