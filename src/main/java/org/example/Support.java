package org.example;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
		"url",
		"text"
})
@Data
public class Support {

	@JsonProperty("url")
	private String url;
	@JsonProperty("text")
	private String text;
}
