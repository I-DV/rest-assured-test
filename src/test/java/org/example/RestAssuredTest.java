package org.example;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class RestAssuredTest {

	@BeforeAll
	public static void setUp() {
		RestAssured.baseURI = "https://reqres.in";
	}

	@Test
	public void firstGetTest() {

		Response response = given()
				.header("Content-type", "application/json")
				.param("id", "1")
				.when()
				.get("/api/users")
				.then()
				.assertThat()
				.statusCode(200)
				.extract().response();
		assertEquals("George", response.jsonPath().getString("data.first_name"));
		assertEquals("Bluth", response.jsonPath().getString("data.last_name"));
		assertEquals("george.bluth@reqres.in", response.jsonPath().getString("data.email"));
	}

	@Test
	public void secondGetTest() {
		Response response = given()
				.header("Content-type", "application/json")
				.param("id", "7")
				.when()
				.get("/api/users?page=2")
				.then()
				.assertThat()
				.statusCode(200)
				.extract().response();
		assertEquals("Michael", response.jsonPath().getString("data.first_name"));
		assertEquals("Lawson", response.jsonPath().getString("data.last_name"));
		assertEquals("michael.lawson@reqres", response.jsonPath().getString("data.email"));
	}
}
