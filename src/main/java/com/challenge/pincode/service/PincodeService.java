package com.challenge.pincode.service;

import java.util.List;

import com.challenge.pincode.exception.PincodeServiceException;

public interface PincodeService {
	List<String> calculatePincodeMinRanges(List<String> possibleRanges) throws PincodeServiceException;
}
