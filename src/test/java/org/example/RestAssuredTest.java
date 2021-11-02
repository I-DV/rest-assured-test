package org.example;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class RestAssuredTest {
	private final Request request = new Request();

	@BeforeAll
	public static void setUp() {
		RestAssured.baseURI = "https://reqres.in";
	}

	@Test
	public void responseGet() {
		request.requestGet("[Michael]", "[Lawson]");
		request.assertMail("[michael.lawson@reqres]");
		request.requestGet("[George]", "[Bluth]");
		request.assertMail("[george.bluth@reqres.in]");
	}
}
