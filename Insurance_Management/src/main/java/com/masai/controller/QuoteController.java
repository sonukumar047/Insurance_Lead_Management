package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Quote;
import com.masai.service.QuoteService;

@RestController
@RequestMapping(value = "/quote")
public class QuoteController {
	
	@Autowired
	private QuoteService quoteService;
	
	@PostMapping(value = "/add-quote")
	public ResponseEntity<Quote> addQuote(@RequestBody Quote quote){
		return new ResponseEntity<Quote>(quoteService.createQuote(quote), HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/get-quote-by-id/{quoteId}")
	public ResponseEntity<Quote> getQuoteById(@PathVariable("quoteId") Long quoteId){
		return new ResponseEntity<Quote>(quoteService.getQuoteById(quoteId), HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value = "/get-all-quotes")
	public ResponseEntity<List<Quote>> getAllQuotes(){
		return new ResponseEntity<List<Quote>>(quoteService.getAllQuotes(), HttpStatus.ACCEPTED);
	}
	
	@PutMapping(value = "/update-quote/{quoteId}")
	public ResponseEntity<Quote> updateQuote(@PathVariable("quoteId") Long quoteId, @RequestBody Quote quote){
		return new ResponseEntity<Quote>(quoteService.updateQuote(quoteId, quote), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/delete-quote")
	public ResponseEntity<String> deleteQuote(@PathVariable("quoteId") Long quoteId){
		return new ResponseEntity<String>(quoteService.deleteQuote(quoteId), HttpStatus.OK);
	}
	
	@GetMapping(value = "/get-quotes-for-policy/{quoteId}")
	public ResponseEntity<List<Quote>> getQuotesForPolicy(@PathVariable("quoteId") Long quoteId){
		return new ResponseEntity<List<Quote>>(quoteService.getQuotesForPolicy(quoteId), HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value = "/get-average-quote-amount")
	public ResponseEntity<Double> getAverageQuoteAmount(){
		return new ResponseEntity<Double>(quoteService.getAverageQuoteAmount(), HttpStatus.ACCEPTED);
	}
}
