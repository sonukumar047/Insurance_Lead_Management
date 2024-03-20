package com.masai.service;

import java.util.List;

import com.masai.model.Advertisement;

public interface AdvertisementService {
	List<Advertisement> getAllAdvertisements();
    Advertisement getAdvertisementById(Long advertisementId);
    Advertisement createAdvertisement(Advertisement advertisement);
    Advertisement updateAdvertisement(Long advertisementId, Advertisement advertisementDetails);
    String deleteAdvertisement(Long advertisementId);
    List<Advertisement> getActiveAdvertisements();
}
