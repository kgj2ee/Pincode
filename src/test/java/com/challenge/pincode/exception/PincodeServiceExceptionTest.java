package com.challenge.pincode.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PincodeServiceExceptionTest {

	
	@Test
	public void testNoArgs() {
		
		PincodeServiceException exception = new PincodeServiceException();
		Assertions.assertNotNull(exception);
		
	}
	
	@Test
	public void testOneArgs() {
		
		PincodeServiceException exception = new PincodeServiceException("test");
		Assertions.assertNotNull(exception);
		
	}
	
	@Test
	public void testTwoArgs() {
		
		PincodeServiceException exception = new PincodeServiceException("test", "test1");
		Assertions.assertNotNull(exception);
		
	}
}
