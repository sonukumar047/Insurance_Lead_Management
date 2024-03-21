package com.masai.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.model.InsurancePolicy;
import com.masai.model.Quote;
import com.masai.repository.InsurancePolicyRepository;
import com.masai.repository.QuoteRepository;
import com.masai.service.QuoteService;

@Service
public class QuoteServiceImpl implements QuoteService {

	@Autowired
    private QuoteRepository quoteRepository;

    @Autowired
    private InsurancePolicyRepository policyRepository;

    @Override
    public List<Quote> getAllQuotes() {
        return quoteRepository.findAll();
    }

    @Override
    public Quote getQuoteById(Long quoteId) {
        return quoteRepository.findById(quoteId)
                              .orElseThrow(() -> new RuntimeException("Quote not found with id: " + quoteId));
    }

    @Override
    public Quote createQuote(Quote quote) {
        return quoteRepository.save(quote);
    }

    @Override
    public Quote updateQuote(Long quoteId, Quote quoteDetails) {
        Quote quote = getQuoteById(quoteId);
        quote.setQuotedAmount(quoteDetails.getQuotedAmount());
        quote.setExpirationDate(quoteDetails.getExpirationDate());
        return quoteRepository.save(quote);
    }

    @Override
    public String deleteQuote(Long quoteId) {
        Quote quote = getQuoteById(quoteId);
        quoteRepository.delete(quote);
        return "Quote deleted successfully";
    }

    @Override
    public List<Quote> getQuotesForPolicy(Long policyId) {
        return quoteRepository.findByPolicyId(policyId);
    }

    @Override
    public Double getAverageQuoteAmount() {
        List<Quote> quotes = getAllQuotes();
        if (quotes.isEmpty()) {
            return 0.0;
        }
        return quotes.stream()
                     .mapToDouble(Quote::getQuotedAmount)
                     .average()
                     .orElse(0.0);
    }

}
