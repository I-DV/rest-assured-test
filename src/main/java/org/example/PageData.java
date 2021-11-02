package org.example;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
		"page",
		"per_page",
		"total",
		"total_pages",
		"data",
		"support"
})
@Data
public class PageData {
	@JsonProperty("page")
	public Integer page;
	@JsonProperty("per_page")
	public Integer perPage;
	@JsonProperty("total")
	public Integer total;
	@JsonProperty("total_pages")
	public Integer totalPages;
	@JsonProperty("data")
	public List<UserData> data = null;
	@JsonProperty("support")
	private Support support;


}
