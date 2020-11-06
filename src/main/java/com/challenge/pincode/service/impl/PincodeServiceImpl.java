package com.challenge.pincode.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.challenge.pincode.exception.PincodeServiceException;
import com.challenge.pincode.service.PincodeService;

@Service
public class PincodeServiceImpl implements PincodeService{

	private static final Logger LOG = LogManager.getLogger(PincodeServiceImpl.class.getName());

	@Override
	public List<String> calculatePincodeMinRanges(List<String> possibleRanges) throws PincodeServiceException {
		LOG.info("calculatePincodeMinRanges - > ");
		List<Integer> minRanges = new ArrayList<>();
		List<Integer> maxRanges = new ArrayList<>();
		List<String> finalPincodeRanges= new ArrayList<>();
		for (String pincodeRange : possibleRanges) {
			String range[] = pincodeRange.split(",");
			if(checkIfValid(range[0])){
				minRanges.add(Integer.parseInt(range[0]));
			}
			if(checkIfValid(range[1])){
				maxRanges.add(Integer.parseInt(range[1]));
			}
		}
		for (int i = 0; i < minRanges.size(); i++) {
			for (int j = 0; j < maxRanges.size(); j++) {
				if ((minRanges.get(j)>=minRanges.get(i) && maxRanges.get(j)<maxRanges.get(i))) {
						minRanges.remove(j);
						maxRanges.remove(j);
						sortRanges(minRanges,maxRanges);
						i=0;
						j=0;
				}
				if ((minRanges.get(j)>=minRanges.get(i) && 
						(minRanges.get(j)<=maxRanges.get(i) || minRanges.get(j)==maxRanges.get(i)+1) 
						&& maxRanges.get(j)>maxRanges.get(i)) ) {
					maxRanges.set(i, maxRanges.get(j));
					minRanges.remove(j);
					maxRanges.remove(j);
					sortRanges(minRanges,maxRanges);
					i=0;
					j=0;
				}
				
			}
		}

		for (Integer min : minRanges) {
			finalPincodeRanges.add(min + "," + maxRanges.get(minRanges.indexOf(min)));
		}
	    List<String> finalPincodeRangeswithoutDeplicates = new ArrayList<>(
	    	      new HashSet<>(finalPincodeRanges));
		return finalPincodeRangeswithoutDeplicates;
	}
	
	private static void sortRanges(List<Integer> minRanges, List<Integer> maxRanges) {
		int temp;
		for (int i = 0; i < minRanges.size(); i++) {
			for (int j = i + 1; j < minRanges.size(); j++) {
				if (minRanges.get(i) > minRanges.get(j)) {
					temp = minRanges.get(i);
					minRanges.set(i, minRanges.get(j));
					minRanges.set(j, temp);
					temp = maxRanges.get(i);
					maxRanges.set(i, maxRanges.get(j));
					maxRanges.set(j, temp);
				}
			}
		}

	}
	
	private static boolean checkIfValid(String pincode) throws PincodeServiceException{
		if(!org.apache.commons.lang3.StringUtils.isNumeric(pincode)){
			throw new PincodeServiceException(pincode+" is not a valid pincode and cannot be parsed to a number");
		}
		return org.apache.commons.lang3.StringUtils.isNumeric(pincode);
		
		
	}
	
}
