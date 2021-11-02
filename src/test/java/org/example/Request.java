package org.example;

import net.thucydides.core.annotations.Step;

import static io.restassured.RestAssured.given;

public class Request {
	private int numberOfPage = 1;


	@Step
	public PageData requestGet() {
		String getParam = "/api/users?page=" + numberOfPage;
		return given()
				.baseUri("https://reqres.in")
				.when()
				.get(getParam)
				.then()
				.statusCode(200)
				.extract().body().as(PageData.class);
	}

	@Step
	public PageData requestGet(int i){
		this.numberOfPage = i;
		return requestGet();
	}

}
