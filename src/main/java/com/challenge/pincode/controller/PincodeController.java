package com.challenge.pincode.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.pincode.exception.PincodeServiceException;
import com.challenge.pincode.service.PincodeService;

@RestController
@RequestMapping("/pincodeApi")
public class PincodeController {

	private static final Logger LOG = LogManager.getLogger(PincodeController.class.getName());

	@Autowired
	PincodeService pincodeService;
	
	@PostMapping("/calculateMinRanges")
	public ResponseEntity<List<String>> calculateMinRanges(@RequestBody List<String> allPossibleRanges){
		try {
			LOG.info("/calculateMinRanges - > ");
			return new ResponseEntity<List<String>>(pincodeService.calculatePincodeMinRanges(allPossibleRanges), HttpStatus.OK);
		} catch(PincodeServiceException e){
			LOG.debug("Exception in calculateMinRanges method of PincodeController Class" + e.getMessage());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
