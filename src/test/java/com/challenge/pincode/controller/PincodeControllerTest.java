package com.challenge.pincode.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;


@SpringBootTest
public class PincodeControllerTest {
	  
	  
	  @Autowired
	private PincodeController controller;
	
	@Test
	public void test() throws Exception {

		List<String> test = new ArrayList<>();
		test.add("1,2");
		ResponseEntity<List<String>> entity =  controller.calculateMinRanges(test);
		Assertions.assertEquals(200, entity.getStatusCodeValue());
	}
	
	@Test
	public void test1() throws Exception {

		List<String> test = new ArrayList<>();
		test.add("test,2");
		ResponseEntity<List<String>> entity =  controller.calculateMinRanges(test);
		Assertions.assertEquals(400, entity.getStatusCodeValue());
	}
		

}
