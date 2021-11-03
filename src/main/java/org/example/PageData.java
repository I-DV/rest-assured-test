package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class PageData {
	public int page;
	@JsonProperty("per_page")
	public int perPage;
	public int total;
	@JsonProperty("total_pages")
	public int totalPages;
	public List<UserData> data = null;
	private Support support;


}
