package com.challenge.sw.domain;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class ApiResponse<T> {

    String message;

    @JsonProperty("total_records") int totalRecords;

    @JsonProperty("total_pages") int totalPages;

    @JsonAlias("result") T results;
}
