package org.jot;

import org.jot.domain.Account;
import org.jot.domain.EmailAddress;
import org.jot.domain.PhoneNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@SpringBootTest( webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SpringBootWorkshopApplicationTests {

	@LocalServerPort
	private int port;
	private RestTemplate restTemplate = new RestTemplate();

	@Test
	void testValidationOk() {
		Account account = new Account();
		EmailAddress email = new EmailAddress();
		PhoneNumber number = new PhoneNumber();
		account.setEmailAddress(email);
		account.setPhoneNumber(number);

		Account response = restTemplate.postForObject("http://localhost:"+port+"/accounts", account, Account.class);

		Assertions.assertNotNull(response);
	}

	@Test
	void testValidationNoEmail() {
		Account account = new Account();
		PhoneNumber number = new PhoneNumber();
		account.setPhoneNumber(number);

		HttpClientErrorException thrown = Assertions.assertThrows(
				HttpClientErrorException.class,
				() -> restTemplate.postForObject("http://localhost:"+port+"/accounts", account, Account.class),
				"Expected to get a HttpClientErrorException, but it didn't"
		);
		Assertions.assertTrue(thrown.getMessage().contentEquals("400 : \"{\"emailAddress\":\"email cannot be null\"}\""));
	}
}
