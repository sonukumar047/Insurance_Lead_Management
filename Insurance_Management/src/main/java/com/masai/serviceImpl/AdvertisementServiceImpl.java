package com.masai.serviceImpl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.AdvertisementNotFoundException;
import com.masai.model.Advertisement;
import com.masai.repository.AdvertisementRepository;
import com.masai.service.AdvertisementService;

@Service
public class AdvertisementServiceImpl implements AdvertisementService{
	
	@Autowired
	private AdvertisementRepository advertisementRepository;

	@Override
	public List<Advertisement> getAllAdvertisements() {
		return advertisementRepository.findAll();
	}

	@Override
	public Advertisement getAdvertisementById(Long advertisementId) {
		return advertisementRepository.findById(advertisementId).orElseThrow(() -> new AdvertisementNotFoundException("Advertisement not found with id: " + advertisementId));
	}

	@Override
	public Advertisement createAdvertisement(Advertisement advertisement) {
		return advertisementRepository.save(advertisement);
	}

	@Override
	public Advertisement updateAdvertisement(Long advertisementId, Advertisement advertisementDetails) {
		Advertisement advertisement = getAdvertisementById(advertisementId);
		advertisement.setTitle(advertisementDetails.getTitle());
		advertisement.setContent(advertisementDetails.getContent());
		advertisement.setEndDate(advertisementDetails.getEndDate());
		return advertisementRepository.save(advertisement);
		
	}

	@Override
	public String deleteAdvertisement(Long advertisementId) {
		advertisementRepository.deleteById(advertisementId);
		return "Advertisement with id: " + advertisementId + " deleted successfully";
	}

	@Override
	public List<Advertisement> getActiveAdvertisements() {
		return advertisementRepository.findByEndDateAfter(LocalDate.now());
	}

}
