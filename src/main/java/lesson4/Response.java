package lesson4;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "cuisine",
        "cuisines",
        "confidence",
        "nutrition",
        "results",
        "id",
        "title",
        "nutrition",
        "nutrients",
        "name",
        "amount",
        "offset",
        "number",
        "totalResults"
})
@Data
public class Response {

    @JsonProperty("cuisine")
    private String cuisine;
    @JsonProperty("cuisines")
    private List<String> cuisines = null;
    @JsonProperty("confidence")
    private Double confidence;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    @JsonProperty("complexSearch")
    private String complexSearch;
    @JsonProperty("nutrition")
    private String nutrition;
    @JsonProperty("results")
    private Double results;
    @JsonProperty("id")
    private  Integer id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("nutrients")
    private String nutrients;
    @JsonProperty("name")
    private String name;
    @JsonProperty("amount")
    private Double amount;
    @JsonProperty("offset")
    private Double offset;
    @JsonProperty("number")
    private Double number;
    @JsonProperty("totalResults")
    private Double totalResults;

    public String getСomplexSearch() {
        return getСomplexSearch();
    }
}



