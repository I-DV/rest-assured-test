package org.example;

import io.restassured.response.Response;
import net.thucydides.core.annotations.Step;
import org.junit.jupiter.api.Assertions;

import java.util.NoSuchElementException;

import static io.restassured.RestAssured.given;

public class Request {
	private static Response response;
	private int numberOfPage = 1;

	@Step
	public boolean requestGet(String firstName, String lastName) {
		String getParam = "/api/users?page=" + numberOfPage;
		response = given()
				.header("Content-type", "application/json")
				.param("per_page", "1")
				.when()
				.get(getParam)
				.then()
				.assertThat()
				.statusCode(200)
				.extract().response();
		return assertRequest(response,  firstName, lastName);
	}

	public boolean assertRequest(Response response, String firstName, String last_name) {
		if (!response.jsonPath().getString("data").equals("[]")) {
			if (firstName.equals(response.jsonPath().getString("data.first_name"))) {
				Request.response = response;
				return false;
			} else {
				this.numberOfPage++;
				requestGet(firstName, last_name);
			}
		} else {
			throw new NoSuchElementException();
		}
		return true;
	}

	@Step
	public void assertMail(String email) {
		Assertions.assertEquals( email , response.jsonPath().getString("data.email"));
	}
}
