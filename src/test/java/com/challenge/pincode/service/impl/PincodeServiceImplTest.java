package com.challenge.pincode.service.impl;

import java.util.ArrayList;
import java.util.List;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Assertions;
import com.challenge.pincode.exception.PincodeServiceException;
import com.challenge.pincode.service.PincodeService;

@SpringBootTest
public class PincodeServiceImplTest {
	
	@Autowired PincodeService service;
	
	@Test
	public void testPincodeMinRangeCalculatorPositive() throws PincodeServiceException{
		List<String> ranges = new ArrayList<>();
		ranges.add("1,2");
		ranges.add("3,4");
		List<String> result = service.calculatePincodeMinRanges(ranges);
		Assertions.assertTrue(result.size() > 0);
		Assertions.assertEquals(1, result.size());
	}
	
	@Test
	public void testPincodeMinRangeCalculatorNeutral1() throws PincodeServiceException{
		List<String> ranges = new ArrayList<>();
		
		ranges.add("3,4");
		ranges.add("1,2");
		List<String> result = service.calculatePincodeMinRanges(ranges);
		Assertions.assertTrue(result.size() > 0);
		Assertions.assertEquals(1, result.size());
	}
	

	@Test
	public void testPincodeExplicit() throws PincodeServiceException{
		List<String> ranges = new ArrayList<>();
		
		ranges.add("94133,94133");
		ranges.add("94200,94299");
		ranges.add("94600,94699");
		List<String> result = service.calculatePincodeMinRanges(ranges);
		Assertions.assertTrue(result.size() > 0);
		
		Assertions.assertEquals(3, result.size());
	}
	
	@Test
	public void testPincodeOverlap() throws PincodeServiceException{
		List<String> ranges = new ArrayList<>();
		
		ranges.add("94133,94133");
		ranges.add("94200,94299");
		ranges.add("94226,94399");
		List<String> result = service.calculatePincodeMinRanges(ranges);
		Assertions.assertTrue(result.size() > 0);
		Assertions.assertEquals(2, result.size());
	}	
	
	@Test
	public void testPincodeMinRangeCalculatorNeutral2() throws PincodeServiceException{
		List<String> ranges = new ArrayList<>();
		
		ranges.add("3,6");
		ranges.add("1,4");
		ranges.add("5,12");
		ranges.add("4,8");
		List<String> result = service.calculatePincodeMinRanges(ranges);
		Assertions.assertTrue(result.size() > 0);
		Assertions.assertEquals(1, result.size());
	}
	
	
	@Test
	public void testPincodeMinRangeCalculatorException() {
		

		Assertions.assertThrows(PincodeServiceException.class, () -> {
			List<String> ranges = new ArrayList<>();

			ranges.add("test,4");
			ranges.add("1,2");
			service.calculatePincodeMinRanges(ranges);
		});
	}
}
