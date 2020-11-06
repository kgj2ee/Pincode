package com.challenge.pincode;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

import com.challenge.pincode.controller.PincodeController;

@SpringBootTest
class PincodeApplicationTests {
	
@Autowired PincodeController controller;

	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}

}
