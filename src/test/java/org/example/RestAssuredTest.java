package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class RestAssuredTest {
	private final Request request = new Request();
	private final int totalPage = request.requestGet()
			.getTotalPages();


	@Test
	public void firstTest() {
		String email = null;
		for (int i = 1; i <= totalPage; i++) {
			for (UserData user : request.requestGet(i).getData()
			) {
				if (user.getFirstName().equals("George")
						&& user.getLastName().equals("Bluth")) {
					email = user.getEmail();
				}
			}
		}
		assertNotEquals(null, email);
		assertEquals("george.bluth@reqres.in", email);
	}

	@Test
	public void secondTest() {
		String email = null;
		for (int i = 1; i <= totalPage; i++) {
			for (UserData user : request.requestGet(i).getData()
			) {
				if (user.getFirstName().equals("Michael")
						/*&& user.getLastName().equals("Lawson")*/) {
					email = user.getEmail();
				}
			}
		}
		//assertNotEquals(null, email);
		assertEquals("michael.lawson@reqres", email);
	}
}
